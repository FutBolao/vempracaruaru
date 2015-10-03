package br.com.vempracaruaru.destaque;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.DestaqueJaCadastradoException;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;


public interface IRepositorioDestaque {

	public Destaque cadastrar(Destaque destaque) throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueJaCadastradoException, Exception;
	public ArrayList<Destaque> listarTodos(String complemento) throws SQLException, DestaqueNaoCadastradoException, Exception;
	public Destaque listarPorId(int id) throws SQLException, DestaqueNaoCadastradoException, Exception;
	public ArrayList<Destaque> listarPorTitulo(String titulo) throws SQLException, DestaqueNaoCadastradoException, Exception;
	public void alterar(Destaque destaque) throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, DestaqueNaoCadastradoException, Exception;
	public boolean existeId(Destaque destaque) throws SQLException, DestaqueJaCadastradoException, Exception;
	
}
