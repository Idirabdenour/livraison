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

	
	private static String FIND_ALL_livreurs = "SELECT * FROM livreurs";
	private static String Select_journaux_livreurs  = "SELECT * FROM livreurs where ID_Liv=?";
	private static String CREATE_livreur = "INSERT INTO livreurs (parcours, ID_Dep, Code) VALUES (?,?,?)";
	
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String BD_URL="jdbc:mysql://localhost/livraison";
	
	private Connection connection=null;
	private PreparedStatement statement =null;
	private ResultSet resultset=null;
	
	/*****************Ajouter une facture**********************/
	public int CreateLivreur(livreur livreur) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(CREATE_livreur);
				statement.setString(1, livreur.getparcours());
				statement.setInt(2, livreur.getID_Dep());
				statement.setInt(3, livreur.getID_Liv());
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
	public ArrayList<livreur> getAllLivreurs(){
		ArrayList<livreur> livreur = new ArrayList<Livraison.model.livreur>();
	
		try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_ALL_livreurs);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Liv = resultset.getInt("ID_Liv");
				String parcours = resultset.getString("parcours");
				int ID_Dep = resultset.getInt("ID_Dep");
				int Code = resultset.getInt("code");
				livreur livreurs = new livreur(ID_Liv, parcours, ID_Dep, Code);
				livreur.add(livreurs);
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
	return livreur;
	}
	
	/************************Selectionner les factures d'un client***********************/
	public ArrayList<livreur> findByIdL_Code(int Codej){
		ArrayList<livreur> livreur = new ArrayList<livreur>();
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(Select_journaux_livreurs);
			statement.setInt(1, Codej);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Liv = resultset.getInt("ID_Liv");
				String parcours = resultset.getString("parcours");
				int ID_Dep = resultset.getInt("ID_Dep");
				int Code = resultset.getInt("code");
				livreur livreurs = new livreur(ID_Liv, parcours, ID_Dep, Code);
				livreur.add(livreurs);
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
	return livreur;
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
		livreurDAO Ldao=livreurDAO.getInstance();
		ArrayList<livreur> livreurs=Ldao.getAllLivreurs();
		System.out.println("Liste des factures : \n");
		System.out.println(livreurs);
		
		
		System.out.println("Liste des articles : \n");
			ArrayList<livreur>  cl=Ldao.findByIdL_Code(1);
			System.out.println(cl);
	}

	
}
