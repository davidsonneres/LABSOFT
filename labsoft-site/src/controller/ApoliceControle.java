package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Apolice;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/ApoliceControle")
public class ApoliceControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Apolice> apoliceList = new ArrayList<>();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApoliceControle() {
        super();
        // TODO Auto-generated constructor stub
        apoliceList.add(new Apolice(new Date(1535496984907l), new Date(1539496984907l), "encerrada"));
        apoliceList.add(new Apolice(new Date(1530096984907l), new Date(1530096984907l), "ativa"));
        apoliceList.add(new Apolice(new Date(1530096984907l), new Date(1534096984907l), "encerrada"));
        apoliceList.add(new Apolice(new Date(1530096984907l), new Date(154696984907l), "cancelada"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("id") == null) {
			request.setAttribute("apoliceList", apoliceList);
			RequestDispatcher requestDispacher = getServletContext().getRequestDispatcher("/apolices.jsp");
			requestDispacher.forward(request, response);
		} else {
			request.setAttribute("apolice", apoliceList.get(Integer.valueOf(request.getParameter("id"))));
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/detalhe_apolice.jsp");
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
