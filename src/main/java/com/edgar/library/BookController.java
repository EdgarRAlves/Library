package com.edgar.library;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
class BookController {

    private final BookService service;

    BookController(BookService service) {
        this.service = service;
    }

    // Create a new book
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return service.save(newBook);
    }

    // Get a book
    @GetMapping("/books/{barcode}")
    Book one(@PathVariable Long barcode) {
        return service.findByBarcode(barcode);
    }

    // Update a book
    @PutMapping("/books/{barcode}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long barcode) {
        return service.update(newBook, barcode);
    }

    // Get total price of all units of a book
    @GetMapping("/books/{barcode}/total-price")
    Double totalPrice(@PathVariable Long barcode) {
        return service.getTotalPrice(barcode);
    }

    // Get a list of barcodes of books in stock grouped by quantity.
    @GetMapping("/books")
    List<Object[]> listBarcodes() {
        return service.getListBarcodes();
    }
}
