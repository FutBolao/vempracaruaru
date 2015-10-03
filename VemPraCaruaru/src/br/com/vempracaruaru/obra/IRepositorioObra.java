package br.com.vempracaruaru.obra;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.exception.ObraNaoCadastradoException;


public interface IRepositorioObra {

	public Obra cadastrar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraJaCadastradoException, Exception;
	public ArrayList<Obra> listarTodos(String complemento) throws SQLException, ObraNaoCadastradoException, Exception;
	public Obra listarPorId(int id) throws SQLException, ObraNaoCadastradoException, Exception;
	public ArrayList<Obra> listarPorNome(String nome) throws SQLException, ObraNaoCadastradoException, Exception;
	public void alterar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, ObraNaoCadastradoException, Exception;
	public boolean existeId(Obra obra) throws SQLException, ObraJaCadastradoException, Exception;
}
