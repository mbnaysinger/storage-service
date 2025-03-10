package br.org.naysinger.config;

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.CollectionOptions;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.core.query.Collation;
//
//import java.util.List;
//
//@Configuration
//public class StartupConfig {
//    @Bean
//    public CommandLineRunner initDatabase(ReactiveMongoTemplate reactiveMongoTemplate) {
//        return args -> reactiveMongoTemplate.getCollectionNames()
//                .collectList()
//                .subscribe(existingCollections -> List
//                        .of("bb_bank_parameters", "bank_slips", "card_transaction", "database_sequences",
//                                "protheus_integration_parameters", "bb_pix_parameters", "pix")
//                        .forEach(collectionToCreate -> {
//                            var collectionOptions = CollectionOptions.just(Collation.of("pt"));
//                            if (!existingCollections.contains(collectionToCreate)) {
//                                reactiveMongoTemplate.createCollection(collectionToCreate, collectionOptions)
//                                        .subscribe();
//                            }
//                        }));
//    }
//}
