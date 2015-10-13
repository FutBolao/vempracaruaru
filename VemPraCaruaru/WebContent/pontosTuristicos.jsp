<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%ArrayList<PontoTuristico> pontos = new ArrayList<PontoTuristico>(); %>
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
			<h3>Pontos Turísticos</h3>
        	<%
        	  int contador = 0;
        	  pontos = Fachada.getInstance().pontoTuristicoListarTodos("AND ativo='S'");
        	  for (PontoTuristico ponto : pontos) {
        	    contador++;%>
        	  	<div class="coluna" style="margin-top: 40px;">
           	    	<a href="pontosTuristicosDetalhes.jsp?id=<%=ponto.getId() %>" alt="Link para visualizar detalhes do ponto tur&iacute;stico <%=ponto.getNome() %>"><img src="<%=ponto.getFoto() %>" alt="Imagem principal do ponto tur&iacute;stico <%=ponto.getNome() %>" title="Imagem principal do ponto tur&iacute;stico <%=ponto.getNome() %>" width="255" height="169"></a>
                    <div id="pontoTuristicoTitulo" onClick="window.open('pontosTuristicosDetalhes.jsp?id=<%=ponto.getId() %>', '_self')"><%=ponto.getNome() %></div>
                    <div style="text-align:center;"><a href="pontosTuristicosDetalhes.jsp?id=<%=ponto.getId() %>" alt="Link para visualizar detalhes do ponto tur&iacute;stico <%=ponto.getNome() %>">ver detalhes</a> - <a href="#" alt="Link para o ponto tur&iacute;stico <%=ponto.getNome() %> a lista de roteiro à visitar">adicionar a lista</a></div>
                </div>
        	<%
        	  if (contador == 4) {
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