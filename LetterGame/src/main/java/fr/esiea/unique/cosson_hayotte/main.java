package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}
	static int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
			//Déclaration objet
			int nbJoueurs;
			SacLettres tirage = new SacLettres();
			PotCommun pot = new PotCommun();
			List<Joueur> listeJoueurs = new ArrayList <Joueur>();
			
			TreeMap<String, String> treeMap=new TreeMap<String, String>();
			
			//Recuperation du nombre de joueur
			System.out.println("Choisis le nombre de joueur : ");
			Scanner sc = new Scanner(System.in);
			nbJoueurs=sc.nextInt();
	
		//	System.out.println(nbJoueurs);
			

			for(int i=1;i<=nbJoueurs;i++){
				
				//Initialise les joueurs
				listeJoueurs.add(new Joueur("Joueur "+i));

				
				//nouveau tirage
				tirage.nouveauTirage();
				
				//remplissage du treeMap (lettre/joueur) pour trier la plus petite lettre
				treeMap.put(tirage.getLettre(), listeJoueurs.get(i-1).getNom());
				
				//associe la lettre tirée avec le joueur
				listeJoueurs.get(i-1).setDerniereLettre(tirage.getLettre());
				System.out.println(listeJoueurs.get(i-1).getNom()+" a tiré la lettre : "+listeJoueurs.get(i-1).getDerniereLettre());
				
				//Affichage potCommun
				pot.addPotCommum(tirage.getLettre());
				pot.affichePotCommun();
	
			}
			//Affichage du joueur avec la plus petite lettre
	        System.out.println(treeMap.firstEntry()+" donc 1er à jouer");
	        listeJoueurs.forEach((liste)->{
	        	if(liste.getNom()==treeMap.firstEntry().getValue())
	        		liste.setTour(true);
	        });
	        
	       while(true){
	    	   //Quand la liste de joueurs a été parcouru on recommence
	    	    i=0;
	    	    //On parcours la liste de joueurs
	        	listeJoueurs.forEach((liste)->{
	        		//Si c'est son tour alors
	        		if(liste.getTour()){
	        			//Tire 2 nouvelles aléatoires et rajoute au pot commun
	        			System.out.println(liste.getNom()+" tire une lettre");
	    				tirage.nouveauTirage();
	    				pot.addPotCommum(tirage.getLettre());
	    				pot.affichePotCommun();
	    				tirage.nouveauTirage();
	    				pot.addPotCommum(tirage.getLettre());
	    				pot.affichePotCommun();
	        			//Il entre un mot ou il passe
	        			System.out.println(liste.getNom()+" : Essaye de faire mot ou passe en écrivant 'passe'");
	        			
	        			//Attente de l'entrée joueur
	        			Scanner test = new Scanner(System.in);
	        			String s=test.nextLine();
	        			
	        			
	        			//Si il passe alors
	        			if("passe".equals(s)){
	        				//Ce n'est plus son tour
	        				liste.setTour(false);
	        				//Si c'est le dernier le 1er joueur rejoue
	        				if(i+1==listeJoueurs.size())
	        					listeJoueurs.get(0).setTour(true);
	        				//Sinon le suivant joue
	        				else listeJoueurs.get(i+1).setTour(true);	        				
	        			}
   			
	        		}
	        		//On incrémente l'index
	        		i++;
	        	});

	       }





		


	}

}
