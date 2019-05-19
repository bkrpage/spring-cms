package dev.bradleypage.author;

import dev.bradleypage.mapping.BsonMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends BsonMapper {

    AuthorOutput authorToOutput(Author author);
    @InheritInverseConfiguration
    Author outputToAuthor(AuthorOutput output);

    List<AuthorOutput> authorListToOutputList(List<Author> authors);
    @InheritInverseConfiguration
    List<Author> outputListToAuthorList(List<AuthorOutput> outputs);

    AuthorPostOutput authorToPostOutput(Author author);
    @InheritInverseConfiguration
    Author postOutputToAuthor(AuthorPostOutput author);

    List<AuthorPostOutput> authorListToPostOutputList(List<Author> authors);
    @InheritInverseConfiguration
    List<Author> postOutputListToAuthorList(List<AuthorPostOutput> outputs);

    AuthorPostInput authorToPostInput(Author author);
    @InheritInverseConfiguration
    Author postInputToAuthor(AuthorPostInput input);

    AuthorInput authorToInput(Author author);
    @InheritInverseConfiguration
    Author inputToAuthor(AuthorInput input);
}
