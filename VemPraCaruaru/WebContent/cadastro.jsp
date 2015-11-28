<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="java.util.ArrayList"%>
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
	<script>
		// Isto é chamado com os resultados da função FB.getLoginStatus().
		function statusChangeCallback(response) {
			console.log('statusChangeCallback');
			console.log(response);
			// O objeto de resposta é retornado com um campo de status que permite
			// o app saber o atual stado de autenticação do usuário.
			if (response.status === 'connected') {
				// Autenticado com o seu app e com o Facebook
				usuarioConectado();
			} else if (response.status === 'not_authorized') {
				// O usuário está logado no Facebook mais não no seu app.
				document.getElementById('status').innerHTML = 'Faça seu login no app';
			} else {
				// O usuário não está logado no Facebook, portanto não dá para 
				// definir se está logado no app ou não.
				document.getElementById('status').innerHTML = 'Faça seu login no facebook';
				var uid = response.authResponse.userID;
                var accessToken = response.authResponse.accessToken;
			}
		}

		// Essa função é chamada quando alguém termina a sessão clicando no botão de login
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
			<h3>Venha conheçer a Capital do Forró, Vem Pra Caruaru!!!</h3>
			<br/><br/><br/><br/>
			<iframe style="display:none;" name="recebeForm"></iframe>
			<div id="form" class="form" style="width:1200px; text-align:center;">
				<a href="#"><img alt="Imagem com link para cadastrar-se usando os dados do facebook" src="img/facebookEntrar.png"></a>
				<br/><br/><br/><br/>
				<strong>ou registre-se conosco</strong>
				<br/><br/><br/><br/>
				<form id="form" name="formCadastroUsuario" method="post" target="recebeForm" action="UsuarioCadastrar">
					<div class="coluna" style="text-align:left;">
                		<label for="campoNome">Nome</label>
                		<input type="text" id="campoNome" name="campoNome" style="width:250px; margin-right:20px;" class="required" minlength="4" value="" />
                		<span>Informe o seu nome</span>
              		</div>
              		<div class="coluna" style="text-align:left;">
                		<label for="campoEmail">Email</label>
                		<input type="text" id="campoEmail" name="campoEmail" style="width:250px; margin-right:20px;" class="required email" value="" />
                		<span>Informe o seu email</span>
              		</div>
              		<div class="coluna" style="text-align:left;">
                		<label for="campoSenha">Senha</label>
                		<input type="password" id="campoSenha" name="campoSenha" style="width:200px; margin-right:20px;" class="required password" value="" />
                		<span>Digite a senha</span>
              		</div>
					<div class="coluna" style="text-align:left;">
                		<label for="campoSenhaR">Repita a senha</label>
                		<input type="password" id="campoSenhaR" name="campoSenhaR" style="width:200px; margin-right:20px;" class="required password" value="" />
                		<span>Confirme a senha digitada</span>
              		</div>
              		<div class="coluna">
		                <button class="button blue submit" type="submit" style="margin-top:32px;">Resgistrar-se</button>
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