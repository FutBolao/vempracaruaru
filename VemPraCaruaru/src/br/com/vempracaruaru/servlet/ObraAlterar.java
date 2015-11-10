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
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarDestaqueException;
import br.com.vempracaruaru.exception.ObraNaoCadastradaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.obra.Obra;

/**
 * Servlet implementation class ObraCadastrar
 */
@WebServlet("/ObraAlterar")
public class ObraAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObraAlterar() {
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
	    int idArtista = Integer.parseInt(request.getParameter("campoArtista"));
	    int idPontoTuristico = Integer.parseInt(request.getParameter("campoPonto"));
	    String descricao = request.getParameter("campoDescricao");

		try {
			Fachada.getInstance().obraAlterar(new Obra(id, idArtista, "", sessionAdministrador.getId(), "", idPontoTuristico, "", nome, 'S', "", descricao));
			out.println( "<script>parent.alert(\"Alteração efetuada com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"sistema/obraListar.jsp\";</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelAlterarDestaqueException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ObraNaoCadastradaException e) {			
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (BusinessException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao alterar a obra\");</script>" );
		}
	}

}
