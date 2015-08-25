package br.com.vempracaruaru.pontoturistico;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoNaoCadastradoException;

public interface IRepositorioPontoTuristico {
	public void cadastrar(PontoTuristico pontoTuristico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoJaCadastradoException, Exception;
	public ArrayList<PontoTuristico> listarTodos(String complemento) throws SQLException, PontoTuristicoJaCadastradoException, Exception;
	public PontoTuristico listarPorId(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception;
	public ArrayList<PontoTuristico> listarPorNome(String nome) throws SQLException, PontoTuristicoNaoCadastradoException, Exception;
	public void alterar(PontoTuristico pontoTuristico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoNaoCadastradoException, Exception;
	public void deletar(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception;
	public boolean existeId(PontoTuristico pontoTuristico) throws SQLException, PontoTuristicoJaCadastradoException, Exception;
}
