package fr.esiea.unique.cosson_hayotte.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import fr.esiea.unique.cosson_hayotte.letters.CommonPot;
import fr.esiea.unique.cosson_hayotte.letters.Dictionary;
import fr.esiea.unique.cosson_hayotte.letters.LetterBag;

public class IA {
	
	private Player IA;
	public IA(Player IA){
		this.IA=IA;
	}
	
	public boolean iaMakeWord(CommonPot pot){
		Dictionary dico= new Dictionary();
		BufferedReader in=dico.getDictionary();
		String str="";
        try {
			while ((str = in.readLine()) != null) {
			     if (str.matches("["+pot.getCommonPot()+"]*") && pot.notUsedTwoSameChars(str) ) {
			    	IA.addWord(str);
			    	//System.out.println(str.length()+" "+str.charAt(0));
			    	for (int i=0;i<str.length();i++)
			    	pot.getCommonPot().remove(""+str.charAt(i));
			    	LetterBag draw=new LetterBag();
			    	draw.newDraw();
			    	IA.setScore();
			    	pot.getCommonPot().add(draw.getLetter());
			    	return true;

			     }
			 }
			// in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}
	
}
