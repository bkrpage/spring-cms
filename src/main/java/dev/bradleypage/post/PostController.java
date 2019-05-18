package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostRepository repository;
    private final PostMapper mapper;


    @GetMapping("/posts")
    List<PostOutput> getAllPosts() {
        return mapper.mapOutput(repository.findAll());
    }

    @GetMapping("/post/{id}")
    PostOutput getPost(
            @PathVariable String id
    ) {
        return mapper.mapOutput(repository.findById(new ObjectId(id)).orElse(null));
    }
}
