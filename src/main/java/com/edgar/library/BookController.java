package com.edgar.library;

import org.springframework.web.bind.annotation.*;

@RestController
class BookController {

    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    // Create a new book
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // Get a book
    @GetMapping("/books/{barcode}")
    Book one(@PathVariable Long barcode) {
        return repository.findById(barcode)
            .orElseThrow(() -> new BookNotFoundException(barcode));

    }

    // Update a book
    @PutMapping("/books/{barcode}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long barcode) {
        return repository.findById(barcode)
            .map(book -> {
                book.setName(newBook.getName());
                book.setAuthor(newBook.getAuthor());
                book.setBarcode(newBook.getBarcode());
                book.setQuantity(newBook.getQuantity());
                book.setPrice(newBook.getPriceUnit());
                return repository.save(book);
            })
            .orElseThrow(() -> new BookNotFoundException(barcode));
    }

    // Get total price of all units of a book
    @GetMapping("/books/{barcode}/total-price")
    Double totalPrice(@PathVariable Long barcode) {
        Book book = repository.findById(barcode) . orElseThrow(() -> new BookNotFoundException(barcode));
        return book.getTotalPrice();
    }

    // Get a list of barcodes of books in stock grouped by quantity
    //@GetMapping("/books")
    //List<Book> all() {
    //    return repository.findAll()
    //}

    // {50: barcodes, 10: barcodes, 34: barcodes}
}
