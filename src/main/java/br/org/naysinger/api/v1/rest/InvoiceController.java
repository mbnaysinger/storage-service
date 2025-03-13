package br.org.naysinger.api.v1.rest;

import br.org.naysinger.domain.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("InvoiceControllerV1")
@RequestMapping("/v1/invoice")
public class InvoiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);

    private static final String AUTHORIZATION_ERROR = "Acesso negado";

    private final String apiKey;
    private final FileStorageService fileStorageService;

    public InvoiceController(@Value("${app.api-key}") String apiKey,
                             FileStorageService fileStorageService) {
        this.apiKey = apiKey;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> uploadInvoice(
            @RequestHeader("X-API-Key") String apiKeyParam,
            @RequestPart("file") Mono<FilePart> filePart) {

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new SecurityException(AUTHORIZATION_ERROR)))
                .flatMap(validKey -> filePart
                        .flatMap(part -> {
                            String originalFilename = part.filename();
                            LOGGER.debug("Processando arquivo: {}", originalFilename);

                            return convertFilePartToBytes(part)
                                    .flatMap(fileBytes -> {
                                        LOGGER.debug("Arquivo convertido para bytes. Tamanho: {} bytes", fileBytes.length);
                                        return fileStorageService.saveInvoice(originalFilename, fileBytes);
                                    })
                                    .doOnSuccess(result -> LOGGER.info("Arquivo processado com sucesso: {}", originalFilename))
                                    .doOnError(error -> LOGGER.error("Erro ao processar arquivo: {}", error.getMessage()));
                        })
                )
                .map(result -> "Upload realizado com sucesso.")
                .onErrorResume(this::handleError);
    }

    private Mono<byte[]> convertFilePartToBytes(FilePart filePart) {
        return filePart.content()
                .reduce(DataBuffer::write)
                .map(buffer -> {
                    byte[] bytes = new byte[buffer.readableByteCount()];
                    buffer.read(bytes);
                    DataBufferUtils.release(buffer);
                    return bytes;
                });
    }

    private Mono<String> handleError(Throwable error) {
        if (error instanceof SecurityException) {
            return Mono.error(error);
        } else if (error instanceof IllegalArgumentException) {
            return Mono.error(error);
        } else {
            LOGGER.error("Erro inesperado: ", error);
            return Mono.error(new RuntimeException("Ocorreu um erro ao processar a solicitação."));
        }
    }
}
