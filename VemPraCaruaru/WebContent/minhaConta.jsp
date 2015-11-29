<%@page import="br.com.vempracaruaru.lista.Lista"%>
<%@page import="br.com.vempracaruaru.usuario.Usuario"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vem Pra Caruaru</title>
<link href="css/cssSite.css" type="text/css" media="screen" rel="stylesheet" />
<link href="css/style.css" type="text/css" media="screen" rel="stylesheet" />
<script src="js/jquery.js" type="text/javascript" charset="ISO-8859-1"></script>
<link href="css/button.css" type="text/css" media="screen" rel="stylesheet" />
<script src="js/jquery.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="js/jquery.validate.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="js/jquery.mask.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="js/funcoes.js" type="text/javascript" charset="ISO-8859-1"></script>

</head>

<body>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
          <%
            Usuario sessionUsuario = null;
	        //Verifico se foi feito um login com sucesso!
	        if (session.getAttribute("loginUsuario") == null){
	        	String url = response.encodeURL("/Sair");     
	        	RequestDispatcher rd = request.getRequestDispatcher(url);  
	        	rd.forward(request, response); 
	        } else {
	        	sessionUsuario = (Usuario) session.getAttribute("loginUsuario");
	        }
	        Usuario usuario = Fachada.getInstance().usuarioListarPorId(sessionUsuario.getId());
          %>
		<div id="conteudo">
			<h3>Minha Conta</h3><br/>
			<h4>Olá <%=sessionUsuario.getNome()%></h4><small>sua pontuação atual é <%=usuario.getPontos()%></small><br/><br/>
			<iframe style="display:none;" name="recebeForm"></iframe>
        	<div class="clear">
				<div class="coluna<%if (request.getParameter("acao") != null && request.getParameter("acao").equals("listas")) out.print(" paginaAtual"); %>" id="menuMinhaConta" onClick="window.open('minhaConta.jsp?acao=listas', '_self')">Listar Roteiros</div>
        		<div class="coluna <%if (request.getParameter("acao") != null && request.getParameter("acao").equals("senha")) out.print(" paginaAtual"); %>" id="menuMinhaConta" style="margin-left:30px;" onClick="window.open('minhaConta.jsp?acao=senha', '_self')">Alterar Senha</div>
        		<div class="coluna" id="menuMinhaConta" style="margin-left:30px;" onClick="window.open('Sair', '_self')">Sair</div>
			</div>
			<div class="clear"><br/><br/></div>
			<div class="clear">
			<%if (request.getParameter("acao") != null && request.getParameter("acao").equals("listas")){
				try{
				ArrayList<Lista> listasAtiva = Fachada.getInstance().listarPorUsuario(sessionUsuario.getId(), 'N');
				ArrayList<Lista> listasInativa = Fachada.getInstance().listarPorUsuario(sessionUsuario.getId(), 'S');
				%>
					<span style="color:#009; font-size:16px; font-weight:bold;">Lista de Pontos Turísticos à visitar</span><br/><br/>
					<% for (Lista lista : listasAtiva) { %>
						<a href="ListaDeletar?idPonto=<%=lista.getIdPontoTuristico()%>" target="recebeForm" onClick="return doConfirm(this.id)"><img src="img/deletar.png" alt="Deletar o ponto turístico de ID <%=lista.getIdPontoTuristico()%> da lista." title="Deletar o ponto turístico de ID <%=lista.getIdPontoTuristico()%> da lista." width="24" height="24" align="bottom"></a>
						<%=lista.getNomePontoTuristico()%><br/><hr><br/>
					<%} %>
					<br/><br/><br/><span style="color:#F00; font-size:16px; font-weight:bold;">Lista de Pontos Turísticos visitados</span><br/><br/>
					<% for (Lista lista : listasInativa) {
						out.println(lista.getNomePontoTuristico() +" - (visitado em "+lista.getDataHora()+")");
					} %>
				<%} catch (Exception e){
					e.printStackTrace();
					out.print("Você não tem uma lista de Pontos Turísticos.");
				}
			%>
			<%}else if (request.getParameter("acao") != null && request.getParameter("acao").equals("senha")) { %>
				<div id="form" class="form" style="width:1200px; text-align:center;">
					<form id="form" name="formAlterarSenhaUsuario" method="post" target="recebeForm" action="UsuarioAlterarSenha?id=<%=sessionUsuario.getId()%>">
		           		<div class="coluna" style="text-align:left;">
		               		<label for="campoSenha">Senha</label>
		               		<input type="password" id="campoSenha" name="campoSenha" style="width:300px; margin-right:20px;" class="required password" value="" />
		               		<span>Digite a senha</span>
		           		</div>
						<div class="coluna" style="text-align:left;">
		               		<label for="campoSenhaR">Repita a senha</label>
		               		<input type="password" id="campoSenhaR" name="campoSenhaR" style="width:300px; margin-right:20px;" class="required password" value="" />
		               		<span>Confirme a senha digitada</span>
		           		</div>
		           		<div class="coluna">
			                <button class="button blue submit" type="submit" style="margin-top:32px;">Alterar Senha</button>
		           		</div>
		           	</form>
           		</div>
           	<%} %>
           	<br/><br/><br/><br/>
			</div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>