package fr.esiea.unique.cosson_hayotte.game;

import java.util.List;

import fr.esiea.unique.cosson_hayotte.players.Player;

public class Display {
	Display(){
		
	}
	public void playerMode(){
		System.out.println("Choisis le nombre de joueur ou entre 0 pour jouer contre L'IA ");
	}
	
	public void listWords(List<Player> listPlayers){
		System.out.println("----Listes Mots------");
		listPlayers.forEach((l)->{
			l.printListWords();
	    });
		System.out.println("---------------------");
	}
}
