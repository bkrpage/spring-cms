package dev.bradleypage.author;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    private ObjectId id;

    private @NonNull String firstName;
    private @NonNull String surname;

    private @NonNull String username;

    private String bio;
    private String website;


}
