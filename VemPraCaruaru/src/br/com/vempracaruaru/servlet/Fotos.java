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

import br.com.vempracaruaru.exception.FotoNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.foto.Foto;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

/**
 * Servlet implementation class Foto
 */
@WebServlet("/Fotos")
public class Fotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fotos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;");
	    PrintWriter out = response.getWriter();
    	try {
    		if (request.getParameter("acao").equalsIgnoreCase("capa")) {
    			Foto foto = Fachada.getInstance().fotoListarPorId(Integer.parseInt(request.getParameter("id")));
    			if (foto.getReferencia().equals("ponto")) {
    				Fachada.getInstance().pontoTuristicoDefinirImagemPrincipal(foto.getIdReferencia(), foto.getImagem());
    			} else if (foto.getReferencia().equals("obra")) {
    				
    			} else if (foto.getReferencia().equals("artista")) {
    				
    			}
    			out.println( "<script>parent.alert(\"Imagem principal definida com sucesso!!!\");</script>" );
    			out.println( "<script>window.parent.location.reload(true);</script>" );
    		} else if (request.getParameter("acao").equalsIgnoreCase("deletar")) {
    			Foto foto = Fachada.getInstance().fotoListarPorId(Integer.parseInt(request.getParameter("id")));
    			if (foto.getReferencia().equals("ponto")) {
    				PontoTuristico ponto = Fachada.getInstance().pontoTuristicoListarPorId(foto.getIdReferencia());
    				if (ponto.getFoto().equals(foto.getImagem())) {
    					Fachada.getInstance().fotoDeletar(foto.getId());
    					Foto fotoNova = Fachada.getInstance().fotoListarPorReferencia("ponto", ponto.getId()).get(0);
    					Fachada.getInstance().pontoTuristicoDefinirImagemPrincipal(ponto.getId(), fotoNova.getImagem());
    					File arquivo = new File(foto.getImagem());
    					arquivo.delete();
    				} else {
    					Fachada.getInstance().fotoDeletar(foto.getId());
    					File arquivo = new File(foto.getImagem());
    					arquivo.delete();
    				}
    			} else if (foto.getReferencia().equals("obra")) {
    				
    			} else if (foto.getReferencia().equals("artista")) {
    				
    			}
    			out.println( "<script>parent.alert(\"Foto deletada com sucesso!!!\");</script>" );
    			out.println( "<script>window.parent.location.reload(true);</script>" );
    		}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (SQLException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (FotoNaoCadastradoException e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado manipular a foto\");</script>" );
		}
	}

}
