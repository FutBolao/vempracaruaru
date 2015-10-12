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

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class Login
 */
@WebServlet("/sistema/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    String campoUsuario = request.getParameter("campoUsuario");
	    String campoSenha = request.getParameter("campoSenha");
	    if (!campoUsuario.equals("") && !campoSenha.equals("")) {
	    	Administrador administrador;
			try {
				administrador = Fachada.getInstance().administradorLogin(campoUsuario, campoSenha);
				HttpSession session = request.getSession(true);
				session.setAttribute("loginAdministrador", administrador);
				out.println( "<script>parent.window.location = \"index.jsp\"</script>" );
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
