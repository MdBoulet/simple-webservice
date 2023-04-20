package gn.boulet.simplewebservice.exception;

import java.text.MessageFormat;

public class ItemNotFoundNotException extends RuntimeException{

    public ItemNotFoundNotException(Long id) {
        super(MessageFormat.format("Could not found id : {} ", id));
    }
}
