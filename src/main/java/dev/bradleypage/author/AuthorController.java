package dev.bradleypage.author;

import lombok.AllArgsConstructor;
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
public class AuthorController {

    private final AuthorRepository repository;
    private final AuthorService service;
    private final AuthorMapper map;


    @GetMapping("/authors")
    List<AuthorOutput> getAllAuthors() {
        return map.authorListToOutputList(repository.findAll());
    }

    @PostMapping("/author")
    AuthorOutput submitSingleAuthor(
            @Valid @RequestBody AuthorInput input
    ) throws DuplicateUsernameException {
        return map.authorToOutput(service.createNewAuthor(input));
    }


    /**
     * Using https://www.baeldung.com/spring-boot-bean-validation
     * //TODO add this to controller advice or base controller.
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


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateUsernameException.class)
    public Map<String, String> handleUsernameException(
            DuplicateUsernameException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        errors.put("username", ex.getMessage());
        return errors;
    }

}
