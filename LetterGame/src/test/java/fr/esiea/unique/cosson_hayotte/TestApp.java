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

	
	@Before
    public void setup() {
    }
	

	@Test
	public void testGetLettre() {
		sl.newDraw();
		String lettre = sl.getLetter();
		assertNotNull(lettre); //If OK, letter exists.
	}
	
	@Test
	public void dicoString () {
		Dictionary dc = new Dictionary();
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
		assertEquals(isString, true); //If OK, there are no alphanumeric characters in the Dictionary entries.
	}
	
	@Test
	public void testDictionaryWordExists() {
		Dictionary dc = new Dictionary();
		String input = "test";
		assertEquals(dc.isWord(input), true);
	}
	
	@Test
	public void testIsDictionaryTxtFileExists() {
		boolean f = new File("src/main/resources/dico.txt").exists();
		assertEquals(f, true);
	}
	
	@Test
	public void testIsLetter() {
		LetterBag lb = new LetterBag();
		lb.newDraw();
		String randomLetter = lb.getLetter();
		java.util.regex.Matcher m = lts.matcher(randomLetter);
		boolean b = m.matches();
		assertEquals(true, b); //
	}
	
	@Test
	public void testCommunPot() {
		CommonPot cm = new CommonPot();
		String letterA = "a";
		String letterB = "b";
		ArrayList<String> letters = new ArrayList<String>();
		letters.add(letterA);
		letters.add(letterB);
		cm.addCommonPot(letterA);
		cm.addCommonPot(letterB);
		assertTrue(letters.equals(cm.getCommonPot()));
	}
	
	/*@Test
	public void testGame(){
		boolean x = false; //
		CommonPot cm = new CommonPot();
		LetterBag lb = new LetterBag();
		String out="";
		String in = "soleil";
		do {
			lb.newDraw();
			out = lb.getLetter();
			cm.addCommonPot(out);
		} while(x = in.matches(cm.getCommonPot().toString()) == false);
		assertEquals(true, x);
	}*/

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
	
	@Test
	public void testWordInPlayerList(){
		Player player=new Player("test");
		String wordTest="Test";
		player.addWord(wordTest);
		assertTrue(player.getListWords().contains(wordTest));
	}
	
	@Test
	public void testRemoveWordInPlayerList(){
		Player player=new Player("test");
		String wordTest="Test";
		player.addWord(wordTest);
		player.removeWord(wordTest);
		assertFalse(player.getListWords().contains(wordTest));
	}
	
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
	
	@Test
	public void testIAWordOk(){
		Player testPlayer =new Player("IA");
		IA testIA=new IA(testPlayer);
		List<String> testPot = new ArrayList<String>(); 
		testPot.add("a");
		testPot.add("n");
		testPot.add("g");
		testPot.add("e");
		assertEquals(true,testIA.iaMakeWord(testPot));
	}
	
	@Test
	public void testWordInPot(){
		List<Player> testListPlayers=new ArrayList <Player>();
		testListPlayers.add(new Player("test"));
		CommonPot testPot=new CommonPot();
		testPot.addCommonPot("t");
		testPot.addCommonPot("o");
		testPot.addCommonPot("n");
		assertEquals(true,testPot.wordInPot("tno", testListPlayers));
	}
	
	@Test
	public void testMainIsClas() {
		
		try {
			Class.forName("fr.esiea.unique.cosson_hayotte.game.main");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
	 

	}
	
}
