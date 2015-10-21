<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<footer>
    <div id="rodapeConteudo">
          <div class="coluna">
            <img src="img/logoRodape.png" width="118" height="102" alt="Logomarca Vem Pra Caruaru" title="Logomarca Vem Pra Caruaru">
          </div>
          <div class="coluna" style="margin-top:20px; margin-left:30px; color:#FFFFFF;">
                <div>&copy; Copyright 2015 Vem Pra Caruaru — Todos os direitos reservados</div>
                <div class="coluna" style="margin-top:10px; margin-right:10px;"> <a href="#"><img src="img/iconFacebook.png" width="37" height="37" alt="Link para página do facebook Vem Pra Caruaru" title="Link para página do facebook Vem Pra Caruaru"></a>
                  <a href="#"><img src="img/iconTwitter.png" width="37" height="37" alt="Link para página do twitter Vem Pra Caruaru" title="Link para página do twitter Vem Pra Caruaru"></a>
                  <a href="#"><img src="img/iconInstagram.png" width="38" height="37" alt="Link para página do instagram Vem Pra Caruaru" title="Link para página do instagram Vem Pra Caruaru"></a>
                </div>
                <div style="margin-top:28px;">Siga-nos nas redes sociais.</div>
          </div>
          <div class="coluna" id="menuRodape" style="margin-left:310px;">
              <ul>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="index.jsp">Início</a></li>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="pontosTuristicos.jsp">Pontos Turísticos</a></li>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="artistas.jsp">Artistas</a></li>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="obras.jsp">Obras</a></li>
              </ul>
          </div>
          <div class="coluna" id="menuRodape" style="margin-left:20px;">
              <ul>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="contato.jsp">Contato</a></li>
                <%if (session.getAttribute("loginUsuario") == null){ %>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="cadastro.jsp">Cadastre-se</a></li>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="entrar.jsp">Entrar</a></li>
                <%} else {%>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="minhaConta.jsp">Minha Conta</a></li>
                <li><img src="img/quadrado8x8.png" width="8" height="8"> <a href="Sair">Sair</a></li>
                <%} %>
              </ul>
          </div>
     </div>             
</footer>