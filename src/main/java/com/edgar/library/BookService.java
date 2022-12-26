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
        return repository.findByBarcode(barcode)
            .orElseThrow(() -> new BookNotFoundException(barcode));
    }

    public Book update(Book updatedBook, Long barcode) {
        Book book = findByBarcode(barcode);

        book.setName(updatedBook.getName());
        book.setAuthor(updatedBook.getAuthor());
        book.setBarcode(updatedBook.getBarcode());
        book.setQuantity(updatedBook.getQuantity());
        book.setPrice(updatedBook.getPriceUnit());

        if (book instanceof AntiqueBook) {
            ((AntiqueBook) book).setReleaseYear(((AntiqueBook) updatedBook).getReleaseYear());
        } else if (book instanceof ScienceJournal) {
            ((ScienceJournal) book).setScienceIndex(((ScienceJournal) updatedBook).getScienceIndex());
        }

        return save(book);
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
