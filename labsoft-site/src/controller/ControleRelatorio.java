package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import dao.CompraDAO;

import model.Compra;

@WebServlet("/ControleRelatorio")
public class ControleRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;   
    private VeiculoDAO veiculoDAO;
    private CorretorDAO corretorDAO;
    private ApoliceDAO apoliceDAO;
    private CompraDAO compraDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleRelatorio() {
        super();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
        corretorDAO = new CorretorDAO();
        apoliceDAO = new ApoliceDAO();
        compraDAO = new CompraDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/relatorio/telaGerarRelatorios.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dataInicioParameter = (String) request.getParameter("data-inicio");
		String dataFimParameter = (String) request.getParameter("data-fim");
		if (!dataInicioParameter.equals("") && !dataFimParameter.equals("")) {
			Date dataInicio = Date.valueOf(dataInicioParameter);
			Date dataFim = Date.valueOf(dataFimParameter);
			
			if (dataFim.after(dataInicio)) {
				List<Compra> compraList = new ArrayList<>();
				try {
					compraList = compraDAO.getByPeriod(dataInicio, dataFim);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("compraList", compraList);
				request.setAttribute("isValid", true);
			} else {
				request.setAttribute("isValid", false);
			}
		} else {
			request.setAttribute("isValid", false);
		}
		

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/relatorio/telaGerarRelatorios.jsp");
		requestDispatcher.forward(request, response);
	}
}
	