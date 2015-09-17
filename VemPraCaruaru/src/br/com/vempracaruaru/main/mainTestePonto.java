package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.endereco.Endereco;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class mainTestePonto {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */

		try {
//			Fachada.getInstance().pontoTuristicoCadastrar(new PontoTuristico(10, 3, "jose33",
//					"ponto003", new Endereco(332, "bairro03", "rua03", "sem"), "3726-2121",
//					"12:00", "20:00", "08:00", "sem",'A', "imagem", 100));
			
//			PontoTuristico pontoTeste = Fachada.getInstance().pontoTuristicoListarPorId(1);
//			ArrayList<PontoTuristico> listaPonto01 = Fachada.getInstance().pontoTuristicoListarPorNome("ponto001");
			ArrayList<PontoTuristico> listaPonto02 = Fachada.getInstance().pontoTuristicoListarTodos("nome_ponto_turistico = nome_ponto_turistico");
//			
//			System.out.println(pontoTeste.toString());
			
			
//			for (PontoTuristico pontoTuristico : listaPonto01) {
//				System.out.println(pontoTuristico.toString());
//			}
//			
			System.out.println("Teste 02");
			
			for (PontoTuristico pontoTuristico : listaPonto02) {
				System.out.println(pontoTuristico.toString());
			}
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
