package dev.bradleypage.post;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, ObjectId> {

    List<Post> findByMetaDataAuthor(@Param("author") String author);
}
