<jsp:include page="verificaLogin.jsp" />
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.destaque.Destaque"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Destaque> destaques = new ArrayList<Destaque>();
String url = String.valueOf(request.getRequestURL());
%>
<div id="topoMenuConteudo">
        <div class="coluna" id="logoTopo">
            <img src="img/logoTopo.png" width="156" height="136" alt="Logomarca Vem Pra Caruaru">
        </div>
        <div class="coluna" id="menu">
            <nav id='nav'>
                <ul class='menunav' id='navinti'>
                    <li<%if (url.endsWith("index.jsp")) out.print(" class='menuSelecionado'"); %>><a href='index.jsp' alt="Link para página inicial" title="Link para página inicial">Início</a></li>
                    <li<%if (url.endsWith("pontosTuristucos.jsp")) out.print(" class='menuSelecionado'"); %>><a href='pontosTuristucos.jsp' alt="Link para página de pontos turísticos" title="Link para página de pontos turísticos">Pontos Turísticos</a></li>
                    <li<%if (url.endsWith("artistas.jsp")) out.print(" class='menuSelecionado'"); %>><a href='artistas.jsp' alt="Link para página de artistas" title="Link para página de artistas">Artistas</a></li>
                    <li<%if (url.endsWith("obras.jsp")) out.print(" class='menuSelecionado'"); %>><a href='obras.jsp' alt="Link para página de obras" title="Link para página de obras">Obras</a></li>
                    <li<%if (url.endsWith("contato.jsp")) out.print(" class='menuSelecionado'"); %>><a href='contato.jsp' alt="Link para página de contato" title="Link para página de contato">Contato</a></li>
                    <li<%if (url.endsWith("cadastro.jsp")) out.print(" class='menuSelecionado'"); %>><a href='cadastro.jsp' alt="Link para página de cadastro" title="Link para página de cadastro">Cadastre-se</a></li>
                    <li<%if (url.endsWith("entrar.jsp")) out.print(" class='menuSelecionado'"); %>><a href='entrar.jsp' alt="Link para página de login" title="Link para página de login">Entrar</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="wowslider-container1">
    <div class="ws_images">
        <ul>
            <%int contadorDestaque = 0;
              destaques = Fachada.getInstance().destaqueListarTodos("");
              for (Destaque destaque : destaques){ 
                if (destaque.getLink().equals("")) {
                    destaque.setLink("#");
                }%>
            <li><a href="<%=destaque.getLink() %>" target="_blank"><img src="<%=destaque.getImagem() %>"
                    alt="Imagem do destaque <%=destaque.getTitulo() %>"
                    title="<%=destaque.getTitulo() %>" id="wows1_<%=contadorDestaque %>" /></a></li>
            <%contadorDestaque++; } %>
        </ul>
    </div>
    <div class="ws_bullets">
        <div>
            <%contadorDestaque = 0;
              for (Destaque destaque : destaques){ 
                if (destaque.getLink().equals("")) {
                    destaque.setLink("#");
                }%>
                    <a href="<%=destaque.getLink() %>"><span><img src="<%=destaque.getImagem() %>" 
                    alt="Imagem do destaque <%=destaque.getTitulo() %>"
                    title="<%=destaque.getTitulo() %>" width="80" height="60" /><%=contadorDestaque %></span></a>
            <%contadorDestaque++; } %>
        </div>
    </div>
    <div class="ws_shadow"></div>
</div>
<script src="js/wowslider.js" type="text/javascript" charset="utf-8"></script>
<script src="js/script.js" type="text/javascript" charset="utf-8"></script>