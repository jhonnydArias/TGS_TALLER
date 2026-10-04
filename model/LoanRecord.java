import java.util.ArrayList;

public class LoanRecord {
    private ArrayList<Loan> loans;

    

    public LoanRecord() {
        this.loans = new ArrayList<>();
    }

    public LoanRecord(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public Loan searchByUserName (String userName){
        for(Loan loan : loans){
            if(loan.getUser().getName().equals(userName)){
                return loan;
            }
        }
        return null;
    }

    public Loan searchByUserId (int userId){
        for(Loan loan : loans){
            if(loan.getUser().getId() == userId){
                return loan;
            }
        }
        return null;
    }

    public Loan searchByLoanObjectName (String name){
        for(Loan loan : loans){
            if(loan.getLoanObject().getName().equals(name)){
                return loan;
            }
        }
        return null;
    }

    public Loan searchByLoanObjectId (int id){
        for(Loan loan : loans){
            if(loan.getLoanObject().getId() == id){
                return loan;
            }
        }
        return null;
    }

    public boolean addLoan(LoanObject loan, int userId, String userName, String academicProgram ) {
        User user = new User(userId, userName, academicProgram);
        Loan newLoan = new Loan(user, loan);
        loans.add(newLoan);
        return true;
    }

    public boolean deleteLoan(Loan loan) {
        if (loan != null && loans.contains(loan)) {
            loans.remove(loan);
            return true;
        }
        return false;
    }
    
    public boolean deleteLoanByName(String loanName) {
        Loan deleteLoan = searchByLoanObjectName(loanName);
        if(deleteLoan != null){
            loans.remove(deleteLoan);
            return true;
        }
        return false;
    }

    public boolean deleteLoanById(int loanId) {
        Loan deleteLoan = searchByLoanObjectId(loanId);
        if(deleteLoan != null){
            loans.remove(deleteLoan);
            return true;
        }
        return false;
    }

    public boolean deleteLoanByUserId(int userId) {
        Loan deleteLoan = searchByUserId(userId);
        if(deleteLoan != null){
            loans.remove(deleteLoan);
            return true;
        }
        return false;
    }

   
}
