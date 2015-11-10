package br.com.vempracaruaru.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.vempracaruaru.administrador.Administrador;
import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;
import br.com.vempracaruaru.exception.ObraJaCadastradaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.foto.Foto;
import br.com.vempracaruaru.obra.Obra;

/**
 * Servlet implementation class ObraCadastrar
 */
@WebServlet("/ObraCadastrar")
public class ObraCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "arquivos" + "/" + "obras" + "/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObraCadastrar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Administrador sessionAdministrador = null;
		if (session.getAttribute("loginAdministrador") != null){
			sessionAdministrador = (Administrador) session.getAttribute("loginAdministrador");
		}
		
		response.setContentType("text/html;");
	    PrintWriter out = response.getWriter();
	    String nome = "";
	    int idArtista = 0;
	    int idPontoTuristico = 0;
	    String descricao = "";
	    String foto = "";
	    char ativo = 'S';
	    int qtdFotos = 0;
		System.out.println("entrou na servlet");
		try {
			Conexao.connection.setAutoCommit(false);
			// cadastro o artista sem a foto principal para garantir o id.
			// após upar e armazenar as imagens atualizo os dados com a imagem principal.
			Obra obra = Fachada.getInstance().obraCadastrar(new Obra(0, idArtista, "", sessionAdministrador.getId(), "", idPontoTuristico, "", nome, ativo, foto, descricao));
			
			// verifica se o pedido realmente contém arquivo de upload
			if (!ServletFileUpload.isMultipartContent(request)) {
				// se não, nós paramos aqui
				throw new BusinessException("Não foi selecionado uma imagem");
			}
			
			// configura algumas definições
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(THRESHOLD_SIZE);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(REQUEST_SIZE);
			
			// constrói o caminho do diretório para o arquivo de upload
			String uploadPath = getServletContext().getRealPath("") + "/" + UPLOAD_DIRECTORY 
					+ "/" + obra.getId() + "/";
			
			// cria o diretório caso não exista
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			// analisa o conteúdo do Request para extrair dados de arquivos
			List<FileItem> formItems = upload.parseRequest(request);
			Iterator<FileItem> iter = formItems.iterator();
			
			// itera sobre os campos do formulário
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				// processa apenas os campos de arquivo do formulário
				if (!item.isFormField()) {
					// faço o cadastro da imagem no bd com dados temporários pra garantir o id e salvar ela no disco com esse id
					// após upar e armazenar a imagem atualizo os dados
					Foto fotoTemp = Fachada.getInstance().fotoCadastrar(new Foto(0, 1, obra.getId(), "obra", "", "", 'S'));
					// se for campo de arquivo processa aqui
					String fileName = new File(item.getName()).getName();
					String extencao = fileName.substring(fileName.lastIndexOf('.') + 1);
					String filePath = uploadPath + fotoTemp.getId() + "." + extencao;
					String imagem = UPLOAD_DIRECTORY + obra.getId() + "/" + fotoTemp.getId() + "." + extencao;
					fotoTemp.setImagem(imagem);
					
					// atualizo os dados do cadastro da foto com seu caminho correto
					Fachada.getInstance().fotoAlterar(fotoTemp);
					
					// se essa for a primeira foto a ser cadastrada, define ele como foto principal do ponto
					qtdFotos++;
					if (qtdFotos == 1) {
						obra.setFoto(imagem);
					}
					
					File storeFile = new File(filePath);
					
					// salva o arquivo no hd
					item.write(storeFile);
				}
				else if (item.getFieldName().equals("campoNome")) {
					nome = item.getString();
					obra.setNome(nome);
				} else if (item.getFieldName().equals("campoArtista")) {
					idArtista = Integer.parseInt(item.getString());
					obra.setIdArtista(idArtista);
				} else if (item.getFieldName().equals("campoPonto")) {
					idPontoTuristico = Integer.parseInt(item.getString());
					obra.setIdPontoTuristico(idPontoTuristico);
				} else if (item.getFieldName().equals("campoDescricao")) {
					descricao = item.getString();
					obra.setDescricao(descricao);
				}
			}
			System.out.println(obra.toString());
			Fachada.getInstance().obraAlterar(obra);
			Conexao.connection.setAutoCommit(true);
			out.println( "<script>parent.alert(\"Cadastro efetuado com sucesso!!!\");</script>" );
			out.println( "<script>parent.limparFormulario();</script>" );
		} catch (SQLException e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (NaoFoiPossivelCadastrarDestaqueException e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ObraJaCadastradaException e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (BusinessException e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (Exception e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar a obra\");</script>" );
		}
	}

}
