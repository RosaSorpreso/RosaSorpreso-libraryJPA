package data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Catalogue_element", discriminatorType = DiscriminatorType.STRING)

@NamedQuery(name = "GET_ISBN", query = "SELECT c FROM Catalogue c WHERE c.ISBN = :ISBN")
@NamedQuery(name = "GET_YEAR", query = "SELECT c FROM Catalogue c WHERE c.publicationYear = :publicationYear")
@NamedQuery(name = "GET_AUTHOR", query = "SELECT c FROM Catalogue c WHERE c.author = :AUTHOR")
@NamedQuery(name = "GET_TITLE", query = "SELECT c FROM Catalogue c WHERE c.title LIKE CONCAT('%', :title, '%')")

public abstract class Catalogue {
    @Id
    @GeneratedValue
    private Integer ISBN;
    private String title;
    private LocalDate publicationYear;
    private int pages;

    public Catalogue(String title, LocalDate publicationYear, int pages) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }

    public Catalogue() {
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "Catalogue{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                '}';
    }
}
