<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet">
<link href="../css/button.css" type="text/css" media="screen" rel="stylesheet" />
<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.mask.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="utf-8"></script>
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
                        	Olá <strong>Kaio César</strong>, seja bem vindo!</div>
                        <div id="sairDoSistema">
                   	  <a href="Sair">Sair do sistema </a></div>
                    </div>
                    <div class="clear"></div>
                </div>
				<div id="menu">
					<nav id='nav'>
						<ul class='menunav' id='navinti'>
							<li><a href='index.jsp'>Início</a></li>
							<li class='singsub'><a href='#'>Administradores</a>
								<ul class='sub-menu hidden'>
									<li><a href='administradorCadastrar.jsp'>Cadastrar</a>
									<li><a href='administradorListar.jsp'>Listar</a>
								</ul></li>
							<li><a href='usuario.jsp'>Usuários</a></li>
							<li class='singsub'><a href='#'>Destaques</a>
								<ul class='sub-menu hidden'>
									<li><a href='destaqueCadastrar.jsp'>Cadastrar</a></li>
									<li><a href='destaqueListar.jsp'>Listar</a></li>
								</ul></li>
                            <li class='singsub'><a href='#'>Pontos Turísticos</a>
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
        <h3>Administradores > Cadastrar</h3>
        <div id="form" class="form" style="width:610px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formAdministrador" name="formAdministrador" method="post" target="recebeForm" action="../AdministradorCadastrar">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:438px; margin-right:10px" class="required" minlength="4" value="" />
                <span>Informe o nome completo do administrador</span>
              </div>
              <div class="coluna">
                <label for="campoCpf">CPF</label>
                <input type="text" id="campoCpf" name="campoCpf" style="width:122px;" class="required cpf" value="" />
                <span>Digite o CPF</span>
              </div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:142px; margin-right:10px" class="fone" value="" />
                <span>Digite o telefone</span>
              </div>
              <div class="coluna">
                <label for="campoUsuario">Usuário</label>
                <input type="text" id="campoUsuario" name="campoUsuario" style="width:418px; margin-right:10px" class="required"  minlength="4" value="" />
                <span>Digite o usuário</span>
              </div>
              <div class="coluna">
                <label for="campoSenha">Senha</label>
                <input type="password" id="campoSenha" name="campoSenha" style="width:280px; margin-right:10px" class="required password" minlength="4" value="" />
                <span>Digite a senha</span>
              </div>
              <div class="coluna">
                <label for="campoSenha">Senha</label>
                <input type="password" id="campoSenhaR" name="campoSenhaR" style="width:280px;" class="required password" minlength="4" value="" />
                <span>Repita a senha</span>
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