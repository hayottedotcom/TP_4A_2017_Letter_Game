package fr.esiea.unique.cosson_hayotte;

import java.util.Random;

public class LetterBag {
	
	//Tableau contenant les lettres
	private String letter;
	
	private String[] vowelBag = {
			"a", "e", "i", "o", "u"
	};
	
	private String[] consonantBag = {
			"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z","y"
	};
	
	
	//Nombre aléatoire généré
	private double freqAlea;
	private int random;

	public LetterBag() {
		// TODO Auto-generated constructor stub
		
	}
	//Génaration d'un nombre aléatoire pour chaque nouveau tirage
	public void newDraw(){
		freqAlea = Math.random() * 99; //10 éléments
		if(freqAlea<65) {
			random = (int) (Math.random() * vowelBag.length);
			letter = (vowelBag[random]);
		} else {
			random = (int) (Math.random() * consonantBag.length);
			letter = (consonantBag[random]);
		}
	}
	//getter de la lettre en fonction du random
	public String getLetter(){
		return letter;
	}

}