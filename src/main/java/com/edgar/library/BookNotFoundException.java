package com.edgar.library;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(Long barcode) {
        super("Could not find book " + barcode);
    }
}
