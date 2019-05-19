package dev.bradleypage.post;

import dev.bradleypage.author.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaData {

    private String formatType;
    private String postType;
    private List<Author> authors;
    @Builder.Default
    private Instant lastEdited = Instant.now();
}
