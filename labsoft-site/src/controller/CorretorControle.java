package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corretor;

/**
 * Servlet implementation class CorretorControle
 */
@WebServlet("/CorretorControle")
public class CorretorControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map <Integer, Corretor> list = new HashMap<>();
	
   
    /**
     * Default constructor. 
     *  
    list.add(new NavegadorWeb("Chrome", "Google"));
    list.add(new NavegadorWeb("Firefox", "Mozilla"));
    list.add(new NavegadorWeb("Internet Explorer", "Microsoft"));
    	private int idCorretor;
	private String nome;
	private String telefone;
	private String email;
     */
    public CorretorControle() {
        // TODO Auto-generated constructor stub
    	super();
    	list.put(01, new Corretor(01,"Tomaz Ferreira","11912344321","tomaz.ferreira@hotmail.com", "1234"));
    	list.put(02, new Corretor(02,"Bruno Lopez","11912355321","bruno.lopez@hotmail.com", "1234"));
    	list.put(03, new Corretor(03,"Altenor Oliveira","11912564321","altnor.oliveira@hotmail.com", "1234"));
    	list.put(04, new Corretor(04,"Alberto Ramos","11912904321","alberto.ramos@hotmail.com", "1234"));
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		if (request.getParameter("id")==null){
			
			
			request.setAttribute("list",list );
			RequestDispatcher requestDispatcher =
			getServletContext().getRequestDispatcher("/listaCorretor.jsp");
			requestDispatcher.forward(request, response);
		}
		else{	
		request.setAttribute("corretor",list.get(Integer.valueOf(request.getParameter("id"))));
		RequestDispatcher requestDispatcher =
		getServletContext().getRequestDispatcher("/detalhesCorretor.jsp");
		requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		


	}

}
