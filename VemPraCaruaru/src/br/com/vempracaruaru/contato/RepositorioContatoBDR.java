package br.com.vempracaruaru.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.ContatoJaCadastradoException;
import br.com.vempracaruaru.exception.ContatoNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarContatoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelDeletarContatoException;
import br.com.vempracaruaru.exception.NaofoiPossivelAlterarContatoException;

public class RepositorioContatoBDR implements IRepositorioContado{

	private static RepositorioContatoBDR instance;
	public static final String NOME_TABELA = "contato";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioContatoBDR getInstanca() throws Exception{
		if(instance == null){
			instance = new RepositorioContatoBDR();
		}
		return instance;
	}
	
	public RepositorioContatoBDR() throws Exception{
		this.connection = Conexao.getConexao(dataBase);
	}
	@Override
	public void cadastrar(Contato contato)
			throws SQLException, NaoFoiPossivelCadastrarContatoException, ContatoJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (nome, email, telefone, assunto,visualizado) VALUES (?,?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());	
			ps.setString(4, contato.getAssunto());
			ps.setString(5, String.valueOf(contato.getVisualizado()));
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				contato.setIdContato(id);
			} else {
				throw new NaoFoiPossivelCadastrarArtistaException();
			}
			System.out.println("Cadastro concluido com sucesso");
		
		ps.close();
		rs.close();
		
	}

	@Override
	public ArrayList<Contato> listarTodos(String complemento)
			throws SQLException, ContatoNaoCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		sql = "SELECT * FROM " + NOME_TABELA + " ";
		sql += "WHERE ";
		sql += complemento;
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Contato contato = new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"),
											  rs.getString("assunto"),rs.getString("data_hora"),rs.getString("visualizado").charAt(0));
				contatos.add(contato);
			}
			System.out.println("- consulta completada com sucesso -");
		}else{
			throw new ContatoNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return contatos;
		
	}
	
	@Override
	public void alterar(Contato contato) throws SQLException, NaoFoiPossivelCadastrarContatoException, ContatoNaoCadastradoException, Exception{
		if (existeId(contato) == false){
			PreparedStatement ps = null;
			String sql = "";
			sql = "UPDATE " + NOME_TABELA + " SET nome=?, email=?, telefone=?, assunto=?,"
					+ " visualizado=? WHERE id=?;";
			ps = this.connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());
			ps.setString(4, contato.getAssunto());
			ps.setString(5, String.valueOf(contato.getVisualizado()));
			ps.setInt(6, contato.getIdContato());
			Integer resultado = ps.executeUpdate();
			if (resultado == 0) throw new NaofoiPossivelAlterarContatoException();
			ps.close();
		}else{
			throw new NaofoiPossivelAlterarContatoException();
		}
				
	}


	@Override
	public void deletar(int id) throws SQLException, ContatoNaoCadastradoException, Exception {		
		System.out.println("chegando ao repositorio");
		PreparedStatement stmt = null;
		String sql = "";
		
		try {
			if(existeId(new Contato(id, "", "", "", "","",'s'))== false){
			sql = "delete from "+ NOME_TABELA +" where id= ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);			
			stmt.execute();
			System.out.println("foi removido");
			}else{
				throw new NaoFoiPossivelDeletarContatoException();
			}
		} finally {

		}

	}

	@Override
	public boolean existeId(Contato contato) throws SQLException, ContatoJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, contato.getIdContato());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		System.out.println("- consulta completada com sucesso -");
		return resposta;
		
	}

}
