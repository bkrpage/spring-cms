package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {

    private @NonNull String formatType;
    private @NonNull String postType;
    private @NonNull String author;
    private @NonNull Instant lastEdited;
}
