package br.com.vempracaruaru.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarUsuarioException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarUsuarioException;
import br.com.vempracaruaru.exception.UsuarioJaCadastradoException;
import br.com.vempracaruaru.exception.UsuarioNaoCadastradoException;

public class RepositorioUsuarioBDR implements IRepositorioUsuario{

	private static RepositorioUsuarioBDR instance;
	public static final String NOME_TABELA = "usuario";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioUsuarioBDR getInstace() throws Exception{
		if(instance !=null){
			instance = new RepositorioUsuarioBDR();
		}
		return instance;
	}
	
	public RepositorioUsuarioBDR() throws Exception{
		this.connection = Conexao.getConexao(dataBase);
		
	}
	
	@Override
	public void cadastrar(Usuario usuario)
			throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (email, nome, localizacao, senha, user_facebook, link_facebook) VALUES (?,?,?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setString(1, usuario.getEmial());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLocalizacao());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getUserFacebook());
			ps.setString(6, usuario.getLink_facebook());
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				usuario.setId(id);
				System.out.println("cadastro concluido com sucesso");
			} else {
				throw new NaoFoiPossivelCadastrarUsuarioException();
			}
					
		ps.close();
		rs.close();	
		
	}

	@Override
	public ArrayList<Usuario> listarTodos(String complemento)
			throws SQLException, UsuarioNaoCadastradoException, Exception {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		sql = "SELECT * FROM " + NOME_TABELA + " ";
		sql += " WHERE ";
		sql += complemento;
		sql += " ORDER BY nome";
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("localizacao"), rs.getString("senha"), rs.getString("user_facebook"),rs.getString("link_facebook"));
				usuarios.add(usuario);
			}
		}else{
			throw new UsuarioNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return usuarios;
		
	}

	@Override
	public Usuario listarPorId(int id) throws SQLException, UsuarioNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
		}

	@Override
	public ArrayList<Usuario> listarPorNome(String nome) throws SQLException, UsuarioNaoCadastradoException, Exception {
		return listarTodos("nome LIKE '%" + nome + "%'");
		}

	@Override
	public void alterar(Usuario usuario)
			throws SQLException, NaoFoiPossivelCadastrarUsuarioException, UsuarioNaoCadastradoException, Exception {
		
		if (existeId(usuario) == false){
				PreparedStatement ps = null;
				String sql = "";
				// instrução de update do usuario
				sql = "UPDATE " + NOME_TABELA + " SET email=?, nome=?, localizacao=?, senha=?, user_facebook=?, link_facebook=? WHERE id=?;";
				ps = this.connection.prepareStatement(sql);
				ps.setString(1, usuario.getEmial());
				ps.setString(2, usuario.getNome());
				ps.setString(3, usuario.getLocalizacao());
				ps.setString(4, usuario.getSenha());
				ps.setString(5, usuario.getUserFacebook());
				ps.setString(6, usuario.getLink_facebook());
				ps.setInt(7, usuario.getId());
				Integer resultado = ps.executeUpdate();
				if (resultado == 0) throw new NaoFoiPossivelAlterarUsuarioException();
				ps.close();
			}else{
				throw new NaoFoiPossivelAlterarUsuarioException();
			}
		
	}

	//metodo incompleto
	@Override
	public void deletar(int id) throws SQLException, UsuarioNaoCadastradoException, Exception {
//		
//		Usuario usuario = new Usuario(0, "", "", "", "", "", "");
//		if (existeId(usuario) == false){
//			PreparedStatement ps = null;
//			String sql = "";
//			// instrução de update do usuario
//			sql = "UPDATE " + NOME_TABELA + " SET ativo=? WHERE id=?;";
//			ps = this.connection.prepareStatement(sql);
//			ps.setString(1, String.valueOf(administrador.getAtivo()));
//			ps.setInt(2, usuario.getId());
//			Integer resultado = ps.executeUpdate();
//			if (resultado == 0) throw new NaoFoiPossivelAlterarUsuarioException();
//			ps.close();
//		}else{
//			throw new UsuarioNaoCadastradoException();
//		}
//		
	}

	@Override
	public boolean existeId(Usuario usuario) throws SQLException, UsuarioJaCadastradoException, Exception {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, usuario.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		return resposta;		
	}

	
}
