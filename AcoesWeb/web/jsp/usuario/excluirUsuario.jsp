<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    Usuario us = new Usuario(id);
    ControleUsuario usCont = new ControleUsuario();
    us = usCont.excluir(us);
    //String pbusca = request.getParameter("pbusca");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarUsuario.jsp?nome=";
    response.sendRedirect(url);
%>