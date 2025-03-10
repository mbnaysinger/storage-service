package br.org.naysinger.domain.port;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FileStoragePort {

    Mono<String> saveInvoice(String fileName, byte[] file);

    Mono<byte[]> getInvoice(String fileName);

    Flux<String> listInvoice();

}
