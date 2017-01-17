package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;

public class PotCommun {
	private List<String> potCommum=new ArrayList<String>();
	
	public PotCommun(){
	}
	
	public void addPotCommum(String lettre){
		potCommum.add(lettre);
	}
	public List<String> getPotCommum(){
	
		return potCommum;
		
	}
	public void affichePotCommun(){
		System.out.println("Pot Commun :");
		potCommum.forEach(System.out::println);
	}

}
