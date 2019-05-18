package dev.bradleypage.post;

import dev.bradleypage.mapping.BsonMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper extends BsonMapper {

    PostOutput mapOutput(Post post);

    List<PostOutput> mapOutput(List<Post> posts);

    @InheritInverseConfiguration
    Post mapObject(PostOutput output);

    @InheritInverseConfiguration
    List<Post> mapObject(List<PostOutput> outputs);

    PostInput mapInput(Post post);

    @InheritInverseConfiguration
    Post mapObject(PostInput input);
}
