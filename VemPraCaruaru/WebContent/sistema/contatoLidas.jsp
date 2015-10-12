<%@page import="br.com.vempracaruaru.contato.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Contato> contatos = new ArrayList<Contato>();
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
        <h3>Contato > Mensagens Lidas</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Mensagens Lidas
              </caption>
              <tr>
                <th width="93">ID</th>
                <th width="474">NOME</th>
                <th width="440">EMAIL</th>
                <th width="177">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  contatos = Fachada.getInstance().contatoListarTodos("AND visualizado='S'");
            	  for (Contato contato : contatos) {
            		ponteiro = ponteiro+1;
		  			if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=contato.getId()%></td>
	                  <td><%=contato.getNome()%></td>
	                  <td><%=contato.getEmail()%></td>
	                  <td style="text-align:center;"><a href="contatoListarDetalhes.jsp?id=<%=contato.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '400'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes da mensagem de ID <%=contato.getId()%>" title="Visualizar detalhes da mensagem de ID <%=contato.getId()%>" width="44" height="24"></a>&nbsp;<a href="#"><img src="../img/alterar.png" alt="Alterar a mensagem de ID <%=contato.getId()%>" title="Alterar a mensagem de ID <%=contato.getId()%>" width="24" height="24"></a>&nbsp;<a href="#"><img src="../img/deletar.png" alt="Deletar a mensagem de ID <%=contato.getId()%>" title="Deletar a mensagem de ID <%=contato.getId()%>" width="24" height="24"></a></td>
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