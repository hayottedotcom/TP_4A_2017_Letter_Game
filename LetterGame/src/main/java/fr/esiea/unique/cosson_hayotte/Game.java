package fr.esiea.unique.cosson_hayotte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Game implements Runnable {
	
	//Déclaration objet
	static int i;
	int nbJoueurs;
	LetterBag tirage = new LetterBag();
	CommonPot pot = new CommonPot();
	List<Player> listPlayers = new ArrayList <Player>();
	TreeMap<String, String> treeMap=new TreeMap<String, String>();
	IA ia;
	
	public Game(){
		i=0;
		tirage = new LetterBag();
		pot = new CommonPot();
		listPlayers = new ArrayList <Player>();
		treeMap=new TreeMap<String, String>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Recuperation du nombre de joueur
		System.out.println("Choisis le nombre de joueur ou entre 0 pour jouer contre L'IA ");
		Scanner sc = new Scanner(System.in);
		nbJoueurs=sc.nextInt();
		
		if(nbJoueurs==0){
			listPlayers.add(new Player("IA"));
			listPlayers.add(new Player("Joueur 1"));
			ia=new IA(listPlayers.get(0));
			
			for(int i=0;i<=1;i++){
				//nouveau tirage
				tirage.newDraw();

				//remplissage du treeMap (lettre/joueur) pour trier la plus petite lettre
				treeMap.put(tirage.getLetter(), listPlayers.get(i).getName());
				
				//associe la lettre tirée avec le joueur
				listPlayers.get(0).setLastLetter(tirage.getLetter());
				System.out.println("\n"+listPlayers.get(i).getName()+" a tiré la lettre : "+listPlayers.get(i).getLastLetter());
				
				//Affichage potCommun
				pot.addCommonPot(tirage.getLetter());
				pot.printCommonPot();
			}

		}
		else{
		for(int i=1;i<=nbJoueurs;i++){
			//Initialise les joueurs
			listPlayers.add(new Player("Joueur "+i));
			
			//nouveau tirage
			tirage.newDraw();

			//remplissage du treeMap (lettre/joueur) pour trier la plus petite lettre
			treeMap.put(tirage.getLetter(), listPlayers.get(i-1).getName());
			
			//associe la lettre tirée avec le joueur
			listPlayers.get(i-1).setLastLetter(tirage.getLetter());
			System.out.println(listPlayers.get(i-1).getName()+" a tiré la lettre : "+listPlayers.get(i-1).getLastLetter());
			
			//Affichage potCommun
			pot.addCommonPot(tirage.getLetter());
			pot.printCommonPot();

		}}
		//Affichage du joueur avec la plus petite lettre
        System.out.println(treeMap.firstEntry()+" donc 1er à jouer");
        listPlayers.forEach((liste)->{
        	if(liste.getName()==treeMap.firstEntry().getValue())
        		liste.setTurn(true);
        });
        
       while(true){
    	   //Quand la liste de joueurs a été parcouru on recommence
    	    i=0;
    	    //On parcours la liste de joueurs
        	listPlayers.forEach((liste)->{
        		//Si c'est son tour alors
        		if(liste.getTurn()){
    				if(liste.getName()=="IA"){
    					ia.iaMakeWord(pot.getCommonPot());
    					//Ce n'est plus son tour
        				liste.setTurn(false);
        				//Si c'est le dernier, le 1er joueur rejoue
        				if(i+1==listPlayers.size())
        					listPlayers.get(0).setTurn(true);
        				//Sinon le suivant joue
        				else listPlayers.get(i+1).setTurn(true);
        				
    				}
        			//Tire 2 nouvelles aléatoires et rajoute au pot commun
        			System.out.println("\n"+liste.getName()+" tire deux lettres");
    				tirage.newDraw();
    				pot.addCommonPot(tirage.getLetter());
    				//pot.affichePotCommun();
    				tirage.newDraw();
    				pot.addCommonPot(tirage.getLetter());
    				pot.printCommonPot();
    				System.out.println("----Listes Mots------");
    				listPlayers.forEach((l)->{
    					l.printListWords();
    			    });
    				System.out.println("---------------------");
        			//Il entre un mot ou il passe
    				

    				if(liste.getName()!="IA"){
        			System.out.println(liste.getName()+" : Essayes de faire un mot ou passes en écrivant 'P'");
        			
        			//Attente de l'entrée joueur
        			Scanner test = new Scanner(System.in);
        			String s=test.nextLine();

        				int cpt=0;
        				Dictionary dico=new Dictionary();
        				//dico.bonMot(s);
        				while(true){
        					dico=new Dictionary();
        					if(dico.stealWord(s, listPlayers, pot)){
        						//liste.addMotDansListe(s);
        						break;
        					}
        					else if("P".equals(s)){
        	        				//Ce n'est plus son tour
        	        				liste.setTurn(false);
        	        				//Si c'est le dernier, le 1er joueur rejoue
        	        				if(i+1==listPlayers.size())
        	        					listPlayers.get(0).setTurn(true);
        	        				//Sinon le suivant joue
        	        				else listPlayers.get(i+1).setTurn(true);
        	        				break;
        	        		}
        					else if(dico.isWord(s)==false || pot.wordInPot(s)==false){
        					System.out.println("Le mot est incorrect ou pas présent dans le pot");
        					s=test.nextLine();
        					

        					}
        					else{
        						tirage.newDraw();
        	    				pot.addCommonPot(tirage.getLetter());
        						break;
        						
        					}
        				}
        				if(!s.equals("P")){
        					
        				listPlayers.get(i).addWord(s);
    					//Ce n'est plus son tour
        				liste.setTurn(false);
        				//Si c'est le dernier, le 1er joueur rejoue
        				if(i+1==listPlayers.size())
        					listPlayers.get(0).setTurn(true);
        				//Sinon le suivant joue
        				else listPlayers.get(i+1).setTurn(true);
        				}
        			}
        		}
			
        		
        		//On incrémente l'index
        		i++;
        	});

       }
	}

}
