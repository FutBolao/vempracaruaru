package br.com.vempracaruaru.artista;

import com.mysql.jdbc.Blob;

import br.com.vempracaruaru.pessoa.Pessoa;

public class Artista extends Pessoa{

	private int				idAdministrador;
	private String			nomeAdministrador;
	private String			historico;
	private String			tipo;
	private char			ativo;
	private Blob			foto;
	
	public Artista(int id, String nome, int idAdministrador, String nomeAdministrador, String historico, String tipo,
			char ativo, Blob foto) {
		super(id, nome);
		this.idAdministrador = idAdministrador;
		this.nomeAdministrador = nomeAdministrador;
		this.historico = historico;
		this.tipo = tipo;
		this.ativo = ativo;
		this.foto = foto;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNomeAdministrador() {
		return nomeAdministrador;
	}

	public void setNomeAdministrador(String nomeAdministrador) {
		this.nomeAdministrador = nomeAdministrador;
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

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Artista [idAdministrador=" + idAdministrador + ", nomeAdministrador=" + nomeAdministrador
				+ ", historico=" + historico + ", tipo=" + tipo + ", ativo=" + ativo + ", foto=" + foto + "]";
	}
				
}
