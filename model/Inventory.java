import java.util.ArrayList;

public class Inventory {
    private ArrayList<LoanObject> loanObjects;



    public Inventory(ArrayList<LoanObject> loanObjects) {
        this.loanObjects = loanObjects;
    }

    public ArrayList<LoanObject> getLoanObjects() {
        return loanObjects;
    }

    public void setLoanObjects(ArrayList<LoanObject> loanObjects) {
        this.loanObjects = loanObjects;
    }


    

}
