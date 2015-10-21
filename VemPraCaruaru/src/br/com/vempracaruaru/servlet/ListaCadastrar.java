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

import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.lista.Lista;
import br.com.vempracaruaru.usuario.Usuario;

/**
 * Servlet implementation class ListaCadastrar
 */
@WebServlet("/ListaCadastrar")
public class ListaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCadastrar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	    int idUsuario = usuario.getId();
		int idPonto = Integer.parseInt(request.getParameter("idPonto"));
		try {
			Fachada.getInstance().listaCadastrar(new Lista(idUsuario, idPonto, "", 'N'));
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarListaException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ListaJaCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o ponto na lista\");</script>" );
		}
	}

}
