package br.com.vempracaruaru.fotos;

import com.mysql.jdbc.Blob;

public class Foto {

	private int			id;
	private int			idAdministrador;
	private	int			idReferencia;
	private String 		referencia;
	private Blob		imagem;
	public Foto(int id, int idAdministrador, int idReferencia, String referencia, Blob imagem) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.idReferencia = idReferencia;
		this.referencia = referencia;
		this.imagem = imagem;
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
	public int getIdReferencia() {
		return idReferencia;
	}
	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Blob getImagem() {
		return imagem;
	}
	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}
	@Override
	public String toString() {
		return "Foto [id=" + id + ", idAdministrador=" + idAdministrador + ", idReferencia=" + idReferencia
				+ ", referencia=" + referencia + ", imagem=" + imagem + "]";
	}	
	
}
