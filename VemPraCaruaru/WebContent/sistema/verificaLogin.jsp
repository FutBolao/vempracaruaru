<%
//Verifico se foi feito um login com sucesso!
if (session.getAttribute("loginAdministrador") == null){
	String url = response.encodeURL("Sair");     
	RequestDispatcher rd = request.getRequestDispatcher(url);  
	rd.forward(request, response); 
}
%>