package fr.esiea.unique.cosson_hayotte.players;

import java.util.Scanner;

public class InputPlayer {
	private Scanner sc;
	public InputPlayer(){
		sc = new Scanner(System.in);
	}
	
	public int playerNumber(){
		return sc.nextInt();
	}
	public String playerWord(){
		return sc.nextLine();
	}
}
