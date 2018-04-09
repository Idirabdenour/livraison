package Livraison.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Livraison.model.depositaire;

public class DepositaireDao {
	
	private static String FIND_ALL_Article = "SELECT * FROM article";
	private static String FIND_BY_ID = "SELECT * FROM article WHERE ID_Article=?";
	private static String CREATE_Article = "INSERT INTO article (Nom_Article, Categorie, prix,Quantite) VALUES (?,?,?,?)";
	private static String UPDATE_Article = "UPDATE article SET Nom_Article=?, Categorie=?, prix=?, Quantite=? WHERE ID_Article=?";
	private static String DELETE_Article = "DELETE FROM article WHERE ID_Article=?";
	
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String BD_URL="jdbc:mysql://localhost/test2";
	
	
	private Connection connection=null;
	private PreparedStatement statement =null;
	private ResultSet resultset=null;
	
	/************************Selectionner un articles***********************/
	public depositaire findById(int ArticleId){
		ArrayList<depositaire> articles = new ArrayList<depositaire>();
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_BY_ID);
			statement.setInt(1, ArticleId);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Article = resultset.getInt("ID_Article");
				String Nom_Article = resultset.getString("Nom_Article");
				String Categorie = resultset.getString("Categorie");
				String prix = resultset.getString("prix");
				String Quantite = resultset.getString("Quantite");
				depositaire article = new depositaire(ID_Article, Nom_Article, Categorie, prix, Quantite);
				articles.add(article);
			}
			resultset.close();
			statement.close();
			connection.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return articles.get(0);
	}
		/************************Lister les articles***********************/
	public ArrayList<depositaire> getAllarticle(){
		ArrayList<depositaire> article = new ArrayList<Livraison.model.depositaire>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_ALL_Article);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Article = resultset.getInt("ID_Article");
				String Nom_Article = resultset.getString("Nom_Article");
				String Categorie = resultset.getString("Categorie");
				String prix = resultset.getString("prix");
				String Quantite = resultset.getString("Quantite");
				depositaire articles = new depositaire(ID_Article, Nom_Article, Categorie, prix, Quantite);
				article.add(articles);
			}
			resultset.close();
			statement.close();
			connection.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return article;
	}
	/*****************Ajouter un Article**********************/
	public int CreateArticle(depositaire article) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(CREATE_Article);
				statement.setString(1, article.getNom_Article());
				statement.setString(2, article.getCategorie());
				statement.setString(3, article.getprix());
				statement.setString(4, article.getQuantite());
				result = statement.executeUpdate();
				statement.close();
				connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/*****************Modifier un article**********************/
	public int updateArticle(int ArticleId,depositaire article) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(UPDATE_Article);
				statement.setString(1, article.getNom_Article());
				statement.setString(2, article.getCategorie());
				statement.setString(3, article.getprix());
				statement.setString(4, article.getQuantite());
				statement.setInt(5, ArticleId);
				result = statement.executeUpdate();
				statement.close();
				connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/*****************Supprimer un article********************/
	public int deleteArticle(int ArticleId){
		int result = -1;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=  (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(DELETE_Article);
				statement.setInt(1, ArticleId);
				result = statement.executeUpdate();
				statement.close();
				connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public depositaire findArticleById() {
		return null;
	}
	
	private static DepositaireDao instance = null;
	private DepositaireDao(){}
	
	public static DepositaireDao getInstance() {
		if(instance==null) {
			instance = new DepositaireDao();
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepositaireDao Adao=DepositaireDao.getInstance();
		ArrayList<depositaire> articles=Adao.getAllarticle();
		System.out.println("Liste des articles : \n");
		depositaire ar=Adao.findById(1);
		System.out.println(ar.getNom_Article());
		
	}

}
