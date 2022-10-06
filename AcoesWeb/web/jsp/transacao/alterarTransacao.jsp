<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="acoesbackend.model.bean.Transacao"%>
<%@page import="acoesbackend.controller.ControleTransacao"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
ControleAcao acCont = new ControleAcao();
    Acao ac = new Acao(0,"","",0);
    List<Acao> acoes = acCont.listar(ac);

    ControleUsuario usCont = new ControleUsuario();
    Usuario us = new Usuario(0,"","","","","","","");
    List<Usuario> usuarios = usCont.listar(us);
    
    int id = Integer.parseInt(request.getParameter("id"));
    Transacao tr = new Transacao(id);
    ControleTransacao trCont = new ControleTransacao();
    tr = trCont.buscar(tr);
    String pbusca = request.getParameter("pbusca");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar - Transação</title>
    <body>
       <div class="container"/>
       <h1>Alterar Transação</h1>
        <form name="alterarTransacao" action="validaAlterarTransacao.jsp" method="post">
            <table>
                <tr>
                        <td>
                            Usuário:<br><br>
                            <select NAME="idU" class="browser-default">
                                <% for (Usuario usu : usuarios) { %>
                                    <% if( usu.getId() == tr.getIdU()) { %>
                                        <option selected value="<%=usu.getId()%>"><%=usu.getNome()+" "+usu.getSobrenome()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getId()%>"><%=usu.getNome()+" "+usu.getSobrenome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        
                        <td>
                            Ação:<br><br>
                            <select NAME ="idA" class="browser-default">
                                <% for (Acao aca : acoes) { %>
                                    <% if( aca.getId()== tr.getIdA()) { %>
                                        <option selected value="<%=aca.getId()%>"><%=aca.getTicker()%></option>
                                    <% } else { %>
                                        <option value="<%=aca.getId()%>"><%=aca.getTicker()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        
                        <td>Data:<br><input type="text" name="data" value="<%=tr.getData()%>"></td>

                    </tr>
                    <tr>
                        
                        <td>Tipo:<br><input type="text" name="tipo" value="<%=tr.getTipo()%>"></td>

                    </tr>
                    <tr>
                        
                        <td>Quantidade:<br><input type="text" name="qtd" value="<%=tr.getQtd()%>"></td>

                    </tr>
                    <tr>
                        
                        <td>Preço:<br><input type="text" name="preco" value="<%=tr.getPreco()%>"></td>

                    </tr>
                    <tr>
                        
                        <td>Taxas:<br><input type="text" name="taxas" value="<%=tr.getTaxas()%>"></td>

                    </tr>
                    <tr>
                        
                        <td>Corretora:<br><input type="text" name="corretora" value="<%=tr.getCorretora()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="id" value="<%=tr.getId()%>"> <br>
            <input type="HIDDEN" name="pbusca" value="<%=pbusca%>">
            <center>
            <input type="submit" name="Enviar" value="Enviar">
            <input type="button" onclick="location.href='validaConsultarTransacao.jsp?data='" value="Cancelar">
            </center>
        </form>
        <div>
    </body>
</html>