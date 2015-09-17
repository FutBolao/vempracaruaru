package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.obra.Obra;

public class mainTesteObra {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */
		
		try {
//			Fachada.getInstance().obraCadastrar(new Obra(1, 1, "josé2", 1, "josé2",
//					1, "se2,", "can2", 'A', "imagemObra2"));
			
//		Obra obra =	Fachada.getInstance().obraListarPorId(1);
//		ArrayList<Obra> lista1 = Fachada.getInstance().obraListarPorNome("can");
		ArrayList<Obra> lista2 = Fachada.getInstance().obraListarTodos("nome = nome");
//		
//		System.out.println(obra.toString());
//		
//		for (Obra obra1 : lista1) {
//			System.out.println(obra1.toString());
//		}
		System.out.println("Lista 2");
		for (Obra obra1 : lista2) {
			System.out.println(obra1.toString());
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarObraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObraJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
