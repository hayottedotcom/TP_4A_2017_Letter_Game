package fr.esiea.unique.cosson_hayotte;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class IA {
	
	private Player IA;
	public IA(Player IA){
		this.IA=IA;
	}
	
	public void iaMakeWord(List<String> pot){
		Dictionary dico= new Dictionary();
		BufferedReader in=dico.getDictionary();
		String str="";
        try {
			while ((str = in.readLine()) != null) {
			     if (str.matches("^(?:(["+pot+"])(?!.*\1))*$")) {
			    	IA.addWord(str);
			    	//System.out.println(str.length()+" "+str.charAt(0));
			    	for (int i=0;i<str.length();i++)
			    	pot.remove(""+str.charAt(i));
			    	LetterBag draw=new LetterBag();
			    	draw.newDraw();
			    	pot.add(draw.getLetter());

			     }
			 }
			// in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
