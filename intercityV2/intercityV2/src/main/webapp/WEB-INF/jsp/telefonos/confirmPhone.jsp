
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
        <a href="index.htm">REGRESAR AL INICIO</a>
        <div id="usuarios" >
            <ul>
                <li>
                <li>codigo=<c:out value="${codigo}" /></li>

                </li>
            </ul>

        </div>
    <center>
    <dif id="form">
        <form method="POST" action="validarPhone.htm">
            <label>Ingrese el codigo enviado a su telefono <c:out value="${codigo}" /></label>
            <input type="num" name="codigo" placeholder="Codigo" required="" >
            <br>
            <input type="submit" name="enviar" value="enviar">
        </form>
    </dif>
        </center>
    <center>
            <h3>
                ${mensaje}
            </h3>

        </center>
                

    </body>
</html>