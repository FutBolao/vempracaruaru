<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.destaque.Destaque"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Destaque destaque = null;
try {
	destaque = Fachada.getInstance().destaqueListarPorId(Integer.parseInt(request.getParameter("id")));
} catch (Exception e) {
	String url = response.encodeURL("destaqueListar.jsp");     
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
        <h3>Destaques > Alterar</h3>
        <div id="form" class="form" style="width:610px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formDestaque" name="formDestaque" method="post" target="recebeForm" action="../DestaqueAlterar?id=<%=destaque.getId() %>" enctype="multipart/form-data">
              <input type="hidden" id="campoImagemString" name="campoImagemString" value="<%=destaque.getImagem() %>" />
              <div class="coluna">
                <label for="campoImagem">Imagem (selecione a imagem se quiser alterar a atual)</label>
                <input type="file" id="campoImagem" name="campoImagem" accept="image/*" style="width:438px; margin-right:10px" minlength="1" />
                <span>Selecione a imagem de destaque</span>
              </div>
              <div class="coluna">
                <label for="campoTitulo">Titulo</label>
                <input type="text" id="campoTitulo" name="campoTitulo" style="width:438px; margin-right:10px" class="required" minlength="4" value="<%=destaque.getTitulo() %>" />
                <span>Informe um t&iacute;tulo da imagem de destaque</span>
              </div>
              <div class="coluna">
                <label for="campoLink">Link</label>
                <input type="text" id="campoLink" name="campoLink" style="width:438px; margin-right:10px" minlength="4" value="<%=destaque.getLink() %>" />
                <span>Informe um link para a imagem</span>
              </div>
            <div class="coluna">
                <button class="button blue submit" type="submit" style="margin-top:14px; margin-right:10px;">Alterar</button>
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