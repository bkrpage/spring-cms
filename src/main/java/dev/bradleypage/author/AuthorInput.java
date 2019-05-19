package dev.bradleypage.author;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorInput {

    @NotBlank
    private String firstName;
    @NotNull
    private String surname;

    @NotBlank
    private String username;

    private String bio;
    private String website;


}
