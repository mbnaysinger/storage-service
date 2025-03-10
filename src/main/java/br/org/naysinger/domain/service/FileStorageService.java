package br.org.naysinger.domain.service;

import br.org.naysinger.domain.port.FileStoragePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FileStorageService {
    private final FileStoragePort fileStoragePort;

    public FileStorageService(FileStoragePort fileStoragePort) {
        this.fileStoragePort = fileStoragePort;
    }

    public Mono<String> saveInvoice(String fileName, byte[] file) {
        return fileStoragePort.saveInvoice(fileName, file);
    }

    public Mono<byte[]> getInvoice(String fileName) {
        return fileStoragePort.getInvoice(fileName);
    }

    public Flux<String> listInvoice() {
        return fileStoragePort.listInvoice();
    }
}
