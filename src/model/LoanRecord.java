package model;

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

    public ArrayList<Loan> searchByUserName(String userName) {
    ArrayList<Loan> results = new ArrayList<>();
    for (Loan loan : loans) {
        if (loan.getUser().getName().equalsIgnoreCase(userName)) {
            results.add(loan);
        }
    }
    return results;
}

    public ArrayList<Loan> searchByUserId(int userId) {
    ArrayList<Loan> results = new ArrayList<>();
    for (Loan loan : loans) {
        if (loan.getUser().getId() == userId) {
            results.add(loan);
        }
    }
    return results;
}

    public ArrayList<Loan> searchByLoanObjectType (String type){
        ArrayList<Loan> results = new ArrayList<>();
        for(Loan loan : loans){
            if(loan.getLoanObject().getType().equalsIgnoreCase(type)){
                results.add(loan);
            }
        }
        return results;
    }

    public ArrayList<Loan> searchByLoanObjectId(int id) {
    ArrayList<Loan> results = new ArrayList<>();
    for (Loan loan : loans) {
        if (loan.getLoanObject().getId() == id) {
            results.add(loan);
        }
    }
    return results;
}
    

    public ArrayList<Loan> searchActiveByLoanObjectType(String type) {
    ArrayList<Loan> results = new ArrayList<>();
    for (Loan loan : loans) {
        if (loan.isActive() && loan.getLoanObject().getType().equalsIgnoreCase(type)) {
            results.add(loan);
        }
    }
    return results;
    }

    public Loan searchActiveByLoanObjectId(int id) {
    for (Loan loan : loans) {
        if (loan.isActive() && loan.getLoanObject().getId() == id) {
            return loan;
        }
    }
    return null;
    }
    public boolean addLoan(LoanObject loan, int userId, String userName, String academicProgram) {
        User user = new User(userId, userName, academicProgram);
        Loan newLoan = new Loan(user, loan);
        loans.add(newLoan);
        return true;
    }
}
