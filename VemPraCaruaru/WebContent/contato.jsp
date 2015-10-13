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
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo">
			<h3>Contato</h3>
			<iframe style="display:none;" name="recebeForm"></iframe>
			<div id="form" class="form" style="width:1200px">
				<form id="formContato" name="formContato" method="post" target="recebeForm" action="ContatoCadastrar">
					<div class="clear">
                		<label for="campoNome">Nome</label>
                		<input type="text" id="campoNome" name="campoNome" style="width:600px;" class="required" minlength="4" value="" />
                		<span>Informe o seu nome</span>
              		</div>
              		<div class="clear">
                		<label for="campoEmail">Email</label>
                		<input type="text" id="campoEmail" name="campoEmail" style="width:600px;" class="email" value="" />
                		<span>Informe o seu email</span>
              		</div>
              		<div class="clear">
                		<label for="campoTelefone">Telefone</label>
                		<input type="text" id="campoTelefone" name="campoTelefone" style="width:600px;" class="required fone" value="" />
                		<span>Informe o seu telefone</span>
              		</div>
              		<div class="clear">
                		<label for="campoAssunto">Assunto</label>
                		<textarea id="campoAssunto" name="campoAssunto" style="width:600px; height:200px;" class="required" minlength="10" value="" /></textarea>
                		<span>Digite o assunto que deseja nos enviar</span>
              		</div>
              		<div class="clear">
		                <button class="button blue submit" type="submit" style="margin-top:14px; margin-right:10px;">Enviar</button>
              		</div>
				</form>
			</div>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>