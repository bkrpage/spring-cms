package dev.bradleypage.post;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
public class MetaDataInput {

    private String formatType = "plainText";
    @NotBlank
    private String postType;
    @NotBlank
    private String author;

    private String lastEdited = Instant.now().toString();
}
