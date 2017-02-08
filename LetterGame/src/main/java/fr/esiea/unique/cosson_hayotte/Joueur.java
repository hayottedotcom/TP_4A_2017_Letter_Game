package fr.esiea.unique.cosson_hayotte;

public class Joueur {
	
	private String derniereLettre;
	private String nom;
	private boolean tour;
	public Joueur(String nom){
		this.nom=nom;
		this.tour=false;
	}
	
	public void setDerniereLettre(String derniereLettre){
		this.derniereLettre=derniereLettre;

	}
	
	public String getDerniereLettre(){
		return derniereLettre;
	}
	
	public String getNom(){
		return nom;
	}
	public void setTour(boolean tour){
		this.tour=tour;
	}
	public boolean getTour(){
		return tour;
	}

}
