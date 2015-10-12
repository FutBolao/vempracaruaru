<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Artista> artistas = new ArrayList<Artista>();
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
        <h3>Artistas > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Artistas
              </caption>
              <tr>
                <th width="93">ID</th>
                <th width="817">NOME</th>
                <th width="69">ATIVO</th>
                <th width="201">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  artistas = Fachada.getInstance().artistaListarTodos("");
            	  for (Artista artista : artistas) {
            		ponteiro = ponteiro+1;
            		if (artista.getAtivo() == 'N') {
 		  				cssClasse = "vermelho";
 		  			} else if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
		  			String imagemAtivarInativar = artista.getAtivo() == 'S' ? "inativar.png" : "ativar.png";
		  			String nomeAtivarInativar = artista.getAtivo() == 'S' ? "Inativar" : "Ativar";
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=artista.getId()%></td>
	                  <td><%=artista.getNome()%></td>
	                  <td style="text-align:center;"><%=artista.getAtivo()%></td>
	                  <td style="text-align:center;"><a href="artistaListarDetalhes.jsp?id=<%=artista.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '700', height: '420'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes do artista de ID <%=artista.getId()%>" title="Visualizar artista turístico de ID <%=artista.getId()%>" width="44" height="24"></a>&nbsp;<a href="artistaListarFotos.jsp?id=<%=artista.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '880', height: '600'} )"><img src="../img/fotos.png" alt="Visualizar fotos do artista de ID <%=artista.getId()%>" title="Visualizar fotos do artista de ID <%=artista.getId()%>" width="33" height="24"></a>&nbsp;<a href="artistaListarObras.jsp?id=<%=artista.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '880', height: '600'} )"><img src="../img/lista.png" alt="Listar obras do artista de ID <%=artista.getId()%>" title="Listar obras do artista de ID <%=artista.getId()%>" width="19" height="24"></a>&nbsp;<a href="#"><img src="../img/<%=imagemAtivarInativar %>" alt="<%=nomeAtivarInativar %> o artista de ID <%=artista.getId()%>" title="<%=nomeAtivarInativar %> o artista de ID <%=artista.getId()%>" width="28" height="24"></a>&nbsp;<a href="#"><img src="../img/alterar.png" alt="Alterar o artista de ID <%=artista.getId()%>" title="Alterar o artista de ID <%=artista.getId()%>" width="24" height="24"></a></td>
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