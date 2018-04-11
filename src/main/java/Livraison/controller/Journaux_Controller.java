package Livraison.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Livraison.DAO.JournauxDAO;
import Livraison.DAO.livreurDAO;
import Livraison.model.journaux;
import Livraison.model.livreur;

@WebServlet("/Journaux_Controller")
public class Journaux_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Journaux_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	JournauxDAO Jdao=JournauxDAO.getInstance();
	livreurDAO Fdao=livreurDAO.getInstance();
		
		String action=request.getParameter("action");
		String idStr=request.getParameter("id");
		journaux journal =null;
		journaux journaux = null;
		
		 if ("select".equals(action)) {
			if (idStr != null) {
				int id= Integer.parseInt(idStr);
				journal=Jdao.findById(id);
				request.setAttribute("journal", journal);
				journaux=Jdao.findById(id);
				System.out.println("effffffffffffff"+journaux);
				request.setAttribute("journaux", journaux);
			}
		}
		 
		
		ArrayList<journaux> journau=Jdao.getAlljournaux();
		request.setAttribute("journaux", journau);
		
		String nextJSP = "/journauxList.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JournauxDAO Jdao=JournauxDAO.getInstance();
		
		String Titre= request.getParameter("Titre");
		String prix= request.getParameter("prix");
		String categorie= request.getParameter("categorie");
		
		String idStr = request.getParameter("Code");
		String action =request.getParameter("action");
		journaux journal=null;
		
		
		if ("update".equals(action)) {
			if (idStr!=null) {
				
				int Code=Integer.parseInt(idStr);
				int Prix=Integer.parseInt(prix);
				
				journal=new journaux(Code, Titre, Prix,categorie);
				Jdao.updateJournal(Code,journal);
			
			}
		}else if ("facture".equals(action)) {
			if (idStr!=null) {
				
				request.setAttribute("id", idStr);
				RequestDispatcher rd = request.getRequestDispatcher("/livreur_journaux_Controller");
				rd.forward(request, response);
			
			}
		}
		else if ("ajout".equals(action)) {
			if (idStr!=null) {
				
				request.setAttribute("id", idStr);
				RequestDispatcher rd = request.getRequestDispatcher("/Add_FacC");
				rd.forward(request, response);
			
			}
		}
		doGet(request, response);
	}
	
}
