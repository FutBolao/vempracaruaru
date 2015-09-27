package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.lista.Lista;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class mainTesteLista {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */
		
		
		try {
			ArrayList<PontoTuristico> lista = new ArrayList<>();
			lista.add(new PontoTuristico(1, 10, "teste", "teste", null,
					"teste", "teste", "teste", "teste", "teste", 'A', "teste",0));
			
			lista.add(new PontoTuristico(2, 10, "teste", "teste", null,
					"teste", "teste", "teste", "teste", "teste", 'A', "teste",0));
			
			lista.add(new PontoTuristico(3, 10, "teste", "teste", null,
					"teste", "teste", "teste", "teste", "teste", 'A', "teste",0));
			
			Fachada.getInstance().listaCadastrar(new Lista(10, lista, 3, "17/09/12 - 11:00",'S'));
			
			Lista listaTeste = Fachada.getInstance().listarPorId(6);
			
//			ArrayList<Lista> listaLista = Fachada.getInstance().listarTodasListas("");
			
			System.out.println(listaTeste.toString());
			for (PontoTuristico ponto : listaTeste.getListaPontoTuristico()) {
				System.out.println(ponto.toString());
			}
			
//			System.out.println("Teste 02");
//			
//			for (Lista lista : listaLista) {
//				System.out.println(lista.toString());
//					for (PontoTuristico ponto : lista.getListaPontoTuristico()) {
//						System.out.println(ponto.toString());
//				}
//			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarListaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ListaJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
