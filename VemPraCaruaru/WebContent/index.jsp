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
           	<a href="cadastro.jsp"  alt="Link para p&aacute;gina de cadastro">Cadastre-se e crie uma lista com seu roteiro de visitas.<br/>Assim você poderá acessa-la através do nosso aplicativo.</a>
            </div>
            <div>
            	<p style="margin-top:20px;"><h3>Sobre Caruaru</h3></p>
                <div style="margin-top:20px; line-height:20px; text-align:justify;">
                	A cidade de Caruaru começou a tomar forma em 1681, quando o governador Aires de Souza de Castro, concedeu à família Rodrigues de Sá uma sesmaria (concessão de terras com o intuito de desenvolver a agricultura e a criação de gado) com 30 léguas de extensão (aproximadamente 12 hectares), denominada Fazenda Caruru. Mas, apenas em 1776, José Rodrigues de Jesus decidiu voltar para a fazenda do pai, que havia passado alguns anos abandonada. Pouco tempo após a morte do patriarca, a fazenda ganhava uma capela, dedicada a Nossa Senhora da Conceição, que foi acolhendo um pequeno povoado ao seu redor.Caruaru tornou-se cidade, uma das primeiras do Agreste pernambucano, pelo projeto nº 20, do deputado provincial Francisco de Paula Baptista, defendido em primeira discussão em 03 de abril de 1857,depois de aprovação sem debate, em 18 de maio do mesmo ano, com a assinatura da Lei Provincial nº 416, pelo vice-presidente da província de Pernambuco, Joaquim Pires Machado Portela.Localizada no Vale do Ipojuca, ao longo dos anos Caruaru recebeu várias denominações, sendo conhecida também como a ‘Princesa do Agreste’, ‘Capital do Agreste’ e a ‘Capital do Forró’. O município é mais populoso do interior de Pernambuco, com uma população residente de 289.086 habitantes, conforme dados do IBGE, relativos ao ano de 2009, que vivem numa área territorial de 921 Km², tendo como padroeira Nossa Senhora das Dores.Atualmente Caruaru destaca-se como o mais importante pólo econômico, médico-hospitalar, acadêmico, cultural e turístico do Agreste, sendo também famosa por sua tradicional feira livre, enaltecida nos versos do compositor Onildo Almeida e na voz do eterno Rei do Baião, Luiz Gonzaga. A cidade abriga um dos mais importantes entrepostos comerciais do Nordeste e tem no Alto do Moura o Maior Centro de Artes Figurativas da América Latina, título este concedido pela Unesco, como reconhecimento de uma história iniciada na década de 40 do século passado, através do seu mais ilustre filho, Vitalino Pereira dos Santos, o Mestre Vitalino, ceramista que fez história através da criação de bonecos de barro, arte perpetuada entre seus familiares e vários discípulos, representados nas gerações de artesãos, ainda hoje residentes na famosa vila.
                </div>
            </div>
      </div>
		<div id="rodape">
			<jsp:include page="rodape.jsp"></jsp:include>
        </div>
	</div>
</body>
</html>