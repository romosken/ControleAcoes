<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.controller.ControleAcao"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%
    String ticker = request.getParameter("ticker");
    Acao ac = new Acao(0,ticker,"",0);
    ControleAcao acCont = new ControleAcao();
    List<Acao> acoes = acCont.listar(ac);
    Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "pbusca=" + ac.getTicker()+"&id=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Lista Ações</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cpf">Ticker</th>
                  <th data-field="Empresa">Empresa</th>
                  <th data-field="Cotacao">Cotação</th>
                  <% if (usLogado.getTipo().equals("ADM")) { %>
                    <th data-field="Excluir">Excluir</th>
                    <th data-field="Alterar">Alterar</th>
                  <% } %>
              </tr>
            </thead>
            <% if (!(acoes.isEmpty())) { %>    
                <tbody>
                    <% for (Acao listaAcoes : acoes) { %>
                        <tr>
                            <td><%=listaAcoes.getId()%></td>
                            <td><%=listaAcoes.getTicker()%></td>
                            <td><%=listaAcoes.getEmpresa()%></td>
                            <td><%=listaAcoes.getCotacao()%></td>
                            <% if (usLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirAcao.jsp?<%=url + listaAcoes.getId()%>">Excluir</a></td>
                                <td><a href="alterarAcao.jsp?<%=url + listaAcoes.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>
        <br>
        <center>
            <form action="../acesso/menu.jsp" method="POST">
                <input type="hidden" name="login" value="<%=usLogado.getLogin()%>" />
                <input type="hidden" name="senha" value="<%=usLogado.getSenha()%>" />
                <button class="tim">Voltar ao Menu</button>
            </form>
        </center>
    </body>
</html>