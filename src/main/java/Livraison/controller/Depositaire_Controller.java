package Livraison.controller;

import java.io.IOException;
import java.util.ArrayList;

import Livraison.DAO.DepositaireDao;
import Livraison.model.depositaire;

@WebServlet("/ArticleController")
public class Depositaire_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Depositaire_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DepositaireDao Adao=DepositaireDao.getInstance();
		
		String action=request.getParameter("action");
		String idStr=request.getParameter("id");
		depositaire article =null;
		
		if ("delete".equals(action)) {
			if (idStr != null) {
				int id= Integer.parseInt(idStr);
				Adao.deleteArticle(id);
			}
		}else if ("select".equals(action)) {
			if (idStr != null) {
				int id= Integer.parseInt(idStr);
				article=Adao.findById(id);
				
				request.setAttribute("article", article);
			}
		}
		
		
		ArrayList<depositaire> articles=Adao.getAllarticle();
		request.setAttribute("articles", articles);
		
		String nextJSP = "/ArticleList.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepositaireDao Adao=DepositaireDao.getInstance();
		
		String Nom_Article= request.getParameter("Nom_Article");
		String Categorie= request.getParameter("Categorie");
		String prix= request.getParameter("prix");
		String Quantite= request.getParameter("Quantite");
		String idStr = request.getParameter("ID_Article");
		String action =request.getParameter("action");
		depositaire article=null;
		
		if ("update".equals(action)) {
			if (idStr!=null) {
				int ID_Article=Integer.parseInt(idStr);
				article=new depositaire(ID_Article, Nom_Article, Categorie, prix, Quantite);
				Adao.updateArticle(ID_Article,article);
			}
		}else {
				article=new depositaire(-1, Nom_Article, Categorie,prix, Quantite);
				Adao.CreateArticle(article);
		}
		
		doGet(request, response);
	}

}
