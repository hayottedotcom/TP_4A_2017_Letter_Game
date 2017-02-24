package fr.esiea.unique.cosson_hayotte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestApp {
	
	LetterBag sl = new LetterBag();

	
	@Before
    public void setup() {
    }
	

	@Test
	public void testGetLettre() {
		sl.newDraw();
		String lettre = sl.getLetter();
		assertNotNull(lettre); //Test si la lettre existe
	}
	
	@Test
	public void testScanNbJoueurs() {
		
	}

}
