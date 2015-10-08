package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.contato.Contato;
import br.com.vempracaruaru.exception.ContatoJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarContatoException;
import br.com.vempracaruaru.fachada.Fachada;

public class MainContato {

	public static void main(String[] args) {
		
		try {
//			Fachada.getInstance().contatoCadastrar(new Contato(1, "joao", "joao@email.com", "9999-0099", "nada","",'S'));
			
			ArrayList<Contato> lista= Fachada.getInstance().contatoListarTodos("nome = nome");
			
			for (Contato contato : lista) {
				System.out.println(contato.toString());
			}
//			
//			Fachada.getInstance().contatoDeletar(1);
			
//			Fachada.getInstance().contatoAlterar(new Contato(2, "joao", "joao@email.com", "9999-0099", "nada","",'S'));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarContatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ContatoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
