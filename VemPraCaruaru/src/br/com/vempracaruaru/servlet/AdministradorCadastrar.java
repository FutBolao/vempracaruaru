package br.com.vempracaruaru.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class AdministradorCadastrar
 */
@WebServlet("/AdministradorCadastrar")
public class AdministradorCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorCadastrar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
		String nome = request.getParameter("campoNome");
		String cpf = request.getParameter("campoCpf");
		String telefone = request.getParameter("campoTelefone");
		String usuario = request.getParameter("campoUsuario");
		String senha = request.getParameter("campoSenha");
		try {
			Fachada.getInstance().administradorCadastrar(new Administrador(0, nome, cpf, telefone, usuario, senha, 'S'));
			out.println( "<script>parent.alert(\"Cadastro efetuado com sucesso!!!\");</script>" );
			out.println( "<script>parent.limparFormulario();</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarAdministradorException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (AdministradorJaCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o administrador\");</script>" );
		}
	}

}
