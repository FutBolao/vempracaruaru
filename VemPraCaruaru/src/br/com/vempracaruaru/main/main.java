package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("inicio do teste");
//			Fachada.getInstance().administradorCadastrar(new Administrador(1, "João Henrique", "104.845.104-60",
//					"9310-5217", "joao60", "123", 'A'));
			
//			ArrayList<Administrador> lista = Fachada.getInstance().administradorListarTodos("nome = nome");
//			Administrador admTeste = Fachada.getInstance().administradorListarPorId(1);
//			System.out.println(admTeste.toString());
			ArrayList<Administrador> lista  = Fachada.getInstance().administradorListarPorNome("João Henrique");
			
			
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
