package dev.bradleypage.mapping;

import org.bson.types.ObjectId;

/**
 * Custom mapper that, if extended, acts as an implicit mapping from ObjectId -> String using built in toString().
 *
 * @author bkrpage
 */
public interface BsonMapper {

    default String map(ObjectId id){
        return id.toString();
    }
}
