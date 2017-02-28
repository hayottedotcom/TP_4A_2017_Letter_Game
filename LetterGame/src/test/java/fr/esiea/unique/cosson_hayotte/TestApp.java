package fr.esiea.unique.cosson_hayotte;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

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
			while ((str = dc.in.readLine()) != null) {
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
	
	@Test
	public void testGame(){
		boolean x; //
		CommonPot cm = new CommonPot();
		Dictionary dc = new Dictionary();
		LetterBag lb = new LetterBag();
		String out="";
		String in = "soleil";
		do {
			lb.newDraw();
			out = lb.getLetter();
			cm.addCommonPot(out);
		} while(x = in.indexOf(cm.getCommonPot().toString()) < 0);
		assertTrue(x);
	}

}
