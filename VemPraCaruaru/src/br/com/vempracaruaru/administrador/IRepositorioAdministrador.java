package br.com.vempracaruaru.administrador;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;

public interface IRepositorioAdministrador {
	
	public void cadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorJaCadastradoException, Exception;
	public ArrayList<Administrador> listarTodos(String complemento) throws SQLException, AdministradorNaoCadastradoException, Exception;
	public Administrador listarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception;
	public ArrayList<Administrador> listarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception;
	public Administrador listarPorCpf(String cpf) throws SQLException, AdministradorNaoCadastradoException, Exception;
	public void alterar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, AdministradorNaoCadastradoException, Exception;
	public boolean existeId(Administrador administrador) throws SQLException, AdministradorJaCadastradoException, Exception;
	public boolean existeCpf(Administrador administrador) throws SQLException, AdministradorJaCadastradoException, Exception;

}
