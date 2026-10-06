package model;

import java.util.ArrayList;

import persistence.FileManager;

public class LabSystem {

    private Inventory inventory;
    private LoanRecord loanRecord;
    private FileManager fileManager;
    private boolean lastSaveSuccessful = true;

    public LabSystem() {
        this.fileManager = new FileManager();
        this.inventory = fileManager.loadInventory();
        this.loanRecord = fileManager.loadLoanRecord(inventory);
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
        boolean created = inventory.createLoanObject(id, brand, type, description);
        if (created) {
            saveInventory();
        }
        return created; 
    }

    public boolean deleteLoanObjectById(int id) {
        if (loanRecord.searchActiveByLoanObjectId(id) != null) {
            return false;
        }
        boolean deleted = inventory.deleteLoanObjectById(id);
        if (deleted) {
            saveInventory();
        }
        return deleted;
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
        if (loanObject == null || !loanObject.isAvailable()) {
            return false;
        }
        loanRecord.addLoan(loanObject, userId, userName, academicProgram);
        loanObject.setAvailable(false);
        saveLoanRecord();
        return true;
    }

    public boolean returnLoan(int objectId) {
        LoanObject loanObject = inventory.searchById(objectId);
        if (loanObject == null) {
            return false;
        }
        Loan activeLoan = loanRecord.searchActiveByLoanObjectId(objectId);
        if (activeLoan == null) {
            return false;
        }
        activeLoan.setReturnDate(new java.sql.Date(System.currentTimeMillis()));
        loanObject.setAvailable(true);
        saveLoanRecord();
        return true;
    }

    public ArrayList<LoanObject> getAllLoanObjects() {
        return inventory.getLoanObjects();
    }

    public ArrayList<LoanObject> getAvailableLoanObjects() {
        return inventory.getAvailableLoanObjects();
    }

    public ArrayList<Loan> getActiveLoans() {
    ArrayList<Loan> activeLoans = new ArrayList<>();
    for (LoanObject obj : inventory.getLoanObjects()) {
        Loan loan = loanRecord.searchActiveByLoanObjectId(obj.getId());
        if (loan != null) {
            activeLoans.add(loan);
        }
    }
    return activeLoans;
    }

    public boolean existsLoanObject(int id) {
        return inventory.searchById(id) != null;
    }

    public boolean isLoanObjectAvailable(int id) {
        LoanObject obj = inventory.searchById(id);
        return obj != null && obj.isAvailable();
    }

    public ArrayList<LoanObject> searchLoanObjectsById(int id) {
        ArrayList<LoanObject> result = new ArrayList<>();
        LoanObject obj = inventory.searchById(id);
        if (obj != null) {
            result.add(obj);
        }
        return result;
    }

    public boolean saveData() {
        boolean inventorySaved = fileManager.saveInventory(inventory);
        boolean loansSaved = fileManager.saveLoanRecord(loanRecord);
        return inventorySaved && loansSaved;
    }

    private void saveInventory() {
        lastSaveSuccessful = fileManager.saveInventory(inventory);
    }

    private void saveLoanRecord() {
    lastSaveSuccessful = fileManager.saveLoanRecord(loanRecord);
    }

    public boolean isLastSaveSuccessful() {
        return lastSaveSuccessful;
    }
}
