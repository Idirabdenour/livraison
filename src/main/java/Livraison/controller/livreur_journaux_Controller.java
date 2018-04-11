package Livraison.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Livraison.DAO.DepositaireDao;
import Livraison.DAO.JournauxDAO;
import Livraison.DAO.livreurDAO;
import Livraison.model.depositaire;
import Livraison.model.journaux;
import Livraison.model.livreur;

@WebServlet("/livreur_journaux_Controller")
public class livreur_journaux_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public livreur_journaux_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		livreurDAO Fdao=livreurDAO.getInstance();
		String s= (String) request.getAttribute("id");
		int i=Integer.parseInt(s);
		ArrayList<livreur> livreurs=Fdao.findByIdL_Code(i);
		request.setAttribute("livreurs", livreurs);
	
		
		String nextJSP = "/livreurJournaux.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		doGet(request, response);
	}
}
