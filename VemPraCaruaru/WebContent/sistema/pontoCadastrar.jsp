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
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/mapa.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery-ui.custom.min.js" type="text/javascript" charset="ISO-8859-1"></script>
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
                        	Ol&aacute; <strong>Kaio C&eacute;sar</strong>, seja bem vindo!</div>
                        <div id="sairDoSistema">
                   	  <a href="Sair">Sair do sistema </a></div>
                    </div>
                    <div class="clear"></div>
                </div>
				<div id="menu">
					<nav id='nav'>
						<ul class='menunav' id='navinti'>
							<li><a href='index.jsp'>In&iacute;cio</a></li>
							<li class='singsub'><a href='#'>Administradores</a>
								<ul class='sub-menu hidden'>
									<li><a href='administradorCadastrar.jsp'>Cadastrar</a>
									<li><a href='administradorListar.jsp'>Listar</a>
								</ul></li>
							<li><a href='usuario.jsp'>Usu&aacute;rios</a></li>
							<li class='singsub'><a href='#'>Destaques</a>
								<ul class='sub-menu hidden'>
									<li><a href='destaqueCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='destaqueListar.jsp'>Listar</a></li>
								</ul></li>
                            <li class='singsub'><a href='#'>Pontos Tur&iacute;sticos</a>
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
        <h3>Pontos Tur&iacute;sticos > Cadastrar</h3>
        <div id="form" class="form" style="width:1200px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formPonto" name="formPonto" method="post" target="recebeForm" action="../PontoCadastrar" enctype="multipart/form-data">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:1188px;" class="required" minlength="4" value="" />
                <span>Informe o nome do ponto tur&iacute;stico</span>
              </div>
              <div class="coluna">
                <label for="campoEndereco">Endere&ccedil;o</label>
                <input type="text" id="campoEndereco" name="campoEndereco" style="width:1188px;" class="required" minlength="4" value="" />
                <span>Informe o endere&ccedil;o do ponto tur&iacute;stico</span>
                <input type="hidden" id="campoLatitude" name="campoLatitude" />
                <input type="hidden" id="campoLongitude" name="campoLongitude" />
              </div>
              <div class="coluna">
                <div id="mapa"></div>
              </div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:138px; margin-right:10px" class="fone" value="" />
                <span>Informe o telefone</span>
              </div>
              <div class="coluna">
                <label for="campoEmail">Email</label>
                <input type="text" id="campoEmail" name="campoEmail" style="width:350px; margin-right:10px" class="email" minlength="4" value="" />
                <span>Informe o email</span>
              </div>
              <div class="coluna">
                <label for="campoTempo">Tempo de visita&ccedil;&atilde;o</label>
                <input type="text" id="campoTempo" name="campoTempo" style="width:138px; margin-right:10px" class="required tempo" minlength="4" value="" />
                <span>Informe tempo</span>
              </div>
              <div class="coluna">
                <label for="campoHorarioDeFuncionamento">Hor&aacute;rio de funcionamento</label>
                <input type="text" id="campoHorarioDeFuncionamento" name="campoHorarioDeFuncionamento" style="width:504px;" class="required" minlength="4" value="" />
                <span>Informe hor&aacute;rio de funcionamento</span>
              </div>
              <div class="coluna">
                <label for="campoDescricao">Descri&ccedil;&atilde;o do ponto tur&iacute;stico</label>
                <textarea id="campoDescricao" name="campoDescricao" style="width:1188px; height:200px;" class="required" minlength="1" value="" /></textarea>
                <span>Informe uma descri&ccedil;&atilde;o do ponto tur&iacute;stico</span>
              </div>
              <div class="coluna">
                <label for="campoImagem">Imagem</label>
                <input type="file" id="campoImagem" name="campoImagem[]" multiple style="width:1188px;" class="required" minlength="1" />
                <span>Selecione as imagens do ponto</span>
              </div>
              <div class="coluna">
                <button class="button blue submit" type="submit" style="margin-top:14px; margin-right:10px;">Cadastrar</button>
                <button  class="button gray reset" type="reset" style="margin-top:14px;">Redefinir</button>
              </div>
              <div class="clear"></div>
          </form>
        </div>
      </div>
      </div>
    </div>
</body>
</html>