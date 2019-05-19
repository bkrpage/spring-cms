package dev.bradleypage.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
