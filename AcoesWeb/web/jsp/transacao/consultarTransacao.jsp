<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");%>
<!DOCTYPE html>
<html>
   <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Consultar - Transação</title>
    <body>
       <div class="container"/>
       <h1>Consultar Transação</h1>
       <form name="consultarTransacao" action="validaConsultarTransacao.jsp" method="post">
           Data: <input type="text" name ="data" value=""> <br>
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
