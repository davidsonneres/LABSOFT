package controller;

import java.io.IOException;
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
import dao.AcessorioDAO;
import model.Acessorio;
import model.Cliente;
import model.Compra;

/**
 * Servlet implementation class ControleCompra
 */
@WebServlet("/ControleCompra")
public class ControleCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;   
    private VeiculoDAO veiculoDAO;
    private AcessorioDAO acessorioDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleCompra() {
        super();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
        acessorioDAO = new AcessorioDAO();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Compra compra = new Compra();
		try {
			compra.setCliente(clienteDAO.findByPrimaryCPF((String) request.getParameter("cpf")));
			compra.setVeiculo(veiculoDAO.findByPrimaryKey((String) request.getParameter("renavam")));
			String tipoValor = (String) request.getParameter("tipo-valor");
			compra.setTipoValor(tipoValor);
			if (tipoValor.equals("Determinado")) {
				compra.setValorDeterminado(Float.valueOf((String) request.getParameter("valor-determinado")));
			}
			
			List<Acessorio> acessorioList = new ArrayList<>();
			System.out.println((String) request.getParameter("vidro"));
			System.out.println((String) request.getParameter("retrovisor"));
			
			if (request.getParameter("vidro") != null) {
				acessorioList.add(acessorioDAO.findByType("Vidro"));
			}
			
			if (request.getParameter("retrovisor") != null) {
				acessorioList.add(acessorioDAO.findByType("Retrovisor"));
			}
			
			compra.setAcessorios(acessorioList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("compra", compra);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/comprar/telaConfirmarPedido.jsp");
		requestDispatcher.forward(request, response);
	}


}
