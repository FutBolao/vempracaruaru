package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

public class mainAdm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
//			System.out.println("inicio do teste");
//			Fachada.getInstance().administradorCadastrar(new Administrador(1, "João Henrique", "425.802.737-51",
//					"9310-5217", "joao60", "123", 'A'));
			
			ArrayList<Administrador> lista = Fachada.getInstance().administradorListarTodos("nome = nome");
//			Administrador admTeste = Fachada.getInstance().administradorListarPorId(1);
//			Administrador admTeste = Fachada.getInstance().administradorListarPorCpf("425.802.737-51");
//			System.out.println(admTeste.toString());
//			ArrayList<Administrador> lista  = Fachada.getInstance().administradorListarPorNome("João Henrique");
//			Fachada.getInstance().administradorAlterar(new Administrador(1, "João Henrique", "42580273751",
//					"9310-5217", "joao61", "456", 'A'));
//			Fachada.getInstance().administradorDeletar(1);
//			
		for (Administrador adm : lista) {
			System.out.println(adm.toString());
		}			
		
			System.out.println("fim do teste");
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
