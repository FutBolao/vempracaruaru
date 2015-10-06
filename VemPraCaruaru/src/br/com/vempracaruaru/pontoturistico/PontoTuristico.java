package br.com.vempracaruaru.pontoturistico;


public class PontoTuristico {
	
	private int				id;
	private int				idAdministrador;
	private String			nomeAdministrador;
	private String			nome;
	private String			endereco;
	private String			telefone;
	private String			email;
	private String			tempoVisitacao;
	private String			horarioFuncionamento;
	private String			historicoDescricao;
	private char			ativo;
	private String			foto;
	
	public PontoTuristico(int id, int idAdministrador,
			String nomeAdministrador, String nome, String endereco,
			String telefone, String email, String tempoVisitacao,
			String horarioFuncionamento, String historicoDescricao, String foto, char ativo) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.nomeAdministrador = nomeAdministrador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.tempoVisitacao = tempoVisitacao;
		this.horarioFuncionamento = horarioFuncionamento;
		this.historicoDescricao = historicoDescricao;
		this.foto = foto;
		this.ativo = ativo;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTempoVisitacao() {
		return tempoVisitacao;
	}

	public void setTempoVisitacao(String tempoVisitacao) {
		this.tempoVisitacao = tempoVisitacao;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "PontoTuristico [id=" + id + ", idAdministrador="
				+ idAdministrador + ", nomeAdministrador=" + nomeAdministrador
				+ ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone +  ", email=" + email + ", tempoVisitacao=" + tempoVisitacao
				+ ", horarioFuncionamento=" + horarioFuncionamento
				+ ", historicoDescricao=" + historicoDescricao + ", ativo="
				+ ativo + ", foto=" + foto + "]";
	}
	
}
