package fr.esiea.unique.cosson_hayotte.letters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import fr.esiea.unique.cosson_hayotte.players.Player;

public class Dictionary {
	private InputStream is;
	private BufferedReader in;
	int i=0;
	String start,end,word;
	public Dictionary(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		is = loader.getResourceAsStream("dico.txt");
		InputStreamReader isr = new InputStreamReader(is);
		in = new BufferedReader(isr);
	}
	
	public BufferedReader getDictionary(){
		return in;
	}
	
	public boolean isWord(String word){
		 String str="";
         try {
			while ((str = in.readLine()) != null) {
			     if (str.equals(word)) {
			    	
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
    public boolean stealWord(String s,List<Player> listPlayers,CommonPot pot){
    
    	listPlayers.forEach((list)->{
    		i=0;
    		list.getListWords().forEach((li)->{
    			if(s.indexOf(li)!=-1){
    				Dictionary dico= new Dictionary();
    				BufferedReader in=dico.getDictionary();
    				String str="";
    		        try {
    					while ((str = in.readLine()) != null) {
    					     if (str.matches("["+pot+li+"]*") && str.equals(s) && !s.equals(li)) {
    					    	 for(int i=0;i<str.length();i++){
    					    		 if(!li.contains(""+str.charAt(i))){
    					    			 pot.getCommonPot().remove(""+str.charAt(i));
    					    		 }
    					    	 }
    					    	 //System.out.println("dfsdsf");
    					    	 word=li;
    					    	 i=1;
    					     }
    					 }
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		});
    		if(i==1)
    			list.getListWords().remove(word);
    		
    			//return true	
    });
   	 if(i==1)
   		 return true;
   	 
   	 return false;
   	 
    }
}
