package model;

public class LoanObject {
    private int id;
    private String brand;
    private String type;
    private String description;
    private boolean isAvailable;


    public LoanObject(int id, String brand, String type, String description) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.isAvailable = true; 
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }   
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
