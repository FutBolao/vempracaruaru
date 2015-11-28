package br.com.vempracaruaru.destaque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.DestaqueJaCadastradoException;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarDestaqueException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;
import br.com.vempracaruaru.exception.NaofoiPossivelDeletarDestaqueException;

public class RepositorioDestaqueBDR implements IRepositorioDestaque {

	private static RepositorioDestaqueBDR instance;
	public static final String NOME_TABELA = "destaque";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioDestaqueBDR getInstance() throws Exception{
		if(instance ==  null){
			instance = new RepositorioDestaqueBDR();
		}
		return instance;
	}
	
	public RepositorioDestaqueBDR() throws Exception{
		this.connection = Conexao.getConexao(dataBase);
	}
	
	@Override
	public Destaque cadastrar(Destaque destaque) throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueJaCadastradoException, Exception{
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (id_administrador, titulo, imagem, link) VALUES (?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setInt(1, destaque.getIdAdministrador());
			ps.setString(2, destaque.getTitulo());
			ps.setString(3, destaque.getImagem());	
			ps.setString(4, destaque.getLink());
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				destaque.setId(id);
			} else {
				throw new NaoFoiPossivelCadastrarArtistaException();
			}
			System.out.println("Cadastro concluido com sucesso");
		
		ps.close();
		rs.close();
		
		return destaque;
	}

	@Override
	public ArrayList<Destaque> listarTodos(String complemento)
			throws SQLException, DestaqueNaoCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		ArrayList<Destaque> destaques = new ArrayList<Destaque>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		sql = "SELECT * FROM " + NOME_TABELA + " ";
		sql += "WHERE id IS NOT NULL ";
		sql += complemento;
		sql += " ORDER BY titulo";
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Destaque destque = new Destaque(rs.getInt("id"), rs.getInt("id_administrador"), rs.getString("titulo"),
						rs.getString("imagem"), rs.getString("link"));
				destaques.add(destque);
			}
			System.out.println("- consulta completada com sucesso -");
		}else{
			throw new DestaqueNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return destaques;
		
	}

	@Override
	public Destaque listarPorId(int id) throws SQLException, DestaqueNaoCadastradoException, Exception {
		return listarTodos("AND id=" + id).get(0);
		}

	@Override
	public ArrayList<Destaque> listarPorTitulo(String titulo) throws SQLException, DestaqueNaoCadastradoException, Exception{
		return listarTodos("AND titulo LIKE '%" + titulo    + "%'");
		
	}

	@Override
	public void alterar(Destaque destaque)
			throws SQLException, NaoFoiPossivelCadastrarDestaqueException, DestaqueNaoCadastradoException, Exception {
		if (existeId(destaque) == false){
				PreparedStatement ps = null;
				String sql = "";
				sql = "UPDATE " + NOME_TABELA + " SET id_administrador=?, titulo=?, imagem=?, link=? WHERE id=?;";
				ps = this.connection.prepareStatement(sql);
				ps.setInt(1, destaque.getIdAdministrador());
				ps.setString(2, destaque.getTitulo());
				ps.setString(3, destaque.getImagem());
				ps.setString(4, destaque.getLink());
				ps.setInt(5, destaque.getId());
				Integer resultado = ps.executeUpdate();
				if (resultado == 0) throw new NaoFoiPossivelAlterarDestaqueException();
				ps.close();
			}else{
				throw new NaoFoiPossivelAlterarDestaqueException();
			}
				
	}

	@Override
	public void deletar(int id) throws SQLException, DestaqueNaoCadastradoException, Exception {		
		System.out.println("chegando ao repositorio");
		PreparedStatement stmt = null;
		String sql = "";
		if(existeId(new Destaque(id, 0, "", "", ""))== false){
		sql = "delete from "+ NOME_TABELA +" where id= ?";
		stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);			
		stmt.execute();
		System.out.println("foi removido");
		}else{
			throw new NaofoiPossivelDeletarDestaqueException();
		}
	}

	@Override
	public boolean existeId(Destaque destaque) throws SQLException, DestaqueJaCadastradoException, Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, destaque.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		return resposta;		
	
	}

}
