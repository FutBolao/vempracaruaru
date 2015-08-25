package br.com.vempracaruaru.obra;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.exception.ObraNaoCadastradoException;

public class ControladorObra {

	private IRepositorioObra repositorio;
	
	public ControladorObra() throws Exception{
		this.repositorio = new RepositorioObraBDR();
	}

	public void cadastrar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraJaCadastradoException, Exception{
		if(obra !=null){
			repositorio.cadastrar(obra);
		}
	}
	public ArrayList<Obra> listarTodos(String complemento) throws SQLException, ObraNaoCadastradoException, Exception{
		return repositorio.listarTodos(complemento);
	}
	public Obra listarPorId(int id) throws SQLException, ObraNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}
	public ArrayList<Obra> listarPorNome(String nome) throws SQLException, ObraNaoCadastradoException, Exception{
		return repositorio.listarPorNome(nome);
	}
	public void alterar(Obra obra) throws SQLException, NaoFoiPossivelCadastrarObraException, ObraNaoCadastradoException, Exception{
		repositorio.alterar(obra);
	}
	public void deletar(int id) throws SQLException, ObraNaoCadastradoException, Exception{
		repositorio.deletar(id);
	}

}
