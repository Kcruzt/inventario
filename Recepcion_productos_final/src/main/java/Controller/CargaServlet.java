package Controller;

import Dao.*;
import Entity.*;
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

@WebServlet(name = "CargaServlet" ,urlPatterns = "/CargaControl")
public class CargaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion1= request.getParameter("accion");
        RequestDispatcher requestDispatcher;
        CargaDao cargaDao = new CargaDao();
        ClienteDao clienteDao=new ClienteDao();

      
            if(accion1=="Buscar" || accion1.equals("Buscar")){
                request.setCharacterEncoding("UTF-8");
                List<DetalleRecepcion> datas = new ArrayList<>();
                String texto = request.getParameter("txt-buscar");
                try {
                    DetalleRecepcionDao detalleRecepcionDao=new DetalleRecepcionDao();
                    datas = detalleRecepcionDao.Buscar(texto);
                } catch (Exception e) {
                    System.out.println(e + "error showMedico");
                }
                request.setAttribute("data", datas);
                requestDispatcher = request.getRequestDispatcher("tabla-carga.jsp");
                requestDispatcher.forward(request, response);
               
            }

        }
    }
    
