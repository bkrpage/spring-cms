package dev.bradleypage.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class PostOutput {

    private String id;

    private String title;
    private String bodyText;
    private String posted;
    private MetaDataOutput metaData;
}
