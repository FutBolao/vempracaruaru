<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" rel="stylesheet" type="text/css">
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
        <h3>Destaques > Listar</h3>
        <div id="form">
          <p>asdas        </p>
        </div>
      </div>
    </div>
    <div>
</body>
</html>