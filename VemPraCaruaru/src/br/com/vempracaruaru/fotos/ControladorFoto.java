package br.com.vempracaruaru.fotos;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vempracaruaru.exception.FotoJaCadastradoException;
import br.com.vempracaruaru.exception.FotoNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarFotoException;

public class ControladorFoto {

	private IRepositorioFoto repositorio;
	
	public ControladorFoto() throws Exception{
	// TODO Auto-generated constructor stub
		this.repositorio = new RepositorioFotoBDR();
	}
	
	public void cadastrar(Foto foto) throws SQLException, NaoFoiPossivelCadastrarFotoException, FotoJaCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		if(foto != null){
			repositorio.cadastrar(foto);
		}
	}
	public ArrayList<Foto> listarTodos(String complemento) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarTodos(complemento);
	}
	public Foto listarPorId(int id) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarPorId(id);
	}
	public ArrayList<Foto> listarPorReferencia(String referencia) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		return repositorio.listarPorReferencia(referencia);
	}
	public void alterar(Foto foto) throws SQLException, NaoFoiPossivelCadastrarFotoException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		repositorio.alterar(foto);
	}
	public void deletar(int id) throws SQLException, FotoNaoCadastradoException, Exception{
		System.out.println("Passando pela Controladora - concluido com sucesso -");
		repositorio.deletar(id);
	}
}
