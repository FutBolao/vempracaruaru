<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
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
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet" />
<link href="../css/button.css" type="text/css" media="screen" rel="stylesheet" />
<link href="highslide/highslide.css" type="text/css" media="screen" rel="stylesheet" />
<script src="highslide/highslide-with-html.js" type="text/javascript" charset="utf-8"></script>
<script src="highslide/highslide.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.mask.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	<div id="detalhes">
		<h3>Detalhes do Admistrador de ID <% out.print(request.getParameter("id")); %></h3>
	    <p style="line-height:22px; padding-top:10px;">ID: <%=administrador.getId() %><br/>
	       Nome: <%=administrador.getNome() %><br/>
	       CPF: <%=Formatacao.cpf(administrador.getCpf()) %><br/>
	       Telefone: <%=administrador.getTelefone() %><br/>
	       Usu&aacute;rio: <%=administrador.getUsuario() %><br/>
	       Ativo: <%=administrador.getAtivo() %><br/>
	    </p>
    </div>
</body>
</html>