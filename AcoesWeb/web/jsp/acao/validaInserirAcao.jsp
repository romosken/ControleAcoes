<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
    String ticker = request.getParameter("ticker");
    String empresa = request.getParameter("empresa");
    double cotacao = Double.parseDouble(request.getParameter("cotacao"));
 
    Acao ac = new Acao(0,ticker,empresa,cotacao);
    ControleAcao acCont = new ControleAcao();
    ac = acCont.inserir(ac);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirAcao.jsp";
    response.sendRedirect(url);
%>

