<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
ArrayList<Obra> obras = new ArrayList<Obra>();
ArrayList<Foto> fotos = new ArrayList<Foto>();
String complemento = "AND ativo='S'";
if (request.getParameter("idPonto") != null) {
	complemento += " AND id_ponto_turistico=" + request.getParameter("idPonto");
}
%>
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
		<div id="conteudo" style="text-align: center;">
			<br/><br/>
			<h3>Venha conheçer a Capital do Forró, Vem Pra Caruaru!!!</h3>
			<br/><br/><br/><br/>
			<iframe style="display:none;" name="recebeForm"></iframe>
			<div id="form" class="form" style="width:1200px; text-align:center;">
				<a href="#"><img alt="Imagem com link para cadastrar-se usando os dados do facebook" src="img/facebookEntrar.png"></a>
				<br/><br/><br/><br/>
				<strong>ou</strong>
				<br/><br/>
				<form id="form" name="formCadastroUsuario" method="post" target="recebeForm" action="UsuarioLoginSite">
	                <div style="padding-left:15px; margin-left: 390px; text-align: left;">
	                    <label for="campoEmail">Email</label>
	                    <input type="text" id="campoEmail" name="campoEmail" style="width:380px; margin-top:2px;" class="required email" minlength="4" value="" />
	                    <span>Informe o email</span>
	                </div>
	                <div style="padding-left:15px; margin-left: 390px; text-align: left;">
	                    <label for="campoSenha">Senha</label>
	                    <input type="password" id="campoSenha" name="campoSenha" style="width:380px; margin-top:2px;" class="required password" minlength="4" value="" />
	                    <span>Informe a senha</span>
	                </div>
	                <div>
	                	<button class="button blue submit" type="submit" style="margin-top:14px; margin-left:15px; margin-right:15px; width:390px">Entrar</button>
	                </div>
              		<div class="clear"></div>
				</form>
			</div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>