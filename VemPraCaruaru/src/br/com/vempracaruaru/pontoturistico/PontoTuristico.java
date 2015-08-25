package br.com.vempracaruaru.pontoturistico;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.endereco.Endereco;

public class PontoTuristico {
	
	private int				id;
	private Administrador	administrador;
	private String			nome;
	private Endereco		endereco;
	private String			telefone;
	private String			horarioAbertura;
	private String			horarioEncerramento;
	private String			tempoVisitacao;
	private String			historicoDescricao;
	private char			ativo;
	
	public PontoTuristico(int id, Administrador administrador, String nome, Endereco endereco, String telefone,
			String horarioAbertura, String horarioEncerramento, String tempoVisitacao, String historicoDescricao,
			char ativo) {
			this.id = id;
		this.administrador = administrador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.horarioAbertura = horarioAbertura;
		this.horarioEncerramento = horarioEncerramento;
		this.tempoVisitacao = tempoVisitacao;
		this.historicoDescricao = historicoDescricao;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setIdAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public String getHorarioEncerramento() {
		return horarioEncerramento;
	}

	public void setHorarioEncerramento(String horarioEncerramento) {
		this.horarioEncerramento = horarioEncerramento;
	}

	public String getTempoVisitacao() {
		return tempoVisitacao;
	}

	public void setTempoVisitacao(String tempoVisitacao) {
		this.tempoVisitacao = tempoVisitacao;
	}

	public String getHistoricoDescricao() {
		return historicoDescricao;
	}

	public void setHistoricoDescricao(String historicoDescricao) {
		this.historicoDescricao = historicoDescricao;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "PontoTuristico [id=" + id + ", idA"
				+ "dministrador=" + administrador + ", nome=" + nome + ", endereco="
				+ endereco + ", telefone=" + telefone + ", horarioAbertura=" + horarioAbertura
				+ ", horarioEncerramento=" + horarioEncerramento + ", tempoVisitacao=" + tempoVisitacao
				+ ", historicoDescricao=" + historicoDescricao + ", ativo=" + ativo + "]";
	}
	
		
}
