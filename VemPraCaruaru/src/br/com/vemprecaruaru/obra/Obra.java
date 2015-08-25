package br.com.vemprecaruaru.obra;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class Obra {

	private int id;
	private Artista artista;
	private Administrador administrador;
	private PontoTuristico pontoTuristico;
	private String nome;
	private String historico;
	private char ativo;
	
	public Obra(int id, Artista artista, Administrador administrador, PontoTuristico pontoTuristico, String nome,
			String historico, char ativo) {
		this.id = id;
		this.artista = artista;
		this.administrador = administrador;
		this.pontoTuristico = pontoTuristico;
		this.nome = nome;
		this.historico = historico;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public PontoTuristico getPontoTuristico() {
		return pontoTuristico;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Obra [id=" + id + ", artista=" + artista + ", administrador=" + administrador + ", pontoTuristico="
				+ pontoTuristico + ", nome=" + nome + ", historico=" + historico + ", ativo=" + ativo + "]";
	}
	
	
}
