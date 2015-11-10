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
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class AdministradorCadastrar
 */
@WebServlet("/AdministradorAlterar")
public class AdministradorAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorAlterar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("campoNome");
		String cpf = request.getParameter("campoCpf");
		String telefone = request.getParameter("campoTelefone");
		String usuario = request.getParameter("campoUsuario");
		String senha = request.getParameter("campoSenha");
		try {
			if (!senha.equals(request.getParameter("campoSenhaR"))) throw new Exception("As senhas digitadas não são iguais, por favor verifique!");
			Fachada.getInstance().administradorAlterar(new Administrador(id, nome, cpf, telefone, usuario, senha, 'S'));
			out.println( "<script>parent.alert(\"Alteração efetuada com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"sistema/administradorListar.jsp\";</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelAlterarAdministradorException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (AdministradorNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		}
	}

}
