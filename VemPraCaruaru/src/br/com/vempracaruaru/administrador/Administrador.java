package br.com.vempracaruaru.administrador;

import br.com.vempracaruaru.pessoa.Pessoa;

public class Administrador extends Pessoa{
	
	private String		cpf;
	private String		telefone;
	private String		usuario;
	private String		senha;
	private char		ativo;
	
	public Administrador(int id, String nome, String cpf, String telefone, String usuario, String senha, char ativo) {
		super(id, nome);
		this.cpf = cpf;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
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
		return "Administrador [cpf=" + cpf + ", telefone=" + telefone + ", usuario=" + usuario + ", senha=" + senha
				+ ", ativo=" + ativo + "]";
	}
	
}
