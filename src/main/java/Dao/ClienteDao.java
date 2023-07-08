package Dao;
import Conexion.Conexion;
import Entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDao {
    private Connection conn;
    private PreparedStatement ps;
    public ClienteDao(){
        conn= Conexion.openConnection();
      
    }
    public void insert(Cliente cliente){
        try {
            String sql="INSERT INTO cliente(nombres,apellidos,dni,telefono)" +
                    " VALUES(?,?,?,?)";
            try {
                ps= conn.prepareStatement(sql);
                ps.setString(1,cliente.getNombres());
                ps.setString(2,cliente.getApellidos());
                ps.setString(3,cliente.getDni());
                ps.setString(4,cliente.getTelefono());
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("ERROR INSERT INTO CLIENTES"+e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Cliente> list(){
        List<Cliente> clients=new ArrayList<>();
        try {
            String sql="SELECT*FROM cliente order by id_cliente desc";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                Cliente cliente=new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"));
                clients.add(cliente);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return clients;

    }
    public Optional<Cliente> listId(Integer id){
        Optional<Cliente> optional= Optional.empty();
        try{
            String sql="SELECT*FROM cliente  WHERE id_cliente=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
              Cliente cliente=new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"));
                optional= Optional.of(cliente);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR OPTIONAL CLIENTES"+e);
        }
        return  optional;
    }

    public void update(Cliente cliente){
        try {
            String sql="UPDATE cliente SET nombres=?,apellidos=?,dni=?,telefono=? WHERE id_cliente=?";
            ps= conn.prepareStatement(sql);
            ps.setString(1,cliente.getNombres());
            ps.setString(2,cliente.getApellidos());
            ps.setString(3,cliente.getDni());
              ps.setString(4,cliente.getTelefono());
            ps.setInt(5,cliente.getId());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            System.out.println("ERROR UPDATE "+e);
        }
    }
    public void delete(Integer id){
        try {
            String sql="DELETE  FROM cliente WHERE id_cliente=?";
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

    public List<Cliente>Buscar(String texto) {
        List<Cliente> datos = new ArrayList<>();
        try {
            String sql="Select*from cliente  where id_cliente like '%" + texto + "%'or nombres like'%" + texto +
                    "%'or apellidos like'%" + texto + "%'or dni like'%" + texto + "%'or telefono like'%" + texto + "%'";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cliente cliente=new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"));
                datos.add(cliente);
            }
        } catch (Exception e) {
            System.out.println(e + "ERRRRROOOOOOORRRRRRR");
        }
        return datos;
    }
}
