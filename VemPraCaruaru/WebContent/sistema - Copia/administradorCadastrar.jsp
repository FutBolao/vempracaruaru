<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<script type="text/javascript" language="javascript">
validaCadastroAdministrador();
</script>
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
        <h3>Administradores > Cadastrar</h3>
        <div id="form" class="form" style="width:610px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formAdministrador" name="formAdministrador" method="post" target="recebeForm" action="AdministradorCadastrar">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:478px; margin-right:10px" value="" />
              </div>
              <div class="coluna">
                <label for="campoCpf">CPF</label>
                <input type="text" id="campoCpf" name="campoCpf" style="width:102px;" value="" />
              </div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:142px; margin-right:10px" value="" />
              </div>
              <div class="coluna">
                <label for="campoUsuario">Usuário</label>
                <input type="text" id="campoUsuario" name="campoUsuario" style="width:208px; margin-right:10px" value="" />
              </div>
              <div class="coluna">
                <label for="campoSenha">Senha</label>
                <input type="password" id="campoSenha" name="campoSenha" style="width:210px;" value="" />
              </div>
              <div class="coluna">
                <button class="botao submit" type="submit" name="submit" style="margin-right:10px;">Cadastrar</button>
                <button class="botao" type="reset">Redefinir</button>
              </div>
              <div class="clear"></div>
          </form>
        </div>
      </div>
    </div>
    <div>
</body>
</html>