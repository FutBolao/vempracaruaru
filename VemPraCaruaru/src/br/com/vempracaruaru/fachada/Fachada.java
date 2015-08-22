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
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;
import br.com.vempracaruaru.usuario.ControladorUsuario;
import br.com.vempracaruaru.usuario.Usuario;

public class Fachada {
	
	private static Fachada instance = null;
	private ControladorAdministrador controladorAdministrador;
	private ControladorArtista controladorArtista;
	private ControladorUsuario controladorUsuario;
	
	public Fachada() throws Exception {
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorArtista = new ControladorArtista();
		this.controladorUsuario = new ControladorUsuario();
	}
	
	public static Fachada getInstance() throws Exception {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	// M�TODOS DO ADMINISTRADOR
	public void administradorCadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorAdministrador.cadastrar(administrador);
	}
	
	public ArrayList<Administrador> administradorListarTodos(String complemento) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorAdministrador.listarTodos(complemento);
	}
	
	public Administrador administradorListarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		return controladorAdministrador.listarPorId(id);
	}
	
	public ArrayList<Administrador> administradorListarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
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
	
	//M�TODOS DO ARTISTA	
	public void artistaCadastrar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorArtista.cadastrar(artista);		
	}
	
	public ArrayList<Artista> artistaListarTodos(String complemento) throws SQLException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorArtista.listarTodos(complemento);
	}
	public Artista artistaListarPorId(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return controladorArtista.listarPorId(id);
	}
	public ArrayList<Artista> artistaListarPorNome(String nome) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return controladorArtista.listarPorNome(nome);
	}
	
	public void artistaAlterar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaNaoCadastradoException, Exception{
		controladorArtista.alterar(artista);
	}
	public void artistaDeletar(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		controladorArtista.deletar(id);
	}
	
	//M�TODOS DO USARIO

	public void usuarioCadastrar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioJaCadastradoException, Exception{
		controladorUsuario.cadastrar(usuario);
	}
	public ArrayList<Usuario> usuarioListarTodos(String complemento) throws SQLException, UsuarioNaoCadastradoException, Exception{
		return controladorUsuario.listarTodos(complemento);
	}
	public Usuario listarPorId(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		return controladorUsuario.listarPorId(id);
	}
	public ArrayList<Usuario> listarPorNome(String nome) throws SQLException, UsuarioNaoCadastradoException, Exception{
		return controladorUsuario.listarPorNome(nome);
	}
	public void alterar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioNaoCadastradoException, Exception{
		controladorUsuario.alterar(usuario);
	}
	public void deletar(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		controladorUsuario.deletar(id);
	}
}
