package dev.bradleypage.post;

import lombok.*;
import org.bson.types.ObjectId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    private @NonNull String title;
    private @NonNull String bodyText;
    private @NonNull Instant posted;
    private @NonNull MetaData metaData;

}
