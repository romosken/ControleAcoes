<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Transacao"%>
<%@page import="acoesbackend.controller.ControleTransacao"%>

<%
    int idU = Integer.parseInt(request.getParameter("idU"));
    int idA = Integer.parseInt(request.getParameter("idA"));
    String data = request.getParameter("data");
    String tipo = request.getParameter("tipo");
    int qtd = Integer.parseInt(request.getParameter("qtd"));
    double preco = Double.parseDouble(request.getParameter("preco"));
    double taxas = Double.parseDouble(request.getParameter("taxas"));
    String corretora = request.getParameter("corretora");
    Transacao tr = new Transacao(0,idU,idA,data,tipo,qtd,preco,taxas,corretora);
    ControleTransacao trCont = new ControleTransacao();
    tr = trCont.inserir(tr);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirTransacao.jsp";
    response.sendRedirect(url);

%>