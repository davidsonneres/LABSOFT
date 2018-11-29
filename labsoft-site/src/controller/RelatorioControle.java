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
import dao.VeiculoDAO;
import dao.CorretorDAO;
import dao.ApoliceDAO;

public class RelatorioControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;   
    private VeiculoDAO veiculoDAO;
    private CorretorDAO corretorDAO;
    private ApoliceDAO apoliceDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioControle() {
        super();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
        corretorDAO = new CorretorDAO();
        apoliceDAO = new ApoliceDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("type") != null && request.getParameter("type").equals("dataInicial")) {
			try {
				request.setAttribute("apolice", apoliceDAO.findByPrimaryCPF((String) request.getParameter("dataInicial")));
				request.setAttribute("firstAccess", false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (request.getParameter("renavam") != null) {
				try {
					request.setAttribute("veiculo", veiculoDAO.findByPrimaryKey((String) request.getParameter("renavam")));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/comprar/telaCompra.jsp");
		requestDispatcher.forward(request, response);
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
