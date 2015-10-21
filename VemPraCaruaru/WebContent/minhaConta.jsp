<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%ArrayList<Artista> artistas = new ArrayList<Artista>(); %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vem Pra Caruaru</title>
<link href="css/cssSite.css" type="text/css" media="screen" rel="stylesheet" />
<link href="css/style.css" type="text/css" media="screen" rel="stylesheet" />
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>

</head>

<body>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo">
			<h3>Minha Conta</h3><br/><br/>
        	<div class="clear">
				<div class="coluna" style="background-color:#666; color:#FFF; width:150px; height:30px; padding-left:8px; padding-right:8px; cursor:pointer; line-height:28px;" onClick="window.open('minhaLista.jsp?acao=listas', '_self')">Listar Roteiros</div>
        		<div class="coluna" style="background-color:#666; color:#FFF; width:150px; height:30px; padding-left:8px; padding-right:8px; cursor:pointer; line-height:28px; margin-left:30px;" onClick="window.open('minhaLista.jsp?acao=senha', '_self')">Alterar Senha</div>
        		<div class="coluna" style="background-color:#666; color:#FFF; width:150px; height:30px; padding-left:8px; padding-right:8px; cursor:pointer; line-height:28px; margin-left:30px;" onClick="window.open('Sair', '_self')">Sair</div>
			</div>
			<div class="clear"></div>
			<div class="clear">
			<% %>
			</div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>