import data.Book;
import data.Magazine;
import data.Periodicity;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.logging.Logger;

import Services.ArchiveFile;

public class Main {

    Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var ArchiveFile = new ArchiveFile();

        Book book0 = new Book("prova libro 0", LocalDate.parse("1999-03-02"), 100, "Mario Rossi", "giallo");
        Book book1 = new Book( "prova libro 1", LocalDate.parse("1998-04-03"), 150, "Mario Rossi", "narrativa");
        Book book2 = new Book( "prova libro 2", LocalDate.parse("1997-05-04"), 180, "Mario Rossi", "romantico");

        Magazine magazine0 = new Magazine("prova rivista 0", LocalDate.parse("1999-03-02"), 100, Periodicity.SEMIANNUAL);
        Magazine magazine1 = new Magazine("prova rivista 1", LocalDate.parse("1999-05-07"), 108, Periodicity.WEEKLY);
        Magazine magazine2 = new Magazine("prova rivista 2", LocalDate.parse("1999-06-03"), 150, Periodicity.MONTHLY);

        ArchiveFile.save(book0);
        ArchiveFile.save(book2);
        ArchiveFile.save(magazine0);
        ArchiveFile.save(magazine1);

        ArchiveFile.deleteISBN(1);
        ArchiveFile.deleteISBN(5);

        System.out.println(ArchiveFile.getByTitle("prova"));

        System.out.println(ArchiveFile.getByTitle("ciao"));
    }


}