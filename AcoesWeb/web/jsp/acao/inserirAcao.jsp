<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir - Ação</title>
    <body>
       <div class="container"/>
        <h1>Inserir Ação</h1>
        <form name="inserirAcao" action="validaInserirAcao.jsp" method="post">
            Ticker: <input type="text" name="ticker" value=""> <br>
            Empresa: <input type="text" name="empresa" value=""> <br>
            Cotação: <input type="text" name="cotacao" value=""> <br><br>
            <center><input type="submit" name="Enviar" value="Enviar"></center>
        </form>
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
