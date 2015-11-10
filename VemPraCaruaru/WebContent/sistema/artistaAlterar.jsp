<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.artista.Artista"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Artista artista = null;
try {
	artista = Fachada.getInstance().artistaListarPorId(Integer.parseInt(request.getParameter("id")));
} catch (Exception e) {
	String url = response.encodeURL("artistaListar.jsp");     
	RequestDispatcher rd = request.getRequestDispatcher(url);  
	rd.forward(request, response);
}
%>
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
	<div id="corpo">
    	<div id="topo">
        	<jsp:include page="topo.jsp" />
      	</div>
        <div id="conteudo">
        <div id="get">
        <h3>Artistas > Alterar</h3>
        <div id="form" class="form" style="width:1200px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formArtista" name="formArtista" method="post" target="recebeForm" action="../ArtistaAlterar?id=<%=artista.getId() %>">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:588px; margin-right:10px" class="required" minlength="4" value="<%=artista.getNome() %>" />
                <span>Informe o nome do artista</span>
              </div>
              <div class="coluna">
                <label for="campoTipo">Tipo do artista</label>
                <select name="campoTipo" id="campoTipo" style="width:592px;" class="required">
                  <option value=""<%if (artista.getTipo().equals("")) out.print(" selected"); %>>Selecione um item na lista</option>
                  <option value="Artesão"<%if (artista.getTipo().equals("Artesão")) out.print(" selected"); %>>Artes&atilde;o</option>
                  <option value="Escultor(a)"<%if (artista.getTipo().equals("Escultor(a)")) out.print(" selected"); %>>Escultor(a)</option>
                  <option value="Fotográfo(a)"<%if (artista.getTipo().equals("Fotográfo")) out.print(" selected"); %>>Fotogr&aacute;fo(a)</option>
                  <option value="Músico"<%if (artista.getTipo().equals("Músico")) out.print(" selected"); %>>M&uacute;sico</option>
                  <option value="Pintor(a)"<%if (artista.getTipo().equals("Pintor")) out.print(" selected"); %>>Pintor(a)</option>
                  <option value="Poeta"<%if (artista.getTipo().equals("Poeta")) out.print(" selected"); %>>Poeta</option>
                </select>
                <span>Selecione o tipo do artista</span>
              </div>
              <div class="clear"></div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:142px; margin-right:10px" class="fone" value="<%=artista.getTelefone() %>" />
                <span>Digite o telefone</span>
              </div>
              <div class="coluna">
                <label for="campoEmail">Email</label>
                <input type="text" id="campoEmail" name="campoEmail" style="width:220px; margin-right:10px" class="email" minlength="4" value="<%=artista.getEmail() %>" />
                <span>Informe o email</span>
              </div>
              <div class="coluna">
                <label for="campoTwitter">Link do Twitter</label>
                <input type="text" id="campoTwitter" name="campoTwitter" style="width:250px; margin-right:10px" value="<%=artista.getTwitter() %>" />
                <span>Informe link do Twitter</span>
              </div>
              <div class="coluna">
                <label for="campoInstagram">Link do Instagram</label>
                <input type="text" id="campoInstagram" name="campoInstagram" style="width:249px; margin-right:10px;" value="<%=artista.getInstagram() %>" />
                <span>Informe link do Instagram</span>
              </div>
              <div class="coluna">
                <label for="campoFacebook">Link do Facebook</label>
                <input type="text" id="campoFacebook" name="campoFacebook" style="width:249px;" value="<%=artista.getFacebook() %>" />
                <span>Informe link do Facebook</span>
              </div>
              <div class="coluna">
                <label for="campoHistorico">Digite um breve hist&oacute;rico do artista</label>
                <textarea id="campoHistorico" name="campoHistorico" style="width:1188px; height:200px;" class="required" minlength="1" /><%=artista.getHistorico() %></textarea>
                <span>Informe um breve hist&oacute;rico do artista</span>
              </div>
              <div class="coluna">
                <button class="button blue submit" type="submit" style="margin-top:14px; margin-right:10px;">Alterar</button>
                <button  class="button gray reset" type="reset" style="margin-top:14px;">Redefinir</button>
              </div>
              <div class="clear"></div>
          </form>
        </div>
      </div>
      <div id="rodape">
      	<jsp:include page="rodape.jsp" />
      </div>
      </div>
    </div>
</body>
</html>