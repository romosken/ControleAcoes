<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%Usuario usLogado = (Usuario) session.getAttribute("UsuarioLogado");%>
<html>
   <%@include file="../../inc/materalizeWeb.inc"%>
    <title>Inserir - Usuário</title>
    <body>
       <div class="container"/>
        <h1>Inserir Usuário</h1>
        <form name="inserirUsuario" action="validaInserirUsuario.jsp" method="post">
            Login: <input type="text" name="login" value=""> <br>
            Senha: <input type="password" name="senha" value=""> <br>
            Cpf: <input type="text" name="cpf" value=""> <br>
            Nome: <input type="text" name="nome" value=""> <br>
            Sobrenome: <input type="text" name="sobrenome" value=""> <br>
            Status: <input type="text" name="status" value=""> <br>
            Tipo: <input type="text" name="tipo" value=""> <br><br>
            <center> <input type="submit" name="Enviar" value="Enviar"></center>
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
