package com.edgar.library;

class BookNotFoundException extends RuntimeException {
    BookNotFoundException(Long barcode) {
        super("Could not find book " + barcode);
    }
}
