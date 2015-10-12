<jsp:include page="verificaLogin.jsp" />
<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%
Administrador sessionAdministrador = null;
// //Verifico se foi feito um login com sucesso!
// if (session.getAttribute("loginAdministrador") == null){
// // 	response.sendRedirect("login.jsp");
// 	String url = response.encodeURL("/sistema/Sair");     
// 	RequestDispatcher rd = request.getRequestDispatcher(url);  
// 	rd.forward(request, response); 
// } else {
	sessionAdministrador = (Administrador) session.getAttribute("loginAdministrador");
// }
%>
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
                Ol&aacute; <strong><%=sessionAdministrador.getNome() %></strong>, seja bem vindo!</div>
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
                <li class='singsub'><a href='#'>Contato</a>
                    <ul class='sub-menu hidden'>
                        <li><a href='contatoNovas.jsp'>Mensagens Novas</a></li>
                        <li><a href='contatoLidas.jsp'>Mensagem Lidas</a></li>
                    </ul></li>
            </ul>
        </nav>
    </div>
</div>
<div class="clear"></div>