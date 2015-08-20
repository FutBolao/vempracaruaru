package br.com.vempracaruaru.Exception;

public class AdministradorNaoCadastradoException extends Exception{
	
	private static final long serialVersionUID = -2849294837831479260L;

	public AdministradorNaoCadastradoException(){
		super("Administrador não cadastrado!");
	}
	
	public AdministradorNaoCadastradoException(String msg){
		super(msg);
	}

}
