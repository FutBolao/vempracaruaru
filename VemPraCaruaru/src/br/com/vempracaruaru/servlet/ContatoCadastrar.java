package br.com.vempracaruaru.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vempracaruaru.contato.Contato;
import br.com.vempracaruaru.exception.ContatoJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarContatoException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class CadastrarContato
 */
@WebServlet("/ContatoCadastrar")
public class ContatoCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoCadastrar() {
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
		String telefone = request.getParameter("campoTelefone");
		String assunto = request.getParameter("campoAssunto");
		try {
			Fachada.getInstance().contatoCadastrar(new Contato(0, nome, email, telefone, assunto, "", 'N'));
			out.println( "<script>parent.contatoEnviadoComSucesso();</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarContatoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ContatoJaCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o contato\");</script>" );
		}
	}

}
