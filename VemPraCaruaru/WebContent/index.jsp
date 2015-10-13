<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vem Pra Caruaru</title>
<link href="css/cssSite.css" type="text/css" media="screen" rel="stylesheet" />
<link href="css/style.css" type="text/css" media="screen" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Dosis:500' rel='stylesheet' type='text/css'>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>

</head>

<body>
	<div id="corpo">
		<div id="topo">
          <jsp:include page="topo.jsp"></jsp:include>
		<div id="conteudo">
        	<div id="textoCadastro">
           	<a href="cadastro.jsp"  alt="Link para p&aacute;gina de cadastro">Cadastre-se e crie uma lista com seu roteiro de visitas.<br/>Assim voc� poder� acessa-la atrav�s do nosso aplicativo.</a>
            </div>
            <div>
            	<p style="margin-top:20px;"><h3>Sobre Caruaru</h3></p>
                <div style="margin-top:20px; line-height:20px; text-align:justify;">
                	A cidade de Caruaru come�ou a tomar forma em 1681, quando o governador Aires de Souza de Castro, concedeu � fam�lia Rodrigues de S� uma sesmaria (concess�o de terras com o intuito de desenvolver a agricultura e a cria��o de gado) com 30 l�guas de extens�o (aproximadamente 12 hectares), denominada Fazenda Caruru. Mas, apenas em 1776, Jos� Rodrigues de Jesus decidiu voltar para a fazenda do pai, que havia passado alguns anos abandonada. Pouco tempo ap�s a morte do patriarca, a fazenda ganhava uma capela, dedicada a Nossa Senhora da Concei��o, que foi acolhendo um pequeno povoado ao seu redor.Caruaru tornou-se cidade, uma das primeiras do Agreste pernambucano, pelo projeto n� 20, do deputado provincial Francisco de Paula Baptista, defendido em primeira discuss�o em 03 de abril de 1857,depois de aprova��o sem debate, em 18 de maio do mesmo ano, com a assinatura da Lei Provincial n� 416, pelo vice-presidente da prov�ncia de Pernambuco, Joaquim Pires Machado Portela.Localizada no Vale do Ipojuca, ao longo dos anos Caruaru recebeu v�rias denomina��es, sendo conhecida tamb�m como a �Princesa do Agreste�, �Capital do Agreste� e a �Capital do Forr�. O munic�pio � mais populoso do interior de Pernambuco, com uma popula��o residente de 289.086 habitantes, conforme dados do IBGE, relativos ao ano de 2009, que vivem numa �rea territorial de 921 Km�, tendo como padroeira Nossa Senhora das Dores.Atualmente Caruaru destaca-se como o mais importante p�lo econ�mico, m�dico-hospitalar, acad�mico, cultural e tur�stico do Agreste, sendo tamb�m famosa por sua tradicional feira livre, enaltecida nos versos do compositor Onildo Almeida e na voz do eterno Rei do Bai�o, Luiz Gonzaga. A cidade abriga um dos mais importantes entrepostos comerciais do Nordeste e tem no Alto do Moura o Maior Centro de Artes Figurativas da Am�rica Latina, t�tulo este concedido pela Unesco, como reconhecimento de uma hist�ria iniciada na d�cada de 40 do s�culo passado, atrav�s do seu mais ilustre filho, Vitalino Pereira dos Santos, o Mestre Vitalino, ceramista que fez hist�ria atrav�s da cria��o de bonecos de barro, arte perpetuada entre seus familiares e v�rios disc�pulos, representados nas gera��es de artes�os, ainda hoje residentes na famosa vila.
                </div>
            </div>
      </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>