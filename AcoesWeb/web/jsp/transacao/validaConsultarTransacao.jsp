
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.model.bean.Transacao"%>
<%@page import="acoesbackend.controller.ControleTransacao"%>

<%

    String data = request.getParameter("data");
    
    Transacao tr = new Transacao(0,0,0,"",data,"",0,0,0,0,0,0,"");
    ControleTransacao trCont = new ControleTransacao();
    List<Transacao> transacoes = trCont.listar(tr);
    Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "pbusca=" + tr.getData() +"&id=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Transações</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdTransacao">Id</th>
                  <th data-field="IdUsuario">Id Usuário</th>
                  <th data-field="IdAcao">Id Ação</th>
                  <th data-field="Papel">Papel</th>
                  <th data-field="Data">Data</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="Qtd">Quantidade</th>
                  <th data-field="Preco">Preço</th>
                  <th data-field="Taxas">Taxas</th>
                  <th data-field="ValorOpe">Valor Operação</th>
                  <th data-field="ValorLiq">Valor Líquido</th>
                  <th data-field="Lucro">Lucro</th>
                  <th data-field="Corretora">Corretora</th>
                 <% if (usLogado.getTipo().equals("ADM")) { %>
                    <th data-field="Excluir">Excluir</th>
                    <th data-field="Alterar">Alterar</th>
                  <% } %>
              </tr>
            </thead>
            <% if (!(transacoes.isEmpty())) { %>    
                <tbody>
                    <% for (Transacao listaTransacao : transacoes) { %>
                        <tr>
                            <td><%=listaTransacao.getId()%></td>
                            <td><%=listaTransacao.getIdU()%></td>
                            <td><%=listaTransacao.getIdA()%></td>
                            <td><%=listaTransacao.getPapel()%></td>
                            <td><%=listaTransacao.getData()%></td>
                            <td><%=listaTransacao.getTipo()%></td>
                            <td><%=listaTransacao.getQtd()%></td>
                            <td><%=listaTransacao.getPreco()%></td>
                            <td><%=listaTransacao.getTaxas()%></td>
                            <td><%=listaTransacao.getValorOpe()%></td>
                            <td><%=listaTransacao.getValorLiq()%></td>
                            <td><%=listaTransacao.getLucro()%></td>
                            <td><%=listaTransacao.getCorretora()%></td>
                            <% if (usLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirTransacao.jsp?<%=url + listaTransacao.getId()%>">Excluir</a></td>
                                <td><a href="alterarTransacao.jsp?<%=url + listaTransacao.getId()%>">Alterar</a></td>
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