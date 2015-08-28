package br.com.vempracaruaru.main;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.usuario.Usuario;

public class mainUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			Fachada.getInstance().usuarioCadastrar(new Usuario(1, "João", "joao60", "sem", "123", "joao henrique", "sem"));
			
//			ArrayList<Usuario> lista = Fachada.getInstance().usuarioListarTodos("nome = nome");
//			
//			for (Usuario usuario : lista) {
//				System.out.println(usuario.toString());
//			}
			
			Fachada.getInstance().usuarioAlterar(new Usuario(1, "João", "joao60", "aqui", "123", "joao henrique", "sem"));
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
