
package Entity;
public class LoginAdmin {
    private int id;
    private String user_name;
    private String contrasenia;

    public LoginAdmin(int id, String user_name, String contrasenia) {
        this.id = id;
        this.user_name = user_name;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
