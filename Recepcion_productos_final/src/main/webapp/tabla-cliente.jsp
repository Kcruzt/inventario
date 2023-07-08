<%@ page import="Entity.Administrador" %>
<%@ page import="Dao.AdministradorDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Cliente" %>
<%@ page import="Dao.ClienteDao" %>
<%!
 List<Cliente> info=new ArrayList();
  List<Cliente> Buscar=new ArrayList();
  ClienteDao clienteDao=new ClienteDao();
  Integer id;
    String apellidos;
    String dni;
    String nombres;
   HttpSession session;
%>
<%
           response.setHeader("Cache-Control", "no-cache");
     response.setHeader("Cache-Control", "no-store");
     response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
     Buscar=(List<Cliente>)request.getAttribute("data");
     if (Buscar==null) {
           info=clienteDao.list();
        }else{
              info=Buscar;
        }

 nombres= (String) session.getAttribute("nombres");
    apellidos= (String) session.getAttribute("apellidos");
    session = request.getSession();
    id=(Integer) session.getAttribute("id");
    if(nombres==null){
        response.sendRedirect("login.jsp");
    }

%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>tabla de clientes</title>
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
    <div class="full-width navBar sas ">
        <div class="full-width navBar-options ">
            <!-- BOTON MENÚ PARA DESLIZAR LA BARRA LATERAL -->
            <a class="salir"><i class="zmdi zmdi-swap btn-menu fas fa-2x fa-bars " id="btn-menu"></i></a>
            <nav class="navBar-options-list ">
                <ul class="list-unstyle ">
                    <li class="btn-Notification " id="notifications ">
                        <i class="zmdi zmdi-notifications "></i>
                        <div class="mdl-tooltip " for="notifications ">Notifications</div>
                    </li>
                     <a onclick="Salir()"><i class="fas  fa-power-off"></i></a>
                    <div class="mdl-tooltip " for="btn-exit ">LogOut</div>
                    </li>
                    <li class="text-condensedLight noLink "><small> <strong><%=nombres%> <%=apellidos%></strong> </small></li>
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
    <form action="ClienteControl?accion=Buscar" class="titulo-tabla">
        <div>TABLA PROVEEDORES <i class="fas fa-user-check"></i>
            <div class="agregar2 sas">
                <a onclick="print()"><i class="fas fa-print"></i></a>
            </div>
            <div class="agregar2 sas">
                <a href="registro-cliente.jsp"><i class="fas fa-user-plus"></i></a>
            </div>

            <div class="buscar-caja sas">
                <input type="text" name="txt-buscar" class="buscar-txt" placeholder="Buscar... " />
                <button type="submit" name="accion" value="Buscar" class="buscar-btn" id="btn-eliminar"> <i
                        class="fas fa-search"></i></button>

            </div>

        </div>
    </form>


    <table class="tabla" border="1 ">
        <thead>
        <tr>
            <th class="cabecera ">ID</th>
            <th class="cabecera ">Nombres</th>
            <th class="cabecera ">Apellidos</th>
            <th class="cabecera ">Dni</th>
            <th class="cabecera ">Telefono</th>
            <th class="cabecera sas">Editar</th>
        </tr>
        </thead>
        <tbody>
            <%
                    for (Cliente cliente:info){
                %>
        <tbody>
        <tr>

            <td ><%=cliente.getId()%></td>
            <td><%=cliente.getNombres()%></td>
            <td><%=cliente.getApellidos()%></td>
            <td><%=cliente.getDni()%></td>
            <td><%=cliente.getTelefono() %></td>


            <td class="sas"> <a href="ClienteControl?accion=Editar&id=<%=cliente.getId()%>"
                    class="a-button a-button-edit"><i class="far fa-edit"></i></a>

                <a class="a-button a-button-delete" id="btDelete" onclick="Eliminar('<%=cliente.getId()%>')"><i class="fas fa-trash-alt"></i></a></td>
          </tr>


                  <%}%>
        </tbody>
    </table>
</section>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="js/funcion-cliente.js"></script>
<script src="js/Ouput.js"></script>
<script src="js/Ouput.js"></script>

</body>

</html>