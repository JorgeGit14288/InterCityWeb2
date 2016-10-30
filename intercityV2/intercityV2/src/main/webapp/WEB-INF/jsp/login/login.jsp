
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

        <title>LOGIN</title>



    </head>

    <body>

        <div class="container">
            <div>
                <form class="form-signin" method="POST" action="validarLogin.htm">
                    <h2 class="form-signin-heading">INGRESE SUS CREDENCIALES</h2>
                    <label for="codigoArea">Codigo de Area</label>
                    <input type="text" name="codigo" id="codigo" list="codigoArea"/>
                    <datalist id="codigoArea">
                        <option value="201" />
                        <option value="502" />
                        <option value="503" />
                        <option value="504" />
                        <option value="505" />
                    </datalist> 
                    <label for="Telefono" class="sr-only">Telefono</label>
                    <input type="tel" name="telefono" maxlength="9" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus  >
                    <label for="inputPassword"  class="sr-only">Password</label>
                    <input type="password" maxlength="25" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Recuerdame
                        </label>
                    </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>

    </div> <!-- /container --
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <br>
    <br>


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
                <li><a href="registrar.htm">Registrarse</a></li>
                <li><a href="index.htm">Regresar al Inicio</a></li>

            </ul>
        </center>
    </div>

</body>
</html>