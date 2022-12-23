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
        if (this == o)
            return true;
        if (!(o instanceof ScienceJournal scienceJournal))
            return false;
        if (!super.equals(o))
            return false;
        return Objects.equals(this.scienceIndex, scienceJournal.scienceIndex);
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
