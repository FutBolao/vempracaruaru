<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Artista artista = null;
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
        	<%artista = Fachada.getInstance().artistaListarPorId(Integer.parseInt(request.getParameter("id")));%>
        	<div class="coluna">
        		<h3><%=artista.getNome() %></h3>
        	</div>
        	<br/><br/><br/><br/>
        	<div class="clear">
                <div class="coluna" style="margin-right:10px;">
                    <img src="<%=artista.getFoto() %>" alt="Imagem principal do artista <%=artista.getNome()%>" title="Imagem principal do artista <%=artista.getNome()%>" width="150" height="186"><br/>
                </div>
                <div style="margin-right:10px; line-height:20px;">
                    <strong><%=artista.getTipo()%></strong><br/>
                    <%if (!artista.getTelefone().equals("")) { %>
                    <strong>Telefone: </strong><%=artista.getTelefone()%><br/>
                    <%} %>
                    <%if (!artista.getEmail().equals("")) { %>
                    <strong>Email: </strong><%=artista.getEmail()%><br/>
                    <%} %>
			        <%if (!artista.getTwitter().equals("")) { %>
		            <a href="<%=artista.getTwitter() %>" target="_blank"><img src="img/iconTwitter.png" alt="Link do Twitter do Artista <%=artista.getNome() %>" title="Link do Twitter do Artista <%=artista.getNome() %>" width="37" height="37"></a>
		            <%}
			        if (!artista.getInstagram().equals("")) { %>
		            <a href="<%=artista.getInstagram() %>" target="_blank"><img src="img/iconInstagram.png" alt="Link do Instagram do Artista <%=artista.getNome() %>" title="Link do Instagram do Artista <%=artista.getNome() %>" width="38" height="37"></a>
		            <%}
			        if (!artista.getFacebook().equals("")) { %>
		            <a href="<%=artista.getFacebook() %>" target="_blank"><img src="img/iconFacebook.png" alt="Link do Facebook do Artista <%=artista.getNome() %>" title="Link do Facebook do Artista <%=artista.getNome() %>" width="37" height="37"></a><br>
		            <%} %>
                    <strong>Descrição: </strong><%=artista.getHistorico().replaceAll("\n", "<br/>").replaceAll("\r", "")%>
                </div>
        	</div>
            <%fotos = Fachada.getInstance().fotoListarPorReferencia("artista", artista.getId());
              if (fotos.size() > 1) { %>
            <div class="clear">
            	<br/><br/>
            	<span style="color:#FECC47; font-size:16px; font-weight:bold;">Fotos</span>
            </div>
            <div class="clear">
            	<%
            	int contador = 0;
            	for (Foto foto : fotos) {
            	contador++; %>
            	<div class="coluna" style="margin-top:20px;">
            		<a href="<%=foto.getImagem() %>" rel="lightbox[roadtrip]" alt="Link para ampliar a imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=artista.getNome() %>"><img src="<%=foto.getImagem() %>" alt="Imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=artista.getNome() %>" title="Imagem de id <%=foto.getId() %> do artista tur&iacute;stico <%=artista.getNome() %>" width="150" height="186"></a>
            	</div>
            	<%
	        	  if (contador == 7) {
	        		  contador = 0;
	        	  } else {%>
	        		<div class="coluna" style="min-width: 25px;">&nbsp;</div>
	        	<%}
            	}%>
            </div>
            <%}%>
            <div class="clear"></div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>