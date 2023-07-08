package Dao;
import Conexion.Conexion;
import Entity.Administrador;
import Entity.Categoria;
import Entity.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDao {
    private Connection conn;
    private PreparedStatement ps;
    public CategoriaDao(){
        conn= Conexion.openConnection();
    
    }
    
    public List<Categoria> list(){
        List<Categoria> categorias=new ArrayList<>();
        try {
            String sql="SELECT*FROM categoria";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
             
                Categoria categoria=new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion"));
                categorias.add(categoria);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return categorias;

    }
    public Optional<Categoria> listId(Integer id){
        Optional<Categoria> optional= Optional.empty();
        try{
            String sql="SELECT*FROM categoria  WHERE id_categoria=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                Categoria categoria=new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion"));
                optional= Optional.of(categoria);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR LISTAR CATEGORIA "+e);
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
