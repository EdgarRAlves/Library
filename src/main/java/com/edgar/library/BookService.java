package com.edgar.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Double getTotalPrice(Long barcode) {
        Book book = repository.findById(barcode) . orElseThrow(() -> new BookNotFoundException(barcode));

        return book.calculateTotalPrice();
    }

    public Map<Integer, List<Book>> getListBarcodes() {
        return groupByQuantity(findAllInStock());
    }

    // Books can have quantity = 0
    public List<Book> findAllInStock() {
         return repository.findAll().stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
    }

    public Map<Integer, List<Book>> groupByQuantity(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(Book::getQuantity));
    }
}
