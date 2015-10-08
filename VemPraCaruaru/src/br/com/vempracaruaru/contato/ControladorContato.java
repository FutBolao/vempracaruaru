package br.com.vempracaruaru.contato;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ContatoJaCadastradoException;
import br.com.vempracaruaru.exception.ContatoNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarContatoException;

public class ControladorContato {

	private IRepositorioContado repositorio;

	public ControladorContato() throws Exception{
		this.repositorio = new RepositorioContatoBDR();
	}
	
	public void cadastrar(Contato contato)
			throws SQLException, NaoFoiPossivelCadastrarContatoException, ContatoJaCadastradoException, Exception {
		System.out.println("passando pela controladora - concluido com sucesso -");
		if(contato != null){
			repositorio.cadastrar(contato);
		}
	}


	public ArrayList<Contato> listarTodos(String complemento)
			throws SQLException, ContatoNaoCadastradoException, Exception {
		System.out.println("passando pela controladora - concluido com sucesso -");
		return repositorio.listarTodos(complemento);
	}


	public void deletar(int id) throws SQLException, ContatoNaoCadastradoException, Exception {
		System.out.println("passando pela controladora - concluido com sucesso -");
		repositorio.deletar(id);
	}
}
