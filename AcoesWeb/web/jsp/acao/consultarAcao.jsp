<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");%>
<!DOCTYPE html>
<html>
   <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Consultar - Ação</title>
    <body>
       <div class="container"/>
       <h1>Consultar - Ação</h1>
       <form name="consultarAcao" action="validaConsultarAcao.jsp" method="post">
           Ticker: <input type="text" name ="ticker" value=""> <br>
           <center><input type="submit" name ="Enviar" value="Consultar"></center>
       </form>
       <br>
       <center>
       <form action="../acesso/menu.jsp" method="POST">
                <input type="hidden" name="login" value="<%=usLogado.getLogin()%>" />
                <input type="hidden" name="senha" value="<%=usLogado.getSenha()%>" />
                <input type="submit" name="voltar" value="Cancelar">
       </form>
       </center>
       </div>
    </body>
</html>
