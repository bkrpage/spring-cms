package dev.bradleypage.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {

    private String formatType;
    private String author;
    private Instant lastEdited;
}
