<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
    String cod = request.getParameter("id");
    int id = Integer.parseInt(cod);
    Acao ac = new Acao(id);
    ControleAcao acCont = new ControleAcao();
    ac = acCont.buscar(ac);
    String pbusca = request.getParameter("pbusca");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar - Ação</title>
    <body>
       <div class="container"/>
       <h1>Alterar Ação</h1>
        <form name="alterarAcao" action="validaAlterarAcao.jsp" method="post">
            Ticker: <input type="text" name="ticker" value="<%=ac.getTicker()%>"> <br>
            Empresa: <input type="text" name="empresa" value="<%=ac.getEmpresa()%>"> <br>
            Cotação: <input type="text" name="cotacao" value="<%=ac.getCotacao()%>"> <br>
            <input type="HIDDEN" name="id" value="<%=ac.getId()%>"> <br>
            <input type="HIDDEN" name="pbusca" value="<%=pbusca%>"> 
            <center>
            <input type="submit" name="Enviar" value="Enviar">
            <input type="button" onclick="location.href='validaConsultarAcao.jsp?ticker='" value="Cancelar">
            </center>
        </form>
        <div>
    </body>
</html>