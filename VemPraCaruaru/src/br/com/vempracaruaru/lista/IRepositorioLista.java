package br.com.vempracaruaru.lista;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.ListaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;

public interface IRepositorioLista {

	public void cadastrar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception;
	public ArrayList<Lista> listarTodos(String complemento) throws SQLException, ListaNaoCadastradoException, Exception;
	public Lista listarPorId(int id) throws SQLException, ListaNaoCadastradoException, Exception;
	public ArrayList<Lista> listarPorNome(String nome) throws SQLException, ListaNaoCadastradoException, Exception;
	public void alterar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, ListaNaoCadastradoException, Exception;
	public boolean existeId(Lista lista) throws SQLException, ListaJaCadastradoException, Exception;


}
