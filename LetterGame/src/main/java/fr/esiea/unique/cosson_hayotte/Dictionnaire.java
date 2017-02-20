package fr.esiea.unique.cosson_hayotte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Dictionnaire {
	InputStream is;
	BufferedReader in;
	Dictionnaire(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		is = loader.getResourceAsStream("dico.txt");
		InputStreamReader isr = new InputStreamReader(is);
		in = new BufferedReader(isr);
	}
	
	public boolean bonMot(String word){
		 String str="";
         try {
			while ((str = in.readLine()) != null) {
			     if (str.indexOf(word) != -1) {
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
