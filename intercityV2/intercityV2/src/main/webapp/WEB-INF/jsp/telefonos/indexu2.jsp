<%-- 
    Document   : usuarios
    Created on : 23-oct-2016, 13:36:59
    Author     : jorge
--%>

<%@page import="com.dao.UsuariosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entitys.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.controller.UsuariosController" %>
<%

    List<Usuarios> lista = new ArrayList<Usuarios>();
    UsuariosDao usuariosHelper = new UsuariosDao();
    lista = usuariosHelper.getAllUsuarios();

%> 

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
        <h1>Usuarios Registrados</h1>

        <div id="content">
            <form action="../UsuarioServletIndex" method="GET" name="formLista" >
                <center>
                    <table border="2">
                        <tr>
                            <td>Nombre</td>
                            <td>Pais</td>
                            <td>Password</td>
                            <td>Codi de Area</td>
                            <td>Telefono</td>
                            <td>Status</td>
                        </tr>
                        <%  for (int i = 0; i < lista.size(); i++) {%>
                        <tr>
                            <td><%=lista.get(i).getNombre()%> </td>
                            <td><%=lista.get(i).getPais()%> </td>
                            <td><%=lista.get(i).getPassword()%> </td>
                            <td><%=lista.get(i).getCodigoArea()%> </td>
                            <td><%=lista.get(i).getTelefono()%> </td>
                            <td><%=lista.get(i).getStatus()%> </td>
                            <td><a href="editar.htm?%=lista.get(i).getTelefono()%>&action=Buscar">Modificar</a></td>         
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </center>

            </form>

        </div>
    </body>
</html>
