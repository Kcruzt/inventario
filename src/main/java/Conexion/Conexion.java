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
            String url="jdbc:mysql://database-cloud.mysql.database.azure.com:3306/mariadb?useSSL=true";Connection myDbConn = DriverManager.getConnection(url, "Administrador", "Kc77532875.");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
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