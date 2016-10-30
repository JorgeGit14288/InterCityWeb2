<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>


        <title>Signin Template for Bootstrap</title>

    </head>

    <body>

        <div class="container">

            <form class="form-Registro" method="POST" action="validarRegistro.htm" >
                <h2 class="form-signin-heading">INGRESE SUS DATOS </h2>                
                <label for="codigoArea"  class="sr-only">Codigo de Area</label>
                <input type="text" name="codigo" placeholder="Codigo de Area" id="codigo" list="codigoArea"/>
                    <datalist id="codigoArea">
                        <option value="201" />
                        <option value="502" />
                        <option value="503" />
                        <option value="504" />
                        <option value="505" />
                    </datalist>   
                <label for="Telefono" class="sr-only">Telefono</label>
                <input type="tel" name="telefono" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="confirmPassword" class="sr-only">Confiramar Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                
                
                 
                <div class="checkbox">
                    
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->

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
