package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostRepository repository;
    private final PostMapper map;


    @GetMapping("/posts")
    List<PostOutput> getAllPosts() {
        return map.postListToOutputList(repository.findAll());
    }

    @GetMapping("/post/{id}")
    PostOutput getPost(
            @PathVariable String id
    ) {
        return map.postToOutput(repository.findById(new ObjectId(id)).orElse(null));
    }

    @PostMapping("/post")
    PostOutput submitPost(
            @Valid @RequestBody PostInput postInput
    ) {
        return map.postToOutput(repository.save(map.inputToPost(postInput)));
    }

    @PostMapping("/posts")
    List<PostOutput> submitPosts(
            @Valid @RequestBody List<PostInput> postInputs
    ) {
        return map.postListToOutputList(repository.saveAll(map.inputListToPostList(postInputs)));
    }

    /**
     * Using https://www.baeldung.com/spring-boot-bean-validation
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.put(((FieldError) error).getField(), error.getDefaultMessage()));
        return errors;
    }

}
