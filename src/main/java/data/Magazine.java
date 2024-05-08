package data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("magazine")

public class Magazine extends Catalogue {

    private Periodicity periodicity;

    public Magazine(int ISBN, String title, LocalDate publicationYear, int pages, Periodicity periodicity) {
        super(title, publicationYear, pages);
        this.periodicity = periodicity;
    }

    public Magazine() {
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}
