package Livraison.model;


public class depositaire {

	private int ID_Article;
	private String Nom_Article;
	private String Categorie;
	private String prix;
	private String Quantite;
	
	
	public depositaire(int ID_Article, String Nom_Article, String Categorie,String prix, String Quantite) {
		super();
		this.ID_Article = ID_Article;
		this.Nom_Article = Nom_Article;
		this.Categorie = Categorie;
		this.prix = prix;
		this.Quantite = Quantite;
	}

	public int getID_Article() {
		return ID_Article;
	}

	public void setID_Article(int ID_Article) {
		this.ID_Article = ID_Article;
	}

	public String getNom_Article() {
		return Nom_Article;
	}

	public void setNom_Article(String Nom_Article) {
		this.Nom_Article = Nom_Article;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String Categorie) {
		this.Categorie = Categorie;
	}

	public String getprix() {
		return prix;
	}

	public void setpris(String prix) {
		this.prix = prix;
	}
	
	public String getQuantite() {
		return Quantite;
	}

	public void setQuantite(String Quantite) {
		this.Quantite = Quantite;
	}


	@Override
	public String toString() {
		return String
				.format("article [ID_Article=%s, ID_Nom=%s, Categorie=%s, Quantite=%s]",
						ID_Article, Nom_Article, Categorie, Quantite);
	}
	
	/*
	public String toString() {
		return Nom_Article;
	}*/
	
		
}

