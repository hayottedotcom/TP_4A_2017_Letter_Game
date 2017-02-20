package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;

public class PotCommun {
	//List lettre dans le pot commun
	private List<String> potCommum=new ArrayList<String>();
	
	public PotCommun(){
	}
	
	//Ajout lettre dans pot commun
	public void addPotCommum(String lettre){
		potCommum.add(lettre);
	}
	/*public void deleteFromPotCommun(String lettre){
		potCommum.remove(lettre);
	}*/
	
	//get potCommun
	public List<String> getPotCommum(){
	
		return potCommum;
		
	}
	//Afficher pot commun
	public void affichePotCommun(){
		System.out.print("Pot Commun : ");
		System.out.print("[");
		potCommum.forEach(System.out::print);
		System.out.println("]");

	}
	public boolean motDansPot(String s){
		int cpt=0;
		for(int i=0;i<s.length();i++){
			//System.out.println(s.length());
			//System.out.println(s.charAt(i));
			String lettre=""+s.charAt(i);
			if(potCommum.contains(lettre)){
				potCommum.remove(lettre);
				cpt++;
			}
			if(cpt==s.length()){
				System.out.println("Mot ok depuis le pot ocmmun");
				return true;
			}
		}
		return false;
	}

}
