<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <form action="Login" method="post">
            <div id="contenedor">

                <div id="contenedorcentrado">
                    <div id="login">
                        <form id="loginform">
                            <label for="usuario">Usuario</label>
                            <input id="usuario" type="text" name="usuario" placeholder="Usuario" required>

                            <label for="password">Contraseña</label>
                            <input id="password" type="password" placeholder="Contraseña" name="password" required>

                            <button type="submit" title="Ingresar" name="Ingresar">Login</button>
                        </form>

                    </div>
                    <div id="derecho">
                        <div class="titulo">
                            Bienvenido

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
