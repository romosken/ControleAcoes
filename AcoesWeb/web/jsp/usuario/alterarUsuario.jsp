<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    Usuario us = new Usuario(id,"","","","","","","");
    ControleUsuario usCont = new ControleUsuario();
    us = usCont.buscar(us);
    String pbusca = request.getParameter("pbusca");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar - Usuário</title>
    <body>
       <div class="container"/>
       <h1>Alterar Usuário</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            Login: <input type="text" name="login" value="<%=us.getLogin()%>"> <br>
            Senha: <input type="password" name="senha" value="<%=us.getSenha()%>"> <br>
            Cpf: <input type="text" name="cpf" value="<%=us.getCpf()%>"> <br>
            Nome: <input type="text" name="nome" value="<%=us.getNome()%>"> <br>
            Sobrenome: <input type="text" name="sobrenome" value="<%=us.getSobrenome()%>"> <br>
            Status: <input type="text" name="status" value="<%=us.getStatus()%>"> <br>
            Tipo: <input type="text" name="tipo" value="<%=us.getTipo()%>"> <br>
            <input type="HIDDEN" name="id" value="<%=us.getId()%>"> <br>
            <input type="HIDDEN" name="pbusca" value="<%=pbusca%>"> 
            <center>
            <input type="submit" name="Enviar" value="Enviar">
            <input type="button" onclick="location.href='validaConsultarUsuario.jsp?nome='" value="Cancelar">
            </center>
        </form>
        <div>
    </body>
</html>