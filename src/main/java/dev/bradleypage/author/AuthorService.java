package dev.bradleypage.author;

import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    Author createNewAuthor(AuthorInput author) throws DuplicateUsernameException;

    Author createNewAuthor(Author author) throws DuplicateUsernameException;
}
