package br.org.naysinger.infrastructure.mongo;

//import br.org.fiergs.infrastructure.mongo.entity.InvoiceEntity;
//import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Component
//public interface InvoiceRepository extends ReactiveMongoRepository<InvoiceEntity, String> {
//
//    Mono<InvoiceEntity> findByCorrelationIdAndSourceSystem(String correlationId, String SourceSystem);
//    Mono<InvoiceEntity> findByCorrelationId(String correlationId);
//    Flux<InvoiceEntity> findByFileStatusContainingOrXmlStatusContaining(String fileStatus, String xmlStatus);
//
//}
