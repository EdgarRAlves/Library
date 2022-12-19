package com.edgar.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Book(
                    "Ensaio sobre a Cegueira", "Jose Saramago", 1853594334L, 10, 15.93
            )));
            log.info("Preloading " + repository.save(new Book(
                    "12 Rules for Life", "Dr. Jordan Peterson", 34543543543L, 50, 20.23
            )));
            log.info("Preloading " + repository.save(new Book(
                    "How Not To Die", "Dr. Michael Greger", 3243243245L, 34, 21.34
            )));
        };
    }
}
