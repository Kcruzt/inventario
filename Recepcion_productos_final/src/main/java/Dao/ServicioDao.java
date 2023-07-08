package Dao;
import Conexion.Conexion;
import Entity.Administrador;
import Entity.Carga;
import Entity.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioDao {
    private Connection conn;
    private PreparedStatement ps;
    public ServicioDao(){
        conn= Conexion.openConnection();
    
    }
    
    public List<Servicio> list(){
        List<Servicio> clients=new ArrayList<>();
        try {
            String sql="SELECT*FROM servicio";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
             
                Servicio servicio=new Servicio(
                        rs.getInt("id_servicio"),
                        rs.getString("descripcion"));
                clients.add(servicio);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return clients;

    }
    public Optional<Servicio> listId(Integer id){
        Optional<Servicio> optional= Optional.empty();
        try{
            String sql="SELECT*FROM servicio  WHERE id_servicio=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                Servicio servicio=new Servicio(
                        rs.getInt("id_servicio"),
                        rs.getString("descripcion"));
                optional= Optional.of(servicio);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR OPTIONAL LISTAR CATEGORIA"+e);
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
