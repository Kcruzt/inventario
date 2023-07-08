package Controller;


import Dao.AdministradorDao;
import Dao.CargaDao;
import Dao.CategoriaDao;
import Dao.ClienteDao;
import Dao.DetalleRecepcionDao;
import Dao.RecepcionDao;
import Dao.ServicioDao;
import Entity.Admin;
import Entity.Administrador;
import Entity.Carga;
import Entity.Categoria;
import Entity.Cliente;
import Entity.DetalleRecepcion;
import Entity.*;
import Entity.Servicio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "RecepcionServlet" ,urlPatterns = "/RecepcionControl")
public class RecepcionServlet extends HttpServlet {
     ClienteDao clienteDao=new ClienteDao();
        AdministradorDao administradorDao=new AdministradorDao();
        RecepcionDao recepcionDao=new RecepcionDao();
        CategoriaDao categoriaDao=new CategoriaDao();
        CargaDao cargaDao=new CargaDao();
        ServicioDao servicioDao=new ServicioDao();
        DetalleRecepcionDao detalleRecepcionDao=new DetalleRecepcionDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("valor");
        RequestDispatcher requestDispatcher;
      
        switch (accion) {
            case "Guardar": {
                //opteniendo datos
                request.setCharacterEncoding("UTF-8");
                //para la tabla recepcion=============
                int id_administrador = Integer.parseInt(request.getParameter("id"));
                int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
                //int id_administrador = Integer.parseInt(request.getParameter("id_adminisrrador"));
                String tipo_comprobante = request.getParameter("tipo_comprobante");
                String estado = request.getParameter("estado");
                String total = request.getParameter("total");
                //Detalle Servicio ================
                 int id_servicio = Integer.parseInt(request.getParameter("id_servicio4"));
                //tabla  carga =======================
                int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
                String descripcion = request.getParameter("descripcion");
                String estado_carga = request.getParameter("estadocarga");
                // EditorialDao editorialDao=new EditorialDao();
                //Optional<Editorial> optionalEditorial = editorialDao.findId(editorial);
                try {
                Optional<Cliente> optionalCliente = clienteDao.listId(id_cliente);
                Optional<Administrador> optionalAdministrador = administradorDao.listId(id_administrador);
                Optional<Categoria> optionalCategoria = categoriaDao.listId(id_categoria);
                Optional<Servicio> optionalServicio = servicioDao.listId(id_servicio);
                
                //ingresar datos a la tabla RECEPCION
                Recepcion recepcion=new Recepcion(optionalCliente.get(),optionalAdministrador.get(),tipo_comprobante,estado,total);
                recepcionDao.insert(recepcion);
                //ingrear datos a la tabla CARGA
                Carga carga=new Carga(optionalCategoria.get(),descripcion,estado_carga);
                cargaDao.insert(carga);
                //Obteniendo id de la nueva recpcion.
                int id_recepcion=recepcionDao.obtenerIdRecepcion();
                int id_carga=cargaDao.obtenerIdCarga();
                Optional<Recepcion> optionalRecepcion = recepcionDao.listId(id_recepcion);
                Optional<Carga> optionalCarga = cargaDao.listId(id_carga);
                //ingresar datos a la tabla DETALLE RECEPCION.
                DetalleRecepcion detalleRecepcion=new DetalleRecepcion(optionalRecepcion.get(),optionalServicio.get(),optionalCarga.get());
                detalleRecepcionDao.insert(detalleRecepcion);
                } catch (Exception e) {
                  requestDispatcher = request.getRequestDispatcher("tabla-recepcion2.jsp");
                    requestDispatcher.forward(request, response);
                }
                response.sendRedirect("tabla-recepcion.jsp");
                break;
            }
            case "EditGuardar": {
                //===========================RECEPCION
                request.setCharacterEncoding("UTF-8");
                Integer id_recepcion = Integer.valueOf(request.getParameter("ir"));
                int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
                String tipo_comprobante = request.getParameter("tipo_comprobante");
                String estado = request.getParameter("estado");
                  String total = request.getParameter("total");
              
                 //===============================CARGA
                 int id_carga = Integer.parseInt(request.getParameter("ic"));
                 int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
                 String descripcion = request.getParameter("descripcion");
                 String estado_carga = request.getParameter("estadocarga");
                 //============================DETALLE-CARGA
                 int id_detalle_recepcion = Integer.parseInt(request.getParameter("id"));
                 int id_servicio = Integer.parseInt(request.getParameter("id_servicio4"));
    
                try {
                   Optional<Cliente> optionalCliente = clienteDao.listId(id_cliente);
                   Recepcion recepcion=new Recepcion(id_recepcion,optionalCliente.get(),tipo_comprobante,estado,total);
                   //========
                    Optional<Categoria> optionalCategoria = categoriaDao.listId(id_categoria);
                    Carga carga=new Carga(id_carga,optionalCategoria.get(),descripcion,estado_carga);
                    int h= carga.getCategoria().getId();
                   cargaDao.update(carga);
                   recepcionDao.update(recepcion);
                   detalleRecepcionDao.update(id_detalle_recepcion, id_servicio);
                   
                   
                } catch (Exception e) {
                    requestDispatcher = request.getRequestDispatcher("tabla-admin.jsp");
                    requestDispatcher.forward(request, response);
                }
                response.sendRedirect("tabla-recepcion.jsp");
                break;
            }
        }}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accionl = request.getParameter("accion");
        RequestDispatcher requestDispatcher;
        
        switch (accionl) {
            case "Editar": {
                request.setCharacterEncoding("UTF-8");
                Integer id_detalle_re = Integer.parseInt(request.getParameter("id_dll"));
                try {
                      List<Cliente>cliente=clienteDao.list();
                     List<Categoria>categoria =categoria=categoriaDao.list();
                    List<Servicio>servicio = servicio=servicioDao.list();
                     request.setAttribute("cliente", cliente);
                    request.setAttribute("categoria", categoria);
                    request.setAttribute("servicio", servicio);
                    Optional<DetalleRecepcion>detalle_recepcion = detalleRecepcionDao.listId(id_detalle_re);
                    request.setAttribute("detalle_recepcion", detalle_recepcion.get());
                } catch (Exception e) {
                    requestDispatcher = request.getRequestDispatcher("tabla-recepcion.jsp");
                    requestDispatcher.forward(request, response);
                    
                }
                requestDispatcher = request.getRequestDispatcher("editar-recepcion.jsp");
                requestDispatcher.forward(request, response);
                break;
            }
            case "Boleta": {
                request.setCharacterEncoding("UTF-8");
                Integer id_detalle_re = Integer.parseInt(request.getParameter("id_dll"));
                try {
                    Optional<DetalleRecepcion>detalle_recepcion = detalleRecepcionDao.listId(id_detalle_re);
                    request.setAttribute("detalle_recepcion", detalle_recepcion.get());
                } catch (Exception e) {
                    System.out.println("error edittrabajador" + e);
                }
                requestDispatcher = request.getRequestDispatcher("boleta.jsp");
                requestDispatcher.forward(request, response);
                break;
            }
            
               case "NuevaRecepcion": {
                request.setCharacterEncoding("UTF-8");
                  List<Cliente>cliente = new ArrayList<>();
                  List<Categoria>categoria = new ArrayList<>();
                  List<Servicio>servicio = new ArrayList<>();
                try {
                    cliente=clienteDao.list();
                    categoria=categoriaDao.list();
                    servicio=servicioDao.list();
                     request.setAttribute("cliente", cliente);
                    request.setAttribute("categoria", categoria);
                    request.setAttribute("servicio", servicio);
                } catch (Exception e) {
                    System.out.println("error edittrabajador" + e);
                    requestDispatcher = request.getRequestDispatcher("registro-recepcion.jsp");
                    requestDispatcher.forward(request, response);
                }
                requestDispatcher = request.getRequestDispatcher("registro-recepcion.jsp");
                requestDispatcher.forward(request, response);
                break;
            }
            case "Eliminar":{
                   request.setCharacterEncoding("UTF-8");
                Integer id_carga = Integer.parseInt(request.getParameter("id_c"));
                Integer id_recepcion = Integer.parseInt(request.getParameter("id_r"));
                Integer id_detalle_re = Integer.parseInt(request.getParameter("id_dll"));
                try {
                    
                   detalleRecepcionDao.delete(id_detalle_re);
                   recepcionDao.delete(id_recepcion);
                   cargaDao.delete(id_carga);
                   
                } catch (Exception e) {
                    System.out.println("error delete "+e);
                }
                requestDispatcher = request.getRequestDispatcher("tabla-recepcion.jsp");
                requestDispatcher.forward(request, response);
                break;}
            case "Buscar":
                request.setCharacterEncoding("UTF-8");
                List<DetalleRecepcion> datas = new ArrayList<>();
                String texto = request.getParameter("txt-buscar");
                try {
                    datas = detalleRecepcionDao.Buscar(texto);
                } catch (Exception e) {
                    System.out.println(e + "error showMedico");
                    requestDispatcher = request.getRequestDispatcher("tabla-recepcion.jsp");
                requestDispatcher.forward(request, response);
                }
                request.setAttribute("data", datas);
                requestDispatcher = request.getRequestDispatcher("tabla-recepcion.jsp");
                requestDispatcher.forward(request, response);
                break;

             
        }
    }
    }

