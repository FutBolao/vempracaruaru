package br.com.vempracaruaru.pontoturistico;

import com.mysql.jdbc.Blob;

import br.com.vempracaruaru.endereco.Endereco;

public class PontoTuristico {
	
	private int				id;
	private int				idAdministrador;
	private String			nomeAdministrador;
	private String			nome;
	private Endereco		endereco;
	private String			telefone;
	private String			horarioAbertura;
	private String			horarioEncerramento;
	private String			tempoVisitacao;
	private String			historicoDescricao;
	private char			ativo;
	private Blob			foto;
	private int				pontos;
	
	
	public PontoTuristico(int id, int idAdministrador, String nomeAdministrador, String nome, Endereco endereco,
			String telefone, String horarioAbertura, String horarioEncerramento, String tempoVisitacao,
			String historicoDescricao, char ativo, Blob foto,int pontos) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.nomeAdministrador = nomeAdministrador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.horarioAbertura = horarioAbertura;
		this.horarioEncerramento = horarioEncerramento;
		this.tempoVisitacao = tempoVisitacao;
		this.historicoDescricao = historicoDescricao;
		this.ativo = ativo;
		this.foto = foto;
		this.pontos = pontos;
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


	public String getNomeAdministrador() {
		return nomeAdministrador;
	}


	public void setNomeAdministrador(String nomeAdministrador) {
		this.nomeAdministrador = nomeAdministrador;
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


	public Blob getFoto() {
		return foto;
	}


	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	

	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


	@Override
	public String toString() {
		return "PontoTuristico [id=" + id + ", idAdministrador=" + idAdministrador + ", nomeAdministrador="
				+ nomeAdministrador + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", horarioAbertura=" + horarioAbertura + ", horarioEncerramento=" + horarioEncerramento
				+ ", tempoVisitacao=" + tempoVisitacao + ", historicoDescricao=" + historicoDescricao + ", ativo="
				+ ativo + ", foto=" + foto + ", pontos=" + pontos + "]";
	}



	
}
