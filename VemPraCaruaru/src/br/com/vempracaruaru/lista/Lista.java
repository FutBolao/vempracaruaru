package br.com.vempracaruaru.lista;

import java.util.ArrayList;

import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class Lista {

	private int 						id;
	private ArrayList<PontoTuristico>	listaPontoTuristico;
	private int 						idUsuario;
	private String 						dataHoraCriacao;
	
	public Lista(int id, ArrayList<PontoTuristico> listaPontoTuristico, int idUsuario, String dataHoraCriacao) {
		this.id = id;
		this.listaPontoTuristico = listaPontoTuristico;
		this.idUsuario = idUsuario;
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<PontoTuristico> getListaPontoTuristico() {
		return listaPontoTuristico;
	}

	public void setListaPontoTuristico(ArrayList<PontoTuristico> listaPontoTuristico) {
		this.listaPontoTuristico = listaPontoTuristico;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(String dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	@Override
	public String toString() {
		return "Lista [id=" + id + ", listaPontoTuristico=" + listaPontoTuristico + ", idUsuario=" + idUsuario
				+ ", dataHoraCriacao=" + dataHoraCriacao + "]";
	}		
}
