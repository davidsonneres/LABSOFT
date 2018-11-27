package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;

/**
 * Servlet implementation class ControleCompra
 */
@WebServlet("/ControleCompra")
public class ControleCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleCompra() {
        super();
        clienteDAO = new ClienteDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("type") != null && request.getParameter("type").equals("cpf")) {
			try {
				request.setAttribute("cliente", clienteDAO.findByPrimaryCPF((String) request.getParameter("cpf")));
				request.setAttribute("firstAccess", false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/comprar/telaCompra.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
