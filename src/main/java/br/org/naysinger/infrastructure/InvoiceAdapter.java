package br.org.naysinger.infrastructure;

//import br.org.fiergs.domain.model.Invoice;
//import br.org.fiergs.domain.port.InvoicePort;
//import br.org.fiergs.infrastructure.converter.InvoiceEntityConverter;
//import br.org.fiergs.infrastructure.mongo.InvoiceRepository;
//import br.org.fiergs.infrastructure.mongo.entity.InvoiceEntity;
//import br.org.fiergs.utils.Pageable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.mongodb.core.ReactiveMongoOperations;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.data.mongodb.core.query.Query.query;
//
//@Component
//public class InvoiceAdapter implements InvoicePort {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceAdapter.class);
//
//    private final InvoiceRepository invoiceRepository;
//    private final InvoiceEntityConverter invoiceEntConverter;
//    private final ReactiveMongoOperations mongoOperations;
//
//    public InvoiceAdapter(InvoiceRepository invoiceRepository, InvoiceEntityConverter invoiceEntConverter, ReactiveMongoOperations mongoOperations) {
//        this.invoiceRepository = invoiceRepository;
//        this.invoiceEntConverter = invoiceEntConverter;
//        this.mongoOperations = mongoOperations;
//    }
//
//    @Override
//    public Mono<Invoice> findByCorrelationIdAndSourceSystem(String correlationId, String sourceSystem) {
//        return invoiceRepository.findByCorrelationIdAndSourceSystem(correlationId, sourceSystem)
//                .map(invoiceEntConverter::toAutomationModel);
//    }
//
//    @Override
//    public Mono<Invoice> findByCorrelationId(String correlationId) {
//        return invoiceRepository.findByCorrelationId(correlationId)
//                .map(invoiceEntConverter::toAutomationModel);
//    }
//
//    @Override
//    public Mono<Invoice> savePartially(Invoice invoice) {
//        return invoiceRepository.save(invoiceEntConverter.toPartialEntity(invoice))
//                .map(invoiceEntConverter::toAutomationModel);
//    }
//
//    @Override
//    public Flux<Invoice> findAll(Invoice invoice, Pageable pageable) {
//        return mongoOperations
//                .find(query(Criteria.byExample(invoiceEntConverter.convertExample(invoice)))
//                                .skip(pageable.getSkip())
//                                .limit(pageable.getLimitPlusOne()),
//                        InvoiceEntity.class)
//                .map(invoiceEntConverter::toAutomationModel);
//    }
//
//    @Override
//    public Mono<Invoice> update(Invoice invoice) {
//        return invoiceRepository.findById(invoice.getId())
//                .flatMap(entity -> invoiceRepository.save(invoiceEntConverter.update(invoice, entity)))
//                .map(invoiceEntConverter::toAutomationModel);
//    }
//
//}
