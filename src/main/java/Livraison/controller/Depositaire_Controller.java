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
import Livraison.model.depositaire;

@WebServlet("/Depositaire_Controller")
public class Depositaire_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Depositaire_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DepositaireDao Ddao=DepositaireDao.getInstance();
		
		String action=request.getParameter("action");
		String idStr=request.getParameter("id");
		depositaire depositaire =null;
		
		if ("delete".equals(action)) {
			if (idStr != null) {
				int id= Integer.parseInt(idStr);
				Ddao.deleteDepositaire(id);
			}
		}else if ("select".equals(action)) {
			if (idStr != null) {
				int id= Integer.parseInt(idStr);
				depositaire=Ddao.findById(id);
				
				request.setAttribute("depositaire", depositaire);
			}
		}
		
		
		ArrayList<depositaire> depositaires=Ddao.getAlldépositaires();
		request.setAttribute("depositaires", depositaires);
		
		String nextJSP = "/ArticleList.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepositaireDao Ddao=DepositaireDao.getInstance();
		
		String Nom= request.getParameter("Nom");
		String adresse= request.getParameter("adresse");
		String idStr = request.getParameter("ID_Dep");
		String action =request.getParameter("action");
		depositaire depositaire=null;
		
		if ("update".equals(action)) {
			if (idStr!=null) {
				int ID_Dep=Integer.parseInt(idStr);
				depositaire=new depositaire(ID_Dep, Nom, adresse);
				Ddao.updateDépositaire(ID_Dep,depositaire);
			}
		}else {
			depositaire=new depositaire(-1, Nom, adresse);
				Ddao.CreateDepositaire(depositaire);
		}
		
		doGet(request, response);
	}

}
