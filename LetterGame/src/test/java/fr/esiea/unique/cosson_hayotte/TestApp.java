package fr.esiea.unique.cosson_hayotte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestApp {
	
	SacLettres sl = new SacLettres();

	
	@Before
    public void setup() {
    }
	

	@Test
	public void testGetLettre() {
		sl.nouveauTirage();
		String lettre = sl.getLettre();
		assertNotNull(lettre); //Test si la lettre existe
	}
	
	@Test
	public void testScanNbJoueurs() {
		
	}

}
