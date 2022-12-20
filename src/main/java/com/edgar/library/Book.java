package com.edgar.library;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {
    private String name;
    private String author;
    private @Id Long barcode;
    private Integer quantity;
    private Double priceUnit;

    protected Book() {}

    public Book(String name, String author, Long barcode, Integer quantity, Double priceUnit) {
        this.name = name;
        this.author = author;
        this.barcode = barcode;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public Long getBarcode() {
        return this.barcode;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getPriceUnit() {
        return this.priceUnit;
    }

    public Double getTotalPrice() {
        return this.priceUnit * this.quantity;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public void setAuthor(String Author) {
        this.author = author;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return Objects.equals(this.name, book.name) && Objects.equals(this.author, book.author) &&
                Objects.equals(this.barcode, book.barcode) && Objects.equals(this.quantity, book.quantity) &&
                Objects.equals(this.priceUnit, book.priceUnit);
    }

    @Override
    public int hashCode() {
       return Objects.hash(this.name, this.author, this.barcode, this. quantity, this.priceUnit);
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + this.name + ", author=" + this.author + ", barcode=" + this.barcode +
                ", quantity=" + this.quantity + ", price =" + this.priceUnit + '}';
    }
}
