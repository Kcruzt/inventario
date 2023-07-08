package Entity;

public class Admin {
    private int id;
    private String nombreUser;
    private String contraseña;

    public Admin(int id, String nombreUser, String contraseña) {
        this.id = id;
        this.nombreUser = nombreUser;
        this.contraseña = contraseña;
    }
    public Admin(String nombreUser, String contraseña) {
        this.nombreUser = nombreUser;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
