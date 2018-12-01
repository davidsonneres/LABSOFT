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
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.CorretorDAO;
import dao.CorretoraDAO;
import dao.VeiculoDAO;
import dao.AcessorioDAO;
import dao.ApoliceDAO;
import model.Acessorio;
import model.Apolice;
import model.Cliente;
import model.Compra;
import util.Calcula;

/**
 * Servlet implementation class ControleCompra
 */
@WebServlet("/ControleCompra")
public class ControleCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;   
    private VeiculoDAO veiculoDAO;
    private AcessorioDAO acessorioDAO;
    private CompraDAO compraDAO;
    private ApoliceDAO apoliceDAO;
    private CorretoraDAO corretoraDAO;
    private CorretorDAO corretorDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleCompra() {
        super();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
        acessorioDAO = new AcessorioDAO();
        compraDAO = new CompraDAO();
        apoliceDAO = new ApoliceDAO();
        corretoraDAO = new CorretoraDAO();
        corretorDAO = new CorretorDAO();
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
		
	    // Create a session object if it is already not  created.
	    HttpSession session = request.getSession(true);
	    
	    String confirm = (String) request.getAttribute("confirm");
	    if (confirm == null) {
	    	Compra compra = new Compra();
			try {
				compra.setCliente(clienteDAO.findByPrimaryCPF((String) request.getParameter("cpf")));
				compra.setVeiculo(veiculoDAO.findByPrimaryKey((String) request.getParameter("renavam")));
				String tipoValor = (String) request.getParameter("tipo-valor");
				
				compra.setTipoValor(tipoValor);
				float valorCobertura = 0;
				if (tipoValor.equals("Determinado")) {
					valorCobertura = Float.valueOf((String) request.getParameter("valor-determinado"));
					compra.setValorDeterminado(valorCobertura);
				} else {
					valorCobertura = compra.getVeiculo().getFipe().getValorFIPE();
				}
				
				List<Acessorio> acessorioList = new ArrayList<>();
				
				float valorAcessorios = 0;
				if (request.getParameter("vidro") != null) {
					Acessorio acessorio = acessorioDAO.findByType("Vidro");
					acessorioList.add(acessorio);
					valorAcessorios += acessorio.getValorAcessorio();
				}
				
				if (request.getParameter("retrovisor") != null) {
					Acessorio acessorio = acessorioDAO.findByType("Retrovisor");
					acessorioList.add(acessorio);
					valorAcessorios += acessorio.getValorAcessorio();
				}
				
				compra.setTipoFranquia((String) request.getParameter("franquia"));
				compra.setValorCobertura(valorCobertura);
				double premioLiquido = Calcula.premioLiquido(valorCobertura, compra.getTipoFranquia(), calculaIdade(compra.getCliente().getDataNascimento(), new java.util.Date()), valorAcessorios, 100000);
				compra.setValorLiquidoPremios((float) premioLiquido);
				compra.setValorIOF((float) Calcula.calculaIOF(premioLiquido));
				compra.setAcessorios(acessorioList);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("compra", compra);
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/comprar/telaConfirmarPedido.jsp");
			requestDispatcher.forward(request, response);
	    } else {
	    	Compra compra = (Compra) session.getAttribute("compra");
	    	try {
				compra.setIdCompra(compraDAO.getLastCompraId() + 1);
				Apolice apolice = new Apolice();
				apolice.setId(apoliceDAO.getLastApoliceId() + 1);
				apolice.setStatus("Pendente");
				apoliceDAO.create(apolice);
				
				compra.setApolice(apolice);
				compra.setCorretor(corretorDAO.findByPrimaryCPF("319.032.943-55"));
				compra.setCorretora(corretoraDAO.findByPrimaryKey("29.777.007/0001-04"));
				
		    	compraDAO.create(compra);
		    	session.removeAttribute("compra");
		    	
		    	request.setAttribute("successCompra", true);
		    	
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaInicial.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

	private int calculaIdade(Date nascimento, java.util.Date hoje) {
		int anoNascimento = Integer.valueOf(nascimento.toString().split("-")[0]);
		int anoHoje =  hoje.getYear();
		return anoHoje - anoNascimento;
	}

}
