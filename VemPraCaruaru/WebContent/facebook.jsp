<!DOCTYPE html>
<html>
<head>
<title>Facebook Login JavaScript Example</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<meta charset="UTF-8">
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
// 				$.post('FBLogin',{campoNome: response.name, campoEmail: response.email, campoId: response.id})
                $('#info').html(
                        'Nome: '+response.name + 
                        '<br>username: '+response.username + 
                        '<br>Link perfil: '+response.link + 
                        '<br>Email: '+response.email +
                        '<br>Picture: '+response.picture +
                        '<br>Idade: '+response.age_range +
                        '<br>Sexo: '+response.gender +
                        '<br>ID: '+response.id 
                    );
                    // Um exemplo de como você pode recuperar a foto do usuário.
                $('#foto').html('<img src="https://graph.facebook.com/'+response.username+'/picture" alt="'+response.name+'" />')
			});
			FB.api('/me/permissions', function(response2) {
				console.log('CHECANDO PERMISSÕES');
				console.log(response2);
                var perms = response2.data[1];
                // Check for publish_stream permission in this case....
                if (perms.email) {                
                	console.log('EMAIL OK');
                } else {                
                	console.log('EMAIL NÃO');
                }
            });
		}
	</script>

	<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

	<fb:login-button size="xlarge" scope="public_profile,email,user_friends"
		onlogin="checkLoginState();">Entre com o Facebook
	</fb:login-button>

	<div id="status"></div>
	
	<div id="info"></div>
	<div id="foto"></div>

</body>
</html>