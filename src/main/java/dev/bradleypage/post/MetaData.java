package dev.bradleypage.post;

import lombok.Data;
import lombok.NonNull;

import java.time.Instant;

@Data
public class MetaData {

    private @NonNull String formatType;
    private @NonNull String postType;
    private @NonNull String author;
    private @NonNull Instant lastEdited;
}
