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
import br.com.vempracaruaru.exception.FotoJaCadastradoException;
import br.com.vempracaruaru.exception.FotoNaoCadastradoException;
import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.ListaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarFotoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.exception.ObraNaoCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoNaoCadastradoException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;
import br.com.vempracaruaru.fotos.ControladorFoto;
import br.com.vempracaruaru.fotos.Foto;
import br.com.vempracaruaru.lista.ControladorLista;
import br.com.vempracaruaru.lista.Lista;
import br.com.vempracaruaru.obra.ControladorObra;
import br.com.vempracaruaru.obra.Obra;
import br.com.vempracaruaru.pontoturistico.ControladorPontoTuristico;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;
import br.com.vempracaruaru.usuario.ControladorUsuario;
import br.com.vempracaruaru.usuario.Usuario;

public class Fachada {
	
	private static Fachada instance = null;
	
	private ControladorAdministrador controladorAdministrador;
	private ControladorArtista controladorArtista;
	private ControladorUsuario controladorUsuario;
	private ControladorPontoTuristico controladoraPontoTuristico;
	private ControladorObra controladorObra;
	private ControladorLista controladorLista;
	private ControladorFoto controladorFoto;
	
	public Fachada() throws Exception {
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorArtista = new ControladorArtista();
		this.controladorUsuario = new ControladorUsuario();
		this.controladoraPontoTuristico = new ControladorPontoTuristico();
		this.controladorObra = new ControladorObra();
		this.controladorLista = new ControladorLista();
		this.controladorFoto = new ControladorFoto();
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
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorAdministrador.listarTodos(complemento);
	}
	public Administrador administradorListarPorId(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorAdministrador.listarPorId(id);
	}
	public ArrayList<Administrador> administradorListarPorNome(String nome) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorAdministrador.listarPorNome(nome);
	}	
	public Administrador administradorListarPorCpf(String cpf) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorAdministrador.listarPorCpf(cpf);
	}
	public void administradorAlterar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorAdministrador.alterar(administrador);
	}
	public void administradorDeletar(int id) throws SQLException, AdministradorNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorAdministrador.deletar(id);
	}
	
	//MÉTODOS DO ARTISTA	
	public void artistaCadastrar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorArtista.cadastrar(artista);		
	}
	
	public ArrayList<Artista> artistaListarTodos(String complemento) throws SQLException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorArtista.listarTodos(complemento);
	}
	public Artista artistaListarPorId(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorArtista.listarPorId(id);
	}
	public ArrayList<Artista> artistaListarPorNome(String nome) throws SQLException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorArtista.listarPorNome(nome);
	}	
	public void artistaAlterar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorArtista.alterar(artista);
	}
	public void artistaDeletar(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorArtista.deletar(id);
	}
	
	//MÉTODOS DO USARIO

	public void usuarioCadastrar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorUsuario.cadastrar(usuario);
	}
	public ArrayList<Usuario> usuarioListarTodos(String complemento) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorUsuario.listarTodos(complemento);
	}
	public Usuario usuarioListarPorId(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorUsuario.listarPorId(id);
	}
	public ArrayList<Usuario> usuarioListarPorNome(String nome) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorUsuario.listarPorNome(nome);
	}
	public void usuarioAlterar(Usuario usuario) throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorUsuario.alterar(usuario);
	}
	public void usuarioDeletar(int id) throws SQLException, UsuarioNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorUsuario.deletar(id);
	}
	
	//MÉTODOS DO PONTO_TURISTICOS
	
	public void pontoTuristicoCadastrar(PontoTuristico pontoTurustico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladoraPontoTuristico.cadastrar(pontoTurustico);
	}
	public ArrayList<PontoTuristico> pontoTuristicoListarTodos(String complemento) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladoraPontoTuristico.listarTodos(complemento);
	}
	public PontoTuristico pontoTuristicoListarPorId(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladoraPontoTuristico.listarPorId(id);
	}
	public ArrayList<PontoTuristico> pontoTuristicoListarPorNome(String nome) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladoraPontoTuristico.listarPorNome(nome);
	}
	public void pontoTuristicoAlterar(PontoTuristico pontoTurustico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladoraPontoTuristico.alterar(pontoTurustico);
	}
	public void pontoTuristicodeletar(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladoraPontoTuristico.deletar(id);
	}
	
	//METODOS DAS OBRAS
	
	public void obraCadastrar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorObra.cadastrar(obra);		
	}
	public ArrayList<Obra> obraListarTodos(String complemento) throws SQLException, ObraNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorObra.listarTodos(complemento);
	}
	public Obra obraListarPorId(int id) throws SQLException, ObraNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorObra.listarPorId(id);
	}
	public ArrayList<Obra> obraListarPorNome(String nome) throws SQLException, ObraNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorObra.listarPorNome(nome);
	}
	public void obraAlterar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorObra.alterar(obra);
	}
	public void obraDeletar(int id) throws SQLException, ObraNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorObra.deletar(id);
	}
	
	//METODOS DAS LISTA
	
	public void listaCadastrar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorLista.cadastrar(lista);
	}
	public ArrayList<Lista> listarTodasListas(String complemento) throws SQLException, ListaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorLista.listarTodos(complemento);
	}
	public Lista listarPorId(int id) throws SQLException, ListaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorLista.listarPorId(id);
	}
	public void ListaAlterar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorLista.alterar(lista);
	}
	public void listaDeletar(int id) throws SQLException, ListaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorLista.deletar(id);
	}
	
		
	//METODOS DAS FOTO
	
	public void fotoCadastrar(Foto foto) throws SQLException, NaoFoiPossivelCadastrarFotoException, FotoJaCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorFoto.cadastrar(foto);
	}
	public ArrayList<Foto> fotoListarTodos(String complemento) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorFoto.listarTodos(complemento);
	}
	public Foto fotoListarPorId(int id) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorFoto.listarPorId(id);
	}
	public ArrayList<Foto> fotoListarPorReferencia(String nome) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return controladorFoto.listarPorReferencia(nome);
	}
	public void fotoAlterar(Foto foto) throws SQLException, NaoFoiPossivelCadastrarFotoException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorFoto.alterar(foto);
	}
	public void fotoDeletar(int id) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		controladorFoto.deletar(id);
	}

}
