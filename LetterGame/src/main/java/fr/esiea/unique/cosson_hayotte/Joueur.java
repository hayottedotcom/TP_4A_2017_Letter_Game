package fr.esiea.unique.cosson_hayotte;

public class Joueur {
	
	private String derniereLettre;
	private String nom;
	public Joueur(String nom){
		this.nom=nom;
	}
	
	public void setDerniereLettre(String derniereLettre){
		this.derniereLettre=derniereLettre;
	}
	
	public String getDernereLettre(){
		return derniereLettre;
	}
	
	public String getNom(){
		return nom;
	}

}
