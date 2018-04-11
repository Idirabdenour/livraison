package Livraison.model;


public class depositaire {

	private int ID_Dep;
	private String Nom;
	private String adresse;
	
	
	public depositaire(int ID_Dep, String Nom, String adresse) {
		super();
		this.ID_Dep = ID_Dep;
		this.Nom = Nom;
		this.adresse = adresse;
		
	}

	public int getID_Dep() {
		return ID_Dep;
	}

	public void setID_Dep(int ID_Article) {
		this.ID_Dep = ID_Article;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom_Article) {
		this.Nom = Nom_Article;
	}

	public String getadresse() {
		return adresse;
	}

	public void setadresse(String Categorie) {
		this.adresse = Categorie;
	}

	

	@Override
	public String toString() {
		return String
				.format("dépositaires [ID_Dep=%s, nom=%s, adresse=%s]",
						ID_Dep, Nom, adresse);
	}
	
	/*
	public String toString() {
		return Nom_Article;
	}*/
	
		
}

