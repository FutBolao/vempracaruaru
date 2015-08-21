package br.com.vempracaruaru.main;

import java.sql.SQLException;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.fachada.Fachada;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Inicio do teste da classe do Administrador");
			
			Administrador admTeste = new Administrador(4, "João Henrique", "104.845.104-60",
					"8193105217", "joao60", "123", 'A');
			
			Fachada.getInstance().administradorCadastrar(admTeste);
			
			System.out.println("- Teste concluido com sucesso -");
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
