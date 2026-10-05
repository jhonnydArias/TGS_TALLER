package model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<LoanObject> loanObjects;



    public Inventory() {
        this.loanObjects = new ArrayList<>();
    }

    public ArrayList<LoanObject> getLoanObjects() {
        return loanObjects;
    }

    public void setLoanObjects(ArrayList<LoanObject> loanObjects) {
        this.loanObjects = loanObjects;
    }

    public ArrayList<LoanObject> searchByType(String type){
        ArrayList<LoanObject> results = new ArrayList<>();
        for (LoanObject loanObject : loanObjects) {
            if (loanObject.getType().equalsIgnoreCase(type)) {
                results.add(loanObject);
            }
        }
        return results;
    }

    public LoanObject searchById (int id){
        for (LoanObject loanObject : loanObjects) {
            if (loanObject.getId() == id) {
                return loanObject;
            }
        }
        return null;
    }

    public boolean createLoanObject (int id, String brand, String type, String description){
        if (searchById(id) != null) {
            return false; 
        }
        LoanObject loanObject = new LoanObject(id, brand, type, description);
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
    

    /*public boolean updateStatusLoanObject (int id, boolean isAvailable){
        LoanObject loanObject = searchById(id);
        if (loanObject != null) {
            loanObject.setAvailable(isAvailable);
            return true;
        }
        return false;
    }*/

        public ArrayList<LoanObject> getAvailableLoanObjects() {
            ArrayList<LoanObject> availableObjects = new ArrayList<>();
            for (LoanObject loanObject : loanObjects) {
                if (loanObject.isAvailable()) {
                    availableObjects.add(loanObject);
                }
            }
            return availableObjects;
        }
}
