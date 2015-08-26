package br.com.vempracaruaru.administrador;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.util.Validacao;


public class ControladorAdministrador {
	
private IRepositorioAdministrador repositorio;
	
	public ControladorAdministrador() throws Exception{
		this.repositorio = new RepositorioAdministradorBDR();
	}
	
	public void cadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorJaCadastradoException, Exception{	
		System.out.println("passando pela controladora - concluido com sucesso -");
		if (administrador != null) {
			if (Validacao.validaCPF(administrador.getCpf())) {
				administrador.setCpf(administrador.getCpf().replace('.',' ').replace('-',' ').replaceAll(" ", ""));
				repositorio.cadastrar(administrador);
			}
		}
	}
	
	public ArrayList<Administrador> listarTodos(String complemento) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela controladora - concluido com sucesso -");
		return repositorio.listarTodos(complemento);
	}
	
	public Administrador listarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}
	
	public ArrayList<Administrador> listarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return repositorio.listarPorNome(nome);
	}
	
	public Administrador listarPorCpf(String cpf) throws SQLException, AdministradorNaoCadastradoException, Exception{
		if (Validacao.validaCPF(cpf)){
			cpf = cpf.replace('.',' ').replace('-',' ').replaceAll(" ", "");
		}
		return repositorio.listarPorCpf(cpf);
	}
	
	public void alterar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorNaoCadastradoException, Exception{
		if (Validacao.validaCPF(administrador.getCpf())) {
			administrador.setCpf(administrador.getCpf().replace('.',' ').replace('-',' ').replaceAll(" ", ""));
			repositorio.alterar(administrador);
		}
	}
	
	public void deletar(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		repositorio.deletar(id);
	}

}
