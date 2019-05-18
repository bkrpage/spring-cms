package dev.bradleypage;

import dev.bradleypage.author.Author;
import dev.bradleypage.author.AuthorRepository;
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

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Application {

    final MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(PostRepository repository, AuthorRepository authorRepository) {
        return (args) -> {
            //save some example blogs

            if (authorRepository.findAll().size() <= 0) {
                log.info("No Authors Found, creating example users");

                authorRepository.save(
                        Author.builder()
                                .firstName("Jon")
                                .surname("Snow")
                                .username("AeJon")
                                .build()
                );
                authorRepository.save(
                        Author.builder()
                                .firstName("Bran")
                                .surname("Stark")
                                .username("3EyedR4v3n")
                                .build()
                );
                authorRepository.save(
                        Author.builder()
                                .firstName("Sansa")
                                .surname("Stark")
                                .username("QueenInTheNorth")
                                .build()
                );
                authorRepository.save(
                        Author.builder()
                                .firstName("Ramsay")
                                .surname("Snow")
                                .username("RamsayBolton")
                                .build()
                );
                authorRepository.save(
                        Author.builder()
                                .firstName("Hodor")
                                .surname("Hodor")
                                .username("Hodor")
                                .build()
                );
            }

            if (repository.findAll().size() <= 0) {
                log.info("Saving example post Objects");

                repository.save(
                        Post.builder()
                                .title("Case for Northern Independence")
                                .bodyText("Lorem ipsum blah blah blah")
                                .metaData(
                                        MetaData.builder()
                                                .formatType("plaintext")
                                                .authors(authorRepository.findByUsername("QueenInTheNorth"))
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
                                                .authors(authorRepository.findByUsername("AeJon"))
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
                                                .authors(authorRepository.findByUsername("Hodor"))
                                                .postType("blog")
                                                .build()
                                )
                                .build()
                );
            }

            // fetch all authors
            log.info("Authors found with findAll():");
            log.info("-------------------------------");
            authorRepository.findAll().forEach(author -> log.info(author.toString()));
            log.info("");
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(post -> log.info(post.toString()));
            log.info("");

            // fetch customers by last name
//            log.info("Customer found with find by author name");
//            log.info("--------------------------------------------");
//            repository.findByMetaDataAuthor("Sansa Stark").forEach(post -> log.info(post.toString()));
//            log.info("");
        };
    }
}
