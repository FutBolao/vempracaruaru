package br.com.vempracaruaru.exception;

public class ObraNaoCadastradoException extends Exception{
	
	private static final long serialVersionUID = -2849294837831479260L;

	public ObraNaoCadastradoException(){
		super("Obra não cadastrado!");
	}
	
	public ObraNaoCadastradoException(String msg){
		super(msg);
	}

}
