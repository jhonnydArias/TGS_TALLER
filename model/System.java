//CREACION DE LA CLASE SYSTEM, QUE CONTIENE EL INVENTARIO Y EL REGISTRO DE PRÉSTAMOS, "union de todaas las clases logicas"

/**
 * System
 */
public class System {

    private Inventory inventory;
    private LoanRecord loanRecord;

    public System(Inventory inventory, LoanRecord loanRecord) {
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

    public LoanObject searchLoanObjectById(int id){
        return inventory.searchById(id);
    }

    public LoanObject searchLoanObjectByName(String name){
        return inventory.searhByName(name);
    }


    public boolean createLoanObject(int id, String name, String description){
        return inventory.createLoanObject(id, name, description);
    }

    public boolean deleteLoanObjectById(int id){
        return inventory.deleteLoanObjectById(id);
    }

    public boolean deleteLoanObjectByName(String name){
        return inventory.deleteLoanObjectByName(name);
    }

    public boolean updateStatusLoanObject(int id, boolean isAvailable){
        return inventory.updateStatusLoanObject(id, isAvailable);
    }

    //FUNCIONES DEL ADMINISTRADOR EN EL REGISTRO DE PRÉSTAMOS

    public Loan searchLoanByUserName(String userName){
        return loanRecord.searchByUserName(userName);
    }

    public Loan searchLoanByUserId(int userId){
        return loanRecord.searchByUserId(userId);
    }
    public Loan searchLoanByLoanObjectName(String name){
        return loanRecord.searchByLoanObjectName(name);
    }
    public Loan searchLoanByLoanObjectId(int id){
        return loanRecord.searchByLoanObjectId(id);
    }

    public boolean addLoan(int objectId, int userId, String userName, String academicProgram) {
        LoanObject loanObject = inventory.searchById(objectId);
        return loanRecord.addLoan(loanObject, userId, userName, academicProgram);
    }

    public boolean deleteLoan(int loanId) {
        return loanRecord.deleteLoanById(loanId);
    }

    public boolean deleteLoanByUserId(int userId) {
        return loanRecord.deleteLoanByUserId(userId);
    }   
}
