package br.com.vempracaruaru.usuario;

import com.vempracaruaru.pessoa.Pessoa;

public class Usuario extends Pessoa{
	
	private String emial;
	private String localizacao;
	private String senha;
	private String userFacebook;
	private String link_facebook;
	
	public Usuario(int id, String nome, String emial, String localizacao, String senha, String userFacebook,
			String link_facebook) {
		super(id, nome);
		this.emial = emial;
		this.localizacao = localizacao;
		this.senha = senha;
		this.userFacebook = userFacebook;
		this.link_facebook = link_facebook;
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

	public String getLink_facebook() {
		return link_facebook;
	}

	public void setLink_facebook(String link_facebook) {
		this.link_facebook = link_facebook;
	}
	
}
