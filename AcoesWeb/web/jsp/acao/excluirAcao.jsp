<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    Acao ac = new Acao(id);
    ControleAcao acCont = new ControleAcao();
    ac = acCont.excluir(ac);
   
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAcao.jsp?ticker=";
    response.sendRedirect(url);
%>