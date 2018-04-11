package Livraison.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Livraison.DAO.JournauxDAO;
import Livraison.DAO.livreurDAO;
import Livraison.model.livreur;

@WebServlet("/Add_Liv_Jour")
public class Add_Liv_Jour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public Add_Liv_Jour() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	/*	FactureDAO Fdao=FactureDAO.getInstance();
		
		ArrayList<facture> facture=Fdao.getAllfacture();
		request.setAttribute("facture", facture);
		if (facture.size()!=0) {
			
	*/	
		String nextJSP = "/ajoutLivreur.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		doGet(req, res);
	}

}
