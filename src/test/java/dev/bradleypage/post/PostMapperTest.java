package dev.bradleypage.post;

import dev.bradleypage.author.Author;
import dev.bradleypage.author.AuthorPostInput;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@NoArgsConstructor
@Component
@RunWith(SpringRunner.class)
// Need to add the MapStruct Generated Implementation to get it Autowiring.
@SpringBootTest(classes = {PostMapperImpl.class})
public class PostMapperTest {

    @Autowired
    private PostMapper map;

    private final Instant now = Instant.now();

    @Test
    public void givenCorrectInput_whenMapping_thenCorrectPost() {

        ObjectId testId = ObjectId.get();

        PostInput testInput = new PostInput();
        testInput.setTitle("Test Title");
        testInput.setBodyText("Test Body Text");
        testInput.setPosted("2019-05-18T15:18:33.013Z");
        MetaDataInput testMetaDataInput = new MetaDataInput();
        // formatType should autoSet to plainText
        testMetaDataInput.setPostType("comment");
        testMetaDataInput.setLastEdited(now.toString());
        testInput.setMetaData(testMetaDataInput);

        Post result = map.inputToPost(testInput);

        Post expected = createBasicExpectedPostObject();

        assertEquals(
                expected,
                result
        );
    }

    private Post createBasicExpectedPostObject(){
        return Post.builder()
                .bodyText("Test Body Text")
                .title("Test Title")
                .posted(Instant.parse("2019-05-18T15:18:33.013Z"))
                .metaData(MetaData.builder()
                        .postType("comment")
                        .lastEdited(now)
                        .build())
                .build();
    }
}
