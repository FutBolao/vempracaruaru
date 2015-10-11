<%@page import="br.com.vempracaruaru.destaque.Destaque"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Destaque> destaques = new ArrayList<Destaque>();
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
        <h3>Destaques > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Destaques
              </caption>
              <tr>
                <th width="93">ID</th>
                <th width="574">T&Iacute;TULO</th>
                <th width="340">LINK</th>
                <th width="177">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  destaques = Fachada.getInstance().destaqueListarTodos("");
            	  for (Destaque destaque : destaques) {
            		ponteiro = ponteiro+1;
		  			if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=destaque.getId()%></td>
	                  <td><%=destaque.getTitulo()%></td>
	                  <td><%=destaque.getLink()%></td>
	                  <td style="text-align:center;"><a href="destaqueListarDetalhes.jsp?id=<%=destaque.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '650', height: '410'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes do destaque de ID <%=destaque.getId()%>" title="Visualizar detalhes do destaque de ID <%=destaque.getId()%>" width="44" height="24"></a>&nbsp;<a href="#"><img src="../img/alterar.png" alt="Alterar o destaque de ID <%=destaque.getId()%>" title="Alterar o destaque de ID <%=destaque.getId()%>" width="24" height="24"></a>&nbsp;<a href="#"><img src="../img/deletar.png" alt="Deletar o destaque de ID <%=destaque.getId()%>" title="Deletar o destaque de ID <%=destaque.getId()%>" width="24" height="24"></a></td>
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