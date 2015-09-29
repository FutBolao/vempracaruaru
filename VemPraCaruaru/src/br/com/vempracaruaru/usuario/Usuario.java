package br.com.vempracaruaru.usuario;

import br.com.vempracaruaru.pessoa.Pessoa;

public class Usuario extends Pessoa{
	
	private String		emial;
	private String		localizacao;
	private String		senha;
	private String		userFacebook;
	private String		linkfacebook;
	private char		ativo;
	
	public Usuario(int id, String nome, String emial, String localizacao, String senha, String userFacebook,
			String link_facebook, char ativo) {
		super(id, nome);
		this.emial = emial;
		this.localizacao = localizacao;
		this.senha = senha;
		this.userFacebook = userFacebook;
		this.linkfacebook = link_facebook;
		this.ativo = ativo;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUserFacebook() {
		return userFacebook;
	}

	public void setUserFacebook(String userFacebook) {
		this.userFacebook = userFacebook;
	}

	public String getLinkfacebook() {
		return linkfacebook;
	}

	public void setLinkfacebook(String linkfacebook) {
		this.linkfacebook = linkfacebook;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [emial=" + emial + ", localizacao=" + localizacao + ", senha=" + senha + ", userFacebook="
				+ userFacebook + ", linkfacebook=" + linkfacebook + ", ativo=" + ativo + "]";
	}

		
}
