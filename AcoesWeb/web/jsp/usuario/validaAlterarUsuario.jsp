<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    String cpf = request.getParameter("cpf");
    String nome = request.getParameter("nome");
    String sobrenome = request.getParameter("sobrenome");
    String status = request.getParameter("status");
    String tipo = request.getParameter("tipo");
    //String pbusca = request.getParameter("pbusca");

    Usuario us = new Usuario(id,login,senha,cpf,nome,sobrenome,status,tipo);
    ControleUsuario usCont = new ControleUsuario();
    us = usCont.alterar(us);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarUsuario.jsp?nome=";
    response.sendRedirect(url);
%>