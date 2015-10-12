<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Artista artista = null;
try {
	artista = Fachada.getInstance().artistaListarPorId(Integer.parseInt(request.getParameter("id")));
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
	  <h3>Detalhes do Artista de ID 
	    <% out.print(request.getParameter("id")); %></h3>
	    <p style="line-height:22px; padding-top:10px;">
	       Nome: <%=artista.getNome() %><br/>
	       Tipo do Artista: <%=artista.getTipo() %><br/>
	       Telefone: <%=artista.getTelefone() %><br/>
	       Email: <%=artista.getEmail() %><br>
	       <%if (!artista.getTwitter().equals("")) { %>
           <a href="<%=artista.getTwitter() %>" target="_blank"><img src="../img/iconTwitter.png" alt="Link do Twitter" title="Link do Twitter" width="37" height="37"></a>
           <%}
	       if (!artista.getInstagram().equals("")) { %>
           <a href="<%=artista.getInstagram() %>" target="_blank"><img src="../img/iconInstagram.png" alt="Link do Instagram" title="Link do Instagram" width="38" height="37"></a>
           <%}
	       if (!artista.getFacebook().equals("")) { %>
           <a href="<%=artista.getFacebook() %>" target="_blank"><img src="../img/iconFacebook.png" alt="Link do Facebook" title="Link do Facebook" width="37" height="37"></a><br>
           <%} %>
           Ativo: <%=artista.getAtivo() %><br>
           Histórico: <%=artista.getHistorico() %><br/>
      </p>
    </div>
</body>
</html>