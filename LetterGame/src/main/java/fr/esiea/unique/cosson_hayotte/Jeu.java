package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Jeu implements Runnable {
	
	//Déclaration objet
	static int i;
	int nbJoueurs;
	SacLettres tirage = new SacLettres();
	PotCommun pot = new PotCommun();
	List<Joueur> listeJoueurs = new ArrayList <Joueur>();
	TreeMap<String, String> treeMap=new TreeMap<String, String>();
	
	public Jeu(){
		i=0;
		tirage = new SacLettres();
		pot = new PotCommun();
		listeJoueurs = new ArrayList <Joueur>();
		treeMap=new TreeMap<String, String>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
        			System.out.println(liste.getNom()+" tire deux lettre");
    				tirage.nouveauTirage();
    				pot.addPotCommum(tirage.getLettre());
    				pot.affichePotCommun();
    				tirage.nouveauTirage();
    				pot.addPotCommum(tirage.getLettre());
    				pot.affichePotCommun();
        			//Il entre un mot ou il passe
        			System.out.println(liste.getNom()+" : Essayes de faire un mot, passes en écrivant 'P'"
        					+ " ou affiche la liste des mots en écrivant 'L'");
        			
        			//Attente de l'entrée joueur
        			Scanner test = new Scanner(System.in);
        			String s=test.nextLine();
        			
        			
        			//Si il passe alors
        			if("P".equals(s)){
        				//Ce n'est plus son tour
        				liste.setTour(false);
        				//Si c'est le dernier, le 1er joueur rejoue
        				if(i+1==listeJoueurs.size())
        					listeJoueurs.get(0).setTour(true);
        				//Sinon le suivant joue
        				else listeJoueurs.get(i+1).setTour(true);	        				
        			}
        			else if("L".equals(s)){
        				listeJoueurs.get(i).afficheListeMots();
        			}
        			//Sinon il entre un mot
        			else{
        				int cpt=0;
        				Dictionnaire dico=new Dictionnaire();
        				while((pot.motDansPot(s)==false) && ((dico.bonMot(s)==false)|| dico.bonMot(s)==true)){
        					dico=new Dictionnaire();
        					System.out.println("Le mot est incorrect ou pas présent dans le pot");
        					s=test.nextLine();
        				}
        				listeJoueurs.get(i).addMotDansListe(s);
    					//Ce n'est plus son tour
        				liste.setTour(false);
        				//Si c'est le dernier, le 1er joueur rejoue
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
