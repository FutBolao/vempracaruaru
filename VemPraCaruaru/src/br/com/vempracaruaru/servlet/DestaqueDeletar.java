package br.com.vempracaruaru.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vempracaruaru.destaque.Destaque;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class AdministradorInativar
 */
@WebServlet("/DestaqueDeletar")
public class DestaqueDeletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestaqueDeletar() {
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
		    	Destaque destaque = Fachada.getInstance().destaqueListarPorId(id);
		    	Fachada.getInstance().destaqueDeletar(id);
		    	File arquivo = new File(getServletContext().getRealPath(destaque.getImagem()));
		    	System.out.println(destaque.getImagem());
		    	System.out.println("É diretorio: " + arquivo.isDirectory());
		    	System.out.println("É arquivo: " + arquivo.isFile());
				arquivo.delete();
		    	out.println( "<script>parent.alert(\"Destaque deletado com sucesso!\");</script>" );
		    	out.println( "<script>parent.location.href = \"sistema/destaqueListar.jsp\";</script>" );
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (DestaqueNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao deletar o destaque!\");</script>" );
		}
	}

}
