<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Administrador administrador = null;
try {
	administrador = Fachada.getInstance().administradorListarPorId(Integer.parseInt(request.getParameter("id")));
} catch (Exception e) {
	String url = response.encodeURL("administradorListar.jsp");     
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
        <h3>Administradores > Alterar</h3>
        <div id="form" class="form" style="width:610px">
          <iframe style="display:none;" name="recebeForm"></iframe>
		  <form id="formAdministrador" name="formAdministrador" method="post" target="recebeForm" action="../AdministradorAlterar?id=<%=administrador.getId() %>">
              <div class="coluna">
                <label for="campoNome">Nome</label>
                <input type="text" id="campoNome" name="campoNome" style="width:438px; margin-right:10px" class="required" minlength="4" value="<%=administrador.getNome() %>" />
                <span>Informe o nome completo do administrador</span>
              </div>
              <div class="coluna">
                <label for="campoCpf">CPF</label>
                <input type="text" id="campoCpf" name="campoCpf" style="width:122px;" class="required cpf" value="<%=administrador.getCpf() %>" />
                <span>Digite o CPF</span>
              </div>
              <div class="coluna">
                <label for="campoTelefone">Telefone</label>
                <input type="text" id="campoTelefone" name="campoTelefone" style="width:142px; margin-right:10px" class="fone" value="<%=administrador.getTelefone() %>" />
                <span>Digite o telefone</span>
              </div>
              <div class="coluna">
                <label for="campoUsuario">Usu&aacute;rio</label>
                <input type="text" id="campoUsuario" name="campoUsuario" style="width:418px; margin-right:10px" class="required"  minlength="4" value="<%=administrador.getUsuario() %>" readonly="readonly"/>
                <span>Digite o usu&aacute;rio</span>
              </div>
              <div class="coluna">
                <label for="campoSenha">Senha</label>
                <input type="password" id="campoSenha" name="campoSenha" style="width:280px; margin-right:10px" class="password" minlength="4" value="" />
                <span>Digite a senha</span>
              </div>
              <div class="coluna">
                <label for="campoSenhaR">Repita a senha</label>
                <input type="password" id="campoSenhaR" name="campoSenhaR" style="width:280px;" class="password" minlength="4" value="" />
                <span>Repita a senha</span>
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