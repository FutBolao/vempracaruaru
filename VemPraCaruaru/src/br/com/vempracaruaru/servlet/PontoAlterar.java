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
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

/**
 * Servlet implementation class PontoCadastrar
 */
@WebServlet("/PontoAlterar")
public class PontoAlterar extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PontoAlterar() {
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
	    String endereco = request.getParameter("campoEndereco");
	    String latitude = request.getParameter("campoLatitude");
	    String longitude = request.getParameter("campoLongitude");
	    String telefone = request.getParameter("campoTelefone");
	    String email = request.getParameter("campoEmail");
	    String tempoVisitacao = request.getParameter("campoTempo");
	    String horarioFuncionamento = request.getParameter("campoHorarioDeFuncionamento");
	    String historicoDescricao = request.getParameter("campoDescricao");
		try {
			Fachada.getInstance().pontoTuristicoAlterar(new PontoTuristico(id, sessionAdministrador.getId(), "", nome, endereco, latitude, longitude, telefone, email, tempoVisitacao, horarioFuncionamento, historicoDescricao, "", 'S', 0));
			out.println( "<script>parent.alert(\"Alteração efetuada com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"sistema/pontoListar.jsp\";</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarDestaqueException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (PontoTuristicoJaCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (BusinessException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao alterar o ponto turistico\");</script>" );
		}
	}

}
