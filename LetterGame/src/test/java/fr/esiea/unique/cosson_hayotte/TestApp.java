package fr.esiea.unique.cosson_hayotte;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.unique.cosson_hayotte.game.Game;
import fr.esiea.unique.cosson_hayotte.letters.CommonPot;
import fr.esiea.unique.cosson_hayotte.letters.Dictionary;
import fr.esiea.unique.cosson_hayotte.letters.LetterBag;
import fr.esiea.unique.cosson_hayotte.players.IA;
import fr.esiea.unique.cosson_hayotte.players.InputPlayer;
import fr.esiea.unique.cosson_hayotte.players.Player;

public class TestApp {
	
	LetterBag sl = new LetterBag();
	Pattern p = Pattern.compile("[0-9]");
	Pattern lts = Pattern.compile("\\p{L}*");
	Boolean hasSpecialChar = false;
	List<Player> testListPlayers=new ArrayList <Player>();
	Dictionary dc = new Dictionary();
	CommonPot cm = new CommonPot();

	
	@Before
    public void setup() {
    }
	
	//Test si on récupère bien une lettre
	@Test
	public void testGetLettre() {
		sl.newDraw();
		String lettre = sl.getLetter();
		assertNotNull(lettre); //If OK, letter exists.
	}
	
	//Test si un mot dans le Dictionnaire est bien un String
	@Test
	public void dicoString () {
		
		String str = "";
		Boolean isString = false;
		try {
			while ((str = dc.getDictionary().readLine()) != null) {
			     if (hasSpecialChar = p.matcher(str).find() == true) {
			    	 isString = false;
			    	 break;
			     } else {
			    	 isString = true;
			     }
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(isString, true); //Si OK, il n'y pas de caractères alphanumériques dans le Dictionnaire.
	}
	
	//Test si un mot existe dans le Dictionnaire
	@Test
	public void testDictionaryWordExists() {

		String input = "test";
		assertEquals(dc.isWord(input), true);
	}
	
	//Test si le Dictionnaire existe
	@Test
	public void testIsDictionaryTxtFileExists() {
		boolean f = new File("src/main/resources/dico.txt").exists();
		assertEquals(f, true);
	}
	
	//
	@Test
	public void testIsLetter() {
		LetterBag lb = new LetterBag();
		lb.newDraw();
		String randomLetter = lb.getLetter();
		java.util.regex.Matcher m = lts.matcher(randomLetter);
		boolean b = m.matches();
		assertEquals(true, b); //
	}
	
	//Test si ajout dans pot commun OK
	@Test
	public void testCommunPot() {

		String letterA = "a";
		String letterB = "b";
		ArrayList<String> letters = new ArrayList<String>();
		letters.add(letterA);
		letters.add(letterB);
		cm.addCommonPot(letterA);
		cm.addCommonPot(letterB);
		assertTrue(letters.equals(cm.getCommonPot()));
	}
	

	//Test fréquence sur les voyelles (supérieur à 55%)
	@Test
	public void testFreqLetter() {
		LetterBag lb = new LetterBag();
		int count = 0;
		int expected = 55;
		for (int i = 0 ; i < 100 ; i++)
		{
			lb.newDraw();
			if(lb.getLetter()=="a" ||
			   lb.getLetter()=="e" ||
			   lb.getLetter()=="i" ||
			   lb.getLetter()=="o" ||
			   lb.getLetter()=="u") count++;
		}
		
		assertTrue(count > expected);
	}
	
	//Test si l'entrée du joueur est bien un String
	@Test
	public void testIsStringInputPlayer() {
		String dataInput = "This is a Test";
		InputStream stdin = System.in;
		try
		{
			System.setIn(new ByteArrayInputStream(dataInput.getBytes()));
			InputPlayer ip = new InputPlayer();
			assertTrue(ip.playerWord() instanceof String);
		} finally {
			System.setIn(stdin);
		}
	}
	
	//Test si l'entrée du joueur est bien un entier (int)
	@Test
	public void testIsIntInputPlayer(){
		String dataInput = "99";
		InputStream stdin = System.in;
		try
		{
			System.setIn(new ByteArrayInputStream(dataInput.getBytes()));
			InputPlayer ip = new InputPlayer();
			assertTrue((Integer)ip.playerNumber() instanceof Integer);
		} finally {
			System.setIn(stdin);
		}
	}
	
	//Test si l'ajout d'un mot dans la liste d'un joueur OK
	@Test
	public void testWordInPlayerList(){
		Player player=new Player("test");
		String wordTest="Test";
		player.addWord(wordTest);
		assertTrue(player.getListWords().contains(wordTest));
	}
	
	//Test si la suppression d'un mot dans la liste d'un joueur OK
	@Test
	public void testRemoveWordInPlayerList(){
		Player player=new Player("test");
		String wordTest="Test";
		player.addWord(wordTest);
		player.removeWord(wordTest);
		assertFalse(player.getListWords().contains(wordTest));
	}
	
	//Test si le jeu est lancé
	@Test
	public void testGameIsRunning() {

		 	Game game = new Game();
		 	boolean running;
		    ExecutorService service = Executors.newSingleThreadExecutor();
		    service.execute(game);
		    // Add something like this.
		    running=game.isRunning();
		    service.shutdown();
		    assertEquals(true,running);
	    // Add something like this.
	 

	}
	
	//Test si l'IA a fait un mot OK
	@Test
	public void testIAWordOk(){
		Player testPlayer =new Player("IA");
		IA testIA=new IA(testPlayer);
		CommonPot testPot=new CommonPot();
		testPot.getCommonPot().add("a");
		testPot.getCommonPot().add("n");
		testPot.getCommonPot().add("g");
		testPot.getCommonPot().add("e");
		assertEquals(true,testIA.iaMakeWord(testPot));
	}
	
	//Test si un mot est dans le pot
	@Test
	public void testWordInPot(){
		
		testListPlayers.add(new Player("test"));
		CommonPot testPot=new CommonPot();
		testPot.addCommonPot("t");
		testPot.addCommonPot("o");
		testPot.addCommonPot("n");
		assertEquals(true,testPot.wordInPot("tno", testListPlayers));
	}
	

	//Test si le tour d'un joueur est terminé
	@Test
	public void testIsTurnFalse() {

		 	Game game = new Game();
		    ExecutorService service = Executors.newSingleThreadExecutor();
		    service.execute(game);
		    testListPlayers.add(new Player("testP1"));
		    testListPlayers.add(new Player("testP2"));
		    testListPlayers.get(0).setTurn(true);
		    game.listPlayers=testListPlayers;
		    
		   
		    game.endTurn(testListPlayers.get(0));
		    service.shutdown();
		    assertEquals(false, testListPlayers.get(0).getTurn());
	 

	}
	
	//Test si un joueur vole bien un mot
	@Test
	public void testStealWord(){
	    testListPlayers.add(new Player("testP1"));
	    testListPlayers.add(new Player("testP2"));
	    //Ajout du mot tarte pour le joueur1
	    testListPlayers.get(0).addWord("tarte");
	    //System.out.println(testListPlayers.get(0).getListWords());
	    //Ajout de s dans le pot commun
	    cm.addCommonPot("s");
	    //Le joueurs 2 vole le mot tarte en faisant tartes
	    dc.stealWord("tartes", testListPlayers, cm);
	    //Le joueur 1 n'a plus le mot
	    assertTrue(testListPlayers.get(0).getListWords().isEmpty());
	}
	
	//Test si le score du joueur est bien un entier (int)
	@Test
	public void testIsIntPlayerScore() {
		Player pl = new Player("Player0");
		pl.setScore();
		assertTrue((Integer)pl.getScore() instanceof Integer);
	}
	
	// Test si la fonction renvoie bien la dernière lettre du joueur
	@Test
	public void testIsTrueGetLastLetterPlayer() {
		Player pl = new Player("Player0");
		String myLetter1 = "a", myLetter2 = "f";
		pl.setLastLetter(myLetter1);
		pl.setLastLetter(myLetter2);
		assertEquals(pl.getLastLetter(), myLetter2);
	}
}
