<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Obra> obras = new ArrayList<Obra>();
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
        <h3>Obras > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Obras
              </caption>
              <tr>
                <th width="95">ID</th>
                <th width="138">IMAGEM</th>
                <th width="666">INFORMAÇÕES BÁSICAS</th>
                <th width="74">ATIVO</th>
                <th width="203">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  obras = Fachada.getInstance().obraListarTodos("");
            	  for (Obra obra : obras) {
            		ponteiro = ponteiro+1;
            		if (obra.getAtivo() == 'N') {
 		  				cssClasse = "vermelho";
 		  			} else if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
		  			String imagemAtivarInativar = obra.getAtivo() == 'S' ? "inativar.png" : "ativar.png";
		  			String nomeAtivarInativar = obra.getAtivo() == 'S' ? "Inativar" : "Ativar";
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td style="vertical-align:top; padding-top:4px;"><%=obra.getId()%></td>
                      <td style="vertical-align:top; padding-top:4px;"><img src="../<%=obra.getFoto()%>" width="140" height="105"></td>
	                  <td style="vertical-align:top; padding-top:4px;"><%=obra.getNome()%></td>
	                  <td style="text-align:center; vertical-align:text-top; padding-top:4px;"><%=obra.getAtivo()%></td>
	                  <td style="text-align:center; vertical-align:top; padding-top:4px;"><a href="artistaListarDetalhes.jsp?id=<%=obra.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '220'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes da obra de ID <%=obra.getId()%>" title="Visualizar detalhes da obra de ID <%=obra.getId()%>" width="44" height="24"></a>&nbsp;<a href="artistaListarFotos.jsp?id=<%=obra.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '220'} )"><img src="../img/fotos.png" alt="Visualizar fotos da obra de ID <%=obra.getId()%>" title="Visualizar fotos da obra de ID <%=obra.getId()%>" width="33" height="24"></a>&nbsp;<a href="#"><img src="../img/<%=imagemAtivarInativar %>" alt="<%=nomeAtivarInativar %> a obra de ID <%=obra.getId()%>" title="<%=nomeAtivarInativar %> a obra de ID <%=obra.getId()%>" width="28" height="24"></a>&nbsp;<a href="#"><img src="../img/alterar.png" alt="Alterar a obra de ID <%=obra.getId()%>" title="Alterar a obra de ID <%=obra.getId()%>" width="24" height="24"></a></td>
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