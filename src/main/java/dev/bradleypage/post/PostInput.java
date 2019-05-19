package dev.bradleypage.post;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
class PostInput {

    @NotBlank
    private String title;
    @NotBlank
    private String bodyText;

    private String posted = Instant.now().toString();

    @Valid
    private MetaDataInput metaData;


}
