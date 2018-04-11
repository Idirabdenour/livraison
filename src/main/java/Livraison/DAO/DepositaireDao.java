package Livraison.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Livraison.model.depositaire;

public class DepositaireDao {
	
	private static String FIND_ALL_Dep = "SELECT * FROM dépositaires";
	private static String FIND_BY_ID = "SELECT * FROM dépositaires WHERE ID_Dep=?";
	private static String CREATE_dépositaires = "INSERT INTO dépositaires (nom, adresse) VALUES (?,?)";
	private static String UPDATE_dépositaires = "UPDATE dépositaires SET nom=?, adresse=? WHERE ID_Dep=?";
	private static String DELETE_dépositaires = "DELETE FROM dépositaires WHERE ID_Dep=?";
	
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String BD_URL="jdbc:mysql://localhost/livraison";
	
	
	private Connection connection=null;
	private PreparedStatement statement =null;
	private ResultSet resultset=null;
	
	/************************Selectionner un articles***********************/
	public depositaire findById(int ID_Dep){
		ArrayList<depositaire> dépositaires = new ArrayList<depositaire>();
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_BY_ID);
			statement.setInt(1, ID_Dep);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Dep1 = resultset.getInt("ID_Dep");
				String nom = resultset.getString("nom");
				String adresse = resultset.getString("adresse");
				depositaire depositaire = new depositaire(ID_Dep1, nom,adresse);
				dépositaires.add(depositaire);
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
	return dépositaires.get(0);
	}
		/************************Lister les articles***********************/
	public ArrayList<depositaire> getAlldépositaires(){
		ArrayList<depositaire> dépositaire = new ArrayList<Livraison.model.depositaire>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection =(Connection) DriverManager.getConnection(BD_URL, user, password);
			
			statement =(PreparedStatement) connection.prepareStatement(FIND_ALL_Dep);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int ID_Dep1 = resultset.getInt("ID_Dep");
				String nom = resultset.getString("nom");
				String adresse = resultset.getString("adresse");
				depositaire depositaire = new depositaire(ID_Dep1, nom,adresse);
				dépositaire.add(depositaire);
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
	return dépositaire;
	}
	/*****************Ajouter un Article**********************/
	public int CreateDepositaire(depositaire dépositaire) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(CREATE_dépositaires);
				statement.setString(1, dépositaire.getNom());
				statement.setString(2, dépositaire.getadresse());
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
	public int updateDépositaire(int ID_Dep,depositaire dépositaire) {
		int result=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection= (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(UPDATE_dépositaires);
				statement.setString(1, dépositaire.getNom());
				statement.setString(2, dépositaire.getadresse());
				statement.setInt(5, ID_Dep);
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
	public int deleteDepositaire(int ID_Dep){
		int result = -1;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=  (Connection) DriverManager.getConnection(BD_URL, user, password);
				statement=(PreparedStatement) connection.prepareStatement(DELETE_dépositaires);
				statement.setInt(1, ID_Dep);
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
		DepositaireDao Ddao=DepositaireDao.getInstance();
		ArrayList<depositaire> dépositaires=Ddao.getAlldépositaires();
		System.out.println("Liste des dépositaires : \n"+ dépositaires);
		depositaire de=Ddao.findById(1);
		System.out.println(de.getNom());
		
	}

}
