package br.com.vempracaruaru.lista;

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
import br.com.vempracaruaru.exception.ListaJaCadastradoException;
import br.com.vempracaruaru.exception.ListaNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarListaException;
import br.com.vempracaruaru.exception.ObraNaoCadastradoException;
import br.com.vempracaruaru.exception.PontoTuristicoNaoCadastradoException;
import br.com.vempracaruaru.pontoturistico.PontoTuristico;

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
	
	
	@Override
	public void cadastrar(Lista lista)
			throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception {
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
	
			sql = "INSERT INTO " + NOME_TABELA + " (id_usuario) VALUES (?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			ps.setInt(1, lista.getIdUsuario());
			ps.execute();
			rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
				lista.setId(id);
				cardastrarLista(lista);
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
		System.out.println("Chegando ao repositorio -");
		ArrayList<Lista> listas = new ArrayList<Lista>();
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
				Lista lista = new Lista(rs.getInt("ID"), listarPonto(rs.getInt("ID")), rs.getInt("ID_USUARIO"), rs.getString("DATA_HORA_CRIACAO"));
				listas.add(lista);
			}
		}else{
			throw new ObraNaoCadastradoException();
		}
		System.out.println("- Consulta completada com sucesso -");
		ps.close();
		rs.close();
		return listas;
	
	}

	@Override
	public Lista listarPorId(int id) throws SQLException, ListaNaoCadastradoException, Exception {
		return listarTodos("id=" + id).get(0);
		}

	@Override
	public void alterar(Lista lista)
			throws SQLException, NaoFoiPossivelCadastrarListaException, ListaNaoCadastradoException, Exception {
				
	}

	@Override
	public void deletar(int id) throws SQLException, ListaNaoCadastradoException, Exception {
		PreparedStatement stmt = null;
		String sql = "";
		try {
		
			sql = "delete form " + NOME_TABELA +" where id= ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			System.out.println("foi removido");
		} finally {

		}		
	}

	@Override
	public boolean existeId(Lista lista) throws SQLException, ListaJaCadastradoException, Exception {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + NOME_TABELA + " WHERE id=?";
		boolean resposta = false;		
		ps = connection.prepareStatement(sql);
		ps.setInt(1, lista.getId());
		rs = ps.executeQuery();
		if(rs != null){
			resposta = true;
		}
		ps.close();
		rs.close();
		return resposta;		
	}
	
	private void cardastrarLista(Lista lista) throws SQLException, NaoFoiPossivelCadastrarListaException, ListaJaCadastradoException, Exception{
		System.out.println("Chegando ao repositorio");
		PreparedStatement ps = null;
		String sql = "";
	
			sql = "INSERT INTO lista_ponto (id_lista, id_ponto_turistico) VALUES (?,?);";
			if (this.dataBase == DataBase.ORACLE) {
				ps = this.connection.prepareStatement(sql, new String[] { "id" });
			} else {
				ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			
			for (PontoTuristico ponto : lista.getListaPontoTuristico()) {
				ps.setInt(1, lista.getId());
				ps.setInt(2,ponto.getId());
				ps.execute();
				
			}		
		ps.close();
	
	}
	
	private ArrayList<PontoTuristico> listarPonto(int id)throws SQLException, PontoTuristicoNaoCadastradoException, Exception {
		ArrayList<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		sql = "SELECT * FROM  lista_ponto ";
		sql += "WHERE ";
		sql += "id_lista = " + id;
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
								
				PontoTuristico pontoTuristico = repcuperarPonto(rs.getInt("id_ponto_turistico"));
				pontosTuristicos.add(pontoTuristico);
			}
		}else{
			throw new AdministradorNaoCadastradoException();
		}
		ps.close();
		rs.close();
		return pontosTuristicos;
		
	}
	
	private PontoTuristico repcuperarPonto(int id) throws SQLException{
		PontoTuristico ponto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM  vw_ponto_turistico where id_ponto_turistico = " +id;
		
		ps = this.connection.prepareStatement(sql);
		rs = ps.executeQuery();
		
		if(rs != null){
			while(rs.next()){
				ponto = new PontoTuristico(rs.getInt("id_ponto_turistico"), rs.getInt("id_administrador"),
				rs.getString("nome_administrador"),rs.getString("nome_ponto_turistico"), new Endereco(rs.getInt("numero"),
				rs.getString("bairro"), rs.getString("endereco"),rs.getString("complemento")),rs.getString("telefone"),
				rs.getString("horario_abertura"), rs.getString("horario_encerramento"),rs.getString("tempo_visitacao"),
				rs.getString("historico_descricao"), rs.getString("ativo").charAt(0),rs.getString("imagem_principal"));
				}
			}
		ps.close();
		rs.close();
		return ponto;
	}
}
