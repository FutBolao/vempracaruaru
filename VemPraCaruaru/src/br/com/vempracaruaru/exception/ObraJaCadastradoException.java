package br.com.vempracaruaru.exception;

public class ObraJaCadastradoException extends Exception{
	
	private static final long serialVersionUID = -5953376500993574711L;

	public ObraJaCadastradoException(){
		super("Obra já cadastrado!");
	}
	
	public ObraJaCadastradoException(String msg){
		super(msg);
	}

}
