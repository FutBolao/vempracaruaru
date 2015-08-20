package br.com.vempracaruaru.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.administrador.ControladorAdministrador;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;

public class Fachada {
	
	private static Fachada instance = null;
	private ControladorAdministrador controladorAdministrador;
	
	public Fachada() throws Exception {
		this.controladorAdministrador = new ControladorAdministrador();
	}
	
	public static Fachada getInstance() throws Exception {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	// MÉTODOS DO ADMINISTRADOR
	public void administradorCadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorJaCadastradoException, Exception{
		controladorAdministrador.cadastrar(administrador);
	}
	
	public ArrayList<Administrador> administradorListarTodos(String complemento) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return controladorAdministrador.listarTodos(complemento);
	}
	
	public Administrador administradorListarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return controladorAdministrador.listarPorId(id);
	}
	
	public ArrayList<Administrador> administradorListarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return controladorAdministrador.listarPorNome(nome);
	}
	
	public Administrador administradorListarPorCpf(String cpf) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return controladorAdministrador.listarPorCpf(cpf);
	}
	
	public void administradorAlterar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorNaoCadastradoException, Exception{
		controladorAdministrador.alterar(administrador);
	}
	
	public void administradorDeletar(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		controladorAdministrador.deletar(id);
	}

}
