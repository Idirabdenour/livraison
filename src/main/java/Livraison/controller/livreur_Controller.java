package Livraison.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Livraison.DAO.DepositaireDao;
import Livraison.DAO.livreurDAO;
import Livraison.model.depositaire;
import Livraison.model.livreur;

@WebServlet("/livreur_Controller")
public class livreur_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public livreur_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		livreurDAO Ldao=livreurDAO.getInstance();
		ArrayList<livreur> livreurs=Ldao.getAllLivreurs();
		request.setAttribute("livreurs", livreurs);
		
		
		String nextJSP = "/livreurList.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//	doGet(request, response);
	}


}
