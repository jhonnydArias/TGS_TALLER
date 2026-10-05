package controller;

import model.LabSystem;
import utilities.Utils;
import view.View;

public class Control {

    private LabSystem labSystem;
    private View view;

    public Control() {
        this.labSystem = new LabSystem();
        this.view = new View();
        run();
        labSystem.saveData();
    }

    // MENÚ PRINCIPAL

    public void run() {
        view.showMessage(Utils.WELCOME);
        view.showMainMenu();
        int option = view.readOption();
        while (option != 0) {
            switch (option) {
                case 1:
                    createNewLoan();
                    break;
                case 2:
                    returnLoan();
                    break;
                case 3:
                    showInventory();
                    break;
                case 4:
                    showLoanRecord();
                    break;
                case 5:
                    createLoanObject();
                    break;
                case 6:
                    deleteLoanObjectById();
                    break;
                default:
                    view.showMessage(Utils.INVALID_OPTION);
                    break;
            }
            view.showMainMenu();
            option = view.readOption();
        }
    }

    // 1=

    private void createNewLoan() {
        view.showMessage(Utils.LOAN_TITLE);
        int objectId = view.readInt(Utils.ASK_OBJECT_ID);

        if (!labSystem.existsLoanObject(objectId)) {
            view.showMessage(Utils.LOAN_OBJECT_NOT_FOUND);
            return;
        }
        if (!labSystem.isLoanObjectAvailable(objectId)) {
            view.showMessage(Utils.LOAN_NOT_AVAILABLE);
            return;
        }

        int userId = view.readInt(Utils.ASK_USER_ID);
        String userName = view.readRequiredString(Utils.ASK_USER_NAME);
        String userProgram = view.readRequiredString(Utils.ASK_USER_PROGRAM);

        if (labSystem.addLoan(objectId, userId, userName, userProgram)) {
            view.showMessage(Utils.LOAN_OK);
        } else {
            view.showMessage(Utils.LOAN_NOT_AVAILABLE);
        }
    }

    // 2

    private void returnLoan() {
        view.showMessage(Utils.RETURN_TITLE);
        int objectId = view.readInt(Utils.ASK_OBJECT_ID);

        if (labSystem.returnLoan(objectId)) {
            view.showMessage(Utils.RETURN_OK);
        } else {
            view.showMessage(Utils.RETURN_FAIL);
        }
    }

    // 3

    private void showInventory() {
        view.showInventoryMenu();
        int option = view.readOption();
        while (option != 0) {
            switch (option) {
                case 1:
                    viewAllLoanObjects();
                    break;
                case 2:
                    viewAvailableLoanObjects();
                    break;
                case 3:
                    searchObjectByType();
                    break;
                case 4:
                    searchObjectById();
                    break;
                default:
                    view.showMessage(Utils.INVALID_OPTION);
                    break;
            }
            view.showInventoryMenu();
            option = view.readOption();
        }
    }

    private void viewAllLoanObjects() {
        view.showObjects(labSystem.getAllLoanObjects());
        view.waitForEnter();
    }

    private void viewAvailableLoanObjects() {
        view.showObjects(labSystem.getAvailableLoanObjects());
        view.waitForEnter();
    }

    private void searchObjectByType() {
        String type = view.readRequiredString(Utils.ASK_OBJECT_TYPE);
        view.showObjects(labSystem.searchLoanObjectByType(type));
        view.waitForEnter();
    }

    private void searchObjectById() {
        int id = view.readInt(Utils.ASK_OBJECT_ID);
        view.showObjects(labSystem.searchLoanObjectsById(id));
        view.waitForEnter();
    }

    // 4

    private void showLoanRecord() {
        view.showLoansMenu();
        int option = view.readOption();
        while (option != 0) {
            switch (option) {
                case 1:
                    viewActiveLoans();
                    break;
                case 2:
                    viewActiveLoansByType();
                    break;
                case 3:
                    viewLoanHistoryByObjectId();
                    break;
                case 4:
                    viewLoanHistoryByType();
                    break;
                case 5:
                    searchLoanByUserId();
                    break;
                case 6:
                    searchLoanByUserName();
                    break;
                default:
                    view.showMessage(Utils.INVALID_OPTION);
                    break;
            }
            view.showLoansMenu();
            option = view.readOption();
        }
    }

    private void viewActiveLoans() {
        view.showLoans(labSystem.getActiveLoans());
        view.waitForEnter();
    }

    private void viewActiveLoansByType() {
        String type = view.readRequiredString(Utils.ASK_OBJECT_TYPE);
        view.showLoans(labSystem.searchActiveLoansByLoanObjectType(type));
        view.waitForEnter();
    }

    private void viewLoanHistoryByObjectId() {
        int id = view.readInt(Utils.ASK_OBJECT_ID);
        view.showLoans(labSystem.searchLoansByLoanObjectId(id));
        view.waitForEnter();
    }

    private void viewLoanHistoryByType() {
        String type = view.readRequiredString(Utils.ASK_OBJECT_TYPE);
        view.showLoans(labSystem.searchLoansByLoanObjectType(type));
        view.waitForEnter();
    }

    private void searchLoanByUserId() {
        int userId = view.readInt(Utils.ASK_USER_ID);
        view.showLoans(labSystem.searchLoanByUserId(userId));
        view.waitForEnter();
    }

    private void searchLoanByUserName() {
        String userName = view.readRequiredString(Utils.ASK_USER_NAME);
        view.showLoans(labSystem.searchLoanByUserName(userName));
        view.waitForEnter();
    }

    // 5

    private void createLoanObject() {
        view.showMessage(Utils.CREATE_TITLE);

        int id = view.readInt(Utils.ASK_OBJECT_ID);
        while (labSystem.existsLoanObject(id)) {
            view.showMessage(Utils.CREATE_DUPLICATE_ID);
            id = view.readInt(Utils.ASK_OBJECT_ID); // <-- esta línea falta
        }

        String brand = view.readRequiredString(Utils.ASK_OBJECT_BRAND);
        String type = view.readRequiredString(Utils.ASK_OBJECT_TYPE);
        String description = view.readRequiredString(Utils.ASK_OBJECT_DESCRIPTION);

        if (labSystem.createLoanObject(id, brand, type, description)) {
            saveChanges();
            view.showMessage(Utils.CREATE_OK);
        } else {
            view.showMessage(Utils.CREATE_DUPLICATE_ID);
        }
    }

    // 6

    private void deleteLoanObjectById() {
        view.showMessage(Utils.DELETE_TITLE);
        int id = view.readInt(Utils.ASK_OBJECT_ID);

        if (labSystem.deleteLoanObjectById(id)) {
            view.showMessage(Utils.DELETE_OK);
        } else {
            view.showMessage(Utils.DELETE_FAIL);
        }
    }

    private void saveChanges() {
        if (!labSystem.saveData()) {
            view.showMessage(Utils.SAVE_ERROR);
        }
    }

    public static void main(String[] args) {
        new Control();
    }
}