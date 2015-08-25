package br.com.vempracaruaru.lista;

import java.util.ArrayList;

import br.com.vempracaruaru.pontoturistico.PontoTuristico;
import br.com.vempracaruaru.usuario.Usuario;

public class Lista {

	private int id;
	private ArrayList<PontoTuristico> listaPontoTuristico;
	private Usuario usuario;
	private String dataHoraCriacao;
	
	public Lista(int id, ArrayList<PontoTuristico> listaPontoTuristico, Usuario usuario, String dataHoraCriacao) {
		this.id = id;
		this.listaPontoTuristico = listaPontoTuristico;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(String dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	@Override
	public String toString() {
		return "Lista [id=" + id + ", listaPontoTuristico=" + listaPontoTuristico + ", usuario=" + usuario
				+ ", dataHoraCriacao=" + dataHoraCriacao + "]";
	}
	
}
