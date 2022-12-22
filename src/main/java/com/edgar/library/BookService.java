package com.edgar.library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookService {

    private final BookRepository repository;

    BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(Book book) {
        return repository.save(book);
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

    public Double getTotalPrice(Long barcode) {
        Book book = repository.findById(barcode) . orElseThrow(() -> new BookNotFoundException(barcode));

        return book.calculateTotalPrice();
    }

    public List<Object[]> getListBarcodes() {
        return repository.findBarcodesInStockGroupByQuantity();
    }
}
