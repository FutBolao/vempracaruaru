package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;



import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

public class mainTesteArtista {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */
		
		try {
//			Fachada.getInstance().artistaCadastrar(new Artista(11, "MarcosAtual", 10, "joséAtual", "sem", "musico", 'A', "sljdgkjsh"));
			
//			Artista artista1 = Fachada.getInstance().artistaListarPorId(10);
//			ArrayList<Artista> lista1 = Fachada.getInstance().artistaListarPorNome("Marcos");
			ArrayList<Artista> lista2 = Fachada.getInstance().artistaListarTodos("nome_artista = nome_artista");
			
//			System.out.println("artista1: " + artista1.toString());

//			
//			for (Artista artista : lista1) {
//				System.out.println(artista.toString());
//			}
			System.out.println("listar 2");
			
			for (Artista artista : lista2) {
				System.out.println(artista.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarAdministradorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdministradorJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
