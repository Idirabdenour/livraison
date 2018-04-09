package Livraison.model;


public class journaux {

	private int Code;
	private String Titre;
	private int prix;
	private String categorie;
	
	
	
	public journaux(int Code, String Titre, int prix, String categorie) {
		super();
		this.Code = Code;
		this.Titre = Titre;
		this.prix = prix;
		this.categorie = categorie;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int Code) {
		this.Code = Code;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String Titre) {
		this.Titre = Titre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

/*
	@Override
	public String toString() {
		return String
				.format("article [ID_Client=%s, Nom=%s, Prenom=%s]",
						ID_Client, Nom, Prenom);
	}
	*/
	public String toString() {
		return Titre;
	}
	
	
		
}

