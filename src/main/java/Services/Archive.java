package Services;

import data.Catalogue;
import data.Loan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Archive {

    void save(Catalogue catalogue);
    void add(Catalogue catalogue);
    void deleteISBN(int ISBN);
    List<Catalogue> getByTitle(String title);
    List<Catalogue> getLoanedElement(int id);
    List<Catalogue> getByAuthor(String author);
    void getAuthor(String author);
    List<Catalogue> getPublicationYear(LocalDate publicationYear);
    List<Loan> getExpiredLoanedElement();
    Optional<Catalogue> getISBN(int ISBN);
}
