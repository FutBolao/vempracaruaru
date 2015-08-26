package br.com.vempracaruaru.obra;

public class Obra {

	private int				id;
	private int 			idArtista;
	private String 			nomeArtista;
	private int 			idAdministrador;
	private String			nomeAdministrador;
	private int				idPontoTuristico;
	private String			nomePontoTuristico;
	private String 			nome;
	private String 			historico;
	private char 			ativo;
	public Obra(int id, int idArtista, String nomeArtista, int idAdministrador, String nomeAdministrador,
			int idPontoTuristico, String nomePontoTuristico, String nome, String historico, char ativo) {
		super();
		this.id = id;
		this.idArtista = idArtista;
		this.nomeArtista = nomeArtista;
		this.idAdministrador = idAdministrador;
		this.nomeAdministrador = nomeAdministrador;
		this.idPontoTuristico = idPontoTuristico;
		this.nomePontoTuristico = nomePontoTuristico;
		this.nome = nome;
		this.historico = historico;
		this.ativo = ativo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
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
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}
	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}
	public String getNomePontoTuristico() {
		return nomePontoTuristico;
	}
	public void setNomePontoTuristico(String nomePontoTuristico) {
		this.nomePontoTuristico = nomePontoTuristico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Obra [id=" + id + ", idArtista=" + idArtista + ", nomeArtista=" + nomeArtista + ", idAdministrador="
				+ idAdministrador + ", nomeAdministrador=" + nomeAdministrador + ", idPontoTuristico="
				+ idPontoTuristico + ", nomePontoTuristico=" + nomePontoTuristico + ", nome=" + nome + ", historico="
				+ historico + ", ativo=" + ativo + "]";
	}
	
	
}
