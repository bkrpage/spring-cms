package dev.bradleypage.mapping;

import org.bson.types.ObjectId;
import org.mapstruct.InheritInverseConfiguration;

/**
 * Custom mapper that, if extended, acts as an implicit mapping from ObjectId -> String using built in toString().
 *
 * @author bkrpage
 */
public interface BsonMapper {

    default String map(ObjectId id){
        return id.toString();
    }
    @InheritInverseConfiguration
    default ObjectId map(String id){
        return new ObjectId(id);
    }
}
