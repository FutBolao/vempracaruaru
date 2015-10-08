package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

public class MainTesteAdm {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */
		
		try {

			//Fachada.getInstance().administradorCadastrar(new Administrador(10, "josé", "287.558.137-63", "9999-0000", "jose000", "12321", 'A'));
			
			Administrador adm1 = Fachada.getInstance().administradorListarPorId(10);
			Administrador adm2 = Fachada.getInstance().administradorListarPorCpf("28755813763");			
			ArrayList<Administrador> listaAdm1 = Fachada.getInstance().administradorListarPorNome("josé");
			ArrayList<Administrador> listaAdm2 = Fachada.getInstance().administradorListarTodos("nome = nome");
			
			System.out.println("adm1: " + adm1.toString());
			System.out.println("adm2: " + adm2.toString());
			
			for (Administrador administrador : listaAdm1) {
				System.out.println(administrador.toString());
			}
			System.out.println("listar 2");
			
			for (Administrador administrador : listaAdm2) {
				System.out.println(administrador.toString());
			}
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
