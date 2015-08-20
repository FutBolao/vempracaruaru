package br.com.vempracaruaru.administrador;

public class Administrador {
	
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String usuario;
	private String senha;
	private char ativo;
	
	public Administrador(int id, String nome, String cpf, String telefone,
			String usuario, String senha, char ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", usuario=" + usuario
				+ ", senha=" + senha + ", ativo=" + ativo + "]";
	}
	
}
