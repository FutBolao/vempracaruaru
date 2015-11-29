<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Site com Facebook Login</title>
    <!-- O jQuery N�O � necess�rio para utiliza��o do SDK Javascript do Facebook. Inclu� por utilizar em outra parte deste exemplo -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <!-- Logo ap�s a abertura da tag <body> inseri o trecho de c�digo de carregameto e inicializa��o do SDK Javascript do Facebook -->
    <div id="fb-root"></div>
    <script>
        // A fun��o abaixo � executada assim que o SDK � carregado.
        window.fbAsyncInit = function() {
            // Essa � a fun��o de inicializa��o do SDK. � necess�rio configurar alguns par�metros na inicializa��o do SDK.
            FB.init({
              appId      : '1043761065664755', // Substitua pela AppID do aplicativo que voc� criou anteriormente.
              status     : true, // Informa ao SDK que para checar o staus do login do usu�rio.
              cookie     : true, // Habilita o uso de cokie
              xfbml      : true  // habilita o uso da linguagem XFBML
            });
 
            // Fun��o que ser� chamada automaticamente quando hover mudan�a no status da sess�o do usu�rio
            // que ir� acontecer quando ele clicar no bot�o Entrar
            FB.Event.subscribe('auth.authResponseChange', function(response) {
                //Se o usu�rio estiver logado no facebook e j� deu as permiss�es para seu aplicativo o status ser� connected
                if (response.status === 'connected') {
                    // Executa a fun��o usuarioConectado().
                    usuarioConectado();
                } 
            });
        };
 
        // A fun��o abaixo vai incluir no cabe�alho do html o carregamento do SDK Javascript do Facebook. 
        (function(d){
            var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
            if (d.getElementById(id)) {return;}
            js = d.createElement('script'); js.id = id; js.async = true;
            // Substitu� o en_US por pt_BR para usarmos nosso idioma.
            js.src = "//connect.facebook.net/pt_BR/all.js";
            ref.parentNode.insertBefore(js, ref);
        }(document));
 
        // Fun��o de exemplo que � executada quando o usu�rio esta logado e j� deu as permiss�es para o aplicativo.
        function usuarioConectado() {
            // Com a fun��o FB.api, � poss�vel fazer chamadas para o Graph API.
            // Usando o par�metro /me , voc� pode solicitar informa��es do usu�rio conectado.
            FB.api('/me', function(response) {
                // Usando jQuery, ser� exibido no paragrafo com id info as informa��es abaixo, capturdas com o FB.api.
                $('#info').html(
                    'Nome: '+response.name + 
                    '<br>username: '+response.username + 
                    '<br>Link perfil: '+response.link + 
                    '<br>Email: '+response.email +
                    '<br>Sexo: '+response.gender +
                    '<br>ID: '+response.id 
                );
                // Um exemplo de como voc� pode recuperar a foto do usu�rio.
                $('#foto').html('<img src="https://graph.facebook.com/'+response.username+'/picture" alt="'+response.name+'" />')
            });
        }
    </script>
 
    <p id="info">Ol� visitante!</p>
        <p id="foto"></p>
 
    <!-- Bot�o para login implementado em XFBML. Al�m da permiss�o padr�o, est� sendo solicitado acesso ao email do usu�rio.
         Quando o usu�rio clicar neste bot�o, ser� aberta uma janela solicitando que ele entre no Facebook (caso esteja deslogado) e autorize            o aplicativo a obter as permiss�es solicitadas. -->
    <fb:login-button size="xlarge" scope="public_profile,email">Entre com o Facebook</fb:login-button>
 
</body>
</html>