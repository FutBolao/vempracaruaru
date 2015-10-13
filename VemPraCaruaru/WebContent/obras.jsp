<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Obra> obras = new ArrayList<Obra>();
ArrayList<Foto> fotos = new ArrayList<Foto>();
String complemento = "AND ativo='S'";
if (request.getParameter("idPonto") != null) {
	complemento += " AND id_ponto_turistico=" + request.getParameter("idPonto");
}
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
			<h3>Obras</h3>
        	<%obras = Fachada.getInstance().obraListarTodos(complemento);
        	for (Obra obra : obras) {%>
        	<div class="clear" style="margin-top: 40px;">
        	  	<div class="coluna" style="margin-right:10px;">
           	    	<a href="obrasDetalhes.jsp?id=<%=obra.getId() %>" alt="Link para visualizar detalhes da obra <%=obra.getNome() %>"><img src="<%=obra.getFoto() %>" alt="Imagem principal da obra <%=obra.getNome() %>" title="Imagem principal da obra <%=obra.getNome() %>" width="240" height="180"></a>
                </div>
                <div style="line-height:20px;">
						<span style="color:#FECC47; font-size:18px; font-weight:bold;"><%=obra.getNome()%></span><br />
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
            <%} %>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>