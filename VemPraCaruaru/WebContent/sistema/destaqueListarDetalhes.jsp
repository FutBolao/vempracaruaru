<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="br.com.vempracaruaru.destaque.Destaque"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Destaque destaque = null;
try {
	destaque = Fachada.getInstance().destaqueListarPorId(Integer.parseInt(request.getParameter("id")));
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
		<h3>Detalhes do Destaque de ID <% out.print(request.getParameter("id")); %></h3>
	    <p style="line-height:22px; padding-top:10px;">	       T�tulo: <%=destaque.getTitulo() %><br/>
	       Link: <%=destaque.getLink() %><br/>
	       Foto:<br/>
           <img src="../<%=destaque.getImagem() %>" alt="Imagem do destaque de ID <%=destaque.getId()%>" title="Imagem do destaque de ID <%=destaque.getId()%>" width="642" height="262">
      </p>
    </div>
</body>
</html>