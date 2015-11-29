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
		function statusChangeCallback(response) {
			if (response.status === 'connected') {
				usuarioConectado();
			} else if (response.status === 'not_authorized') {

			} else {
				var uid = response.authResponse.userID;
                var accessToken = response.authResponse.accessToken;
			}
		}

		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}

		window.fbAsyncInit = function() {
			FB.init({
				appId : '1043761065664755',
				cookie : true,
				xfbml : true,
				version : 'v2.4'
			});

			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});

		};
		
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		function usuarioConectado() {
			FB.api('/me', {"fields":"id,name,email,gender,link,picture"}, function(response) {
				$.post('FBLogin',{campoNome: response.name, campoEmail: response.email, campoId: response.id},function(data, status){
					$("#retorno").html(data);
				});
			});
		}
	</script>
	<div id="retorno">
	</div>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo" style="text-align: center;">
			<br/><br/>
			<h3>Venha conheçer a Capital do Forró, Vem Pra Caruaru!!!</h3>
			<br/><br/><br/><br/>
			<iframe style="display:none;" name="recebeForm"></iframe>
			<div id="form" class="form" style="width:1200px; text-align:center;">
				<fb:login-button size="xlarge" scope="public_profile,email"
					onlogin="checkLoginState();">Entre com o Facebook
				</fb:login-button>
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