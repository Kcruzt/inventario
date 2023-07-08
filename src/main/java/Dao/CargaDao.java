package Dao;
import Conexion.Conexion;
import Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CargaDao {
    private Connection conn;
    private PreparedStatement ps;
    private CategoriaDao categoriaDao;
    public CargaDao(){
        conn= Conexion.openConnection();
        categoriaDao=new CategoriaDao();
    }
    public void insert(Carga carga){
        try {
            String sql="INSERT INTO carga(id_categoria,descripcion,estado)" +
                    " VALUES(?,?,?)";
            try {
                ps= conn.prepareStatement(sql);
                ps.setInt(1,carga.getCategoria().getId());
                ps.setString(2,carga.getDescripcion());
                ps.setString(3,carga.getEstado());
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("ERROR INSERT INTO CARGA"+e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Carga> list(){
        List<Carga> clients=new ArrayList<>();
        try {
            String sql="SELECT*FROM carga order by id_carga desc";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                int idCategoria =rs.getInt("id_categoria");
                Optional<Categoria> optionalCategoria = categoriaDao.listId(idCategoria);
                Carga carga=new Carga(
                        rs.getInt("id_carga"),
                       optionalCategoria.get(),
                        rs.getString("descripcion"),
                        rs.getString("estado"));
                clients.add(carga);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return clients;

    }
    public Optional<Carga> listId(Integer id){
        Optional<Carga> optional= Optional.empty();
        try{
            String sql="SELECT*FROM carga  WHERE id_carga=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
               int idCategoria =rs.getInt("id_categoria");
                Optional<Categoria> optionalCategoria = categoriaDao.listId(idCategoria);
                Carga carga=new Carga(
                        rs.getInt("id_carga"),
                       optionalCategoria.get(),
                        rs.getString("descripcion"),
                        rs.getString("estado"));
                optional= Optional.of(carga);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR OPTIONAL CLIENTES"+e);
        }
        return  optional;
    }

   
    public void delete(Integer id){
        try {
            String sql="DELETE  FROM carga WHERE id_carga=?";
            try {
                ps= conn.prepareStatement(sql);
                ps.setInt(1,id);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("ERRORRRRRRR DELETE CLIENTES "+e);
            }
        }catch (Exception e){
            System.out.println("ERROR2"+e);
        }
    }
    
       public void update(Carga carga){
        try {
            String sql="UPDATE carga SET id_categoria=?,descripcion=?,estado=? WHERE id_carga=?";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,carga.getCategoria().getId());
            ps.setString(2,carga.getDescripcion());
            ps.setString(3,carga.getEstado());
              ps.setInt(4,carga.getId());
         
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            System.out.println("ERROR UPDATE CARGAAA "+e);
        }
    }

    public List<Carga>Buscar(String texto) {
        List<Carga> datos = new ArrayList<>();
        try {
            String sql="Select*from carga  where id_carga like '%" + texto + "%'or id_categoria like'%" + texto +
                    "%'or descripcion like'%" + texto + "%'or estado like'%" + texto + "%'";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idCategoria =rs.getInt("id_categoria");
                Optional<Categoria> optionalCategoria = categoriaDao.listId(idCategoria);
                Carga carga=new Carga(
                        rs.getInt("id_carga"),
                       optionalCategoria.get(),
                        rs.getString("descripcion"),
                        rs.getString("estado"));

                datos.add(carga);
            }
        } catch (Exception e) {
            System.out.println(e + "ERRRRROOOOOOORRRRRRR");
        }
        return datos;
    }
       public int obtenerIdCarga(){
        int id=0;
        try {
            String sql="Select*from carga order by id_carga desc limit 1";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                id=rs.getInt("id_carga");

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR OTENER ADMIN");
        }
        return id;

    
    }



}
