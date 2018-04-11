package Livraison.model;

import java.sql.Date;

public class livreur {

	private int ID_Liv;
	private String parcours;
	private int ID_Dep;
	private int Code;
	
	
	
	public livreur(int ID_Liv, String parcours, int ID_Dep, int Code) {
		super();
		this.ID_Liv = ID_Liv;
		this.parcours = parcours;
		this.ID_Dep = ID_Dep;
		this.Code = Code;
	}

	public int getID_Liv() {
		return ID_Liv;
	}

	public void setID_Liv(int ID_Liv) {
		this.ID_Liv = ID_Liv;
	}

	public String getparcours() {
		return parcours;
	}

	public void setparcours(String parcours) {
		this.parcours = parcours;
	}

	

	public int getID_Dep() {
		return ID_Dep;
	}

	public void setID_Dep(int ID_Dep) {
		this.ID_Dep = ID_Dep;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int Code) {
		this.Code = Code;
	}

	@Override
	public String toString() {
		return String
				.format("livreurs [ID_Dep=%s, parcours=%s, ID_Dep=%s, Code=%s]",
						ID_Liv, parcours, ID_Dep,Code );
	}
	
	/*public String toString() {
		return ID_facture;
	}*/
	
	
		
}
