package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = {"/Controller" , "/main" ,"/listaContatos" ,"/pages/insert", "/Excluir", "/select", "/edit" , "/baixar"})

public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
       /** The dao. */
       DAO dao = new DAO();
       
       /** The contato. */
       JavaBeans contato = new JavaBeans();
       
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/pages/agenda.jsp").forward(request, response);
		
//		Teste de Coneção
//		dao.TesteCon();
		
		String requisicao = request.getServletPath();
		System.out.println(requisicao);
		
		
		if (requisicao.equals("/main")) {
			contatos(request, response);
		}
		else if (requisicao.equals("/listaContatos")) {
			listaContatos(request, response);
		}
		else if(requisicao.equals("/pages/insert")) {
			novoContato(request, response);
		}else if (requisicao.equals("/select")) {
			select(request, response);
		}	
		else if (requisicao.equals("/Excluir")) {
			delete(request, response);
		}
		else if (requisicao.equals("/edit")) {
			edit(request, response);
		}
		else if (requisicao.equals("/baixar")) {
			GerarPdf(request, response);
		}
		else {
			System.out.println(requisicao);
//			response.sendRedirect("index.html");
		}
		

	}
	
	/**
	 * Delete.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Pegando o Id
		int id = Integer.parseInt(request.getParameter("id"));
//		Chamando o Metodo de Deletar
		dao.Excluir(id);
		
		listaContatos(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("pages/listaContatos.jsp");
//		rd.forward(request, response);
	}

	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("pages/agenda.jsp");
	}
	
	/**
	 * Select.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaBeans EditarContato = dao.BuscarId(Integer.parseInt(request.getParameter("id")));
//		Passando as Informção para o Front
		request.setAttribute("id", EditarContato.getId());
		request.setAttribute("nome", EditarContato.getNome());
		request.setAttribute("fone", EditarContato.getFone());
		request.setAttribute("email", EditarContato.getEmail());
		
//		Redireciona para Editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("pages/editar.jsp");
		rd.forward(request, response);
	}
		
	
	/**
	 * Lista contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listaContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("pages/listaContatos.jsp");
		
//		Criando um Objeto que ira receber os dados da Class JavaBeans
			ArrayList<JavaBeans> lista = dao.listaContatos();
			request.setAttribute("lista", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("pages/listaContatos.jsp");
			rd.forward(request, response);
			

		
		
	}

/**
 * Novo contato.
 *
 * @param request the request
 * @param response the response
 * @throws ServletException the servlet exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
//	Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Teste de recebimento de dados do formulario novo.html
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("email"));
		
		
//		Setar os Atributos da Class JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
//		Invocar os Método de inserir Contato Passando o Objeto Contato
		dao.InserirContato(contato);
		
//		Redirecionar para agenta contatos
		response.sendRedirect("../index.html");
		
//		dao.ReadContato();
		
	}
	
	/**
	 * Edits the.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Pegando os Paremetros
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		
//		Chamando o Dao para dar update
		dao.Update(new JavaBeans(id,nome,fone,email));
		
//		Chamando a ListaContatos
		listaContatos(request, response);
	}
	
	/**
	 * Gerar pdf.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void GerarPdf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document documento = new Document();
		try {
//			Nome do Aquivo
			response.setContentType("contatos/pdf");
			
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			
//			Criar o Document
			PdfWriter.getInstance(documento, response.getOutputStream());
			
//			Abrir o Documento
			documento.open();
			documento.add(new Paragraph(""));
			
			
//			Criar Tabela
			PdfPTable tabela = new PdfPTable(3);
			
			PdfPCell nome = new PdfPCell(new Paragraph("Nome"));
			PdfPCell fone = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell email = new PdfPCell(new Paragraph("Email"));
			
//			Criando as Colunas
			tabela.addCell(nome);
			tabela.addCell(fone);
			tabela.addCell(email);
			
//			Pegando a Lista
			ArrayList<JavaBeans> lista = dao.listaContatos();
			for(int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
			}
			
//			Adicionando a Tabela no Documento
			documento.add(tabela);
			documento.close();
			
		} catch (Exception e) {
			documento.close();
		}
	}
	
}
