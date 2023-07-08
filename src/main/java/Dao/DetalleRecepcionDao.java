package Dao;
import Conexion.Conexion;
import Entity.Administrador;
import Entity.Carga;
import Entity.Categoria;
import Entity.Cliente;
import Entity.DetalleRecepcion;
import Entity.Recepcion;
import Entity.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleRecepcionDao {
    private Connection conn;
    private PreparedStatement ps;
    private CargaDao cargaDao;
    private RecepcionDao recepcionDao;
    private ServicioDao servicioDao;
    public DetalleRecepcionDao(){
        conn= Conexion.openConnection();
        cargaDao=new CargaDao();
        recepcionDao=new RecepcionDao();
        servicioDao=new ServicioDao();
    }
    public void insert(DetalleRecepcion detalle){
        try {
            String sql="INSERT INTO detalle_recepcion(id_recepcion,id_servicio,id_carga)" +
                    " VALUES(?,?,?)";
            try {
                ps= conn.prepareStatement(sql);
                ps.setInt(1,detalle.getRecepcion().getId());
                ps.setInt(2,detalle.getServicio().getId());
                ps.setInt(3,detalle.getCarga().getId());
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("ERROR INSERT INTO CLIENTES"+e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<DetalleRecepcion> list(){
        List<DetalleRecepcion> clients=new ArrayList<>();   
        try {
            //Ordenando del mas reciente al mas antiguo
            String sql="SELECT*FROM detalle_recepcion order by id_detalle_re desc";
            ps=conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                int id_r=rs.getInt("id_detalle_re");
                int id_recepcion=rs.getInt("id_recepcion");
                int id_servicio=rs.getInt("id_servicio");
                int id_carga=rs.getInt("id_carga");
                    Optional<Recepcion> optionalRecepcion = recepcionDao.listId(id_recepcion);
                   Optional<Servicio> optionalServicio= servicioDao.listId(id_servicio);
                   Optional<Carga> optionalCarga= cargaDao.listId(id_carga);
                DetalleRecepcion recepcion=new DetalleRecepcion(
                        id_r,
                        optionalRecepcion.get(),
                        optionalServicio.get(),
                        optionalCarga.get());
                clients.add(recepcion);

            }
        }catch (Exception e){
            System.out.println(e+"ERRROR LISTAR");
        }
        return clients;

    }
    public Optional<DetalleRecepcion> listId(Integer id){
        Optional<DetalleRecepcion> optional= Optional.empty();
        try{
            String sql="SELECT*FROM detalle_recepcion  WHERE id_detalle_re=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                int id_r=rs.getInt("id_detalle_re");
               int id_recepcion=rs.getInt("id_recepcion");
                int id_servicio=rs.getInt("id_servicio");
                int id_carga=rs.getInt("id_carga");
                    Optional<Recepcion> optionalRecepcion = recepcionDao.listId(id_recepcion);
                   Optional<Servicio> optionalServicio= servicioDao.listId(id_servicio);
                   Optional<Carga> optionalCarga= cargaDao.listId(id_carga);
                DetalleRecepcion recepcion=new DetalleRecepcion(
                        id_r,
                        optionalRecepcion.get(),
                        optionalServicio.get(),
                        optionalCarga.get());
                optional= Optional.of(recepcion);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            System.out.println("ERRRRORR"+e);
        }
        return  optional;
    }

    public void update(int id_detalle,int id_servicio){
        try {
            String sql="UPDATE detalle_recepcion SET id_servicio=? WHERE id_detalle_re=?";
             ps= conn.prepareStatement(sql);
              ps.setInt(1,id_servicio);
              ps.setInt(2,id_detalle);
         
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            System.out.println("ERROR UPDATE DETALLEEE "+e);
        }
    }
    public void delete(Integer id){
        try {
            String sql="DELETE  FROM detalle_recepcion WHERE id_detalle_re=?";
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

    public List<DetalleRecepcion>Buscar(String texto) {
        List<DetalleRecepcion> datos = new ArrayList<>();
        try {
           
            String sql="call Buscar(?)";
            ps = conn.prepareStatement(sql);
               ps.setString(1,texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
              int id_r=rs.getInt("detalle_recepcion.id_detalle_re");
                int id_recepcion=rs.getInt("recepcion.id_recepcion");
                int id_servicio=rs.getInt("id_servicio");
                int id_carga=rs.getInt("carga.id_carga");
                System.out.println("GFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+id_carga);
                    Optional<Recepcion> optionalRecepcion = recepcionDao.listId(id_recepcion);
                   Optional<Servicio> optionalServicio= servicioDao.listId(id_servicio);
                   Optional<Carga> optionalCarga= cargaDao.listId(id_carga);
                DetalleRecepcion recepcion=new DetalleRecepcion(
                        id_r,
                        optionalRecepcion.get(),
                        optionalServicio.get(),
                        optionalCarga.get());
                datos.add(recepcion);
            }
        } catch (Exception e) {
            System.out.println(e + "ERRRRROOOOOOORRRRRRR");
        }
        return datos;
    }
}
