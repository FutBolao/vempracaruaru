<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Obra obra = null;
ArrayList<Foto> fotos = new ArrayList<Foto>();
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vem Pra Caruaru</title>
<link href="css/cssSite.css" type="text/css" media="screen" rel="stylesheet" />
<link href="css/style.css" type="text/css" media="screen" rel="stylesheet" />
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/scriptaculous.js?load=effects,builder"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />

</head>

<body>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo">
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<%obra = Fachada.getInstance().obraListarPorId(Integer.parseInt(request.getParameter("id")));%>
        	<div class="coluna">
        		<h3><%=obra.getNome() %></h3>
        	</div><br/><br/><br/><br/>
        	<div class="clear">
                <div class="coluna" style="margin-right:10px;">
                    <img src="<%=obra.getFoto() %>" alt="Imagem principal da obra <%=obra.getNome()%>" title="Imagem principal da obra <%=obra.getNome()%>" width="320" height="242"><br/>
                </div>
                <div style="line-height:20px;">
						<%if (obra.getIdPontoTuristico() > 0) {%>
						<strong>Localização: </strong><%=obra.getNomePontoTuristico()%><br />
						<%}
						if (obra.getIdArtista() > 0) {%>
						<strong>Artista: </strong><%=obra.getNomeArtista()%><br />
						<%}%>
						<strong>Descrição: </strong><%=obra.getDescricao().replaceAll("\n", "<br/>").replaceAll("\r", "")%><br />
				</div>
				<div class="clear"></div>
        	</div>
            <%fotos = Fachada.getInstance().fotoListarPorReferencia("obra", obra.getId());
              if (fotos.size() > 1) { %>
            <br/><br/>
            <div class="clear">
            	<span style="color:#FECC47; font-size:16px; font-weight:bold;">Fotos</span>
            </div>
            <div class="clear">
            	<%
            	int contador = 0;
            	for (Foto foto : fotos) {
            	contador++; %>
            	<div class="coluna" style="margin-top:20px;">
            		<a href="<%=foto.getImagem() %>" rel="lightbox[roadtrip]" alt="Link para ampliar a imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=obra.getNome() %>"><img src="<%=foto.getImagem() %>" alt="Imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=obra.getNome() %>" title="Imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=obra.getNome() %>" width="150" height="110"></a>
            	</div>
            	<%
	        	  if (contador == 7) {
	        		  contador = 0;
	        	  } else {%>
	        		<div class="coluna" style="min-width: 25px;">&nbsp;</div>
	        	<%}
            	}%>
            	<div class="clear"></div>
            </div>
            <%}%>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>