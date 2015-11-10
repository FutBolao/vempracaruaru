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
import br.com.vempracaruaru.destaque.Destaque;
import br.com.vempracaruaru.exception.BusinessException;
import br.com.vempracaruaru.exception.DestaqueNaoCadastradoException;
import br.com.vempracaruaru.exception.NaoFoiPossivelCadastrarDestaqueException;
import br.com.vempracaruaru.fachada.Fachada;

/**
 * Servlet implementation class DestaqueCadastrar
 */
@WebServlet("/DestaqueAlterar")
public class DestaqueAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "arquivos" + "/" + "destaques" + "/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestaqueAlterar() {
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
		
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
	    String titulo = "";
		String link = "";
		String arquivo = "";
		try {
			Conexao.connection.setAutoCommit(false);
			
			// configura algumas definições
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(THRESHOLD_SIZE);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(REQUEST_SIZE);
			
			// constrói o caminho do diretório para o arquivo de upload
			String uploadPath = getServletContext().getRealPath("") + "/" + UPLOAD_DIRECTORY;
			
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
				if (!item.isFormField() && item.getSize() > 0) {
					// se for campo de arquivo processa aqui
					String fileName = new File(item.getName()).getName();
					String extencao = fileName.substring(fileName.lastIndexOf('.') + 1);
					String filePath = uploadPath + id + "." + extencao;
					arquivo = UPLOAD_DIRECTORY + id + "." + extencao;
					File storeFile = new File(filePath);
					
					// salva o arquivo no hd
					item.write(storeFile);
				}else if (item.getFieldName().equals("campoTitulo")) {
					titulo = item.getString();
				} else if (item.getFieldName().equals("campoLink")) {
					link = item.getString();
				} else if (item.getFieldName().equals("campoImagemString")) {
					arquivo = item.getString();
				}
			}
			System.out.println("ARQUIVO 2"+ arquivo);
			Fachada.getInstance().destaqueAlterar(new Destaque(id, sessionAdministrador.getId(), titulo, arquivo, link));
			Conexao.connection.setAutoCommit(true);
			out.println( "<script>parent.alert(\"Alteração efetuada com sucesso!!!\");</script>" );
			out.println( "<script>parent.location.href = \"sistema/destaqueListar.jsp\";</script>" );
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
		} catch (DestaqueNaoCadastradoException e) {
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
			out.println( "<script>parent.alert(\"Ocorreu um erro inesperado ao alterar o destaque\");</script>" );
		}
	}
}
