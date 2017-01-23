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
	
	//get potCommun
	public List<String> getPotCommum(){
	
		return potCommum;
		
	}
	//Afficher pot commun
	public void affichePotCommun(){
		System.out.println("Pot Commun :");
		System.out.print("[");
		potCommum.forEach(System.out::print);
		System.out.println("]");

	}

}
