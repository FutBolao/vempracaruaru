package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.endereco.Endereco;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class mainPontoTuristico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			Fachada.getInstance().pontoTuristicoCadastrar(new PontoTuristico(1, 1, "João Henrique", "museu",
//					new Endereco(100, "sem", "sem", "sem"),
//					"3726-0000","08:00", "18:00", "08:00", "sem", 'A'));
//		ArrayList<PontoTuristico> lista = Fachada.getInstance().pontoTuristicoListarTodos("nome = nome");
//		
//		for (PontoTuristico pontoTuristico : lista) {
//			System.out.println(pontoTuristico.toString());
//		}

//			Fachada.getInstance().pontoTuristicoAlterar(new PontoTuristico(1, 1, "João Henrique", "museu",
//					new Endereco(100, "sem", "sem", "sem"),
//					"3726-0000","08:00", "18:00", "08:00", "sem", 'A'));
			
			Fachada.getInstance().pontoTuristicodeletar(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarPontoTuristicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PontoTuristicoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
