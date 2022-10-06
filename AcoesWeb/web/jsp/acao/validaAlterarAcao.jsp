<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.controller.ControleAcao"%>
<%@page import="acoesbackend.model.bean.Acao"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    String ticker = request.getParameter("ticker");
    String empresa = request.getParameter("empresa");
    String cot = request.getParameter("cotacao");
    double cotacao = Double.parseDouble(cot);
    Acao ac = new Acao(id,ticker,empresa,cotacao);
    ControleAcao acCont = new ControleAcao();
    ac = acCont.alterar(ac);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAcao.jsp?ticker=";
    response.sendRedirect(url);
%>