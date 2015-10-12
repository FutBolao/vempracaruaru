<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@page import="br.com.vempracaruaru.artista.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet" />
<link href="../css/button.css" type="text/css" media="screen" rel="stylesheet" />
<link href="highslide/highslide.css" type="text/css" media="screen" rel="stylesheet" />
<script src="highslide/highslide-with-html.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="highslide/highslide.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.validate.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery.mask.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/funcoes.js" type="text/javascript" charset="ISO-8859-1"></script>
</head>

<body>
	<div id="corpo">
    	<div id="topo">
        	<jsp:include page="topo.jsp" />
      	</div>
        <div id="conteudo">
        <div id="get">
        <h3>Obras > Cadastrar</h3>
        <div id="form" class="form" style="width:1200px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formObra" name="formObra" method="post" target="recebeForm" action="../ObraCadastrar" enctype="multipart/form-data">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:488px; margin-right:10px;" class="required" minlength="4" value="" />
                <span>Informe o nome da obra</span>
              </div>
              <div class="coluna">
                <label for="campoArtista">Artista</label>
                <select name="campoArtista" id="campoArtista" style="width:341px; margin-right:10px;">
                  <option value="0">Artista indefinido</option>
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
                <label for="campoPonto">Ponto Tur&iacute;stico</label>
                <select name="campoPonto" id="campoPonto" style="width:341px;">
                  <option value="0">Ponto Tur&iacute;stico Indefinido</option>
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
                <label for="campoDescricao">Digite a descri&ccedil;&atilde;o da obra</label>
                <textarea id="campoDescricao" name="campoDescricao" style="width:1188px; height:200px;" class="required" minlength="1" value="" /></textarea>
                <span>Informe  a descri&ccedil;&atilde;o da obra</span>
              </div>
              <div class="coluna">
                <label for="campoImagem">Imagem</label>
                <input type="file" id="campoImagem" name="campoImagem[]" accept="image/*" multiple style="width:1188px;" class="required" minlength="1" />
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
      <div id="rodape">
      	<jsp:include page="rodape.jsp" />
      </div>
    </div>
</body>
</html>