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

import br.com.vempracaruaru.exception.NaoFoiPossivelDeletarListaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

/**
 * Servlet implementation class ListaCadastrar
 */
@WebServlet("/ListaDeletar")
public class ListaDeletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDeletar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
		int idPonto = Integer.parseInt(request.getParameter("idPonto"));
		try {
			Fachada.getInstance().listaDeletar(usuario.getId(), idPonto);
			out.println( "<script>parent.alert(\"Ponto turístico deletado da lista com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"minhaConta.jsp?acao=listas\";</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelDeletarListaException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao deletar o ponto turístico na lista\");</script>" );
		}
	}

}
