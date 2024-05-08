package Services;

import data.Catalogue;
import data.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ArchiveFile implements Archive {

    private static final Logger logger = LoggerFactory.getLogger(ArchiveFile.class);
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    protected EntityManager em = emf.createEntityManager();

    private File file = new File("./catalogue.csv");

    @Override
    public void save(Catalogue catalogue) {
        var t = em.getTransaction();
        t.begin();
        em.persist(catalogue);
        t.commit();
    }

    @Override
    public void deleteISBN(int ISBN) {
        try {
            Catalogue catalogue = em.find(Catalogue.class, ISBN);

            if (catalogue != null) {
                var t = em.getTransaction();
                t.begin();
                em.remove(catalogue);
                t.commit();
                logger.info("Catalogue with ISBN {} removed with success", ISBN);
            } else {
                logger.warn("Nothing found with ISBN {}", ISBN);
            }
        } catch (Exception e) {
            logger.error("Error deleting catalogue with ISBN {}", ISBN, e);
        }
    }

    @Override
    public List<Catalogue> getByTitle(String title) {
        try {
            var query = em.createNamedQuery("GET_TITLE", Catalogue.class);
            query.setParameter("title", title);
            List<Catalogue> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Error searching for title", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Catalogue> getByAuthor(String author) {
        try {
            var query = em.createNamedQuery("GET_AUTHOR");
            query.setParameter("AUTHOR", author);
            List<Catalogue> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("No author was found", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Catalogue> getPublicationYear(LocalDate publicationYear) {
        try {
            var query = em.createNamedQuery("GET_YEAR");

            query.setParameter("publicationYear", publicationYear);
            List<Catalogue> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Nessun libro uscito in questo anno nel catalogo", e);
            return null;
        }
    }

    @Override
    public Optional<Catalogue> getISBN(int ISBN) {
        try {
            var query = em.createNamedQuery("GET_ISBN");
            query.setParameter("ISBN", ISBN);
            var cat = (Catalogue) query.getSingleResult();
            return Optional.of(cat);
        } catch (Exception e) {
            logger.error("Error searching catalogue by ISBN", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Loan> getExpiredLoanedElement() {return List.of();}

    @Override
    public List<Catalogue> getLoanedElement(int id) {return List.of();}

    @Override
    public void add(Catalogue catalogue) {}

    @Override
    public void getAuthor(String author) {}
}
