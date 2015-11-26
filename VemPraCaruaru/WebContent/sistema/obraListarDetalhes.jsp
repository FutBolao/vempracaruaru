<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Obra obra = null;
try {
	obra = Fachada.getInstance().obraListarPorId(Integer.parseInt(request.getParameter("id")));
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
	  <h3>Detalhes da Obra de ID <%=obra.getId() %></h3>
	    <p style="line-height:22px; padding-top:10px;">
	       Nome: <%=obra.getNome() %><br/>
	       <%if (obra.getIdPontoTuristico() > 0) {%>
           		Localização: <%=obra.getNomePontoTuristico() %><br/>
           <%}
		   if (obra.getIdArtista() > 0) {%>
                Artista: <%=obra.getNomeArtista() %><br/>
           <%} %>
        Ativo: <%=obra.getAtivo() %><br>
        Descri&ccedil;&atilde;o: <%=obra.getDescricao().replaceAll("\n", "<br/>").replaceAll("\r", "") %><br/><br/>
        <strong>QR CODE</strong><br/>
        <img alt="QR Code da obra de id <%=obra.getId() %>" title="QR Code da obra de id <%=obra.getId() %>" src="http://chart.apis.google.com/chart?cht=qr&chl=http://www.vempracaruaru.com.br/obrasDetalhes.jsp?id=<%=obra.getId() %>&chs=300x300">
      </p>
    </div>
</body>
</html>