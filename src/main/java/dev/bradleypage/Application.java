package dev.bradleypage;

import dev.bradleypage.post.MetaData;
import dev.bradleypage.post.Post;
import dev.bradleypage.post.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public CommandLineRunner demo(PostRepository repository) {
        return (args) -> {
            //save some example blogs

            if (repository.findAll().size() <= 0) {
                repository.save(new Post("Case for Northern Independence", "Lorem Ipsum Dolir sit amet", Instant.now(),
                        new MetaData("plaintext", "blog", "Sansa Stark", Instant.now())));
                repository.save(new Post("It's bigger than the throne", "Lorem Ipsum Dolir sit amet", Instant.now(),
                        new MetaData("plaintext", "blog", "Jon Snow (Aegon Targaryan)", Instant.now())));
                repository.save(new Post("I am the True Heir", "Lorem Ipsum Dolir sit amet", Instant.now(),
                        new MetaData("plaintext", "blog", "Daenerys Targaryan", Instant.now())));
                repository.save(new Post("Hodor hodor", "Lorem Ipsum Dolir sit amet", Instant.now(),
                        new MetaData("plaintext", "blog", "Hodor", Instant.now())));
                repository.save(new Post("Daemon Targaryen's Wheelchair", "Lorem Ipsum Dolir sit amet", Instant.now(),
                        new MetaData("plaintext", "blog", "Brandon Stark (The3EyedR4v3n)", Instant.now())));
            }

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(post -> log.info(post.toString()));
            log.info("");

            // fetch customers by last name
            log.info("Customer found with find by authro namre");
            log.info("--------------------------------------------");
            repository.findByMetaDataAuthor("Sansa Stark").forEach(post -> log.info(post.toString()));
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
