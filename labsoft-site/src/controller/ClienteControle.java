package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class ClienteControle
 */
@WebServlet("/ClienteControle")
public class ClienteControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, Cliente> listaCliente = new HashMap<>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteControle() {
        super();
        listaCliente.put(01, new Cliente("42345234", "Rua Dias Felizes", "(11)92831932", "Joao Silva", "joao.silva@email.com", 01));
        listaCliente.put(02, new Cliente("42345235", "Rua Dias Áureos", "(11)92831932", "Joao Souza", "joao.souza@email.com", 02));
        listaCliente.put(03, new Cliente("42345236", "Rua Dias Chuvosos", "(11)92831932", "Joao Silvestre", "joao.silvestre@email.com", 03));
        listaCliente.put(04, new Cliente("42345237", "Rua Dias Ruins", "(11)92831932", "Joao Salvador", "joao.salvador@email.com", 04));
        
        // TODO Auto-generated constructor stub
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
