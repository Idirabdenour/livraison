package Livraison.model;

import java.sql.Date;

public class livreur {

	private int ID_facture;
	private Date date;
	private int ID_Article;
	private int ID_Client;
	
	
	
	public livreur(int ID_facture, Date date, int ID_Article, int ID_Client) {
		super();
		this.ID_facture = ID_facture;
		this.date = date;
		this.ID_Article = ID_Article;
		this.ID_Client = ID_Client;
	}

	public int getID_facture() {
		return ID_facture;
	}

	public void setID_facture(int ID_facture) {
		this.ID_facture = ID_facture;
	}

	public Date getdate() {
		return date;
	}

	public void setdate(Date date) {
		this.date = date;
	}

	

	public int getID_Article() {
		return ID_Article;
	}

	public void setID_Article(int ID_Article) {
		this.ID_Article = ID_Article;
	}

	public int getID_Client() {
		return ID_Client;
	}

	public void setID_Client(int ID_Client) {
		this.ID_Client = ID_Client;
	}

	@Override
	public String toString() {
		return String
				.format("facture [ID_facture=%s, date=%s, ID_Article=%s, ID_Client=%s]",
						ID_facture, date, ID_Article,ID_Client );
	}
	
	/*public String toString() {
		return ID_facture;
	}*/
	
	
		
}
