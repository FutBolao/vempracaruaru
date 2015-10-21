package br.com.vempracaruaru.lista;

import java.util.ArrayList;

import br.com.vempracaruaru.pontoturistico.PontoTuristico;

public class Lista {

	private int 						idUsuario;
	private int 						idPontoTuristico;
	private String 						dataHora;
	private char						visitado;
	
	public Lista(int idUsuario, int idPontoTuristico, String dataHora,
			char visitado) {
		super();
		this.idUsuario = idUsuario;
		this.idPontoTuristico = idPontoTuristico;
		this.dataHora = dataHora;
		this.visitado = visitado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}

	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public char getVisitado() {
		return visitado;
	}

	public void setVisitado(char visitado) {
		this.visitado = visitado;
	}

	@Override
	public String toString() {
		return "Lista [idUsuario=" + idUsuario + ", idPontoTuristico="
				+ idPontoTuristico + ", dataHora=" + dataHora + ", visitado="
				+ visitado + "]";
	}
	
	

}
