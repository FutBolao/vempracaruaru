<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Administrador> administradores = new ArrayList<Administrador>();
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
        <h3>Administradores > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Administradores
              </caption>
              <tr>
                <th width="82">&nbsp;</td>
                ID
                <th width="608">NOME&nbsp;</td>
                <th width="254">USU&Aacute;RIO
                <th width="66">ATIVO
                <th width="188">A&Ccedil;&Otilde;ES</tr>
              <%
              try {
            	  administradores = Fachada.getInstance().administradorListarTodos("");
            	  for (Administrador administrador : administradores) {
            		ponteiro = ponteiro+1;
		  			if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=administrador.getId()%></td>
	                  <td><%=administrador.getNome()%></td>
	                  <td><%=administrador.getUsuario()%></td>
	                  <td style="text-align:center;"><%=administrador.getAtivo()%></td>
	                 <td style="text-align:center;"><a href="administradorListarDetalhes.jsp?id=<%=administrador.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '220'} )"><img src="../img/verDetalhes.png" alt="Visualizar detalhes do administrador de ID <%=administrador.getId()%>" title="Visualizar detalhes do administrador de ID <%=administrador.getId()%>" width="44" height="24"></a> <a href="#"><img src="../img/inativar.png" alt="Inativar o administrador de ID <%=administrador.getId()%>" title="Inativar o administrador de ID <%=administrador.getId()%>" width="28" height="24"></a> <a href="#"><img src="../img/alterar.png" alt="Alterar o administrador de ID <%=administrador.getId()%>" title="Alterar o administrador de ID <%=administrador.getId()%>" width="24" height="24"></a></td>
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