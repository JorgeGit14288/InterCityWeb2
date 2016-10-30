
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
      
        <title>INTER CITY</title>
      
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

    </head>
    <body>
        <h1>BIENVENIDOS</h1>
        
        <br>
        <br>
        <a href="login.htm">Ir a LOGIN</a>
        <div id="usuarios" >
            <ul>
                <li>
                    <li>codigo=<c:out value="${user.getCodigoArea()}" /></li>
                    <li>Telefono=<c:out value="${user.getTelefono()}" /></li>
                    <li>Password=<c:out value="${user.getPassword()}" /></li>
                </li>
            </ul>
            
        </div>
    </body>
</html>