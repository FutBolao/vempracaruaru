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
import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.exception.ArtistaNaoCadastradoException;
import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarDestaqueException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class ArtistaCadastrar
 */
@WebServlet("/ArtistaAlterar")
public class ArtistaAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistaAlterar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Administrador sessionAdministrador = null;
		if (session.getAttribute("loginAdministrador") != null){
			sessionAdministrador = (Administrador) session.getAttribute("loginAdministrador");
		}
		
		response.setContentType("text/html;");
	    PrintWriter out = response.getWriter();
	    int id = Integer.parseInt(request.getParameter("id"));
	    String nome = request.getParameter("campoNome");
	    String tipo = request.getParameter("campoTipo");
	    String telefone = request.getParameter("campoTelefone");
	    String email = request.getParameter("campoEmail");
	    String twitter = request.getParameter("campoTwitter");
	    String instagram = request.getParameter("campoInstagram");
	    String facebook = request.getParameter("campoFacebook");
	    String historico = request.getParameter("campoHistorico");
	    
		try {
			Fachada.getInstance().artistaAlterar(new Artista(id, nome, sessionAdministrador.getId(), "", historico, tipo, "", telefone, email, twitter, instagram, facebook, 'S'));
			out.println( "<script>parent.alert(\"Alteração efetuada com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"sistema/artistaListar.jsp\";</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelAlterarDestaqueException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ArtistaNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (BusinessException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao alterar o artista\");</script>" );
		}
	}

}
