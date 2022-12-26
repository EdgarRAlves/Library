package com.edgar.library;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BookController {

    private final BookService service;

    BookController(BookService service) {
        this.service = service;
    }

    // Create new Book
    @PostMapping("/books")
    Book createBook(@Valid @RequestBody Book book) {
        return service.save(book);
    }

    // Get one book
    @GetMapping("/books/{barcode}")
    Book getOne(@PathVariable Long barcode) {
        return service.findByBarcode(barcode);
    }

    // Update a book
    @PutMapping("/books/{barcode}")
    Book updateBook(@Valid @RequestBody Book updatedBook, @PathVariable Long barcode) {
        return service.update(updatedBook, barcode);
    }

    // Get total price of all units of a book
    @GetMapping("/books/{barcode}/total-price")
    String getTotalPrice(@PathVariable Long barcode) {
        return service.getTotalPrice(barcode);
    }

    // Get a list of barcodes of books in stock grouped by quantity.
    @GetMapping("/books")
    List<Object[]> getListBarcodes() {
        return service.getListBarcodes();
    }
}
