package com.edgar.library;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AntiqueBook.class, name = "AntiqueBook"),
    @JsonSubTypes.Type(value = ScienceJournal.class, name = "ScienceJournal")
})
@Entity
public class Book {
    protected String name;
    protected String author;
    protected @Id Long barcode;
    protected Integer quantity;
    protected Double priceUnit;

    public Book() {}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
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

    public Double calculateTotalPrice() {
        return this.quantity * this.priceUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book book))
            return false;
        return Objects.equals(this.name, book.name) && Objects.equals(this.author, book.author) &&
                Objects.equals(this.barcode, book.barcode) && Objects.equals(this.quantity, book.quantity) &&
                Objects.equals(this.priceUnit, book.priceUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.author, this.barcode, this.quantity, this.priceUnit);
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + this.name + '\'' + ", author='" + this.author + '\'' + ", barcode=" + this.barcode +
                ", quantity=" + this.quantity + ", priceUnit=" + this.priceUnit + '}';
    }
}
