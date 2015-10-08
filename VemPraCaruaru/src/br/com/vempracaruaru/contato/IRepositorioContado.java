package br.com.vempracaruaru.contato;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ContatoJaCadastradoException;
import br.com.vempracaruaru.exception.ContatoNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarContatoException;

public interface IRepositorioContado {
	

	public void cadastrar(Contato contato) throws SQLException, NaoFoiPossivelCadastrarContatoException, ContatoJaCadastradoException, Exception;
	public ArrayList<Contato> listarTodos(String complemento) throws SQLException, ContatoNaoCadastradoException, Exception;
	public void alterar(Contato contato) throws SQLException, NaoFoiPossivelCadastrarContatoException, ContatoNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, ContatoNaoCadastradoException, Exception;
	public boolean existeId(Contato contato) throws SQLException, ContatoJaCadastradoException, Exception;


}
