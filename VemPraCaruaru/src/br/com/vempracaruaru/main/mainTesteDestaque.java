package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.destaque.Destaque;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;

public class mainTesteDestaque {
	
	public static void main(String[] args) {
		
		ArrayList<Destaque> lista;
		try {
			
			Fachada.getInstance().destaqueCadastrar(new Destaque(0, 1, "Titulo Teste", "imagem teste", "link teste"));
			
//			lista = Fachada.getInstance().destaqueListarTodos("titulo = titulo");
//			for (Destaque destaque : lista) {
//				System.out.println(destaque.toString());
//		}
//			lista = Fachada.getInstance().destaqueListarPorTitulo("sem");
//			for (Destaque destaque : lista) {
//				System.out.println(destaque.toString());
//		}			
//			Destaque destaque = Fachada.getInstance().destaqueListarPorId(1);
//			System.out.println(destaque.toString());
//			
			
//			Fachada.getInstance().destaqueAlterar(new Destaque(1, 1, "Destaque Principal", "Imagem principal", "Link principal"));
//			
//			Fachada.getInstance().destaqueDeletar(7);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DestaqueNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
