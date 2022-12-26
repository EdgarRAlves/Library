package com.edgar.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBarcode(Long barcode);

    @Query(value =
            "SELECT CONCAT('Quantity: ',b.quantity), CONCAT('Barcodes: ', GROUP_CONCAT(b.barcode SEPARATOR ', '))" +
            "FROM Book as b " +
            "WHERE b.quantity > 0 " +
            "GROUP BY b.quantity", nativeQuery = true)
    List<Object[]> findBarcodesInStockGroupByQuantity();
}
