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
                    "Ensaio sobre a Cegueira", "Jose Saramago", 4853594334L, 10, 15.93
            )));
            log.info("Preloading " + repository.save(new Book(
                    "12 Rules for Life", "Dr. Jordan Peterson", 34543543543L, 50, 20.23
            )));
            log.info("Preloading " + repository.save(new Book(
                    "How Not To Die", "Dr. Michael Greger", 3243243245L, 10, 21.34
            )));
            log.info("Preloading " + repository.save(new Book(
                    "Lord of the Flies", "William Golding", 323422845L, 0, 12.78
            )));
            log.info("Preloading " + repository.save(new Book(
                    "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 23532453L, 30, 30.54
            )));
            log.info("Preloading " + repository.save(new AntiqueBook(
                    "Crime and Punishment", "Fyodor Dostoevsky", 346745463L, 20, 28.49, 1866
            )));
            log.info("Preloading " + repository.save(new ScienceJournal(
                    "This Mortal Coil", "Andrew Doig", 4354323435L, 50, 38.00, 6
            )));
        };
    }
}
