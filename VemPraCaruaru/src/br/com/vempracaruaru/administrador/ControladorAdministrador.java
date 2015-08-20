package br.com.vempracaruaru.administrador;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;


public class ControladorAdministrador {
	
private IRepositorioAdministrador repositorio;
	
	public ControladorAdministrador() throws Exception{
		this.repositorio = new RepositorioAdministradorBDR();
	}
	
	public void cadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorJaCadastradoException, Exception{	
		if (administrador != null) {
			repositorio.cadastrar(administrador);
		}
	}
	
	public ArrayList<Administrador> listarTodos(String complemento) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarTodos(complemento);
	}
	
	public Administrador listarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}
	
	public ArrayList<Administrador> listarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarPorNome(nome);
	}
	
	public Administrador listarPorCpf(String cpf) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarPorCpf(cpf);
	}

}
