package fr.esiea.unique.cosson_hayotte.players;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String lastLetter;
	private String name;
	private int score=0;
	private List<String> listWords= new ArrayList<String>();
	private boolean turn;
	public Player(String name){
		this.name=name;
		this.turn=false;
	}
	
	public void addWord(String word){
		listWords.add(word);
	}
	public void removeWord(String word){
		listWords.remove(word);
	}
	public List<String> getListWords(){
		
		return listWords;
	}
	public void setScore(){
		score++;
	}
	public int getScore(){
		return score;
	}
	
	public void printListWords(){
		System.out.print("["+name+ " : ");
		listWords.forEach(System.out::println);
		System.out.println("]");
	}
	public void setLastLetter(String lastLetter){
		this.lastLetter=lastLetter;

	}
	
	public String getLastLetter(){
		return lastLetter;
	}
	
	public String getName(){
		return name;
	}
	public void setTurn(boolean turn){
		this.turn=turn;
	}
	public boolean getTurn(){
		return turn;
	}

}
