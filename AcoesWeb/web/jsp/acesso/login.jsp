<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Login - Controle de Ações</title>
    <body>
        <div class="container"/>
            <h1>LOGIN</h1>
            <form name="FORMLOGIN" action="menu.jsp" method="post">
                Login: <input type="text" name ="login"> <br>
                Senha: <input type="password" name ="senha"> <br>
                <input type="submit" name="enviar" value="Enviar">
            </form>
        </div>
    </body>
</html>
