package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loan {

    private Long id;
    private User user;
    private List<Catalogue> loanedElements = new ArrayList<>();
    private LocalDate startLoan;
    private LocalDate endLoan = startLoan.plusDays(30);
    private LocalDate finalLoan;

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Catalogue> getLoanedElements() {
        return loanedElements;
    }

    public void setLoanedElements(List<Catalogue> loanedElements) {
        this.loanedElements = loanedElements;
    }

    public LocalDate getStartLoan() {
        return startLoan;
    }

    public void setStartLoan(LocalDate startLoan) {
        this.startLoan = startLoan;
    }

    public LocalDate getEndLoan() {
        return endLoan;
    }

    public void setEndLoan(LocalDate endLoan) {
        this.endLoan = endLoan;
    }

    public LocalDate getFinalLoan() {
        return finalLoan;
    }

    public void setFinalLoan(LocalDate finalLoan) {
        this.finalLoan = finalLoan;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", loanedElements=" + loanedElements +
                ", startLoan=" + startLoan +
                ", endLoan=" + endLoan +
                ", finalLoan=" + finalLoan +
                '}';
    }
}
