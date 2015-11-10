package br.com.vempracaruaru.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vempracaruaru.exception.ContatoNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class AdministradorInativar
 */
@WebServlet("/ContatoDeletar")
public class ContatoDeletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoDeletar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		    if (id > 0){
		    	Fachada.getInstance().contatoDeletar(id);
		    	out.println( "<script>parent.alert(\"Mensagem deletada com sucesso!\");</script>" );
		    	out.println( "<script>parent.location.href = \"sistema/contatoNovas.jsp\";</script>" );
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ContatoNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao deletar a mensagem!\");</script>" );
		}
	}

}
