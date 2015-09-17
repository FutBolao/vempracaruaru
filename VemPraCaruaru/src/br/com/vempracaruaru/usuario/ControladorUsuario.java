package br.com.vempracaruaru.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;

public class ControladorUsuario {
	
	private IRepositorioUsuario repositorio;
	
	public ControladorUsuario()throws Exception{
		this.repositorio = new RepositorioUsuarioBDR();
	}
	public void cadastrar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioJaCadastradoException, Exception{
		System.out.println("Passando pela controladora");
		if(usuario !=null){
			repositorio.cadastrar(usuario);
		}
	}
	public ArrayList<Usuario> listarTodos(String complemento) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora");
		return repositorio.listarTodos(complemento);
	}
	public Usuario listarPorId(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora");
		return repositorio.listarPorId(id);
	}
	public ArrayList<Usuario> listarPorNome(String nome) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora");
		return repositorio.listarPorNome(nome);
	}
	public void alterar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora");
	repositorio.alterar(usuario);
	}
	public void deletar(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora");
		repositorio.deletar(id);
		
	}

}
