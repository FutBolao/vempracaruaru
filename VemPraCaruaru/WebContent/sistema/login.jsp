<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet">
<link href="../css/button.css" type="text/css" media="screen" rel="stylesheet" />
<script src="../js/jquery.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.mask.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="ISO-8859-1"></script>
</head>

<body>
	<div id="corpo" style="min-height: 100%; background-image: linear-gradient(to bottom, #E9E9E9, #F0F0F0);">
        <div class="login">
            <div id="form" class="form">
                <iframe style="display:none;" name="recebeForm"></iframe>
                <form id="formLogin" name="formLogin" method="post" target="recebeForm" action="Login">
                <div style="text-align:center;">
                    <img src="../img/login.png" alt="Logo Vem Pra Caruaru" title="Logo Vem Pra Caruaru" width="420" height="103">
                </div>
                <div style="padding-left:15px;">
                    <label for="campoUsuario">Usuário</label>
                    <input type="text" id="campoUsuario" name="campoUsuario" style="width:380px; margin-top:2px;" class="required" minlength="4" value="" />
                    <span>Informe o nome usuário</span>
                </div>
                <div style="padding-left:15px;">
                    <label for="campoSenha">Senha</label>
                    <input type="password" id="campoSenha" name="campoSenha" style="width:380px; margin-top:2px;" class="required password" minlength="4" value="" />
                    <span>Informe a senha</span>
                </div>
                <div>
                	<button class="button blue submit" type="submit" style="margin-top:14px; margin-left:15px; margin-right:15px; width:390px">Acessar o sistema</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>