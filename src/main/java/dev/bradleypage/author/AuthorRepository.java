package dev.bradleypage.author;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

    List<Author> findByUsername(@Param("username") String username);
}
