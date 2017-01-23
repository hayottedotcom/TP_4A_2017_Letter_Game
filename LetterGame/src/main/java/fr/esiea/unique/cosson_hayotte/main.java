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
				System.out.println(listeJoueurs.get(i-1).getNom()+" a tiré la lettre : "+listeJoueurs.get(i-1).getDernereLettre());
				
				//Affichage potCommun
				pot.addPotCommum(tirage.getLettre());
				pot.affichePotCommun();
	
			}
			//Affichage du joueur avec la plus petite lettre
	        System.out.println(treeMap.firstEntry()+" donc 1er à jouer");






		


	}

}
