package dev.bradleypage.author;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorRepository repository;
    private final AuthorMapper map;


    @GetMapping("/authors")
    List<AuthorOutput> getAllAuthors() {
        return map.authorListToOutputList(repository.findAll());
    }

}
