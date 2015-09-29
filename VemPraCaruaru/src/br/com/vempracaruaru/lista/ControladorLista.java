package br.com.vempracaruaru.lista;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.ListaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;

public class ControladorLista {

private IRepositorioLista repositorio;
	
	public ControladorLista() throws Exception{
		this.repositorio = new RepositorioListaBDR();
	}
	
	public void cadastrar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception{
		System.out.println("passando pela controladora - concluido com sucesso -");
		if (lista != null) {
			repositorio.cadastrar(lista);
		}
	}
	public ArrayList<Lista> listarTodos(String complemento) throws SQLException, ListaNaoCadastradoException, Exception{
		System.out.println("Passando pela fachada - concluido com sucesso -");
		return repositorio.listarTodos(complemento);
	}
	public Lista listarPorId(int id) throws SQLException, ListaNaoCadastradoException, Exception{
		return repositorio.listarPorId(id);
	}

	public void alterar(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaNaoCadastradoException, Exception{
		repositorio.alterar(lista);	
	}
	public void deletar(int id) throws SQLException, ListaNaoCadastradoException, Exception{
		repositorio.deletar(id);
	}
}