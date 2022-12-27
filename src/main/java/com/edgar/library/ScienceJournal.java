package com.edgar.library;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Objects;

@Entity
public class ScienceJournal extends Book {
    @Min(1)
    @Max(10)
    private Integer scienceIndex;

    public ScienceJournal() {}

    public ScienceJournal(String name, String author, Long barcode, Integer quantity, Double priceUnit, Integer scienceIndex) {
        super(name, author, barcode, quantity, priceUnit);
        this.scienceIndex = scienceIndex;
    }

    public Integer getScienceIndex() {
        return this.scienceIndex;
    }

    public void setScienceIndex(Integer scienceIndex) {
        this.scienceIndex = scienceIndex;
    }

    public Double calculateTotalPrice() {
        return this.quantity * this.priceUnit * this.scienceIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScienceJournal ScienceJournal = (ScienceJournal) o;
        return Objects.equals(this.scienceIndex, ScienceJournal.scienceIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.scienceIndex);
    }

    @Override
    public String toString() {
        return "ScienceJournal{" + "scienceIndex=" + this.scienceIndex + "} " + super.toString();
    }
}
