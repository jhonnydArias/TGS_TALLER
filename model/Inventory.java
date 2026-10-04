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

    public LoanObject searhByName (String name){
        for (LoanObject loanObject : loanObjects) {
            if (loanObject.getName().equals(name)) {
                return loanObject;
            }
        }
        return null;

    }

    public LoanObject searchById (int id){
        for (LoanObject loanObject : loanObjects) {
            if (loanObject.getId() == id) {
                return loanObject;
            }
        }
        return null;
    }

    public boolean createLoanObject ( int id, String name, String description){
        if (searchById(id) != null || searhByName(name) != null) {
            return false; 
        }
        LoanObject loanObject = new LoanObject(id, name, description);
        loanObjects.add(loanObject);
        return true;
    }

    public boolean deleteLoanObjectById (int id){
        LoanObject loanObject = searchById(id);
        if (loanObject != null) {
            loanObjects.remove(loanObject);
            return true;
        }
        return false;
    }

    public boolean deleteLoanObjectByName (String name){
        LoanObject loanObject = searhByName(name);
        if (loanObject != null) {
            loanObjects.remove(loanObject);
            return true;
        }
        return false;
    }   

    public boolean updateStatusLoanObject (int id, boolean isAvailable){
        LoanObject loanObject = searchById(id);
        if (loanObject != null) {
            loanObject.setAvailable(isAvailable);
            return true;
        }
        return false;
    }


}
