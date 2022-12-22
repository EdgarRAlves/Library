package com.edgar.library;

import jakarta.persistence.Entity;

import java.time.Year;
import java.util.Objects;

@Entity
public class AntiqueBook extends Book {
    private static final Integer CURRENT_YEAR = Year.now().getValue();

    private Integer releaseYear;

    public AntiqueBook() {}

    public AntiqueBook(String name, String author, Long barcode, Integer quantity, Double priceUnit, Integer releaseYear) {
        super(name, author, barcode, quantity, priceUnit);
        this.releaseYear = releaseYear;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double calculateTotalPrice() {
        return this.quantity * this.priceUnit * (CURRENT_YEAR - this.releaseYear)/10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AntiqueBook antiqueBook))
            return false;
        if (!super.equals(o))
            return false;
        return Objects.equals(this.releaseYear, antiqueBook.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.releaseYear);
    }

    @Override
    public String toString() {
        return "AntiqueBook{" + "releaseYear=" + this.releaseYear + "} " + super.toString();
    }
}