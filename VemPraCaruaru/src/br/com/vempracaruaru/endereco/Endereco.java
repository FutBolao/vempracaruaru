package br.com.vempracaruaru.endereco;

public class Endereco {
	
	private int			numero;
	private String		bairro;
	private String		rua;
	private String		complemento;
	
	public Endereco(int numero, String bairro, String rua, String complemento) {
		this.numero = numero;
		this.bairro = bairro;
		this.rua = rua;
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [numero=" + numero + ", bairro=" + bairro + ", rua=" + rua + ", complemento=" + complemento
				+ "]";
	}

	
	
}
