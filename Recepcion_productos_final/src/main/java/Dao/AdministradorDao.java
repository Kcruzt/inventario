package Dao;
import Conexion.Conexion;
import Entity.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministradorDao {
    private Connection conn;
    private PreparedStatement ps;
    public AdministradorDao(){
        conn= Conexion.openConnection();  
    }
    
    public Optional<Administrador> listId(Integer id){
        Optional<Administrador> optional= Optional.empty();
        try{
            String sql="SELECT*FROM administrador  WHERE id_administrador=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                Administrador administrador=new Administrador(
                        rs.getInt("id_administrador"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"));
                optional= Optional.of(administrador);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR OPTIONAL CLIENTES"+e);
        }
        return  optional;
    }
  /* 
    public int obtenerIdAdmin(){
        int id=0;
        try {
            String sql="Select * from usuario_ad order by id_user desc limit 1";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                id=rs.getInt("id_user");

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return id;

    }*/


}
