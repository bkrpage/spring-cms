package dev.bradleypage.author;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper map;

    public final String DUPLICATE_USERNAME_ERROR = "Author with username %s already exists";

    @Override
    public Author createNewAuthor(AuthorInput authorInput) throws DuplicateUsernameException {
        return createNewAuthor(map.inputToAuthor(authorInput));
    }

    @Override
    public Author createNewAuthor(Author author) throws DuplicateUsernameException {
        if (usernameExists(author.getUsername())) {
            throw new DuplicateUsernameException(
                    String.format(DUPLICATE_USERNAME_ERROR, author.getUsername())
            );
        }
        return repository.save(author);
    }

    private boolean usernameExists(String username) {
        List<Author> existing = repository.findByUsernameIgnoreCase(username);
        return (existing.size() > 0);
    }
}
