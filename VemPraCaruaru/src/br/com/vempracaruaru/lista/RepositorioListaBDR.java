package br.com.vempracaruaru.lista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.ListaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;

public class RepositorioListaBDR implements IRepositorioLista{

	private static RepositorioListaBDR instance;
	public static final String NOME_TABELA = "lista";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioListaBDR getInstance() throws Exception {
		
		if(instance == null){
			instance =  new RepositorioListaBDR();
		}
		return instance;
	}
	
	public RepositorioListaBDR() throws Exception {
		// TODO Auto-generated constructor stub
		this.connection = Conexao.getConexao(dataBase);
	}
	
	
	//metodo incompleto
	@Override
	public void cadastrar(Lista lista)
			throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (id_usuario, ) VALUES (?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setInt(1, lista.getIdUsuario());
			ps.setString(2, lista.getDataHoraCriacao());
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				lista.setId(id);
			} else {
				throw new NaoFoiPossivelCadastrarArtistaException();
			}
			System.out.println("Cadastro concluido com sucesso");
		
		ps.close();
		rs.close();
		
	
		
	}

	@Override
	public ArrayList<Lista> listarTodos(String complemento)
			throws SQLException, ListaNaoCadastradoException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista listarPorId(int id) throws SQLException, ListaNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
		}

	@Override
	public ArrayList<Lista> listarPorNome(String nome) throws SQLException, ListaNaoCadastradoException, Exception {
		return listarTodos("nome LIKE '%" + nome + "%'");
		}

	@Override
	public void alterar(Lista lista)
			throws SQLException, NaoFoiPossivelCadastrarListaException, ListaNaoCadastradoException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int id) throws SQLException, ListaNaoCadastradoException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeId(Lista lista) throws SQLException, ListaJaCadastradoException, Exception {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, lista.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		return resposta;		
	}

	
}
