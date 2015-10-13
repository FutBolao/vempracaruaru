<%@page import="br.com.vempracaruaru.usuario.Usuario"%>
<%
Usuario sessionUsuario = null;
//Verifico se foi feito um login com sucesso!
if (session.getAttribute("loginUsuario") == null){
	String url = response.encodeURL("/Sair");     
	RequestDispatcher rd = request.getRequestDispatcher(url);  
	rd.forward(request, response); 
} else {
	sessionUsuario = (Usuario) session.getAttribute("loginUsuario");
}
%>