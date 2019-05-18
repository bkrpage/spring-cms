package dev.bradleypage.post;

import dev.bradleypage.author.AuthorPostOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
class MetaDataOutput {


    private String formatType;
    private String postType;
    private List<AuthorPostOutput> authors;
    private String lastEdited;
}
