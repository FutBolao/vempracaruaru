package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.obra.Obra;

public class mainObra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			Fachada.getInstance().obraCadastrar(new Obra(1, 1, "Zé", 1,	"João Henrique", 1, "museu", "sem", "sem", 'A'));

//		ArrayList<Obra> lista =  Fachada.getInstance().obraListarTodos("nome = nome");
//		
//		for (Obra obra : lista) {
//			System.out.println(obra.toString());
//		}
			
//		Fachada.getInstance().obraAlterar(new Obra(1, 1, "Zé", 1,"João Henrique", 1, "museu", "vaso", "sem", 'A'));
		
		Fachada.getInstance().obraDeletar(1);	
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
