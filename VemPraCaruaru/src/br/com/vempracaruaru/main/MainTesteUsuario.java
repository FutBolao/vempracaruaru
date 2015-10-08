package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

public class MainTesteUsuario {

	public static void main(String[] args) {
		/*Os teste com cadatrar e listar foram feitos com sucesso e ja estão prontos para uso
		 * 
		 * falta testar os metodos restantes
		 */
		
		try {
//			Fachada.getInstance().usuarioCadastrar(new Usuario(12, "juca", "juca@gmail.com", "não sei", "12321", "juca", "aqui"));
			
			Usuario usuario1 = Fachada.getInstance().usuarioListarPorId(1);
			ArrayList<Usuario> lista1 = Fachada.getInstance().usuarioListarPorNome("juca");
			ArrayList<Usuario> lista2 = Fachada.getInstance().usuarioListarTodos("nome = nome");
			
			System.out.println("usuario: "+ usuario1.toString());
			
			for (Usuario usuario : lista1) {
				System.out.println(usuario);
			}
			System.out.println("lista 2");
			
			for (Usuario usuario : lista2) {
				System.out.println(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoFoiPossivelCadastrarUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
