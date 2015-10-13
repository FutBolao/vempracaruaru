package br.com.vempracaruaru.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;

public interface IRepositorioUsuario {

	public void cadastrar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioJaCadastradoException, Exception;
	public ArrayList<Usuario> listarTodos(String complemento) throws SQLException, UsuarioNaoCadastradoException, Exception;
	public Usuario listarPorId(int id) throws SQLException, UsuarioNaoCadastradoException, Exception;
	public ArrayList<Usuario> listarPorNome(String nome) throws SQLException, UsuarioNaoCadastradoException, Exception;
	public void alterar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, UsuarioNaoCadastradoException, Exception;
	public boolean existeId(Usuario usuario) throws SQLException, UsuarioJaCadastradoException, Exception;
	public Usuario loginSite(String email, String senha) throws SQLException, BusinessException, Exception;
}
