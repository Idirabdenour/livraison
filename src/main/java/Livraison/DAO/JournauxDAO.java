package Livraison.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Livraison.model.journaux;
import Livraison.model.livreur;

public class JournauxDAO {

	private static String FIND_ALL_Journaux = "SELECT * FROM journaux";
	private static String FIND_BY_ID = "SELECT * FROM journaux WHERE Code=?";
	private static String CREATE_Journal = "INSERT INTO journaux (Titre, prix, categorie) VALUES (?,?,?)";
	private static String UPDATE_journal= "UPDATE journaux SET Titre=?, prix=?, categorie=? WHERE Code=?";
	
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String BD_URL="jdbc:mysql://localhost/livraison";
	
	
	private Connection connection=null;
	private java.sql.PreparedStatement statement =null;
	private ResultSet resultset=null;
	
	/************************Selectionner un client***********************/
	public journaux findById(int Code){
		ArrayList<journaux> journaux = new ArrayList<journaux>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_BY_ID);
			statement.setInt(1, Code);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int Code1 = resultset.getInt("Code");
				String Titre = resultset.getString("Titre");
				int prix = resultset.getInt("prix");
				String categorie = resultset.getString("categorie");
				journaux journau = new journaux(Code1, Titre, prix, categorie);
				journaux.add(journau);
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
	return journaux.get(0);
	}
		/************************Lister les clients***********************/
	public ArrayList<journaux> getAlljournaux(){
		ArrayList<journaux> journaux = new ArrayList<journaux>();
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_ALL_Journaux);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int Code = resultset.getInt("Code");
				String Titre = resultset.getString("Titre");
				int prix = resultset.getInt("prix");
				String categorie = resultset.getString("categorie");
				journaux journau = new journaux(Code, Titre, prix, categorie);
				journaux.add(journau);
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
	return journaux;
	}
	/*****************Ajouter une facture**********************/
	public int CreateJournal(journaux journau) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(CREATE_Journal);
				statement.setString(1, journau.getTitre());
				statement.setInt(2, journau.getPrix());
				statement.setString(3, journau.getCategorie());
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
	/*****************Modifier un client**********************/
	public int updateJournal(int Code,journaux journau) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(UPDATE_journal);
				
				statement.setString(1, journau.getTitre());
				statement.setInt(2, journau.getPrix());
				statement.setString(3, journau.getCategorie());
				statement.setInt(4, journau.getCode());
				
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
	
	public journaux findJournalById() {
		return null;
	}
	
	private static JournauxDAO instance = null;
	private JournauxDAO(){}
	
	public static JournauxDAO getInstance() {
		if(instance==null) {
			instance = new JournauxDAO();
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JournauxDAO Cdao=JournauxDAO.getInstance();
		ArrayList<journaux> clients=Cdao.getAlljournaux();
		System.out.println("Liste des articles : \n");
		System.out.println(clients);
		
		
	}

}