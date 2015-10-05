<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
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
        <h3>Obras > Cadastrar</h3>
        <div id="form" class="form" style="width:1200px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formObra" name="formObra" method="post" target="recebeForm" action="../ObraCadastrar">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:488px; margin-right:10px;" class="required" minlength="4" value="" />
                <span>Informe o nome da obra</span>
              </div>
              <div class="coluna">
                <label for="campoArtista">Artista</label>
                <select name="campoArtista" id="campoArtista" style="width:341px; margin-right:10px;">
                  <option value="Indefinido">Artista indefinido</option>
                  <%
				  try {
				  	ArrayList<Artista> artistas = Fachada.getInstance().artistaListarTodos("AND ativo='S'");
				  	for (Artista artista : artistas) {
				  		out.println("<option value='"+ artista.getId() +"'>" + artista.getNome() + "</option>");
				  	}
				  } catch (Exception e){
					e.printStackTrace();
				  }
				  %>
                </select>
                <span>Selecione o tipo do artista</span>
              </div>
              <div class="coluna">
                <label for="campoPonto">Ponto Turístico</label>
                <select name="campoPonto" id="campoPonto" style="width:341px;">
                  <option value="Indefinido">Ponto Turístico Indefinido</option>
                  <%
				  try {
				  	ArrayList<PontoTuristico> pontos = Fachada.getInstance().pontoTuristicoListarTodos("AND ativo='S'");
				  	for (PontoTuristico ponto : pontos) {
				  		out.println("<option value='"+ ponto.getId() +"'>" + ponto.getNome() + "</option>");
				  	}
				  } catch (Exception e){
					e.printStackTrace();
				  }
				  %>
                </select>
                <span>Selecione o tipo do artista</span>
              </div>
              <div class="coluna">
                <label for="campoDescricao">Digite a descrição da obra</label>
                <textarea id="campoDescricao" name="campoDescricao" style="width:1188px; height:200px;" class="required" minlength="1" value="" /></textarea>
                <span>Informe  a descrição da obra</span>
              </div>
              <div class="coluna">
                <label for="campoImagem">Imagem</label>
                <input type="file" id="campoImagem" name="campoImagem[]" multiple style="width:1188px;" class="required" minlength="1" />
                <span>Selecione as imagens da obra</span>
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