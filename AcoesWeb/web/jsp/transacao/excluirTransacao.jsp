<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Transacao"%>
<%@page import="acoesbackend.controller.ControleTransacao"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    Transacao tr = new Transacao(id);
    ControleTransacao trCont = new ControleTransacao();
    tr = trCont.excluir(tr);
    
    
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarTransacao.jsp?data=";
    response.sendRedirect(url);

%>

