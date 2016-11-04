

<script>
function comprobarClave(){
	clave1 = document.f1.password.value
	clave2 = document.f1.confirmPassword.value
	
	if (clave1 == clave2)
		alert("Las dos claves son iguales...\nRealizaríamos las acciones del caso positivo")
	else
		alert("Las dos claves son distintas...\nRealizaríamos las acciones del caso negativo")
            document.f1.submit()
}
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>


        <title>NUEVO PASSWORD</title>

    </head>

    <body>

        <div class="container">

            <form name="f1" class="form-Registro" method="POST" action="validarNewPassword.htm" >
               
                <label for="Telefono" class="sr-only">Telefono</label>
                <input type="tel" value="${sessionScope.usuario}" readonly  name="telefono" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required >
                <label for="confirmPassword" class="sr-only">Confiramar Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit"  >Set Password</button>
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
