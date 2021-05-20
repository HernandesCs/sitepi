package br.pi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pi.dao.DaoContato;
import br.pi.pojo.Contato;


/**
 * Servlet implementation class ServletInserir
 */
@WebServlet("/ServletInserir")
public class ServletInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInserir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// obtem os parametros
			String nome = request.getParameter("nome");
			String foneStr = request.getParameter("fone");
			String email = request.getParameter("email");
			// converte os valores de String para os tipos corretos
			int fone = Integer.parseInt(foneStr);	

			Contato contato = new Contato (nome,fone,email);

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Resultado do cadastro</title>");
			out.println("</head>");
			out.println("<body>");
			
			DaoContato dao = new DaoContato();
			if ( dao.inserirContato(contato)) {
				out.println("inserido com sucesso");	
			} else {
				out.println("nao inserido");
			}
			out.println("</body>");
			out.println("</html>");
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
