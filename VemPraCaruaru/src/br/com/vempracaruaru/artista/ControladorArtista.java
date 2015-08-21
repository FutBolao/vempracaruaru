package br.com.vempracaruaru.artista;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ArtistaJaCadastradoException;
import br.com.vempracaruaru.exception.ArtistaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;

public class ControladorArtista {

	private IRepositorioArtista repositorio;
	
	public ControladorArtista()throws Exception{
		this.repositorio = new RepositorioArtistaBDR();
	}
	
	public void cadastrar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaJaCadastradoException, Exception{
		if(artista !=null){
			repositorio.cadastrar(artista);
		}
	}
	
	public ArrayList<Artista> listarTodos(String complemento) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return repositorio.listarTodos(complemento);
	}
	public Artista listarPorId(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}
	public ArrayList<Artista> listarPorNome(String nome) throws SQLException, ArtistaNaoCadastradoException, Exception{
		return repositorio.listarPorNome(nome);
	}
	
	public void alterar(Artista artista) throws SQLException, NaoFoiPossivelCadastrarArtistaException, ArtistaNaoCadastradoException, Exception{
		repositorio.alterar(artista);
	}
	public void deletar(int id) throws SQLException, ArtistaNaoCadastradoException, Exception{
		repositorio.deletar(id);
	}
	
	
	
}
