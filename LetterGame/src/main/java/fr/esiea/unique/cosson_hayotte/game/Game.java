package fr.esiea.unique.cosson_hayotte.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import fr.esiea.unique.cosson_hayotte.letters.CommonPot;
import fr.esiea.unique.cosson_hayotte.letters.Dictionary;
import fr.esiea.unique.cosson_hayotte.letters.LetterBag;
import fr.esiea.unique.cosson_hayotte.players.IA;
import fr.esiea.unique.cosson_hayotte.players.InputPlayer;
import fr.esiea.unique.cosson_hayotte.players.Player;

public class Game implements Runnable {
	
	//Déclaration objet
	int i;
	private int nbPlayers;
	private LetterBag tirage = new LetterBag();
	private CommonPot pot = new CommonPot();
	private List<Player> listPlayers = new ArrayList <Player>();
	private TreeMap<String, String> treeMap=new TreeMap<String, String>();
	private Display display;
	private IA ia;
	private InputPlayer input;
	public Game(){
		i=0;
		tirage = new LetterBag();
		pot = new CommonPot();
		listPlayers = new ArrayList <Player>();
		treeMap=new TreeMap<String, String>();
		display=new Display();
		input=new InputPlayer();
	}
	
	public void startSeq(int i){

			//nouveau tirage
			tirage.newDraw();

			//remplissage du treeMap (lettre/joueur) pour trier la plus petite lettre
			treeMap.put(tirage.getLetter(), listPlayers.get(i).getName());
			
			//associe la lettre tirée avec le joueur
			listPlayers.get(i).setLastLetter(tirage.getLetter());
			System.out.println("\n"+listPlayers.get(i).getName()+" a tiré la lettre : "+listPlayers.get(i).getLastLetter());
			
			//Affichage potCommun
			pot.addCommonPot(tirage.getLetter());
			pot.printCommonPot();

	}
	
	public void firstPlayer(){
		System.out.println(treeMap.firstEntry()+" donc 1er à jouer");
        listPlayers.forEach((liste)->{
        	if(liste.getName()==treeMap.firstEntry().getValue())
        		liste.setTurn(true);
        });
	}
	
	public void endTurn(Player liste){
		//Ce n'est plus son tour
		liste.setTurn(false);
		//Si c'est le dernier, le 1er joueur rejoue
		if(i+1==listPlayers.size())
			listPlayers.get(0).setTurn(true);
		//Sinon le suivant joue
		else listPlayers.get(i+1).setTurn(true);
	}
	
	
	public void newTurn(Player liste){
		System.out.println("\n"+liste.getName()+" tire deux lettres");
		tirage.newDraw();
		pot.addCommonPot(tirage.getLetter());
		//pot.affichePotCommun();
		tirage.newDraw();
		pot.addCommonPot(tirage.getLetter());
		pot.printCommonPot();
	}
	
	public boolean isRunning(){
		return true;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Recuperation du nombre de joueur
		display.playerMode();
		nbPlayers=input.playerNumber();
		
		if(nbPlayers==0){
			listPlayers.add(new Player("IA"));
			listPlayers.add(new Player("Joueur 1"));
			ia=new IA(listPlayers.get(0));
			
			for(int i=0;i<=1;i++){
				//Séquence de démarage (tirage + ajout dans le pot)
				startSeq(i);
			}

		}
		else{
		for(int i=0;i<nbPlayers;i++){
			//Initialise les joueurs
			listPlayers.add(new Player("Joueur "+(i+1)));
			//Séquence de démarage (tirage + ajout dans le pot)
			startSeq(i);

		}}
		
		//Affichage du joueur avec la plus petite lettre
        firstPlayer();
        
       while(true){
    	   //Quand la liste de joueurs a été parcouru on recommence
    	    i=0;
    	    //On parcours la liste de joueurs
        	listPlayers.forEach((liste)->{
        		//Si c'est son tour alors
        		if(liste.getTurn()){
        			
        			//Tire 2 nouvelles lettres aléatoires et rajoute au pot commun
        			newTurn(liste);

    				
    				//Si l'IA joue
    				if(liste.getName()=="IA"){
    					//L'IA fait un mot
    					ia.iaMakeWord(pot.getCommonPot());
    					//Ce n'est plus son tour
        				liste.setTurn(false);
        				//Si c'est le dernier, le 1er joueur rejoue
        				if(i+1==listPlayers.size())
        					listPlayers.get(0).setTurn(true);
        				//Sinon le suivant joue
        				else listPlayers.get(i+1).setTurn(true);
        				
    				}
    				//Affichage de la liste des mots du joueurs
    				display.listWords(listPlayers);
    				
        			//Si ce n'est pas l'IA, le joueur entre un mot ou passe
    				if(liste.getName()!="IA"){
        			System.out.println(liste.getName()+" : Essayes de faire un mot ou passes en écrivant 'P'");
        			
        			//Attente de l'entrée joueur
        			@SuppressWarnings("resource")
					String s=new Scanner(System.in).nextLine();
        			
        				Dictionary dico=new Dictionary();
        				//dico.bonMot(s);
        				while(true){
        					dico=new Dictionary();
        					//Si le joueur vole un mot
        					if(dico.stealWord(s, listPlayers, pot)){
        						break;
        					}
        					else if("P".equals(s)){
        	        				//Fin du tour
        							endTurn(liste);
        	        				break;
        	        		}
        					else if(dico.isWord(s)==false || pot.wordInPot(s,listPlayers)==false){
        					
        					System.out.println("Le mot est incorrect ou pas présent dans le pot");
        					s=new Scanner(System.in).nextLine();
        					}
        					else{
        						tirage.newDraw();
        	    				pot.addCommonPot(tirage.getLetter());
        						break;
        						
        					}
        				}
        				if(!s.equals("P")){
        					
        				listPlayers.get(i).addWord(s);
    					//Fin du tour
        				endTurn(liste);
        				}
        			}
        		}
			
        		
        		//On incrémente l'index
        		i++;
        	});

       }
	}

}
