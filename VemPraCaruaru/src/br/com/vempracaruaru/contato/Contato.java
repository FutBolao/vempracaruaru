package br.com.vempracaruaru.contato;

public class Contato {

	private int		id;
	private String	nome;
	private String	email;
	private String	telefone;
	private String	assunto;
	private String	dataHora;
	private char	visualizado;
	
	public Contato(int id, String nome, String email, String telefone, String assunto,String dataHora, char visualizado) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.assunto = assunto;
		this.dataHora = dataHora;
		this.visualizado = visualizado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public char getVisualizado() {
		return visualizado;
	}

	public void setVisualizado(char visualizado) {
		this.visualizado = visualizado;
	}

	@Override
	public String toString() {
		return "Contato [idContato=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", assunto=" + assunto + ", dataHora=" + dataHora + ", visualizado=" + visualizado + "]";
	}



}
