package dev.bradleypage.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final ObjectMapper mapper;


    @GetMapping("/posts/")
    public ObjectNode getAllPosts() {
        ObjectNode node = mapper.createObjectNode();

        node.putObject("posts");
        return ;
    }
}
