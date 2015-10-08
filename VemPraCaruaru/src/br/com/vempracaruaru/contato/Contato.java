package br.com.vempracaruaru.contato;

public class Contato {

	private int idContato;
	private String nome;
	private String email;
	private String telefone;
	private String assunto;

	public Contato(int idContato, String nome, String email, String telefone, String assunto) {
		this.idContato = idContato;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.assunto = assunto;
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", assunto=" + assunto + "]";
	}

}
