package br.com.vempracaruaru.usuario;

public class Usuario {
	
	private int id;
	private String emial;
	private String nome;
	private String localizacao;
	private String senha;
	private String userFacebook;
	private String link_facebook;
	
	public Usuario(int id, String emial, String nome, String localizacao, String senha, String userFacebook,
			String link_facebook) {
			this.id = id;
		this.emial = emial;
		this.nome = nome;
		this.localizacao = localizacao;
		this.senha = senha;
		this.userFacebook = userFacebook;
		this.link_facebook = link_facebook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", emial=" + emial + ", nome=" + nome + ", localizacao=" + localizacao + ", senha="
				+ senha + ", userFacebook=" + userFacebook + ", link_facebook=" + link_facebook + "]";
	}
	
}
