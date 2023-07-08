package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    private static Connection conn;
    // Metodo para abrir la conexión a la base de datos
    public static Connection openConnection() {
        if ( conn != null )
            return conn;
        try {
            String usuario = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/mariadb?useSSL=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            System.err.println("Conexion establecida");
        } catch (Exception e) {
            System.err.println( e.getMessage() );
            System.err.println("Conexion Fallida");
        }
        return conn;
    }
    public static void closeConnection() {
        try {
            if( conn != null ) {
                conn.close();
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}