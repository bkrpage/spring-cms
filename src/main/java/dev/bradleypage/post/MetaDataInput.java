package dev.bradleypage.post;

import dev.bradleypage.author.AuthorPostInput;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
class MetaDataInput {

    private String formatType = "plainText";
    @NotBlank
    private String postType;
    @NotBlank
    private List<AuthorPostInput> authors;

    private String lastEdited = Instant.now().toString();
}
