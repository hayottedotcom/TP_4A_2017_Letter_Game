package fr.esiea.unique.cosson_hayotte.letters;

import java.util.ArrayList;
import java.util.List;

import fr.esiea.unique.cosson_hayotte.players.Player;

public class CommonPot {
	//List lettre dans le pot commun
	private List<String> commonPot=new ArrayList<String>();
	private boolean doubleWord=false;
	public CommonPot(){
	}
	
	//Ajout lettre dans pot commun
	public void addCommonPot(String letter){
		commonPot.add(letter);
	}

	//get potCommun
	public List<String> getCommonPot(){
	
		return commonPot;
		
	}
	//Afficher pot commun
	public void printCommonPot(){
		System.out.print("Pot Commun : ");
		System.out.print("[");
		commonPot.forEach(System.out::print);
		System.out.println("]");

	}
	
	public boolean notUsedTwoSameChars(String s){
		int cpt=0;
		List<String> clonePot=new ArrayList<String>(commonPot);
		for(int i=0; i<s.length();i++){
			if(clonePot.contains(""+s.charAt(i))){
				clonePot.remove(""+s.charAt(i));
				cpt++;
			}
				
		}
		if(cpt==s.length())
			return true;
		return false;
	}
	public boolean wordInPot(String s,List<Player> liste){
		int cpt=0;
		liste.forEach((l)->{
			if(l.getListWords().contains(s))
				doubleWord=true;
		});
		for(int i=0;i<s.length();i++){
			//System.out.println(s.length());
			//System.out.println(s.charAt(i));
			String letter=""+s.charAt(i);
			if(commonPot.contains(letter) && !doubleWord){
				commonPot.remove(letter);
				cpt++;
			}
			if(cpt==s.length()){
				//System.out.println("Mot ok depuis le pot commun");
				return true;
				
			}
		}
		doubleWord=false;
		return false;
	}

}
