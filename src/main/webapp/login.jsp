
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
String userL, message;
 Integer id;
    String apellidos;
    String dni;
    String nombres;
   HttpSession session;
%>
<%
  userL = (String) request.getAttribute("msg");
  message = (String) request.getAttribute("message");
  
%>
<%
%>
<!DOCTYPE html>
<html lang="en" >
<head>
    <script>
history.forward();
</script>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="">
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="ADMIN-USUARIO/css/login.css">
    <script src="https://kit.fontawesome.com/a6cfda5194.js" crossorigin="anonymous"></script>
   <link rel="icon" href="PORTADA/images/a.png"/>
</head>
<body>
<!-- partial:index.partial.html -->
<form class="login-form" action="SignInAdministrador" method="post">
    <p class="login-text">
    <span class="fa-stack fa-lg">
      <i class="fa fa-circle fa-stack-2x"></i>
      <i class="fa fa-lock fa-stack-1x"></i>

    </span>
    </p>
   
    <input type="text" class="login-username" autofocus="true" required="true" placeholder="Usuario" id="user_name" name="user_name"
           value="<%=(userL!=null ? userL : "")%>"/>
    <input type="password" class="login-password" required="true" placeholder="Password" id="contrasenia" name="contrasenia" />
     <input type="hidden" class="login-password" placeholder="Password" id="conf" name="conf" value="5"/>
    <button type="submit" style="text-decoration: none ; text-align: center" class="login-submit">Ingresar</button>
    <%=(userL!=null ? userL : "")%>
</form>
       
<a href="index.jsp" class="login-forgot-pass">Regresar a la pagina de inicio</a>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
<!-- partial -->

</body>
</html>
