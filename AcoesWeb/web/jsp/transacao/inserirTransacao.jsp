<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>
<%@page import="acoesbackend.model.bean.Acao"%>
<%@page import="acoesbackend.controller.ControleAcao"%>

<%
    Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");
    
    ControleAcao acCont = new ControleAcao();
    Acao ac = new Acao(0,"","",0);
    List<Acao> acoes = acCont.listar(ac);

    ControleUsuario usCont = new ControleUsuario();
    Usuario us = new Usuario(0,"","","","","","","");
    List<Usuario> usuarios = usCont.listar(us);

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir Transação</title>
    <body>
        <div class="container"/>
        <center><h1>Inserir Transação</h1></center>
            <form name="inserirTransacao" action="validaInserirTransacao.jsp" method="POST">
                <table>
                    <tr>
                        <td>Usuário: <br><br>
                            <select NAME="idU" class="browser-default">
                                <% for (Usuario usu : usuarios) { %>
                                    <option value="<%=usu.getId()%>"><%=usu.getNome()+" "+usu.getSobrenome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Ação:<br><br>                        
                            <select NAME ="idA" class="browser-default">
                                <% for (Acao aca : acoes) { %>
                                    <option value="<%=aca.getId()%>"><%=aca.getTicker()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Data:
                        <input type="text" name="data" value=""></td>

                    </tr>
                    <tr>
                        <td>Tipo:
                        <input type="text" name="tipo" value=""></td>

                    </tr>
                    <tr>
                        <td>Quantidade:
                        <input type="text" name="qtd" value=""></td>

                    </tr>
                    <tr>
                        <td>Preço:
                        <input type="text" name="preco" value=""></td>

                    </tr>
                    <tr>
                        <td>Taxas:
                        <input type="text" name="taxas" value=""></td>

                    </tr>
                    <tr>
                        <td>Corretora:
                        <input type="text" name="corretora" value=""></td>

                    </tr>
                </table>    
                            <br>
                        
                <center> <input type="submit" name="Enviar" value="Enviar"> </center>
            </form>
         <center>
         <form action="../acesso/menu.jsp" method="POST">
                <input type="hidden" name="login" value="<%=usLogado.getLogin()%>" />
                <input type="hidden" name="senha" value="<%=usLogado.getSenha()%>" />
                <input type="submit" name="voltar" value="Cancelar">
            </form>
                </center>
        </div>                     
    </body>
</html>
