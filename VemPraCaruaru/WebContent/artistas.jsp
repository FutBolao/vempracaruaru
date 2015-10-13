<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
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
			<h3>Artistas</h3>
        	<%
        	  int contador = 0;
        	  artistas = Fachada.getInstance().artistaListarTodos("AND ativo='S'");
        	  for (Artista artista : artistas) {
        	    contador++;%>
        	  	<div class="coluna" style="margin-top: 40px;">
           	    	<a href="artistasDetalhes.jsp?id=<%=artista.getId() %>" alt="Link para visualizar detalhes do artista <%=artista.getNome() %>"><img src="<%=artista.getFoto() %>" alt="Imagem principal do artista <%=artista.getNome() %>" title="Imagem principal do artista <%=artista.getNome() %>" width="150" height="186"></a>
                    <div id="artistaTitulo" onClick="window.open('artistasDetalhes.jsp?id=<%=artista.getId() %>', '_self')"><%=artista.getNome() %></div>
                </div>
        	<%
        	  if (contador == 6) {
        		  contador = 0;
        	  } else {%>
        		<div class="coluna" style="min-width: 60px;">&nbsp;</div>
        	  <%}
        	  } %>
            <div class="clear"></div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>