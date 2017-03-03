package fr.esiea.unique.cosson_hayotte.players;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputPlayer {
	private Scanner sc;
	public InputPlayer(){
		sc = new Scanner(System.in);
	}
	
	public int playerNumber(){
		int nbPlayer = 0;
	
		 try {
			 nbPlayer = sc.nextInt();
		 }catch (InputMismatchException e) {
			    System.out.println("La valeur saisie n'est pas un entier, lancement par défaut de L'IA");
		}
		if(nbPlayer>5){
		    System.out.println("Le nombre de joueur doit être inférieur à 6, lancement par défaut de 2 joueurs");
		    nbPlayer=2;
		}
		return nbPlayer;
	}
	public String playerWord(){
		return sc.nextLine();
	}
}
