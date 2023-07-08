<%-- 
    Document   : inicio2
    Created on : 22 oct. 2022, 16:48:04
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%!
    Integer id;
    String apellidos;
    String dni;
    String nombres;
    HttpSession session;


%>
<%
     //Borrar la memoria cache ,para no poder retroceder
       response.setHeader("Cache-Control", "no-cache");
     response.setHeader("Cache-Control", "no-store");
     response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
    nombres= (String) session.getAttribute("nombres");
    apellidos= (String) session.getAttribute("apellidos");
    session = request.getSession();
    id=(Integer) session.getAttribute("id");
    
    
    
     if(nombres==null){
        response.sendRedirect("login.jsp");
    }
  
    

%>
<html>
    <head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/material.min.css">
    <link rel="stylesheet" href="../css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/main-trabajador.css">

    <script>
        window.jQuery || document.write('<script src="ADMIN-USUARIO/js/jquery-1.11.2.min.js"><\/script>')
    </script>
    <script src="ADMIN-USUARIO/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="ADMIN-USUARIO/js/main.js"></script>
   <script src="https://kit.fontawesome.com/a6cfda5194.js" crossorigin="anonymous"></script>
 <link rel="icon" href="PORTADA/images/a.png"/>

</head>

<body>
<!-- Notifications area -->
<!-- navLateral -->
<section class="full-width navLateral">
    <div class="full-width navLateral-bg btn-menu"></div>
    <div class="full-width navLateral-body">
        <div class="full-width navLateral-body-logo text-center tittles">
            MENU
        </div>
        <figure class="full-width navLateral-body-tittle-menu">
            <div>
                <img src="ADMIN-USUARIO/assets/img/avatar-male.png" alt="Avatar" class="img-responsive">
            </div>
            <figcaption class="baldes">
                    <span>
                       <%=nombres%> <%=apellidos%><br>
                        <small class="admin"> Administrador</small>
                    </span>
            </figcaption>
        </figure>
        <nav class="full-width">
            <ul class="full-width list-unstyle menu-principal">
                <li class="full-width">
                    <a href="inicio.jsp" class="full-width">
                        <div class="navLateral-body-cl">
                            <i class="fas fa-home"></i>
                        </div>
                        <div class="navLateral-body-cr">
                            INICIO
                        </div>
                    </a>
                </li>
                    <li class="full-width">
                    <a href="RecepcionControl?accion=NuevaRecepcion" class="full-width">
                        <div class="navLateral-body-cl">
                           <i class="fas fa-plus-square"></i>
                        </div>
                        <div class="navLateral-body-cr">
                            NUEVO REGISTRO
                        </div>
                    </a>
                </li>
                <li class="full-width">
                    <a href="tabla-recepcion2.jsp" class="full-width">
                        <div class="navLateral-body-cl">
                            <i class="fas fa-home"></i>
                        </div>
                        <div class="navLateral-body-cr">
                            REGISTROS
                        </div>
                    </a>
                </li>
                <li class="full-width divider-menu-h"></li>
                <li class="full-width">
                    <a href="#!" class="full-width btn-subMenu">
                        <div class="navLateral-body-cl">
                            <i class="fas fa-users-cog"></i>
                        </div>
                        <div class="navLateral-body-cr">
                            USUARIOS
                        </div>
                        <span class="fas fa-chevron-down"></span>
                    </a>
                    <ul class="full-width menu-principal sub-menu-options">
                        <li class="full-width">
                            <a href="tabla-cliente.jsp" class="full-width">
                                <div class="navLateral-body-cl">
                                   <i class="fas fa-user-friends"></i>
                                </div>
                                <div class="navLateral-body-cr">
                                    PROVEEDORES
                                </div>
                            </a>
                        </li>
                    </ul>
                </li>
       
                <li class="full-width divider-menu-h"></li>

                <li class="full-width">
                    <a href="#" class="full-width">
                        <div class="navLateral-body-cl">
                            <i class="fas fa-question-circle"></i>
                        </div>
                        <div class="navLateral-body-cr">
                            ACERCA DE
                        </div>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</section>
<!-- pageContent -->
<section class="full-width pageContent ">
    <!-- navBar -->
    <div class="full-width navBar ">
        <div class="full-width navBar-options ">
            <!-- BOTON MENÃ PARA DESLIZAR LA BARRA LATERAL -->
            <i class="zmdi zmdi-swap btn-menu fas fa-2x fa-bars " id="btn-menu "></i>
            <nav class="navBar-options-list ">
                <ul class="list-unstyle ">
                    <li class="btn-Notification " id="notifications ">
                        <i class="zmdi zmdi-notifications "></i>
                        <div class="mdl-tooltip " for="notifications ">Notifications</div>
                    </li>
                     <a onclick="Salir()"><i class="fas  fa-power-off"></i></a>
                    <div class="mdl-tooltip " for="btn-exit ">LogOut</div>
                    </li>
                    <li class="text-condensedLight noLink "><small> <%=nombres%> <%=apellidos%><br></small></li>
                    <li class="noLink ">
                        <figure>
                            <img src="ADMIN-USUARIO/assets/img/avatar-male.png " alt="Avatar "
                                 class="img-responsive ">
                        </figure>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="contenedor-imagenes">
    
        
 
         <div class="imagen">
            <a href="tabla-recepcion2.jsp"><i class="fas fa-warehouse"></i></a> <br>
            REGISTRO
        </div>
            <div class="imagen">
            <a href="registro-cliente.jsp"><i class="far fa-comments"></i></a> <br>
            
            REGISTRAR<br> PROVEEDOR
        </div>
        <div class="imagen">
            <a href="tabla-cliente.jsp"><i class="fas fa-users"></i></a> <br>
           
           proveedores
        </div>
       

        <div class="imagen">
            <a href="RecepcionControl?accion=NuevaRecepcion"><i class="fas fa-arrow-circle-down"></i></a> <br>
            Nueva
            Recepcion
        
        
    </div>
                    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="js/Ouput.js"></script>


</html>
