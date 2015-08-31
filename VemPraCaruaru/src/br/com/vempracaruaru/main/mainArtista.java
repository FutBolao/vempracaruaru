package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.exception.ArtistaJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.fachada.Fachada;

public class mainArtista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("inicio teste");
			Fachada.getInstance().artistaCadastrar(new Artista(1, "João Henrique", 
					1,"Zé", "sem", "escultor", 'A',null));
//			ArrayList<Artista> lista = Fachada.getInstance().artistaListarTodos("nome = nome");
		
//			for(Artista artista : lista) {
//				System.out.println(artista.toString());
//			}
			
//			Fachada.getInstance().artistaAlterar(new Artista(1, 1, "João Henrique",	"Zé", "Doido", "escultor", 'A') );
			
			Fachada.getInstance().artistaDeletar(1);
			System.out.println("fim de teste");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarArtistaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArtistaJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
