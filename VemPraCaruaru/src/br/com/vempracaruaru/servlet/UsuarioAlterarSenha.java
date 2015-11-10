package br.com.vempracaruaru.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

/**
 * Servlet implementation class AdministradorInativar
 */
@WebServlet("/UsuarioAlterarSenha")
public class UsuarioAlterarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioAlterarSenha() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    System.out.println("Entrou nessa porra");
	    int id = Integer.parseInt(request.getParameter("id"));
		String senha = request.getParameter("campoSenha");
	    
		try {
		    if (id > 0){
		    	Fachada.getInstance().usuarioAlterarSenha(new Usuario(id, "", "", "", senha, "", "", 0, 'S'));
		    	out.println( "<script>parent.usuarioSenhaAlteradaComSucesso();</script>" );
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (UsuarioNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao alterar a senha do usuário!\");</script>" );
		}
	}

}
