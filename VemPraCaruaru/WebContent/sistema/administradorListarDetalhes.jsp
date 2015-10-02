<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
Administrador administrador = null;
try {
	administrador = Fachada.getInstance().administradorListarPorId(Integer.parseInt(request.getParameter("id")));
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet" />
</head>

<body>
	<div id="detalhes">
		<h3>Detalhes do Admistrador de ID <% out.print(request.getParameter("id")); %></h3>
	    <p style="line-height:22px; padding-top:10px;">ID: <%=administrador.getId() %><br/>
	       Nome: <%=administrador.getNome() %><br/>
	       CPF: <%=Formatacao.cpf(administrador.getCpf()) %><br/>
	       Telefone: <%=administrador.getTelefone() %><br/>
	       Usuário: <%=administrador.getUsuario() %><br/>
	       Ativo: <%=administrador.getAtivo() %><br/>
	    </p>
    </div>
</body>
</html>