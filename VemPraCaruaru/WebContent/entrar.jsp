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
	<script>
		// Isto � chamado com os resultados da fun��o FB.getLoginStatus().
		function statusChangeCallback(response) {
			console.log('statusChangeCallback');
			console.log(response);
			// O objeto de resposta � retornado com um campo de status que permite
			// o app saber o atual stado de autentica��o do usu�rio.
			if (response.status === 'connected') {
				// Autenticado com o seu app e com o Facebook
				usuarioConectado();
			} else if (response.status === 'not_authorized') {
				// O usu�rio est� logado no Facebook mais n�o no seu app.
				document.getElementById('status').innerHTML = 'Fa�a seu login no app';
			} else {
				// O usu�rio n�o est� logado no Facebook, portanto n�o d� para 
				// definir se est� logado no app ou n�o.
				document.getElementById('status').innerHTML = 'Fa�a seu login no facebook';
				var uid = response.authResponse.userID;
                var accessToken = response.authResponse.accessToken;
			}
		}

		// Essa fun��o � chamada quando algu�m termina a sess�o clicando no bot�o de login
		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}

		window.fbAsyncInit = function() {
			FB.init({
				appId : '1043761065664755',
				cookie : true, // enable cookies to allow the server to access 
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v2.4' // use version 2.4
			});

			// Now that we've initialized the JavaScript SDK, we call 
			// FB.getLoginStatus().  This function gets the state of the
			// person visiting this page and can return one of three states to
			// the callback you provide.  They can be:
			//
			// 1. Logged into your app ('connected')
			// 2. Logged into Facebook, but not your app ('not_authorized')
			// 3. Not logged into Facebook and can't tell if they are logged into
			//    your app or not.
			//
			// These three cases are handled in the callback function.

			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});

		};

		// Load the SDK asynchronously
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		// Here we run a very simple test of the Graph API after login is
		// successful.  See statusChangeCallback() for when this call is made.
		function usuarioConectado() {
			FB.api('/me', {"fields":"id,name,email,gender,link,picture"}, function(response) {
				$.post('FBLogin',{campoNome: response.name, campoEmail: response.email, campoId: response.id})
			});
		}
	</script>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo" style="text-align: center;">
			<br/><br/>
			<h3>Venha conhe�er a Capital do Forr�, Vem Pra Caruaru!!!</h3>
			<br/><br/><br/><br/>
			<iframe style="display:none;" name="recebeForm"></iframe>
			<div id="form" class="form" style="width:1200px; text-align:center;">
				<fb:login-button size="xlarge" scope="public_profile,email"
					onlogin="checkLoginState();">Entre com o Facebook
				</fb:login-button>
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