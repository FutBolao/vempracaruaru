<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.usuario.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
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
        <h3>Usuários > Listar</h3>
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<table class="tabelaListar" id="tabelaListar">
              <caption>
                Lista de Usuários
              </caption>
              <tr>
                <th width="93">ID</td>
                <th width="476">NOME&nbsp;</td>
                <th width="361">EMAIL</th>
                <th width="99">PONTOS</th>
                <th width="64">ATIVO</th>
                <th width="79">A&Ccedil;&Otilde;ES</th>
              </tr>
              <%
              try {
            	  usuarios = Fachada.getInstance().usuarioListarTodos("");
            	  for (Usuario usuario : usuarios) {
            		ponteiro = ponteiro+1;
            		if (usuario.getAtivo() == 'N') {
 		  				cssClasse = "vermelho";
 		  			} else if (ponteiro%2==0){
		  				cssClasse = "par";
		  			} else {
		  				cssClasse = "impar";
		  			}
		  			String imagemAtivarInativar = usuario.getAtivo() == 'S' ? "inativar.png" : "ativar.png";
		  			String nomeAtivarInativar = usuario.getAtivo() == 'S' ? "Inativar" : "Ativar";
					String paginaAtivoInativo = usuario.getAtivo() == 'S' ? "../UsuarioInativar?id=" + usuario.getId() : "../UsuarioAtivar?id=" + usuario.getId();
	                %>
	                <tr id="<%=cssClasse%>">
	                  <td><%=usuario.getId()%></td>
	                  <td><%=usuario.getNome()%></td>
	                  <td><%=usuario.getEmail()%></td>
	                  <td><%=usuario.getPontos()%></td>
	                  <td style="text-align:center;"><%=usuario.getAtivo()%></td>
	                 <td style="text-align:center;"><a href="<%=paginaAtivoInativo%>" target="recebeForm"><img src="../img/<%=imagemAtivarInativar %>" alt="<%=nomeAtivarInativar %> o usuário de ID <%=usuario.getId()%>" title="<%=nomeAtivarInativar %> o usuário de ID <%=usuario.getId()%>" width="24" height="24"></a></td>
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