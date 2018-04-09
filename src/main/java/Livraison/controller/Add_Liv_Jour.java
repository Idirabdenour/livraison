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

@WebServlet("/Add_FacC")
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
		String nextJSP = "/ajoutFacture.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		livreurDAO Fdao=livreurDAO.getInstance();
		
		String Date= req.getParameter("date");
		String ID_Art= req.getParameter("ID_Article");
		//String idStr = request.getParameter("ID_facture");
		String ID_Client = req.getParameter("ID_Client");
		
		String action =req.getParameter("action");
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    
		livreur facture=null;
		
		if ("create".equals(action)) {
				int ID_Article=Integer.parseInt(ID_Art);
				int ID_Client1=Integer.parseInt(ID_Client);
				
				try {
					
					Date date = (Date) format.parse(Date);
					java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
					facture=new livreur(-1, sqlStartDate, ID_Article,ID_Client1);
					Fdao.CreateFacture(facture);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
			
		
		doGet(req, res);
	}

}
