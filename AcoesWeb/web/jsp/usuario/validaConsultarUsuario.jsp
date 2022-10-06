
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>

<%
    String nome = request.getParameter("nome");
    Usuario  us = new Usuario(0,"","","",nome,"","","");
    ControleUsuario usCont = new ControleUsuario();
    List<Usuario> usuarios = usCont.listar(us);
    Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "pbusca=" + us.getNome()+"&id=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Lista de Usuários</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Login">Login</th>
                  <th data-field="Senha">Senha</th>
                  <th data-field="Cpf">Cpf</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Sobrenome">Sobrenome</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Tipo">Tipo</th>
                  <% if (usLogado.getTipo().equals("ADM")) { %>
                    <th data-field="Excluir">Excluir</th>
                    <th data-field="Alterar">Alterar</th>
                  <% } %>
              </tr>
            </thead>
            <% if (!(usuarios.isEmpty())) { %>    
                <tbody>
                    <% for (Usuario listaUsuario : usuarios) { %>
                        <tr>
                            <td><%=listaUsuario.getId()%></td>
                            <td><%=listaUsuario.getLogin()%></td>
                            <td><%=listaUsuario.getSenha()%></td>
                            <td><%=listaUsuario.getCpf()%></td>
                            <td><%=listaUsuario.getNome()%></td>
                            <td><%=listaUsuario.getSobrenome()%></td>
                            <td><%=listaUsuario.getStatus()%></td>
                            <td><%=listaUsuario.getTipo()%></td>
                            <% if (usLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirUsuario.jsp?<%=url + listaUsuario.getId()%>">Excluir</a></td>
                                <td><a href="alterarUsuario.jsp?<%=url + listaUsuario.getId()%>">Alterar</a></td>
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