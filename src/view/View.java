package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Loan;
import model.LoanObject;
import utilities.Utils;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    //MENSAJES Y LECTURA

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public String readRequiredString(String message) {
        while (true) {
            String text = readString(message).trim();
            if (text.isEmpty()) {
                showMessage(Utils.EMPTY_FIELD);
            } else if (text.contains(";")) {
                showMessage(Utils.INVALID_CHARACTER);
            } else {
                return text;
            }
        }
    }

    public int readInt(String message) {
        while (true) {
            String text = readString(message).trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                showMessage(Utils.INVALID_NUMBER);
            }
        }
    }

    public int readOption() {
        return readInt(Utils.CHOOSE_OPTION);
    }

    public void waitForEnter() {
        readString(Utils.PRESS_ENTER);
    }

    private void showMenu(String[] lines) {
        for (String line : lines) {
            System.out.print(line);
        }
        System.out.println();
    }

<<<<<<< HEAD
    public void showMainMenu() {    
        showMenu(Utils.MAIN_MENU_TITLE);
=======
    public void showMainMenu() {
        showMenu(Utils.MAIN_MENU);
>>>>>>> e0caae1bde38dd7e9c3084fe91fde521bbc31567
    }

    public void showInventoryMenu() {
        showMenu(Utils.INVENTORY_MENU);
    }

    public void showLoansMenu() {
        showMenu(Utils.LOANS_MENU);
    }

    //TABLAS
    public void showObjects(ArrayList<LoanObject> objects) {
        if (objects == null || objects.isEmpty()) {
            showMessage(Utils.NO_RESULTS);
            return;
        }
        showMessage(Utils.OBJECT_HEADER);
        for (LoanObject obj : objects) {
            String status = obj.isAvailable() ? Utils.STATUS_AVAILABLE : Utils.STATUS_LOANED;
            showMessage(String.format(Utils.OBJECT_ROW,
                    obj.getId(), obj.getBrand(), obj.getType(), status, obj.getDescription()));
        }
    }

    public void showLoans(ArrayList<Loan> loans) {
        if (loans == null || loans.isEmpty()) {
            showMessage(Utils.NO_RESULTS);
            return;
        }
        showMessage(Utils.LOAN_HEADER);
        for (Loan loan : loans) {
            LoanObject obj = loan.getLoanObject();
            String typeAndBrand = obj.getType() + " / " + obj.getBrand();
            String returned = (loan.getReturnDate() == null)
                    ? Utils.NOT_RETURNED
                    : loan.getReturnDate().toString();
            showMessage(String.format(Utils.LOAN_ROW,
                    obj.getId(), typeAndBrand,
                    loan.getUser().getId(), loan.getUser().getName(), loan.getUser().getAcademicProgram(),
                    loan.getLoanDate().toString(), returned));
        }
    }
}
