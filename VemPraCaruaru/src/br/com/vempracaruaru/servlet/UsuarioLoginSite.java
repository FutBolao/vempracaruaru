package br.com.vempracaruaru.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

/**
 * Servlet implementation class UsuarioLoginSite
 */
@WebServlet("/UsuarioLoginSite")
public class UsuarioLoginSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLoginSite() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    String campoEmail = request.getParameter("campoEmail");
	    String campoSenha = request.getParameter("campoSenha");
	    if (!campoEmail.equals("") && !campoSenha.equals("")) {
	    	Usuario usuario = null;
	    	try {
				usuario = Fachada.getInstance().usuarioLoginSite(campoEmail, campoSenha);
				HttpSession session = request.getSession(true);
				session.setAttribute("loginUsuario", usuario);
				out.println( "<script>parent.window.location = \"minhaConta.jsp\"</script>" );
			} catch (SQLException e) {
				e.printStackTrace();
				out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
			} catch (BusinessException e) {
				e.printStackTrace();
				out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
			} catch (Exception e) {
				e.printStackTrace();
				out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao efetuar o login!\");</script>" );
			}
	    } else {
	    	out.println( "<script>parent.alert(\"Login inválido!\");</script>" );
	    }
	}

}
