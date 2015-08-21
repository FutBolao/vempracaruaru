package br.com.vempracaruaru.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.administrador.ControladorAdministrador;
import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.artista.ControladorArtista;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.ArtistaJaCadastradoException;
import br.com.vempracaruaru.exception.ArtistaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;

public class Fachada {
	
	private static Fachada instance = null;
	private ControladorAdministrador controladorAdministrador;
	private ControladorArtista controladorArtista;
	
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
		System.out.println("Passando pela fachada - concluido com sucesso -");
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
	
	//MÉTODOS DO ARTISTA	
	public void cadastrar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaJaCadastradoException, Exception{
		controladorArtista.cadastrar(artista);		
	}
	
	public ArrayList<Artista> listarTodos(String complemento) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return controladorArtista.listarTodos(complemento);
	}
	public Artista listarPorId(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return controladorArtista.listarPorId(id);
	}
	public ArrayList<Artista> listarPorNome(String nome) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return controladorArtista.listarPorNome(nome);
	}
	
	public void alterar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaNaoCadastradoException, Exception{
		controladorArtista.alterar(artista);
	}
	public void deletar(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		controladorArtista.deletar(id);
	}

}
