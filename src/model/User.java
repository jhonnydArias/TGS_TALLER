package model;

public class User {
    private int id;
    private String name;
    private String academicProgram;
    private boolean isAdmin;

    
    public User(int id, String name, String academicProgram, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
        this.academicProgram = academicProgram;
    }

    public User(int id, String name, String academicProgram) {
        this.id = id;
        this.name = name;
        this.isAdmin = false;
        this.academicProgram = academicProgram;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public String getAcademicProgram() {
    return academicProgram;
    }
    public void setAcademicProgram(String academicProgram) {
        this.academicProgram = academicProgram;
    }
    
}
