package dev.bradleypage.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaDataOutput {


    private String formatType;
    private String postType;
    private String author;
    private String lastEdited;
}
