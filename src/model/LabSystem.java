//CREACION DE LA CLASE SYSTEM, QUE CONTIENE EL INVENTARIO Y EL REGISTRO DE PRÉSTAMOS, "union de todaas las clases logicas"

import java.util.ArrayList;

/**
 * System
 */
public class LabSystem {

    private Inventory inventory;
    private LoanRecord loanRecord;

    public LabSystem(Inventory inventory, LoanRecord loanRecord) {
        this.inventory = inventory;
        this.loanRecord = loanRecord;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public LoanRecord getLoanRecord() {
        return loanRecord;
    }
    public void setLoanRecord(LoanRecord loanRecord) {
        this.loanRecord = loanRecord;
    }
    
    //FUNCIONES DE ADMINISTRADOR EN EL INVENTARIO

    public LoanObject searchLoanObjectById(int id) {
        return inventory.searchById(id);
    }

    public ArrayList<LoanObject> searchLoanObjectByType(String type) {
        return inventory.searchByType(type);
    }

    public boolean createLoanObject(int id, String brand, String type, String description) {
        return inventory.createLoanObject(id, brand, type, description);
    }

    public boolean deleteLoanObjectById(int id) {
        return inventory.deleteLoanObjectById(id);
    }

    public boolean updateStatusLoanObject(int id, boolean isAvailable) {
        return inventory.updateStatusLoanObject(id, isAvailable);
    }

    //FUNCIONES DEL ADMINISTRADOR EN EL REGISTRO DE PRÉSTAMOS

    public ArrayList<Loan> searchLoanByUserName(String userName) {
        return loanRecord.searchByUserName(userName);
    }

    public ArrayList<Loan> searchLoanByUserId(int userId) {
        return loanRecord.searchByUserId(userId);
    }

    public ArrayList<Loan> searchLoansByLoanObjectId(int id) {
        return loanRecord.searchByLoanObjectId(id);
    }

    public ArrayList<Loan> searchLoansByLoanObjectType(String type) {
        return loanRecord.searchByLoanObjectType(type);
    }

    public ArrayList<Loan> searchActiveLoansByLoanObjectType(String type) {
        return loanRecord.searchActiveByLoanObjectType(type);
    }

    public Loan searchActiveLoanByLoanObjectId(int id) {
        return loanRecord.searchActiveByLoanObjectId(id);
    }

    public boolean addLoan(int objectId, int userId, String userName, String academicProgram) {
        LoanObject loanObject = inventory.searchById(objectId);
        return loanRecord.addLoan(loanObject, userId, userName, academicProgram);
    }
}
