<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Artista ponto = null;
ArrayList<Obra> obras = new ArrayList<Obra>();
try {
	ponto = Fachada.getInstance().artistaListarPorId(Integer.parseInt(request.getParameter("id")));
	obras = Fachada.getInstance().obraListarTodos(" AND id_artista='" + ponto.getId() + "' ");
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
</head>

<body>
	<div id="detalhes">
		<h3>Obras do Artista de ID <% out.print(request.getParameter("id")); %><br/><br/></h3>		
		<%if (obras.size() == 0) out.print("<br/><p>Não há obras desse artista cadastradas</p>");
		for (Obra obra : obras) {%>
        <div>
            <div class="coluna" style="margin-right:10px;">
                <img src="../<%=obra.getFoto() %>" alt="Imagem de ID <%=obra.getId()%>" title="Obra de ID <%=obra.getId()%>" width="282" height="212"><br/>
            </div>
            <div style="margin-right:10px; line-height:20px;">
            	<span style="color:#FECC47; font-size:18px; font-weight:bold;"><%=obra.getNome() %></span><br/>
            	<%if (obra.getIdPontoTuristico() > 0) {%>
                <strong>Localização: </strong><%=obra.getNomePontoTuristico() %><br/>
                <%}
            	if (obra.getIdArtista() > 0) {%>
                <strong>Artista: </strong><%=obra.getNomeArtista() %><br/>
                <%} %>
                <strong>Descrição: </strong><%=obra.getDescricao().replaceAll("\n", "<br/>").replaceAll("\r", "") %>
            </div>
        </div>
        <div class="clear"></div>
        <hr><br/>
		<%}%>
	</div>
</body>
</html>