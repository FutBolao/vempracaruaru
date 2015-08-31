package br.com.vempracaruaru.pontoturistico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.conexao.DataBase;
import br.com.vempracaruaru.endereco.Endereco;
import br.com.vempracaruaru.exception.AdministradorNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelAlterarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarPontoTuristicoException;
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoNaoCadastradoException;

public class RepositorioPontoTuristicoBDR implements IRepositorioPontoTuristico{
	
	private static RepositorioPontoTuristicoBDR instance;
	private static final String NOME_TABELA = "ponto_turistico";
	private Connection  connection;
	private int dataBase = DataBase.MYSQL;

	
	public static RepositorioPontoTuristicoBDR getInstace() throws Exception{
		if(instance == null){
			instance = new RepositorioPontoTuristicoBDR();
		}
		return instance;
	}
	
	public RepositorioPontoTuristicoBDR() throws Exception{
	this.connection = Conexao.getConexao(dataBase);
	}
	
	
	@Override
	public void cadastrar(PontoTuristico pontoTuristico) throws SQLException,
			NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (id_administrador, nome, endereco, numero, bairro, complemento, telefone,horario_abertura,"
					+ " horario_encerramento,tempo_visitacao,historico_descricao, ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setInt(1, pontoTuristico.getIdAdministrador());
			ps.setString(2, pontoTuristico.getNome());
			ps.setString(3, pontoTuristico.getEndereco().getRua());
			ps.setInt(4, pontoTuristico.getEndereco().getNumero());
			ps.setString(5, pontoTuristico.getEndereco().getBairro());
			ps.setString(6, pontoTuristico.getEndereco().getComplemento());
			ps.setString(7, pontoTuristico.getTelefone());
			ps.setString(8, pontoTuristico.getHorarioAbertura());
			ps.setString(9, pontoTuristico.getHorarioEncerramento());
			ps.setString(10, pontoTuristico.getTempoVisitacao());
			ps.setString(11, pontoTuristico.getHistoricoDescricao());
			ps.setString(12, String.valueOf(pontoTuristico.getAtivo()));
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				pontoTuristico.setId(id);
			} else {
				throw new NaoFoiPossivelCadastrarPontoTuristicoException();
			}
			System.out.println("Cadastro concluido com sucesso");
		
		ps.close();
		rs.close();
		
	
		
	}
	@Override
	public ArrayList<PontoTuristico> listarTodos(String complemento)
			throws SQLException, PontoTuristicoJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		ArrayList<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();
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
				
				
						PontoTuristico pontoTuristico = new PontoTuristico(rs.getInt("id"), rs.getInt("id_Administrador"),rs.getString("nomeAdministrador"),
						rs.getString("nome"), new Endereco(rs.getInt("numero"), rs.getString("bairro"), rs.getString("endereco"),
						rs.getString("complemento")),rs.getString("cpf"),  rs.getString("horario_abertura"), rs.getString("horario_encerramento"), 
						rs.getString("tempo_visitacao"),rs.getString("historico_descricao"), rs.getString("ativo").charAt(0),null,rs.getInt("pontos"));
				
				pontosTuristicos.add(pontoTuristico);
			}
			System.out.println("- consulta completada com sucesso -");
		}else{
			throw new AdministradorNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return pontosTuristicos;
		
	}
	@Override
	public PontoTuristico listarPorId(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
		}
	@Override
	public ArrayList<PontoTuristico> listarPorNome(String nome)
			throws SQLException, PontoTuristicoNaoCadastradoException, Exception {
		return listarTodos("nome LIKE '%" + nome + "%'");
		}
	@Override
	public void alterar(PontoTuristico pontoTuristico) throws SQLException,
			NaoFoiPossivelCadastrarPontoTuristicoException, PontoTuristicoNaoCadastradoException, Exception {
		
		if (existeId(pontoTuristico) == false){
				PreparedStatement ps = null;
				String sql = "";
				// instrução de update do artista
				sql = "UPDATE " + NOME_TABELA + " SET nome=?, endereco=?, numero=?, bairro=?, complemento=?, telefone=?, horario_abertura=?, horario_encerramento=?, "
						+ "tempo_visitacao=?, historico_descricao=?, ativo=? WHERE id=?;";
				ps = this.connection.prepareStatement(sql);
				ps.setString(1, pontoTuristico.getNome());
				ps.setString(2, pontoTuristico.getEndereco().getRua());
				ps.setInt(3, pontoTuristico.getEndereco().getNumero());
				ps.setString(4, pontoTuristico.getEndereco().getBairro());
				ps.setString(5, pontoTuristico.getEndereco().getComplemento());
				ps.setString(6, pontoTuristico.getTelefone());
				ps.setString(7, pontoTuristico.getHorarioAbertura());
				ps.setString(8, pontoTuristico.getHorarioEncerramento());
				ps.setString(9, pontoTuristico.getTempoVisitacao());
				ps.setString(10, pontoTuristico.getHistoricoDescricao());
				ps.setString(11, String.valueOf(pontoTuristico.getAtivo()));		
				ps.setInt(12, pontoTuristico.getId());

				Integer resultado = ps.executeUpdate();
				if (resultado == 0) throw new NaoFoiPossivelAlterarArtistaException();
				ps.close();
			}else{
				throw new NaoFoiPossivelAlterarArtistaException();
			}
				
	}
	@Override
	public void deletar(int id) throws SQLException, PontoTuristicoNaoCadastradoException, Exception {		
		PontoTuristico artista = new PontoTuristico(id, 0, "","", null, "", "", "",	"", "", 'N',null,0);	
		PreparedStatement ps = null;
		String sql = "";
		// instrução de update do artista
		sql = "UPDATE " + NOME_TABELA + " SET ativo=? WHERE id=?;";
		ps = this.connection.prepareStatement(sql);
		ps.setString(1, String.valueOf(artista.getAtivo()));
		ps.setInt(2, artista.getId());
		Integer resultado = ps.executeUpdate();
		if (resultado == 0) throw new NaoFoiPossivelAlterarArtistaException();
		ps.close();

	
}
	@Override
	public boolean existeId(PontoTuristico pontoTuristico)
			throws SQLException, PontoTuristicoJaCadastradoException, Exception {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = true;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, pontoTuristico.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = false;
		}
		ps.close();
		rs.close();
		return resposta;
		
	}
	
	

}
