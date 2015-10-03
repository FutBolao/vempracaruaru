package br.com.vempracaruaru.destaque;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.DestaqueJaCadastradoException;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;

public class ControladorDestaque {
	
	private IRepositorioDestaque repositorio;

	public ControladorDestaque() throws Exception{
		this.repositorio = new RepositorioDestaqueBDR();
	}
	public Destaque cadastrar(Destaque destaque) throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueJaCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");

		if (destaque != null) {
			return repositorio.cadastrar(destaque);
		}else{
		return null;
		}
	}


	public ArrayList<Destaque> listarTodos(String complemento)
			throws SQLException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarTodos(complemento);
	}


	public Destaque listarPorId(int id) throws SQLException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarPorId(id);
	}


	public ArrayList<Destaque> listarPorTitulo(String titulo)
			throws SQLException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarPorTitulo(titulo);
	}


	public void alterar(Destaque destaque)
			throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		repositorio.alterar(destaque);

	}


	public void deletar(int id) throws SQLException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		repositorio.deletar(id);
	}

}
