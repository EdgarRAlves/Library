package com.edgar.library;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
        Book oldBook = findByBarcode(barcode);
        repository.delete(oldBook);

        return save(newBook);
    }

    public String getTotalPrice(Long barcode) {
        Book book = findByBarcode(barcode);

        DecimalFormat df = new DecimalFormat("#.00");

        return "Total price = " + df.format(book.calculateTotalPrice()) + "€";
    }

    public List<Object[]> getListBarcodes() {
        return repository.findBarcodesInStockGroupByQuantity();
    }
}
