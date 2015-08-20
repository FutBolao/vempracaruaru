package br.com.vempracaruaru.administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.AdministradorJaCadastradoException;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarAdministradorException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarAdministradorException;

public class RepositorioAdministradorBDR implements IRepositorioAdministrador{
	
	private static RepositorioAdministradorBDR instance;
	public static final String NOME_TABELA = "administrador";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioAdministradorBDR getInstance()
			throws Exception {
		if (instance == null) {
			instance = new RepositorioAdministradorBDR();
		}
		return instance;
	}
	
	public RepositorioAdministradorBDR() throws Exception{
		this.connection = Conexao.getConexao(dataBase);
	}
	
	@Override
	public void cadastrar(Administrador administrador) throws SQLException, NaoFoiPossivelCadastrarAdministradorException,
			AdministradorJaCadastradoException, Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		if (existeCpf(administrador) == false){
			sql = "INSERT INTO " + NOME_TABELA + " (nome, cpf, telefone, usuario, senha, ativo) VALUES (?,?,?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setString(1, administrador.getNome());
			ps.setString(2, administrador.getCpf());
			ps.setString(3, administrador.getTelefone());
			ps.setString(4, administrador.getUsuario());
			ps.setString(5, administrador.getSenha());
			ps.setString(6, String.valueOf(administrador.getAtivo()));
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				administrador.setId(id);
			} else {
				throw new NaoFoiPossivelCadastrarAdministradorException();
			}
			
		} else {
			throw new AdministradorJaCadastradoException();
		}
		ps.close();
		rs.close();
		
	}

	@Override
	public ArrayList<Administrador> listarTodos(String complemento)
			throws SQLException, AdministradorNaoCadastradoException, Exception {

		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		sql = "SELECT * FROM " + NOME_TABELA + " ";
		sql += "WHERE ";
		sql += complemento;
		sql += " ORDER BY nome";
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Administrador administrador = new Administrador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("usuario"), rs.getString("senha"), rs.getString("nome").charAt(0));
				administradores.add(administrador);
			}
		}else{
			throw new AdministradorNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return administradores;
		
	}
	
	@Override
	public Administrador listarPorId(int id)
			throws SQLException, AdministradorNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
	}
	
	@Override
	public ArrayList<Administrador> listarPorNome(String nome)
			throws SQLException, AdministradorNaoCadastradoException, Exception {
		return listarTodos("nome LIKE '%" + nome + "%'");
	}
	
	@Override
	public Administrador listarPorCpf(String cpf)
			throws SQLException, AdministradorNaoCadastradoException, Exception {
		return listarTodos("cpf='" + cpf + "'").get(0);
	}

	@Override
	public void alterar(Administrador administrador) throws SQLException, NaoFoiPossivelAlterarAdministradorException, AdministradorNaoCadastradoException, Exception {
		
		if (existeId(administrador) == false){
			if(existeCpf(administrador) == false){
				PreparedStatement ps = null;
				String sql = "";
				// instrução de update do clube
				sql = "UPDATE " + NOME_TABELA + " SET nome=?, cpf=?, telefone=?, senha=?, ativo=? WHERE id=?;";
				ps = this.connection.prepareStatement(sql);
				ps.setString(1, administrador.getNome());
				ps.setString(2, administrador.getCpf());
				ps.setString(3, administrador.getTelefone());
				ps.setString(4, administrador.getSenha());
				ps.setString(5, String.valueOf(administrador.getAtivo()));
				ps.setInt(6, administrador.getId());
				Integer resultado = ps.executeUpdate();
				if (resultado == 0) throw new NaoFoiPossivelAlterarAdministradorException();
				ps.close();
			}else{
				throw new NaoFoiPossivelAlterarAdministradorException();
			}
		}else{
			throw new AdministradorNaoCadastradoException();
		}
		
	}

	@Override
	public void deletar(int id) throws SQLException,
			AdministradorNaoCadastradoException, Exception {
		
		Administrador administrador = new Administrador(id, "", "", "", "", "", 'N');
		if (existeId(administrador) == false){
			PreparedStatement ps = null;
			String sql = "";
			// instrução de update do clube
			sql = "UPDATE " + NOME_TABELA + " SET ativo=? WHERE id=?;";
			ps = this.connection.prepareStatement(sql);
			ps.setString(1, String.valueOf(administrador.getAtivo()));
			ps.setInt(2, administrador.getId());
			Integer resultado = ps.executeUpdate();
			if (resultado == 0) throw new NaoFoiPossivelAlterarAdministradorException();
			ps.close();
		}else{
			throw new AdministradorNaoCadastradoException();
		}
		
	}

	@Override
	public boolean existeId(Administrador administrador) throws SQLException,
			AdministradorJaCadastradoException, Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = false;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, administrador.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = true;
		}
		ps.close();
		rs.close();
		return resposta;
		
	}
	
	@Override
	public boolean existeCpf(Administrador administrador) throws SQLException,
			AdministradorJaCadastradoException, Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE cpf=?";
		boolean resposta = false;		
		ps = connection.prepareStatement(sql);
		ps.setString(1, administrador.getCpf());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = true;
		}
		ps.close();
		rs.close();
		return resposta;
		
	}

}
