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
import br.com.vempracaruaru.exception.PontoTuristicoJaCadastradoException;
import br.com.vempracaruaru.fachada.Fachada;
import br.com.vempracaruaru.foto.Foto;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	private String UPLOAD_DIRECTORY = "arquivos" + "/" + "lixo" + "/";
	private String referencia = "lixo";
	private int id = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
	    if (request.getParameter("referencia").equalsIgnoreCase("ponto")) {
	    	referencia = "ponto";
	    } else if (request.getParameter("referencia").equalsIgnoreCase("artista")) {
	    	referencia = "artista";
	    } else if (request.getParameter("referencia").equalsIgnoreCase("obra")) {
	    	referencia = "obra";
	    }
	    id = Integer.parseInt(request.getParameter("id"));
	    UPLOAD_DIRECTORY = "arquivos" + "/" + referencia + "/";
	    try {
			Conexao.connection.setAutoCommit(false);
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
					+ "/" + id + "/";
			
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
					Foto fotoTemp = Fachada.getInstance().fotoCadastrar(new Foto(0, sessionAdministrador.getId(), id, referencia, "", "", 'S'));
					// se for campo de arquivo processa aqui
					String fileName = new File(item.getName()).getName();
					String extencao = fileName.substring(fileName.lastIndexOf('.') + 1);
					String filePath = uploadPath + fotoTemp.getId() + "." + extencao;
					String imagem = UPLOAD_DIRECTORY + id + "/" + fotoTemp.getId() + "." + extencao;
					fotoTemp.setImagem(imagem);
					
					// atualizo os dados do cadastro da foto com seu caminho correto
					Fachada.getInstance().fotoAlterar(fotoTemp);
					
					File storeFile = new File(filePath);
					
					// salva o arquivo no hd
					item.write(storeFile);
				}
			}
			Conexao.connection.setAutoCommit(true);
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
		} catch (PontoTuristicoJaCadastradoException e) {
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
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao cadastrar o ponto turistico\");</script>" );
		}
	}

}
