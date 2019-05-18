package dev.bradleypage;

import dev.bradleypage.post.MetaData;
import dev.bradleypage.post.Post;
import dev.bradleypage.post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Application {

    final MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(PostRepository repository) {
        return (args) -> {
            //save some example blogs

            if (repository.findAll().size() <= 0) {
                log.info("Saving example post Objects");

                repository.save(
                        Post.builder()
                                .title("Case for Northern Independence")
                                .bodyText("Lorem ipsum blah blah blah")
                                .metaData(
                                        MetaData.builder()
                                                .formatType("plaintext")
                                                .author("Sansa Stark")
                                                .postType("blog")
                                                .build()
                                )
                                .build()
                );

                repository.save(
                        Post.builder()
                                .title("It's bigger than the throne")
                                .bodyText("<b>Lorem ipsum</b> blah blah blah")
                                .metaData(
                                        MetaData.builder()
                                                .formatType("html")
                                                .author("Jon Snow (Aegon Targaryan)")
                                                .postType("blog")
                                                .build()
                                )
                                .build()
                );

                repository.save(
                        Post.builder()
                                .title("Hodor hodor")
                                .bodyText("<b>Lorem ipsum</b> blah blah blah")
                                .metaData(
                                        MetaData.builder()
                                                .formatType("plaintext")
                                                .author("Hodor")
                                                .postType("blog")
                                                .build()
                                )
                                .build()
                );
            }

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(post -> log.info(post.toString()));
            log.info("");

            // fetch customers by last name
            log.info("Customer found with find by author name");
            log.info("--------------------------------------------");
            repository.findByMetaDataAuthor("Sansa Stark").forEach(post -> log.info(post.toString()));
            log.info("");
        };
    }
}
