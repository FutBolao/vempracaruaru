<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@page import="br.com.vempracaruaru.pontoturistico.PontoTuristico"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
PontoTuristico ponto = null;
ArrayList<Foto> fotos = new ArrayList<Foto>();
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vem Pra Caruaru</title>
<link href="css/cssSite.css" type="text/css" media="screen" rel="stylesheet" />
<link href="css/style.css" type="text/css" media="screen" rel="stylesheet" />
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/scriptaculous.js?load=effects,builder"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />

</head>

<body>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo">
        	<iframe style="display:none;" name="recebeForm"></iframe>
        	<%ponto = Fachada.getInstance().pontoTuristicoListarPorId(Integer.parseInt(request.getParameter("id")));%>
        	<div class="coluna">
        		<h3><%=ponto.getNome() %></h3>
        	</div>
        	<div class="coluna" style="float:right;">
        		<div class="coluna" style="background-color:#FECC47; color:#FFF; height:30px; padding-left:8px; padding-right:8px; cursor:pointer; line-height:28px;" onClick="window.open('obras.jsp?idPonto=<%=ponto.getId() %>', '_self')">ver obras</div>
        		<div class="coluna" style="background-color:#F3660A; color:#FFF; height:30px; padding-left:8px; padding-right:8px; cursor:pointer; line-height:28px; margin-left:30px;" onClick="window.open('pontosTuristicosDetalhes.jsp?id=<%=ponto.getId() %>', 'recebeForm'); $(this).hide();">+ adicionar à lista</div>
        	</div>
        	<br/><br/><br/><br/>
        	<div class="clear">
                <div class="coluna" style="margin-right:10px;">
                    <img src="<%=ponto.getFoto() %>" alt="Imagem principal do Ponto Turístico <%=ponto.getNome()%>" title="Imagem principal do Ponto Turístico <%=ponto.getNome()%>" width="320" height="242"><br/>
                </div>
                <div style="margin-right:10px; line-height:20px;">
                    <strong>Endereço: </strong><%=ponto.getEndereco()%><br/>
                    <strong>Telefone: </strong><%=ponto.getTelefone()%><br/>
                    <strong>Email: </strong><%=ponto.getEmail()%><br/>
                    <strong>Horario de funcionamento: </strong><%=ponto.getHorarioFuncionamento()%><br/>
                    <strong>Tempo de visitação: </strong><%=ponto.getTempoVisitacao()%><br/>
                    <strong>Descrição: </strong><%=ponto.getHistoricoDescricao().replaceAll("\n", "<br/>").replaceAll("\r", "")%>
                </div>
        	</div>
            <%fotos = Fachada.getInstance().fotoListarPorReferencia("ponto", ponto.getId());
              if (fotos.size() > 1) { %>
            <br/><br/>
            <div class="clear">
            	<span style="color:#FECC47; font-size:16px; font-weight:bold;">Fotos</span>
            </div>
            <div class="clear">
            	<%
            	int contador = 0;
            	for (Foto foto : fotos) {
            	contador++; %>
            	<div class="coluna" style="margin-top:20px;">
            		<a href="<%=foto.getImagem() %>" rel="lightbox[roadtrip]" alt="Link para ampliar a imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=ponto.getNome() %>"><img src="<%=foto.getImagem() %>" alt="Imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=ponto.getNome() %>" title="Imagem de id <%=foto.getId() %> do ponto tur&iacute;stico <%=ponto.getNome() %>" width="150" height="110"></a>
            	</div>
            	<%
	        	  if (contador == 7) {
	        		  contador = 0;
	        	  } else {%>
	        		<div class="coluna" style="min-width: 25px;">&nbsp;</div>
	        	<%}
            	}%>
            </div>
            <%}
              if (!ponto.getLatitude().equals("") && !ponto.getLongitude().equals("")) { %>
            
            <div class="clear">
            	<br/><br/>
            	<span style="color:#FE6602; font-size:16px; font-weight:bold;">Localização</span><br/><br/>
                <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
				<script type="text/javascript">
                  google.maps.event.addDomListener(window, 'load', function() {
                    var map = new google.maps.Map(document.getElementById('map'), {
                      zoom: 17,
                      center: new google.maps.LatLng(<%=ponto.getLatitude()%>, <%=ponto.getLongitude()%>),
                      mapTypeId: google.maps.MapTypeId.ROADMAP
                    });
                
                    var infoWindow = new google.maps.InfoWindow;
                
                    var onMarkerClick = function() {
                      var marker = this;
                      var latLng = marker.getPosition();
                      infoWindow.setContent('<h3>Endereço do Ponto Turístico:</h3> <%=ponto.getEndereco()%>');
                
                      infoWindow.open(map, marker);
                    };
                    google.maps.event.addListener(map, 'click', function() {
                      infoWindow.close();
                    });
                
                    var marker1 = new google.maps.Marker({
                      map: map,
                      position: new google.maps.LatLng(<%=ponto.getLatitude()%>, <%=ponto.getLongitude()%>)
                    });
                 
                
                    google.maps.event.addListener(marker1, 'click', onMarkerClick);
                  });
                </script>
                <div id="map" style="width: 100%; height: 400px"></div>
            </div>
            <%} %>
        </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>