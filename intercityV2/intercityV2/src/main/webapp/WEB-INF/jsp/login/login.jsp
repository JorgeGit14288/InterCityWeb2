
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LOGIN</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/resources/theme1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="${pageContext.request.contextPath}/resources/theme1/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/resources/theme1/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/resources/theme1/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" method="POST" action="validarLogin.htm">
                                <fieldset>
                                    <label for="codigoArea" >Codigo de Area</label>
                                    <select name="codigo"  required  >
                                        <option value="1">+1 Estados Unidos </option> 
                                        <option value="1">+1 Canada</option> 
                                        <option value="1">+1 Puerto Rico</option> 
                                        <option value="1">+1 Republica Dominicana</option> 
                                        <option value="51">+51 Peru</option>
                                        <option value="52">+52 Mexico</option>
                                        <option value="53">+53 Cuba</option>
                                        <option value="56">+56 Chile</option>
                                        <option value="502">+502 Guatemala</option>
                                        <option value="503">+503 El Salvador</option>
                                        <option value="504">+504 Honduras</option>
                                        <option value="505">+505 Nicaragua</option>
                                        <option value="506">+506 Costa Rica</option>
                                        <option value="507">+507 Panama</option>
                                    </select>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="telefono" name="telefono" required type="text" autofocus >
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="" required>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                                </fieldset>
                            </form>
                            <div>
                                <br>
                                <br>
                                <a href="recuperar.htm">Recuperar una cueta existente</a>
                                <br>
                                <br>
                                <a href="registrar.htm">Registrarse como nuevo usuario</a>
                            </div>
                            <div id="Error">
                                <Br>
                                <center>
                                    <h3>
                                        ${mensaje}
                                    </h3>

                                </center>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/resources/theme1/vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/theme1/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/theme1/vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/theme1/dist/js/sb-admin-2.js"></script>

    </body>

</html>
