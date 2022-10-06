<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>

<%
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    Usuario us = new Usuario(login,senha);
    ControleUsuario usCont = new ControleUsuario();
    us = usCont.validar(us);
    session.setAttribute("UsuarioLogado",us);
%>


<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Controle de Ações</title>
    <body>
        <br>
        <br>
        <center>
        <% if (us != null) { %>
            <!-- Dropdownl Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Ação</a>  
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Transação</a>

            <% if (us.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp">Inserir Usuário</a></li>
                    <li><a href="../usuario/consultarUsuario.jsp">Consultar Usuário</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário</a></li>
                </ul>
            <% } %>
            <% if (us.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../acao/inserirAcao.jsp">Inserir Ação</a></li>
                    <li><a href="../acao/consultarAcao.jsp">Consultar Ação</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../acao/consultarAcao.jsp">Consultar Ação</a></li>
                </ul>
            <% } %>
            <% if (us.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../transacao/inserirTransacao.jsp">Inserir Transação</a></li>
                    <li><a href="../transacao/consultarTransacao.jsp">Consultar Transação</a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../transacao/consultarTransacao.jsp">Consultar Transação</a></li>
                </ul>
            <% } %>            
            <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
        </center>
    </body>
</html>