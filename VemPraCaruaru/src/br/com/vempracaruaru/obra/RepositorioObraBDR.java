package br.com.vempracaruaru.obra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarObraException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarObraException;
import br.com.vempracaruaru.exception.ObraJaCadastradoException;
import br.com.vempracaruaru.exception.ObraNaoCadastradoException;

public class RepositorioObraBDR implements IRepositorioObra{
	
	private static RepositorioObraBDR instance;
	public static final String NOME_TABELA = "obra";
	private Connection connection;
	private int dataBase = DataBase.MYSQL;
	
	public static RepositorioObraBDR getInstance()throws Exception{
		if(instance == null){
			instance = new RepositorioObraBDR();
		}
		return instance;
	}
	
	public RepositorioObraBDR() throws Exception{
		// TODO Auto-generated constructor stub
		this.connection = Conexao.getConexao(dataBase);
	}
	
	@Override
	public void cadastrar(Obra obra)
			throws SQLException, NaoFoiPossivelCadastrarObraException, ObraJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (id_artista, id_administrador, nome, historico, ativo) VALUES (?,?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setInt(1, obra.getIdArtista());
			ps.setInt(2, obra.getIdAdministrador());
			ps.setString(3,obra.getNome() );
			ps.setString(4, obra.getHistorico());
			ps.setString(5, String.valueOf(obra.getAtivo()));
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				obra.setId(id);
			} else {
				throw new NaoFoiPossivelCadastrarObraException();
			}
			System.out.println("Cadastro concluido com sucesso");
		
		ps.close();
		rs.close();		
	}

	@Override
	public ArrayList<Obra> listarTodos(String complemento) throws SQLException, ObraNaoCadastradoException, Exception {
		System.out.println("Chegando ao repositorio -");
		ArrayList<Obra> obras = new ArrayList<Obra>();
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
				Obra obra = new Obra(rs.getInt("id"), rs.getInt("idArtista"), rs.getString("nomeArtista"), rs.getInt("idAdministrador"), 
						rs.getString("nomeAdministrador"), rs.getInt("idPontoTuristico"), rs.getString("nomePontoTuristico"), rs.getString("nome"),
						rs.getString("historico"), rs.getString("ativo").charAt(0),null);
				obras.add(obra);
			}
		}else{
			throw new ObraNaoCadastradoException();
		}
		System.out.println("- Consulta completada com sucesso -");
		ps.close();
		rs.close();
		return obras;
	
	}

	@Override
	public Obra listarPorId(int id) throws SQLException, ObraNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
		}

	@Override
	public ArrayList<Obra> listarPorNome(String nome) throws SQLException, ObraNaoCadastradoException, Exception {
		return listarTodos("nome LIKE '%" + nome + "%'");
		}

	@Override
	public void alterar(Obra obra)
			throws SQLException, NaoFoiPossivelCadastrarObraException, ObraNaoCadastradoException, Exception {		
		if (existeId(obra) == false){
				PreparedStatement ps = null;
				String sql = "";
				// instrução de update do obra
				sql = "UPDATE " + NOME_TABELA + " SET nome=?, historico=?, ativo=? WHERE id=?;";
				ps = this.connection.prepareStatement(sql);
				ps.setString(1, obra.getNome());
				ps.setString(2, obra.getHistorico());
				ps.setString(3, String.valueOf(obra.getAtivo()));
				ps.setInt(4, obra.getId());
				Integer resultado = ps.executeUpdate();
				if (resultado == 0) throw new NaoFoiPossivelAlterarObraException();
				ps.close();
			}else{
				throw new NaoFoiPossivelAlterarObraException();
			}
				
	}

	@Override
	public void deletar(int id) throws SQLException, ObraNaoCadastradoException, Exception {	
		Obra obra = new Obra(id, 0, "", 0,"", 0,"", "", "", 'N',null);
		
		PreparedStatement ps = null;
		String sql = "";
		// instrução de update do obra
		sql = "UPDATE " + NOME_TABELA + " SET ativo=? WHERE id=?;";
		ps = this.connection.prepareStatement(sql);
		ps.setString(1, String.valueOf(obra.getAtivo()));
		ps.setInt(2, obra.getId());
		Integer resultado = ps.executeUpdate();
		if (resultado == 0) throw new NaoFoiPossivelAlterarObraException();
		ps.close();

	
}

	@Override
	public boolean existeId(Obra obra) throws SQLException, ObraJaCadastradoException, Exception {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, obra.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		return resposta;
		
	}

}
