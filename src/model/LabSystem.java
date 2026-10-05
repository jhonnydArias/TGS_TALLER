package model;

import java.util.ArrayList;

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
        if(loanRecord.searchActiveByLoanObjectId(id) != null){
            return false;
        }
        return inventory.deleteLoanObjectById(id);
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

        if (loanObject == null) { //el equipo no existe
            return false;
        }
        if (!loanObject.isAvailable()) { //ya está prestado
            return false;
        }

        loanRecord.addLoan(loanObject, userId, userName, academicProgram);
        loanObject.setAvailable(false); // pasa a no disponible
        return true;
    }

    public boolean returnLoan(int objectId) {
        LoanObject loanObject = inventory.searchById(objectId);

        if (loanObject == null) { //el equipo no existe
            return false;
        }

        Loan activeLoan = loanRecord.searchActiveByLoanObjectId(objectId);
        if (activeLoan != null) {
            activeLoan.setReturnDate(new java.sql.Date(System.currentTimeMillis()));
            loanObject.setAvailable(true); // pasa a disponible
            return true;
        }
        return false; //no se encontró un préstamo activo para este objeto
    }
}
