package br.org.naysinger.infrastructure;

import br.org.naysinger.domain.port.FileStoragePort;
import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
import java.util.Objects;

@Component
public class FileStorageS3Adapter implements FileStoragePort {
    private final String bucketInvoice;
    private final BlobServiceAsyncClient blobServiceAsyncClient;

    public FileStorageS3Adapter(@Value("${azure.storage.container-invoice}") String bucketInvoice,
                                BlobServiceAsyncClient blobServiceAsyncClient) {
        this.bucketInvoice = bucketInvoice;
        this.blobServiceAsyncClient = blobServiceAsyncClient;
    }

    private BlobContainerAsyncClient getContainerClient(String containerName) {
        return blobServiceAsyncClient.getBlobContainerAsyncClient(containerName);
    }

    @Override
    public Mono<String> saveInvoice(String fileName, byte[] file) {
        return uploadFile(fileName, file, bucketInvoice);
    }

    @Override
    public Mono<byte[]> getInvoice(String fileName) {
        return downloadFile(fileName, bucketInvoice)
                .filter(Objects::nonNull)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Não há Nota Fiscal disponível para o nome informado")));
    }

    @Override
    public Flux<String> listInvoice() {
        return listBlobs(bucketInvoice);
    }

    public Mono<String> uploadFile(String fileName, byte[] content, String containerName) {
        BlobContainerAsyncClient containerClient = blobServiceAsyncClient.getBlobContainerAsyncClient(containerName);
        BlockBlobAsyncClient blobClient = containerClient.getBlobAsyncClient(fileName).getBlockBlobAsyncClient();

        BinaryData binaryData = BinaryData.fromBytes(content);

        return blobClient.upload(binaryData)
                .thenReturn(fileName);
    }

    public Mono<byte[]> downloadFile(String fileName, String containerName) {
        BlobContainerAsyncClient containerClient = blobServiceAsyncClient.getBlobContainerAsyncClient(containerName);

        return containerClient.getBlobAsyncClient(fileName)
                .downloadContent()
                .map(BinaryData::toBytes);
    }

    public Flux<String> listBlobs(String containerName) {
        BlobContainerAsyncClient containerClient = blobServiceAsyncClient.getBlobContainerAsyncClient(containerName);

        return containerClient.listBlobs()
                .map(BlobItem::getName);
    }


//    private Mono<String> uploadFile(String fileName, byte[] content, String containerName) {
//        BlobAsyncClient blobAsyncClient = getContainerClient(containerName).getBlobAsyncClient(fileName);
//
//        Flux<ByteBuffer> data = Flux.just(ByteBuffer.wrap(content));
//        ParallelTransferOptions parallelTransferOptions = new ParallelTransferOptions();
//
//        return blobAsyncClient.upload(data, parallelTransferOptions, true)
//                .then(Mono.just(fileName));
//    }
//
//    private Mono<byte[]> downloadFile(String fileName, String containerName) {
//        BlobAsyncClient blobAsyncClient = getContainerClient(containerName).getBlobAsyncClient(fileName);
//
//        return blobAsyncClient.exists()
//                .flatMap(exists -> {
//                    if (!exists) {
//                        return Mono.empty();
//                    }
//                    return blobAsyncClient.download()
//                            .reduce(ByteBuffer.allocate(0), (buffer, byteBuffer) -> {
//                                ByteBuffer newBuffer = ByteBuffer.allocate(buffer.remaining() + byteBuffer.remaining());
//                                newBuffer.put(buffer).put(byteBuffer).flip();
//                                return newBuffer;
//                            })
//                            .map(ByteBuffer::array);
//                })
//                .onErrorResume(throwable -> Mono.error(
//                        new RuntimeException("Erro ao baixar o arquivo " + fileName + ": " + throwable.getMessage())));
//    }
//
//    public Flux<String> listBlobs(String containerName) {
//        BlobContainerAsyncClient containerClient = getContainerClient(containerName);
//
//        return containerClient.listBlobs()
//                .map(BlobItem::getName)
//                .onErrorResume(BlobStorageException.class, e -> {
//                    if (e.getStatusCode() == 404) {
//                        return Flux.error(new RuntimeException("Container : " + containerName + " não encontrado"));
//                    }
//                    return Flux.error(e);
//                });
//    }
}
