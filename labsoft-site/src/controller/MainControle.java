package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.CorretorDAO;
import model.Cliente;
import model.Corretor;

/**
 * Servlet implementation class MainControle
 */
@WebServlet("/")
public class MainControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClienteDAO clienteDAO;
	private CorretorDAO corretorDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainControle() {
        super();
        // TODO Auto-generated constructor stub
        clienteDAO = new ClienteDAO();
        corretorDAO = new CorretorDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    // Create a session object if it is already not  created.
	    HttpSession session = request.getSession(true);
	    
	    String permission = (String) session.getAttribute("permission");
	    Object logout = request.getParameter("logout");
	    if (permission != null) {
	    	if (logout == null) {
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaInicial.jsp");
				requestDispatcher.forward(request, response);
	    	} else {
	    		session.invalidate();
	    		response.sendRedirect("/labsoft-site");
	    	}

	    } else {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
	    // Create a session object if it is already not  created.
	    HttpSession session = request.getSession(true);
	    
	    String cpf = (String) request.getParameter("cpf");
	    String senha = (String) request.getParameter("senha");
	    Cliente cliente = null;
	    Corretor corretor = null;
		try {
			cliente = clienteDAO.findByPrimaryCPF(cpf);
			corretor = corretorDAO.findByPrimaryCPF(cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (cliente != null && cliente.getSenha().equals(senha)) {
	    	session.setAttribute("permission", "cliente");
	    	session.setAttribute("first-login", true);
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaInicial.jsp");
			requestDispatcher.forward(request, response);
	    } else if (corretor != null && corretor.getSenha().equals(senha)) {
	    	session.setAttribute("permission", "corretor");
	    	session.setAttribute("first-login", true);
	    	
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaInicial.jsp");
			requestDispatcher.forward(request, response);
	    } else {
	    	request.setAttribute("login", false);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
	    }
	}

}
