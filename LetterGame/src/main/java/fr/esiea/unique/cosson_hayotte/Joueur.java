package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
	private String derniereLettre;
	private String nom;
	private List<String> listeMots= new ArrayList<String>();
	private boolean tour;
	public Joueur(String nom){
		this.nom=nom;
		this.tour=false;
	}
	
	public void addMotDansListe(String mot){
		listeMots.add(mot);
	}
	
	public void afficheListeMots(){
		System.out.print("[ Liste mots : ");
		listeMots.forEach(System.out::print);
		System.out.println("]");
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
