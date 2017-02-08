package fr.esiea.unique.cosson_hayotte;

import java.util.Random;

public class SacLettres {
	
	//Tableau contenant les lettres
	private String lettre;
	
	private String[] sacVoyelle = {
			"a", "e", "i", "o", "u","y"
	};
	
	private String[] sacConsonne = {
			"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"
	};
	
	
	//Nombre aléatoire généré
	private double freqAlea;
	private int random;

	public SacLettres() {
		// TODO Auto-generated constructor stub
		
	}
	//Génaration d'un nombre aléatoire pour chaque nouveau tirage
	public void nouveauTirage(){
		freqAlea = Math.random() * 99; //10 éléments
		if(freqAlea<65) {
			random = (int) (Math.random() * sacVoyelle.length);
			lettre = (sacVoyelle[random]);
		} else {
			random = (int) (Math.random() * sacConsonne.length);
			lettre = (sacConsonne[random]);
		}
	}
	//getter de la lettre en fonction du random
	public String getLettre(){
		return lettre;
	}

}