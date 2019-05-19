package dev.bradleypage.post;

import dev.bradleypage.mapping.BsonMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper extends BsonMapper {

    PostOutput postToOutput(Post post);

    List<PostOutput> postListToOutputList(List<Post> posts);

    @InheritInverseConfiguration
    Post outputToPost(PostOutput output);

    @InheritInverseConfiguration
    List<Post> outputListToPostList(List<PostOutput> outputs);

    PostInput postToInput(Post post);

    @InheritInverseConfiguration
    Post inputToPost(PostInput input);

    List<PostInput> postListToInputList(List<Post> post);

    @InheritInverseConfiguration
    List<Post> inputListToPostList(List<PostInput> input);
}
