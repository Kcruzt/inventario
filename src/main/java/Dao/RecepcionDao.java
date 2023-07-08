package Dao;
import Conexion.Conexion;
import Entity.Administrador;
import Entity.Categoria;
import Entity.Cliente;
import Entity.Recepcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecepcionDao {
    private Connection conn;
    private PreparedStatement ps;
    private ClienteDao clienteDao;
    private AdministradorDao administradorDao;
    public RecepcionDao(){
        conn= Conexion.openConnection();
        clienteDao=new ClienteDao();
        administradorDao=new AdministradorDao();
    }
    public void insert(Recepcion recepcion){
        try {
            String sql="INSERT INTO recepcion(id_cliente,id_administrador,tipo_comprobante,fecha,estado,total)" +
                    " VALUES(?,?,?,now(),?,?)";
            try {
                ps= conn.prepareStatement(sql);
                ps.setInt(1,recepcion.getCliente().getId());
                ps.setInt(2,recepcion.getAdministrador().getId());
                ps.setString(3,recepcion.getTipoComprobante());
                ps.setString(4,recepcion.getEstado());
                 ps.setString(5,recepcion.getTotal());
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("ERROR INSERT INTO CLIENTES"+e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Recepcion> list(){
        List<Recepcion> clients=new ArrayList<>();
        try {
            String sql="SELECT*FROM recepcion";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                int id_cliente=rs.getInt("id_cliente");
                int id_administrador=rs.getInt("id_administrador");
                 Optional<Cliente> optionalCliente = clienteDao.listId(id_cliente);
                   Optional<Administrador> optionalAdministrador= administradorDao.listId(id_administrador);
                Recepcion recepcion=new Recepcion(
                        rs.getInt("id_recepcion"),
                        optionalCliente.get(),
                        optionalAdministrador.get(),
                        rs.getString("tipo_comprobante"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("total"));
                clients.add(recepcion);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return clients;

    }
    public Optional<Recepcion> listId(Integer id){
        Optional<Recepcion> optional= Optional.empty();
        try{
            String sql="SELECT*FROM recepcion  WHERE id_recepcion=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
              int id_cliente=rs.getInt("id_cliente");
                int id_administrador=rs.getInt("id_administrador");
                 Optional<Cliente> optionalCliente = clienteDao.listId(id_cliente);
                   Optional<Administrador> optionalAdministrador= administradorDao.listId(id_administrador);
                Recepcion recepcion=new Recepcion(
                        rs.getInt("id_recepcion"),
                        optionalCliente.get(),
                        optionalAdministrador.get(),
                        rs.getString("tipo_comprobante"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getString("total"));
                optional= Optional.of(recepcion);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR OPTIONAL CLIENTES"+e);
        }
        return  optional;
    }

    public void update(Recepcion recepcion){
        try {
            String sql="UPDATE recepcion SET id_cliente=?,tipo_comprobante=? ,estado=?, total=? WHERE id_recepcion=?";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,recepcion.getCliente().getId());
            ps.setString(2,recepcion.getTipoComprobante());
              ps.setString(3,recepcion.getEstado());
               ps.setString(4,recepcion.getTotal());
            ps.setInt(5,recepcion.getId());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            System.out.println("ERROR UPDATE  RECPCCIONNNNNNNNNNNN"+e);
        }
    }
    public void delete(Integer id){
        try {
            String sql="DELETE  FROM recepcion WHERE id_recepcion=?";
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
    public int obtenerIdRecepcion(){
        int id=0;
        try {
            String sql="Select*from recepcion order by id_recepcion desc limit 1";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                id=rs.getInt("id_recepcion");

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR OTENER ADMIN");
        }
        return id;

    
    }}
