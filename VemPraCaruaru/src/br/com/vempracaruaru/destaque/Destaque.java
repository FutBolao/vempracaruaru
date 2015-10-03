package br.com.vempracaruaru.destaque;

public class Destaque {

	private int id;
	private int idAdministrador;
	private String titulo;
	private String imagem;
	private String link;

	public Destaque(int id, int idAdministrador, String titulo, String imagem, String link) {
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.titulo = titulo;
		this.imagem = imagem;
		this.link = link;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Destaque [id=" + id + ", idAdministrador=" + idAdministrador + ", titulo=" + titulo + ", imagem="
				+ imagem + ", link=" + link +"]";
	}

}
