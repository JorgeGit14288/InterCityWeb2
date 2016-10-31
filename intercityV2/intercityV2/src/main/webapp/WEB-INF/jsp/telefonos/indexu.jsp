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
                    <td>Telefono</td>

                    <td>Id Usuario</td>
                    <td>Status</td>
                    <c:forEach items="${listTel}" var="listTel">
                    <tr>
                        <td><c:out value="${listTel.getTelefonoArea()}" /></td>

                        <td><c:out value="${listTel.getIdUsuario()}" /></td>
                        <td><c:out value="${listTel.getStatus()}" /></td>

                        <td><a href="editar.htm?telefono=${listTel.getTelefonoArea()}">Modificar</a></td>         
                    </tr>
                </c:forEach>
            </table>
        </center>

    </form>
   <form action="editar.htm" method="GET" name="formLista" >
        <center>
            <table border="2">
                <tr>
                    <td>Telefono</td>

                    <td>Id Usuario</td>
                    <td>Status</td>
                    <c:forEach items="${userTels}" var="userTels">
                    <tr>
                        <td><c:out value="${userTels.getTelefonoArea()}" /></td>


                        <td><a href="editar.htm?telefono=${userTels.getTelefonoArea()}">Modificar</a></td>         
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
