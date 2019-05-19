package dev.bradleypage.author;

public class DuplicateUsernameException extends Exception {

    public DuplicateUsernameException(String errorMessage){
        super(errorMessage);
    }

    public DuplicateUsernameException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
