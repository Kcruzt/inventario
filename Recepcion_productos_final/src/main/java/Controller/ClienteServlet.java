package Controller;


import Dao.ClienteDao;
import Entity.Cliente;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ClienteServlet" ,urlPatterns = "/ClienteControl")
public class ClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("valor");
        RequestDispatcher requestDispatcher;
        ClienteDao clienteDao = new ClienteDao();
        switch (accion) {
            case "Guardar": {
                request.setCharacterEncoding("UTF-8");
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String dni = request.getParameter("dni");
                String telefono = request.getParameter("telefono");
                try {
                    //guardar el registro.
                    Cliente dat = new Cliente(nombres, apellidos, dni, telefono);
                    clienteDao.insert(dat);
                } catch (Exception e) {

                }
                response.sendRedirect("tabla-cliente.jsp");
                break;
            }
            case "EditGuardar": {

                request.setCharacterEncoding("UTF-8");
                Integer id = Integer.valueOf(request.getParameter("id"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String dni = request.getParameter("dni");
                String telefono = request.getParameter("telefono");
                try {
                    Cliente dat = new Cliente(id,nombres, apellidos, dni,telefono);
                    clienteDao.update(dat);
                } catch (Exception e) {
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }
                response.sendRedirect("tabla-cliente.jsp");
                break;
            }
        }}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accionl = request.getParameter("accion");
        RequestDispatcher requestDispatcher;
        ClienteDao clienteDao = new ClienteDao();
        switch (accionl) {
            case "Editar": {
                request.setCharacterEncoding("UTF-8");
                Integer idCliente = Integer.parseInt(request.getParameter("id"));
                try {
                    Optional<Cliente>data = clienteDao.listId(idCliente);
                    request.setAttribute("datos", data.get());
                } catch (Exception e) {
                    System.out.println("error edittrabajador" + e);
                }
                requestDispatcher = request.getRequestDispatcher("editar-cliente.jsp");
                requestDispatcher.forward(request, response);
                break;
            }
            case "Eliminar":{
                try {
                    Integer idCliente=  Integer.parseInt(request.getParameter("id"));
                    clienteDao.delete(idCliente);

                } catch (Exception e) {
                    System.out.println("error delete "+e);
                }
              response.sendRedirect("tabla-cliente.jsp");
                break;}
            case "Buscar":
                request.setCharacterEncoding("UTF-8");
                List<Cliente> datas = new ArrayList<>();
                String texto = request.getParameter("txt-buscar");
                try {
                    ClienteDao dao = new ClienteDao();
                    datas = dao.Buscar(texto);
                } catch (Exception e) {
                    System.out.println(e + "error showMedico");
                }
                request.setAttribute("data", datas);
                requestDispatcher = request.getRequestDispatcher("tabla-cliente.jsp");
                requestDispatcher.forward(request, response);
                break;


        }
    }
    }

