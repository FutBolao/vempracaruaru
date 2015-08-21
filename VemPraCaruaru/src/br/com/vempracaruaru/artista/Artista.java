package br.com.vempracaruaru.artista;

public class Artista {

	private int id;
	private int idAdministrador;
	private String nome;
	private String historico;
	private String tipo;
	private char ativo;
	
	public Artista(int id, int idAdministrador, String nome, String historico, String tipo, char ativo) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.nome = nome;
		this.historico = historico;
		this.tipo = tipo;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", idAdministrador=" + idAdministrador + ", nome=" + nome + ", historico="
				+ historico + ", tipo=" + tipo + ", ativo=" + ativo + "]";
	}
	
	
	
}
