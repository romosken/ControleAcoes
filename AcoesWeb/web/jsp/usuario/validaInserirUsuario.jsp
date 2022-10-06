<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="acoesbackend.model.bean.Usuario"%>
<%@page import="acoesbackend.controller.ControleUsuario"%>

<%
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    String cpf = request.getParameter("cpf");
    String nome = request.getParameter("nome");
    String sobrenome = request.getParameter("sobrenome");
    String status = request.getParameter("status");
    String tipo = request.getParameter("tipo");
    Usuario us = new Usuario(0,login,senha,cpf,nome,sobrenome,status,tipo);
    ControleUsuario usCont = new ControleUsuario();
    us = usCont.inserir(us);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirUsuario.jsp";
    response.sendRedirect(url);
%>

<HTML>
    <BODY>
        <%=login%>  <BR>
        <%=senha%>  <BR>
        <%=cpf%>  <BR>
        <%=nome%>  <BR>
        <%=sobrenome%>  <BR>
        <%=status%> <BR>
        <%=tipo%>   <BR>
    </BODY>
</HTML>
