

<%@page import="Entity.Categoria"%>
<%@page import="Entity.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Cliente"%>
<%@page pageEncoding="UTF-8"%>
<%!
    List<Cliente> clientes=new ArrayList();
    List<Servicio> servicio=new ArrayList();
    List<Categoria> categoria=new ArrayList();
     Integer id;
    String apellidos;
    String dni;
    String nombres;
   HttpSession session;
%>
<%
   clientes=(List<Cliente>) request.getAttribute("cliente");
    servicio=(List<Servicio>)request.getAttribute("servicio");
    categoria=(List<Categoria>)request.getAttribute("categoria");
    nombres= (String) session.getAttribute("nombres");
    apellidos= (String) session.getAttribute("apellidos");
    session = request.getSession();
    id=(Integer) session.getAttribute("id");
    if(nombres==null){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/material.min.css">
    <link rel="stylesheet" href="../css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/main-trabajador.css">
    <link rel="stylesheet" type="text/css" href="ADMIN-USUARIO/css/main3.css">
    <script>
        window.jQuery || document.write('<script src="ADMIN-USUARIO/js/jquery-1.11.2.min.js"><\/script>')
    </script>
    <script src="ADMIN-USUARIO/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="ADMIN-USUARIO/js/main.js"></script>
      <script src="https://kit.fontawesome.com/a6cfda5194.js" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
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
    <div class="full-width navBar ">
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
                    <li class="text-condensedLight noLink "><small><%=nombres%> <%=apellidos%> </small></li>
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
            <form class="contact100-form validate-form" name="form" action="RecepcionControl?valor=Guardar&id=<%=id%>" method="post">

                    <span class="contact100-form-title">
                        FICHA DE RECEPCION <i class="far fa-list-alt"></i>
                    </span> 
                
                <div class="wrap-input100 validate-input">
                     <div class="wrap-input100 input100-select">
                        
                        <label class="label-input100" for="id_cliente">Proveedor: <a href="registro-cliente.jsp"><i class="fas fa-user-plus"></i></a></label>
                        <div>
                            <select class="selection-2" name="id_cliente" id="id_cliente">
                                <%
                                    for (Cliente cliente :clientes) {
                                %>
                                <option value="<%=cliente.getId()%>"><%=cliente.getNombres()%> <%=cliente.getApellidos()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input">
                        <label class="label-input100" for="tipo_comprobante" id="l_tipo_comprobante">Fecha vencimiento:</label>
                        <input class="input100" type="date" name="tipo_comprobante" required="true" id="tipo_comprobante"
                               placeholder="Tipo de comprobante"  value="GUIA">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input">
                        <label class="label-input100" for="estado" id="l_estado">Estado:</label>
                        <input class="input100" type="text" name="estado" required="true" id="estado" placeholder="Ingresar estado"
                               value="ATENTIDO">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 input100-select">
                        
                        <label class="label-input100" for="id_servicio4">Servicio: </label>
                        <div>
                            <select class="selection-2" name="id_servicio4" id="id_servicio4">
                                <%
                                    for (Servicio servicio :servicio) {
                                %>
                                <option value="<%=servicio.getId()%>"><%=servicio.getDescripcion()%> </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 input100-select">
                        
                        <label class="label-input100" for="id_categoria">Categoria Producto:</label>
                        <div>
                            <select class="selection-2" name="id_categoria" id="id_categoria" required="true">
                                <%
                                    for (Categoria categoria :categoria) {
                                %>
                                <option value="<%=categoria.getId()%>"><%=categoria.getDescripcion()%> </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <span class="focus-input100"></span>
                    </div
                    <div class="wrap-input100 validate-input">
                        <label class="label-input100" for="descripcion" id="l_descripcion">Descripcion:</label>
                        <input class="input100" type="text" name="descripcion" id="descripcion" required="true" placeholder="Ingresar descripcion">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input">
                        <label class="label-input100" for="estado_carga" id="l_estado_carga">Estado de cargamento:</label>
                        <input class="input100" type="text" name="estadocarga" id="estadocarga" ">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input">
                        <label class="label-input100" for="total" id="l_total">Precio S/: </label>
                        <input class="input100" type="number" name="total" id="total" required="true" placeholder="total" " >
                        <span class="focus-input100"></span>
                    </div>
                   <div class="container-contact100-form-btn">
                        <div class="wrap-contact100-form-btn">
                            <div class="contact100-form-bgbtn"></div>
                            <button class="contact100-form-btn" type="button" id="btnGuardar" >
                                GUARDAR
                                <i class="fa fa-long-arrow-right m-l-7"></i>
                            </button>
                        </div>
                    </div>
                    
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