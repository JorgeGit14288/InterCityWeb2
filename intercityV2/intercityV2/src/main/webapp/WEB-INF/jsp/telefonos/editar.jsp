<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

    </head>
    <div class="container">
        <body>
            </p>Bienvenido ${sessionScope.usuario}</p>
            <form class="form-Registro" method="POST" action="validar.htm" >
                <h2 class="form-signin-heading">DATOS DEL USUARIOS </h2>                
                <label for="codigoArea"  >Codigo de Area</label>
                <input type="text" value="${usuario.getCodigoArea()}" name="codigo" placeholder="Codigo de Area" id="codigo" readonly  />

                <label for="Telefono">Telefono</label>
                <input type="tel" value="${usuario.getTelefono()}" name="telefono" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="confirmPassword" class="sr-only">Confiramar Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputEmail"  class="sr-only">Correo Electronico</label>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputStatus"  class="sr-only">Estadado</label>
                <input type="text" name="status" id="inputEmail" class="form-control" placeholder="status" required autofocus>
                <label for="inputNombre"  class="sr-only">Nombre</label>
                <input type="text" name="nombre" id="nombre" class="form-control" placeholder="nombre" required autofocus>
                <label for="inputPais"  class="sr-only">Pais</label>
                <input type="text" name="pais" id="inputEmail" class="form-control" placeholder="pais" required autofocus>


                <div class="checkbox">

                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
    </div>



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
