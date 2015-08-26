package br.com.vempracaruaru.lista;

import java.util.ArrayList;

import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class Lista {

	private int 						id;
	private int 						idUsuario;
	private String						nomeUsuario;
	private ArrayList<PontoTuristico> 	listaPontoTuristico;
	private String 						dataHoraCriacao;
	
	public Lista(int id, int idUsuario, String nomeUsuario, ArrayList<PontoTuristico> listaPontoTuristico,
			String dataHoraCriacao) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.listaPontoTuristico = listaPontoTuristico;
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public ArrayList<PontoTuristico> getListaPontoTuristico() {
		return listaPontoTuristico;
	}

	public void setListaPontoTuristico(ArrayList<PontoTuristico> listaPontoTuristico) {
		this.listaPontoTuristico = listaPontoTuristico;
	}

	public String getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(String dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	@Override
	public String toString() {
		return "Lista [id=" + id + ", idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario
				+ ", listaPontoTuristico=" + listaPontoTuristico + ", dataHoraCriacao=" + dataHoraCriacao + "]";
	}
	
			
}
