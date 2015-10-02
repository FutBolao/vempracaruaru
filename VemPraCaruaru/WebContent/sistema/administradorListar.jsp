<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Administrador> administradores = new ArrayList<Administrador>();
int ponteiro = 0;
String cssClasse = "";
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
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
	<div id="corpo">
    	<div id="topo">
        	<div class="coluna" id="logo">
       	    	<img src="../img/logoTopo.png" width="156" height="136">
            </div>
            <div class="coluna">
            	<div>
	                <div class="coluna" id="slogan">
                    	Sistema de Gerenciamento do Aplicativo "Vem Pra Caruaru"
                    </div>
                  <div class="coluna" id="informacaoDoUsuario">
                    	<div>
                        	Olá <strong>Kaio César</strong>, seja bem vindo!</div>
                        <div id="sairDoSistema">
                   	  <a href="Sair">Sair do sistema </a></div>
                    </div>
                    <div class="clear"></div>
                </div>
				<div id="menu">
					<nav id='nav'>
						<ul class='menunav' id='navinti'>
							<li><a href='index.jsp'>Início</a></li>
							<li class='singsub'><a href='#'>Administradores</a>
								<ul class='sub-menu hidden'>
									<li><a href='administradorCadastrar.jsp'>Cadastrar</a>
									<li><a href='administradorListar.jsp'>Listar</a>
								</ul></li>
							<li><a href='usuario.jsp'>Usuários</a></li>
							<li class='singsub'><a href='#'>Destaques</a>
								<ul class='sub-menu hidden'>
									<li><a href='destaqueCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='destaqueListar.jsp'>Listar</a></li>
								</ul></li>
                            <li class='singsub'><a href='#'>Pontos Turísticos</a>
								<ul class='sub-menu hidden'>
									<li><a href='pontoCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='pontoListar.jsp'>Listar</a></li>
								</ul></li>
                            <li class='singsub'><a href='#'>Artistas</a>
								<ul class='sub-menu hidden'>
									<li><a href='artistaCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='artistaListar.jsp'>Listar</a></li>
								</ul></li>
                            <li class='singsub'><a href='#'>Obras</a>
								<ul class='sub-menu hidden'>
									<li><a href='obraCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='obraListar.jsp'>Listar</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
            <div class="clear"></div>
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
                <th width="254">USUÁRIO
                <th width="66">ATIVO
                <th width="188">AÇÕES</tr>
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
	                 <td style="text-align:center;"><a href="administradorListarDetalhes.jsp?id=<%=administrador.getId()%>" onclick="return hs.htmlExpand(this, { objectType: 'iframe', preserveContent: false, width: '600', height: '220'} )"><img src="../img/verDetalhes.png" alt="Visializar detalhes do administrador de ID <%=administrador.getId()%>" title="Visializar detalhes do administrador de ID <%=administrador.getId()%>" width="44" height="24"></a> <a href="#"><img src="../img/inativar.png" alt="Inativar o administrador de ID <%=administrador.getId()%>" title="Inativar o administrador de ID <%=administrador.getId()%>" width="28" height="24"></a> <a href="#"><img src="../img/alterar.png" alt="Alterar o administrador de ID <%=administrador.getId()%>" title="Alterar o administrador de ID <%=administrador.getId()%>" width="24" height="24"></a></td>
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
      </div>
</body>
</html>