package br.com.vempracaruaru.util;

public class Formatacao {
	
	public static String cpf(String cpf) {
		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
	}

}