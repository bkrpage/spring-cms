package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
            @Valid @RequestBody PostInput postInput
    ) {
        Post post = mapper.mapObject(postInput);
        repository.save(post);

        return mapper.mapOutput(post);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
