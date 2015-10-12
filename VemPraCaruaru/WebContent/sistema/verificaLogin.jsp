<%@page import="br.com.vempracaruaru.administrador.Administrador"%>
<%
Administrador sessionAdministrador = null;
//Verifico se foi feito um login com sucesso!
if (session.getAttribute("loginAdministrador") == null){
// 	response.sendRedirect("login.jsp");
	String url = response.encodeURL("/sistema/Sair");     
	RequestDispatcher rd = request.getRequestDispatcher(url);  
	rd.forward(request, response); 
} else {
	sessionAdministrador = (Administrador) session.getAttribute("loginAdministrador");
}
%>