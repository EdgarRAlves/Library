package com.edgar.library;

import org.springframework.stereotype.Service;

@Service
class BookService {

    private final BookRepository repository;

    BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(Book newBook) {
        return repository.save(newBook);
    }

    public Book findByBarcode(Long barcode) {
        return repository.findById(barcode)
            .orElseThrow(() -> new BookNotFoundException(barcode));
    }

    public Book update(Book newBook, Long barcode) {
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
}
