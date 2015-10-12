<%@page import="br.com.vempracaruaru.obra.Obra"%>
<%@page import="br.com.vempracaruaru.foto.Foto"%>
<%@page import="br.com.vempracaruaru.util.Formatacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.vempracaruaru.fachada.Fachada"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
Obra obra = null;
ArrayList<Foto> fotos = new ArrayList<Foto>();
try {
	obra = Fachada.getInstance().obraListarPorId(Integer.parseInt(request.getParameter("id")));
	fotos = Fachada.getInstance().fotoListarPorReferencia("obra", obra.getId());
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="ISO-8859-1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de gerenciamento do aplicativo "Vem Pra Caruaru"</title>
<link href="../css/cssSistema.css" type="text/css" media="screen" rel="stylesheet" />
<link href="../css/button.css" type="text/css" media="screen" rel="stylesheet" />
<link href="../css/bootstrap.min.css" type="text/css" media="screen" rel="stylesheet" />
<link href="../css/jquery.fileupload.css" type="text/css" media="screen" rel="stylesheet" />
</head>

<body>
	<div id="detalhes">
      <iframe style="display:none;" name="recebeForm"></iframe>
	  <h3>Fotos da Obra de ID 
        <%=obra.getId() %></h3>
	    <p style="line-height:22px; padding-top:10px;">
      </p>
		<div>
			<span class="btn btn-success fileinput-button"> <i
				class="glyphicon glyphicon-plus"></i> <span>Selecione os arquivos...</span>
				<input id="fileupload" type="file" name="files[]" multiple>
			</span><br><br>
			<!-- The global progress bar -->
			<div id="progress" class="progress">
				<div class="progress-bar progress-bar-success"></div>
			</div>
			<!-- The container for the uploaded files -->
			<div id="files" class="files"></div>
			<br>
		</div>
		<%for (Foto foto : fotos) {%>
		<div class="coluna" style="margin:2px;">
			<img src="../<%=foto.getImagem() %>" alt="Imagem de ID <%=foto.getId()%>" title="Imagem de ID <%=foto.getId()%>" width="282" height="212"><br/>
            <div style="text-align:center;">
            	<%if (!obra.getFoto().equals(foto.getImagem())) { %>
            	<button class="button blue" style="margin-top:2px;" onClick="window.open('../Fotos?acao=capa&id=<%=foto.getId()%>', 'recebeForm')">Definir como capa</button>
            	<%} %>
           		<button class="button red" style="margin-top:2px;" onClick="window.open('../Fotos?acao=deletar&id=<%=foto.getId()%>', 'recebeForm')">Deletar</button>
            </div>
		</div>
		<%}%>
		<div class="clear"></div>
	</div>
<script src="../js/jquery.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="../js/jquery.ui.widget.js" type="text/javascript" charset="ISO-8859-1"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="../js/jquery.iframe-transport.js" type="text/javascript" charset="ISO-8859-1"></script>
<!-- The basic File Upload plugin -->
<script src="../js/jquery.fileupload.js" type="text/javascript" charset="ISO-8859-1"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<script src="../js/bootstrap.min.js" type="text/javascript" charset="ISO-8859-1"></script>
<script>
/*jslint unparam: true */
/*global window, $ */
$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = window.location.hostname === '../Upload?id=<%=obra.getId() %>&referencia=obra' ?
                '../Upload?id=<%=obra.getId() %>&referencia=obra' : '../Upload?id=<%=obra.getId() %>&referencia=obra';
    $('#fileupload').fileupload({
        url: url,
        dataType: 'json',
        done: function (e, data) {
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo('#files');
            });
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css(
                'width',
                progress + '%'
            );
            setTimeout("location.reload(true);", 4000);
			
        }
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
});
</script>
</body>
</html>