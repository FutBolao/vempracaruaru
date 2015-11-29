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
import br.com.vempracaruaru.artista.Artista;
import br.com.vempracaruaru.conexao.Conexao;
import br.com.vempracaruaru.exception.ArtistaJaCadastradoException;
import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarArtistaException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.foto.Foto;

/**
 * Servlet implementation class ArtistaCadastrar
 */
@WebServlet("/ArtistaCadastrar")
public class ArtistaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "arquivos" + "/" + "artistas" + "/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistaCadastrar() {
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
	    String tipo = "";
	    String telefone = "";
	    String email = "";
	    String twitter = "";
	    String instagram = "";
	    String facebook = "";
	    String historico = "";
	    String foto = "";
	    char ativo = 'S';
	    int qtdFotos = 0;
		System.out.println("entrou na servlet");
		try {
			Conexao.connection.setAutoCommit(false);
			// cadastro o artista sem a foto principal para garantir o id.
			// após upar e armazenar as imagens atualizo os dados com a imagem principal.
			Artista artista = Fachada.getInstance().artistaCadastrar(new Artista(0, nome, sessionAdministrador.getId(), "", historico, tipo, foto, telefone, email, twitter, instagram, facebook, ativo));
			
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
			String patch = getServletContext().getRealPath("");
			if (patch.endsWith("/SIS")) patch = patch.replaceAll("/SIS", "");
			String uploadPath = patch + "/" + UPLOAD_DIRECTORY
					+ "/" + artista.getId() + "/";
			
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
					Foto fotoTemp = Fachada.getInstance().fotoCadastrar(new Foto(0, 1, artista.getId(), "artista", "", "", 'S'));
					// se for campo de arquivo processa aqui
					String fileName = new File(item.getName()).getName();
					String extencao = fileName.substring(fileName.lastIndexOf('.') + 1);
					String filePath = uploadPath + fotoTemp.getId() + "." + extencao;
					String imagem = UPLOAD_DIRECTORY + artista.getId() + "/" + fotoTemp.getId() + "." + extencao;
					fotoTemp.setImagem(imagem);
					
					// atualizo os dados do cadastro da foto com seu caminho correto
					Fachada.getInstance().fotoAlterar(fotoTemp);
					
					// se essa for a primeira foto a ser cadastrada, define ele como foto principal do ponto
					qtdFotos++;
					if (qtdFotos == 1) {
						artista.setFoto(imagem);
					}
					
					File storeFile = new File(filePath);
					
					// salva o arquivo no hd
					item.write(storeFile);
				}
				else if (item.getFieldName().equals("campoNome")) {
					nome = item.getString();
					artista.setNome(nome);
				} else if (item.getFieldName().equals("campoTipo")) {
					tipo = item.getString();
					artista.setTipo(tipo);
				} else if (item.getFieldName().equals("campoTelefone")) {
					telefone = item.getString();
					artista.setTelefone(telefone);
				} else if (item.getFieldName().equals("campoEmail")) {
					email = item.getString();
					artista.setEmail(email);
				} else if (item.getFieldName().equals("campoTwitter")) {
					twitter = item.getString();
					artista.setTwitter(twitter);
				} else if (item.getFieldName().equals("campoInstagram")) {
					instagram = item.getString();
					artista.setInstagram(instagram);
				} else if (item.getFieldName().equals("campoFacebook")) {
					facebook = item.getString();
					artista.setFacebook(facebook);
				} else if (item.getFieldName().equals("campoHistorico")) {
					historico = item.getString();
					artista.setHistorico(historico);
				}
			}
			System.out.println(artista.toString());
			Fachada.getInstance().artistaAlterar(artista);
			Fachada.getInstance().artistaDefinirImagemPrincipal(artista.getId(), artista.getFoto());
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
		} catch (NaoFoiPossivelCadastrarArtistaException e) {
			try {
				Conexao.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			out.println( "<script>parent.alert(\"" + e.getMessage() + "\");</script>" );
		} catch (ArtistaJaCadastradoException e) {
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
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o artista\");</script>" );
		}
	}

}
