<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
PontoTuristico ponto = null;
try {
	ponto = Fachada.getInstance().pontoTuristicoListarPorId(Integer.parseInt(request.getParameter("id")));
} catch (Exception e) {
	String url = response.encodeURL("pontoListar.jsp");     
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
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/mapa.js" type="text/javascript" charset="ISO-8859-1"></script>
<script src="../js/jquery-ui.custom.min.js" type="text/javascript" charset="ISO-8859-1"></script>
</head>

<body>
	<div id="corpo">
    	<div id="topo">
        	<jsp:include page="topo.jsp" />
      	</div>
        <div id="conteudo">
        <div id="get">
        <h3>Pontos Tur&iacute;sticos > Alterar</h3>
        <div id="form" class="form" style="width:1200px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formPonto" name="formPonto" method="post" target="recebeForm" action="../PontoAlterar?id=<%=ponto.getId() %>">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:1188px;" class="required" minlength="4" value="<%=ponto.getNome() %>" />
                <span>Informe o nome do ponto tur&iacute;stico</span>
              </div>
              <div class="coluna">
                <label for="campoEndereco">Endere&ccedil;o</label>
                <input type="text" id="campoEndereco" name="campoEndereco" style="width:1188px;" class="required" minlength="4" value="<%=ponto.getEndereco() %>" />
                <span>Informe o endere&ccedil;o do ponto tur&iacute;stico</span>
                <input type="hidden" id="campoLatitude" name="campoLatitude" value="<%=ponto.getLatitude() %>"/>
                <input type="hidden" id="campoLongitude" name="campoLongitude" value="<%=ponto.getLongitude() %>"/>
              </div>
              <div class="coluna">
                <div id="mapa"></div>
                <script type="text/javascript">carregarNoMapa(<%=ponto.getEndereco() %>)</script>
              </div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:138px; margin-right:10px" class="fone" value="<%=ponto.getTelefone() %>" />
                <span>Informe o telefone</span>
              </div>
              <div class="coluna">
                <label for="campoEmail">Email</label>
                <input type="text" id="campoEmail" name="campoEmail" style="width:350px; margin-right:10px" class="email" minlength="4" value="<%=ponto.getEmail() %>" />
                <span>Informe o email</span>
              </div>
              <div class="coluna">
                <label for="campoTempo">Tempo de visita&ccedil;&atilde;o</label>
                <input type="text" id="campoTempo" name="campoTempo" style="width:138px; margin-right:10px" class="required tempo" minlength="4" value="<%=ponto.getTempoVisitacao() %>" />
                <span>Informe tempo</span>
              </div>
              <div class="coluna">
                <label for="campoHorarioDeFuncionamento">Hor&aacute;rio de funcionamento</label>
                <input type="text" id="campoHorarioDeFuncionamento" name="campoHorarioDeFuncionamento" style="width:504px;" class="required" minlength="4" value="<%=ponto.getHorarioFuncionamento() %>" />
                <span>Informe hor&aacute;rio de funcionamento</span>
              </div>
              <div class="coluna">
                <label for="campoDescricao">Descri&ccedil;&atilde;o do ponto tur&iacute;stico</label>
                <textarea id="campoDescricao" name="campoDescricao" style="width:1188px; height:200px;" class="required" minlength="1" /><%=ponto.getHistoricoDescricao() %></textarea>
                <span>Informe uma descri&ccedil;&atilde;o do ponto tur&iacute;stico</span>
              </div>
              <div class="coluna">
                <button class="button blue submit" type="submit" style="margin-top:14px; margin-right:10px;">Alterar</button>
                <button  class="button gray" type="reset" style="margin-top:14px;">Redefinir</button>
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