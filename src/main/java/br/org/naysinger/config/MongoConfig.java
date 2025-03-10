package br.org.naysinger.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.index.Index;
//
//import javax.annotation.PostConstruct;
//
//@Configuration
//@DependsOn("mongoTemplate")
//public class MongoConfig {
//    private static final String COL_TRANSACTION_TYPE = "transactionType";
//    private static final String COL_CORRELATION_ID = "correlationId";
//    private static final String COL_SOURCE_SYSTEM = "sourceSystem";
//    private static final String COL_OUR_NUMBER = "ourNumber";
//    private static final String UK_CODE_NUMBER = "codigo_uk";
//
//    private final ReactiveMongoTemplate reactiveMongoTemplate;
//
//    public MongoConfig(ReactiveMongoTemplate reactiveMongoTemplate, MappingMongoConverter mappingMongoConverter) {
//        this.reactiveMongoTemplate = reactiveMongoTemplate;
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//    }
//
//    @PostConstruct
//    public void initIndexes() {
//        reactiveMongoTemplate.indexOps("card_transaction")
//                .ensureIndex(cardTransactionUniqueKey());
//
//        reactiveMongoTemplate.indexOps("bank_slips")
//                .ensureIndex(bankSlipsUniqueKey());
//
//        reactiveMongoTemplate.indexOps("pix")
//                .ensureIndex(pixUniqueKey());
//
//        reactiveMongoTemplate.indexOps("invoices")
//                .ensureIndex(invoiceUniqueKey());
//
//        reactiveMongoTemplate.indexOps("ournumber_integration")
//                .ensureIndex(ourNumberUniqueKey());
//
//    }
//
//    private Index cardTransactionUniqueKey() {
//        return new Index()
//                .on(COL_SOURCE_SYSTEM, Sort.Direction.ASC)
//                .on(COL_CORRELATION_ID, Sort.Direction.ASC)
//                .on(COL_TRANSACTION_TYPE, Sort.Direction.ASC)
//                .named(UK_CODE_NUMBER)
//                .unique();
//    }
//
//    private Index bankSlipsUniqueKey() {
//        return new Index()
//                .on(COL_SOURCE_SYSTEM, Sort.Direction.ASC)
//                .on(COL_CORRELATION_ID, Sort.Direction.ASC)
//                .named(UK_CODE_NUMBER)
//                .unique();
//    }
//
//    private Index pixUniqueKey() {
//        return new Index()
//                .on(COL_SOURCE_SYSTEM, Sort.Direction.ASC)
//                .on(COL_CORRELATION_ID, Sort.Direction.ASC)
//                .named(UK_CODE_NUMBER)
//                .unique();
//    }
//
//    private Index invoiceUniqueKey() {
//        return new Index()
//                .on(COL_SOURCE_SYSTEM, Sort.Direction.ASC)
//                .on(COL_CORRELATION_ID, Sort.Direction.ASC)
//                .named(UK_CODE_NUMBER)
//                .unique();
//    }
//
//    private Index ourNumberUniqueKey() {
//        return new Index()
//                .on(COL_OUR_NUMBER, Sort.Direction.ASC)
//                .on(COL_CORRELATION_ID, Sort.Direction.ASC)
//                .named(UK_CODE_NUMBER)
//                .unique();
//    }
//}
