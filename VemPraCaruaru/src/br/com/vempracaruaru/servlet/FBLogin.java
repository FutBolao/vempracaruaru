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

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

/**
 * Servlet implementation class FBLogin
 */
@WebServlet("/FBLogin")
public class FBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FBLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
		String nome = request.getParameter("campoNome");
		String email = request.getParameter("campoEmail");
		String idFacebook = request.getParameter("campoId");
		System.out.println(nome);
		System.out.println(email);
		System.out.println(idFacebook);
		Usuario usuario = null;
		try {
			if (email != null && idFacebook != null){
				if (Fachada.getInstance().usuarioExisteEmail(email)) {
					usuario = Fachada.getInstance().usuarioListarPorIdFacebook(idFacebook, email);
					if (usuario != null) {
						HttpSession session = request.getSession(true);
						session.setAttribute("loginUsuario", usuario);
						out.println( "<script>parent.window.location = \"minhaConta.jsp\"</script>" );
					} else {
						Fachada.getInstance().usuarioAlterarIdFacebook(idFacebook, email);
						usuario = Fachada.getInstance().usuarioListarPorIdFacebook(idFacebook, email);
						HttpSession session = request.getSession(true);
						session.setAttribute("loginUsuario", usuario);
						out.println( "<script>parent.window.location = \"minhaConta.jsp\"</script>" );
					}
				} else {
					Fachada.getInstance().usuarioCadastrar(new Usuario(0, nome, email, "", "", idFacebook, "", 0, 'S'));
					usuario = Fachada.getInstance().usuarioListarPorIdFacebook(idFacebook, email);
					HttpSession session = request.getSession(true);
					session.setAttribute("loginUsuario", usuario);
					out.println( "<script>parent.window.location = \"minhaConta.jsp\"</script>" );
				}
			} else {
				out.println( "<script>parent.alert(\"Por favor forneça autorização das informações solicitadas, para que seja possível efetuar o login.\");</script>" );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarUsuarioException e) {
			e.printStackTrace();
		} catch (UsuarioJaCadastradoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o usuário\");</script>" );
		}
	}

}
