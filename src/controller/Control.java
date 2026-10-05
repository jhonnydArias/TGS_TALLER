import java.util.ArrayList;

import model.LabSystem;
import model.Loan;
import view.View;
package controller;

public class Control {
    private LabSystem labSystem;
    private View  view;

    public Control(LabSystem labSystem, View view) {
        this.labSystem = labSystem;
        this.view = view;
        this.run();
    
    }

    public void run() {
        String option = view.readString("menu");
        while (option != "5" ){
            switch(option){
                case "1":
                    
                    break;
                case "2":
                    break;

            }
            option = view.showMessage("menu");
        }
    }
//=========================METODOS DE LOS SWITCHCASE=======================================================
    private void searchObjectByID(){
        try{
            int id = view.readInt("id");
            view.showMessage(labSystem.searchLoanObjectById(id).toString());
        }
        catch (Exception e) {
            view.showMessage("Error al buscaar el objeto con el id " + e.getMessage());
        }
    }

    private void searchObjectByName(){
        try{
            String name = view.readString("name");
            view.showMessage(labSystem.searchByName(name).toString());
        }
        catch (Exception e) {
            view.showMessage("Error al buscar el objeto con el nombre " + e.getMessage());
        }
    }

    private void createLoanObject() {
        int id = view.readInt("Enter the ID of the loan object: ");
        String name = view.readString("Enter the name of the loan object: ");
        String description = view.readString("Enter the description of the loan object: ");
        boolean created = labSystem.createLoanObject(id, name, description);
        if (created) {
            view.showMessage("usuario creado con exito");
        } else {
            view.showMessage("Error:objeto ya creado o no se  pudo crear ");
        }
    }

    private void deleteLoaObjectById(){
        int id = view.readInt("Enter the ID of the loan object to delete: ");
        boolean deleted = labSystem.deleteLoanObjectById(id);
        if (deleted) {
            view.showMessage("Objeto eliminado con exito");
        } else {
            view.showMessage("Error: el objeto no existe o tiene un prestamo activo");
        }
    }

    private void searchLoanByUserName(){
        String userNAme  = view.readString("Enter the user name to search for loans: ");
        if (labSystem.searchLoanByUserName(userNAme).isEmpty()) {
            view.showMessage("No se encontraron préstamos para el usuario: " + userNAme);
        } else {
                view.showArray(labSystem.searchLoanByUserName(userNAme));
        }
    }

    private void searchLoanByUserId(){
        int userId = view.readInt("Enter the user ID to search for loans: ");
        if (labSystem.searchLoanByUserId(userId).isEmpty()) {
            view.showMessage("No se encontraron préstamos para el usuario con ID: " + userId);
        } else {
                view.showArray(labSystem.searchLoanByUserId(userId));
        }
    }

    

}
