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

import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.exception.FotoNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.foto.Foto;
import br.com.vempracaruaru.obra.Obra;
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
    				Fachada.getInstance().obraDefinirImagemPrincipal(foto.getIdReferencia(), foto.getImagem());
    			} else if (foto.getReferencia().equals("artista")) {
    				Fachada.getInstance().artistaDefinirImagemPrincipal(foto.getIdReferencia(), foto.getImagem());
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
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				} else {
    					Fachada.getInstance().fotoDeletar(foto.getId());
//    					File arquivo = new File(getServletContext().getRealPath(foto.getImagem()));
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				}
    			} else if (foto.getReferencia().equals("obra")) {
    				Obra obra = Fachada.getInstance().obraListarPorId(foto.getIdReferencia());
    				if (obra.getFoto().equals(foto.getImagem())) {
    					Fachada.getInstance().fotoDeletar(foto.getId());
    					Foto fotoNova = Fachada.getInstance().fotoListarPorReferencia("obra", obra.getId()).get(0);
    					Fachada.getInstance().obraDefinirImagemPrincipal(obra.getId(), fotoNova.getImagem());
//    					File arquivo = new File(getServletContext().getRealPath(foto.getImagem()));
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				} else {
    					Fachada.getInstance().fotoDeletar(foto.getId());
//    					File arquivo = new File(getServletContext().getRealPath(foto.getImagem()));
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				}
    			} else if (foto.getReferencia().equals("artista")) {
    				Artista artista = Fachada.getInstance().artistaListarPorId(foto.getIdReferencia());
    				if (artista.getFoto().equals(foto.getImagem())) {
    					Fachada.getInstance().fotoDeletar(foto.getId());
    					Foto fotoNova = Fachada.getInstance().fotoListarPorReferencia("artista", artista.getId()).get(0);
    					Fachada.getInstance().artistaDefinirImagemPrincipal(artista.getId(), fotoNova.getImagem());
//    					File arquivo = new File(getServletContext().getRealPath(foto.getImagem()));
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				} else {
    					Fachada.getInstance().fotoDeletar(foto.getId());
//    					File arquivo = new File(getServletContext().getRealPath(foto.getImagem()));
    					String patch = getServletContext().getRealPath(foto.getImagem());
    					if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
    					File arquivo = new File(patch);
    					arquivo.delete();
    				}
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
