<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
PontoTuristico ponto = null;
try {
	ponto = Fachada.getInstance().pontoTuristicoListarPorId(Integer.parseInt(request.getParameter("id")));
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
	  <h3>Detalhes do Ponto Tur&iacute;stico de ID 
	    <% out.print(request.getParameter("id")); %></h3>
	    <p style="line-height:22px; padding-top:10px;">
	       Nome: <%=ponto.getNome() %><br/>
	       Endere&ccedil;o: <%=ponto.getEndereco() %><br/>
	       Telefone: <%=ponto.getTelefone() %><br/>
	       Email: <%=ponto.getEmail() %><br>
        Tempo de Visita&ccedil;&atilde;o: <%=ponto.getTempoVisitacao() %><br>
        Hor&aacute;rio de Funcionamento: <%=ponto.getHorarioFuncionamento() %><br>
        Quantidade de Obras: <%=ponto.getQuantidadeObras() %><br/>
        Ativo: <%=ponto.getAtivo() %><br>
        Descri&ccedil;&atilde;o: <%=ponto.getHistoricoDescricao() %><br/>
      </p>
    </div>
</body>
</html>