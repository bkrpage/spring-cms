package dev.bradleypage.post;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaData {

    private String formatType;
    private String postType;
    private String author;
    @Builder.Default private Instant lastEdited = Instant.now();
}
