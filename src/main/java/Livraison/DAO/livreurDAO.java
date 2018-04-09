package Livraison.DAO;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Livraison.model.livreur;

public class livreurDAO {

	
	private static String FIND_ALL_Facture = "SELECT * FROM facture";
	private static String Select_Client_Facture  = "SELECT * FROM facture where ID_Client=?";
	private static String CREATE_Facture = "INSERT INTO facture (date, ID_Article, ID_Client) VALUES (?,?,?)";
	
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String BD_URL="jdbc:mysql://localhost/test2";
	
	private Connection connection=null;
	private PreparedStatement statement =null;
	private ResultSet resultset=null;
	
	/*****************Ajouter une facture**********************/
	public int CreateFacture(livreur facture) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(CREATE_Facture);
				statement.setDate(1, facture.getdate());
				statement.setInt(2, facture.getID_Article());
				statement.setInt(3, facture.getID_Client());
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
		/************************Lister des Factures***********************/
	public ArrayList<livreur> getAllfacture(){
		ArrayList<livreur> facture = new ArrayList<Livraison.model.livreur>();
	
		try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_ALL_Facture);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_facture = resultset.getInt("ID_facture");
				Date date = resultset.getDate("date");
				int ID_Client = resultset.getInt("ID_Client");
				int ID_Article = resultset.getInt("ID_Article");
				livreur factures = new livreur(ID_facture, date,ID_Article , ID_Client);
				facture.add(factures);
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
	return facture;
	}
	
	/************************Selectionner les factures d'un client***********************/
	public ArrayList<livreur> findByIdF_IdC(int ClientID){
		ArrayList<livreur> factures = new ArrayList<livreur>();
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(Select_Client_Facture);
			statement.setInt(1, ClientID);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_facture = resultset.getInt("ID_facture");
				Date date  = resultset.getDate("date");
				int ID_Article = resultset.getInt("ID_Article");
				int ID_Client = resultset.getInt("ID_Client");
				livreur facture = new livreur(ID_facture, date , ID_Article, ID_Client);
				factures.add(facture);
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
	return factures;
	}
	
	
	public livreur findFactureById() {
		return null;
	}
	
	private static livreurDAO instance = null;
	private livreurDAO(){}
	
	public static livreurDAO getInstance() {
		if(instance==null) {
			instance = new livreurDAO();
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		livreurDAO Fdao=livreurDAO.getInstance();
		ArrayList<livreur> factures=Fdao.getAllfacture();
		System.out.println("Liste des factures : \n");
		System.out.println(factures);
		
		
		System.out.println("Liste des articles : \n");
			ArrayList<livreur>  cl=Fdao.findByIdF_IdC(1);
			System.out.println(cl);
	}

	
}
