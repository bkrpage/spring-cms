package dev.bradleypage.author;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorPostOutput {


    private String id;
    private String firstName;
    private String surname;
    private String username;
}
