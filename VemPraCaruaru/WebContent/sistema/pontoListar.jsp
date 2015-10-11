<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<PontoTuristico> pontos = new ArrayList<PontoTuristico>();
int ponteiro = 0;
String cssClasse = "";
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
<script src="highslide/highslide-with-html.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="highslide/highslide.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.mask.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="ISO-8859-1"></script>
</head>

<body>
	<div id="corpo">
    	<div id="topo">
        	<jsp:include page="topo.jsp" />
      	</div>
        <div id="conteudo">
        <div id="get">
        <h3>Pontos Tur&iacute;sticos > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Pontos Tur&iacute;sticos
              </caption>
              <tr>
                <th width="93">ID</th>
                <th width="817">T&Iacute;TULO</th>
                <th width="69">ATIVO</th>
                <th width="201">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  pontos = Fachada.getInstance().pontoTuristicoListarTodos("");
            	  for (PontoTuristico ponto : pontos) {
            		ponteiro = ponteiro+1;
            		if (ponto.getAtivo() == 'N') {
 		  				cssClasse = "vermelho";
 		  			} else if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
		  			String imagemAtivarInativar = ponto.getAtivo() == 'S' ? "inativar.png" : "ativar.png";
		  			String nomeAtivarInativar = ponto.getAtivo() == 'S' ? "Inativar" : "Ativar";
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=ponto.getId()%></td>
	                  <td><%=ponto.getNome()%></td>
	                  <td style="text-align:center;"><%=ponto.getAtivo()%></td>
	                  <td style="text-align:center;"><a href="pontoListarDetalhes.jsp?id=<%=ponto.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '700', height: '420'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes do ponto turístico de ID <%=ponto.getId()%>" title="Visualizar detalhes do ponto turístico de ID <%=ponto.getId()%>" width="44" height="24"></a>&nbsp;<a href="pontoListarFotos.jsp?id=<%=ponto.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '880', height: '600'} )"><img src="../img/fotos.png" alt="Visualizar fotos do ponto turístico de ID <%=ponto.getId()%>" title="Visualizar fotos do ponto turístico de ID <%=ponto.getId()%>" width="33" height="24"></a>&nbsp;<a href="pontoListarObras.jsp?id=<%=ponto.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '220'} )"><img src="../img/lista.png" alt="Listar obras do ponto turístico de ID <%=ponto.getId()%>" title="Listar obras do ponto turístico de ID <%=ponto.getId()%>" width="19" height="24"></a>&nbsp;<a href="#"><img src="../img/<%=imagemAtivarInativar %>" alt="<%=nomeAtivarInativar %> o ponto turístico de ID <%=ponto.getId()%>" title="<%=nomeAtivarInativar %> o ponto turístico de ID <%=ponto.getId()%>" width="28" height="24"></a>&nbsp;<a href="#"><img src="../img/alterar.png" alt="Alterar o ponto turístico de ID <%=ponto.getId()%>" title="Alterar o ponto turístico de ID <%=ponto.getId()%>" width="24" height="24"></a></td>
	                </tr>
	                <%        
            	  }
              } catch (Exception e) {
            	  e.printStackTrace();
            	  out.println( "<script>parent.alert('" + e.getMessage() + "');</script>" );
              }
              %>
            </table>
      	</div>
      	</div>
        <div id="rodape">
      		<jsp:include page="rodape.jsp" />
     	</div>
      </div>
</body>
</html>