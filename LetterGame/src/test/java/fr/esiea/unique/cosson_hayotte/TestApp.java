package fr.esiea.unique.cosson_hayotte;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class TestApp {
	
	LetterBag sl = new LetterBag();
	Pattern p = Pattern.compile("[0-9]");
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
	public void DicoString () {
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

}
