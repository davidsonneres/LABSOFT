package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import dao.ClienteDAO;

/**
 * Servlet implementation class ClienteControle
 */
@WebServlet("/ClienteControle")
public class ClienteControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, Cliente> listaCliente = new HashMap<>();
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteControle() {
        super(); 
        try {
			listaCliente = clienteDAO.getAll();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id") == null){
			request.setAttribute("listaCliente", listaCliente);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listaCliente.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("cliente", listaCliente.get(Integer.valueOf(request.getParameter("id"))));
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/detalhesCliente.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
