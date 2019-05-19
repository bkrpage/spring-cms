package dev.bradleypage.author;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class AuthorOutput {


    private String id;
    private String firstName;
    private String surname;
    private String username;
    private String bio;
    private String website;
}
