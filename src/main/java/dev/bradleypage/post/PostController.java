package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post")
    PostOutput submitPost(
            @ModelAttribute PostInput postInput,
            BindingResult result
    ) {
        //TODO handle validation
        Post post = mapper.mapObject(postInput);
        repository.save(post);

        return mapper.mapOutput(post);
    }
}
