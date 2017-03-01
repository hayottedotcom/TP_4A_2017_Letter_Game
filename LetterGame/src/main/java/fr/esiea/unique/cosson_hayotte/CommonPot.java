package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;

public class CommonPot {
	//List lettre dans le pot commun
	private List<String> CommonPot=new ArrayList<String>();
	private boolean doubleWord=false;
	public CommonPot(){
	}
	
	//Ajout lettre dans pot commun
	public void addCommonPot(String letter){
		CommonPot.add(letter);
	}

	//get potCommun
	public List<String> getCommonPot(){
	
		return CommonPot;
		
	}
	//Afficher pot commun
	public void printCommonPot(){
		System.out.print("Pot Commun : ");
		System.out.print("[");
		CommonPot.forEach(System.out::print);
		System.out.println("]");

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
			if(CommonPot.contains(letter) && !doubleWord){
				CommonPot.remove(letter);
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
