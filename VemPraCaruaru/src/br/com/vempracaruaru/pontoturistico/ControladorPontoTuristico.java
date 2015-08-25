package br.com.vempracaruaru.pontoturistico;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoNaoCadastradoException;

public class ControladorPontoTuristico{
	
	private IRepositorioPontoTuristico repositorio;
	
	public ControladorPontoTuristico() throws Exception{
		this.repositorio = new RepositorioPontoTuristicoBDR();
	}

	public void cadastrar(PontoTuristico pontoTuristico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoJaCadastradoException, Exception{
		if(pontoTuristico != null){
			repositorio.cadastrar(pontoTuristico);
		}
	}
	public ArrayList<PontoTuristico> listarTodos(String complemento) throws SQLException, PontoTuristicoJaCadastradoException, Exception{
		return repositorio.listarTodos(complemento);
	}
	public PontoTuristico listarPorId(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}
	public ArrayList<PontoTuristico> listarPorNome(String nome) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		return repositorio.listarPorNome(nome);
	}
	public void alterar(PontoTuristico pontoTuristico) throws SQLException, NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoNaoCadastradoException, Exception{
		repositorio.alterar(pontoTuristico);
	}
	public void deletar(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception{
		repositorio.deletar(id);
	}

}
