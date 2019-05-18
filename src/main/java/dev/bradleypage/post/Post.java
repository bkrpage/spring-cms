package dev.bradleypage.post;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Post {

    @Id
    private ObjectId id;

    private String title;
    private String bodyText;
    @Builder.Default private Instant posted = Instant.now();
    private MetaData metaData;

}
