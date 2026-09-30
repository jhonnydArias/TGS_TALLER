import java.sql.Date;

public class Loan {
    private User user;
    private LoanObject loanObject;
    private Date loanDate;
    private Date returnDate;

    // Constructors
    public Loan() {
    }

    public Loan(User user, LoanObject loanObject) {
        this.user = user;
        this.loanObject = loanObject;
        this.loanDate = new Date(System.currentTimeMillis());
    }

    // Getters and Setters
    public User getUser() {
        return user;    
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoanObject getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(LoanObject loanObject) {
        this.loanObject = loanObject;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
