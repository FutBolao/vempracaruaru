package br.com.vempracaruaru.artista;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.pessoa.Pessoa;

public class Artista extends Pessoa{

	private Administrador	administrador;
	private String			historico;
	private String			tipo;
	private char			ativo;
	
	public Artista(int id, Administrador administrador, String nome, String historico, String tipo,char ativo) {
		super(id, nome);
		this.administrador = administrador;
		this.historico = historico;
		this.tipo = tipo;
		this.ativo = ativo;
	}


	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
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
		return "Artista [idAdministrador=" + administrador + ", historico=" + historico + ", tipo=" + tipo
				+ ", ativo=" + ativo + "]";
	}		
}
