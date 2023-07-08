package Controller;


import Dao.* ;
import Entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "SignInAdministradorServlet",urlPatterns = "/SignInAdministrador")
public class SignInAdministradorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        

        RequestDispatcher requestDispatcher;
        LoginDao loginDao = new LoginDao();
       
        String userL = request.getParameter("user_name");
        
        //Incriptar la contraseña con el metodo MD5 para comparar con la base de datos
        String password = loginDao.getMD5(request.getParameter("contrasenia"));
        
        Optional<LoginAdmin> optionalUsuario = loginDao.findByUsername(userL) ;
        
        if(optionalUsuario.isPresent()) {
            LoginAdmin loginAdmin=optionalUsuario.get();
            if( loginAdmin.getContrasenia().equals(password)) {
                Optional<Administrador>optionalAdministrador=loginDao.findIdAd(loginAdmin.getId());
                Administrador administrador=optionalAdministrador.get();
                sesion.setAttribute("nombres",administrador.getNombres());
                sesion.setAttribute("id",administrador.getId() );
                sesion.setAttribute("apellidos",administrador.getApellidos());
                sesion.setAttribute("dni",administrador.getDni() );
                //sesion.setAttribute("userL", userL);
                //sesion.setAttribute("key", "dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb"+userL);

             requestDispatcher = request.getRequestDispatcher("inicio.jsp");
                    requestDispatcher.forward(request, response); 
            }
        }
        
        sesion.setAttribute("msg","error ,credenciales incorrectas" );
       response.sendRedirect("login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        int conf=Integer.parseInt(request.getParameter("conf"));
        if(conf==0){
            
            sesion.removeAttribute("nombres");
            sesion.removeAttribute("apellidos");
            sesion.invalidate();
           request.getSession().invalidate();
           response.sendRedirect("login.jsp");
           
        }
    }
}
