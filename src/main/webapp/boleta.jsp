<%!
    Integer id;
    String apellidos;
    String dni;
    String nombres;
    HttpSession session;
  DetalleRecepcion d;

%>
<%
    nombres= (String) session.getAttribute("nombres");
    apellidos= (String) session.getAttribute("apellidos");
    session = request.getSession();
    id=(Integer) session.getAttribute("id");
   d=(DetalleRecepcion)request.getAttribute("detalle_recepcion");
     if(nombres==null){
        response.sendRedirect("login.jsp");
    }

%>

<%@page import="Entity.DetalleRecepcion "%>
<%@page import="Entity.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Cliente"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Boleta</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/material.min.css">
    <link rel="stylesheet" href="../css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/main-gerente.css">
    <link rel="stylesheet" type="text/css" href="ADMIN-USUARIO/css/main3.css">
    <script>
        window.jQuery || document.write('<script src="ADMIN-USUARIO/js/jquery-1.11.2.min.js"><\/script>')
    </script>
    <script src="ADMIN-USUARIO/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="ADMIN-USUARIO/js/main.js"></script>
   <script src="https://kit.fontawesome.com/a6cfda5194.js" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
 <link rel="icon" href="PORTADA/images/a.png"/>
 <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
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
                    <a href="tabla-recepcion.jsp" class="full-width">
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
    <div class="full-width navBar sas">
        <div class="full-width navBar-options ">
            <!-- BOTON MENÚ PARA DESLIZAR LA BARRA LATERAL -->
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
                    <li class="text-condensedLight noLink "><small><%=nombres%> <%=apellidos%></small></li>
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
    <!-- PAGINA DE INCIO-->
    <div class="container-contact100">
        <div class="wrap-contact100">
            <form class="contact100-form validate-form" name="form" action="" method="post">

                    <span class="contact100-form-title">
                        FICHA DE RECEPCION NRO: 0000000<%=d.getId()%> <a class="sas se" onclick="print()"><i class="fas fa-print "></i></a>
                    </span> 
                
                <div class="wrap-input100 validate-input">
                     <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Codigo Administrador: </label> 
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getAdministrador().getId() %>" readonly>
                               
      
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Nombre Administrador: </label> 
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getAdministrador().getNombres() %> <%=d.getRecepcion().getAdministrador().getApellidos() %>" readonly>
                               
      
                    </div>
                      <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Cliente: </label> 
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getCliente().getNombres()%> <%=d.getRecepcion().getCliente().getApellidos()%>" readonly>
                               
      
                    </div>
                        <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Dni del cliente: </label> 
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getCliente().getDni() %> " readonly>
                               
      
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Tipo Comprobante:</label>
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getTipoComprobante()%>" readonly>
                        
                    </div>
                     <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Fecha y hora de atención :</label>
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getFecha() %>" readonly>
                        
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Estado:</label>
                        <input class="input1005" type="text" value="<%=d.getRecepcion().getEstado()%>" readonly>
                     
                    </div>
                     <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Servicio:</label>
                        <input class="input1005" type="text" value="<%=d.getServicio().getDescripcion()%>" readonly>
                       
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Categoria de la Carga:</label>
                        <input class="input1005" type="text" value="<%=d.getCarga().getCategoria().getDescripcion()%>" readonly>
                       
                    </div>
                    
                      <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Descripcion de la Carga:</label>
                        <input class="input1005" type="text" value="<%=d.getCarga().getDescripcion() %>" readonly>
                   
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005 " >Estado de Carga:</label>
                        <input class="input1005" type="text" value="<%=d.getCarga().getEstado() %>" readonly>
                      
                    </div>
                    <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" >Total:</label>
                        <input class="input1005" type="text" value="S/<%=d.getRecepcion().getTotal() %>" readonly>
                        
                    </div>
                        <div class="wrap-input1005 validate-input">
                        <label class="label-input1005" ></label>
                       <span class="focus-input100"></span>
                   
                 
                </div>
              
                 </form>   
                </div>
            
                </div>
                
        </div>
        
         </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="js/funciones.js"></script>
<script src="js/Ouput.js"></script>
</body>

</html>