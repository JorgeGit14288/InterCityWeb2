<%-- 
    Document   : usuarios
    Created on : 23-oct-2016, 13:36:59
    Author     : jorge
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

        <title>Usuarios Registrados</title>
    </head>
    <body>
        </p>Bienvenido ${sessionScope.usuario}</p>
        <h1>Usuarios Registrados</h1>

        <div id="content">
            <form action="editar.htm" method="GET" name="formLista" >
                <center>
                    <table border="2">
                        <tr>
                            <td>Nombre</td>
                            <td>Pais</td>
                            <td>Password</td>
                            <td>Codi de Area</td>
                            <td>Telefono</td>
                            <td>Status</td>
                            <c:forEach items="${usuariosl}" var="usuariosl">
                            <tr>
                                <td><c:out value="${usuariosl.getNombre()}" /></td>
                                <td><c:out value="${usuariosl.getPais()}" /></td>
                                <td><c:out value="${usuariosl.getPassword()}" /></td>
                                <td><c:out value="${usuariosl.getCodigoArea()}" /></td>
                                <td><c:out value="${usuariosl.getTelefono()}" /></td>
                                <td><c:out value="${usuariosl.getStatus()}" /></td>
                                <td><a href="editar.htm?telefono=${usuariosl.getTelefono()}">Modificar</a></td>         
                            </tr>
                        </c:forEach>
                    </table>
                </center>

            </form>

        </div>
        
        <div id="Error">
        <Br>
        <center>
            <h3>
                ${mensaje}
            </h3>

        </center>

    </div>


    <div class="menu" >
        <center>
            <ul>
                <li><a href="index.htm">Regresar al Inicio</a></li>

            </ul>
        </center>
    </div>
    </body>
</html>
