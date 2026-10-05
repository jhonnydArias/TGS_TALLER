import model.labSystem;
import view.View;
package controller;

public class Control {
    private labSystem labSystem;
    private View  view;

    public Control(labSystem labSystem, View view) {
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

    private void searchObjectByID(){
        try{
            int id = view.readInt("id");
            view.showMessage(labSystem.searchById(id).toString());
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

    private void deleteLoa
}
