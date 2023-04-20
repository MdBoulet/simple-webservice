package gn.boulet.simplewebservice.exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long id) {
        super(MessageFormat.format("Cart with {} id not found", id));
    }
}
