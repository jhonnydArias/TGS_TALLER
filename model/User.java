public class User {
    private int id;
    private String name;
    private String AcademicProgram;
    private boolean isAdmin;

    
    public User(int id, String name, String AcademicProgram, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
        this.AcademicProgram = AcademicProgram;
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
    
}
