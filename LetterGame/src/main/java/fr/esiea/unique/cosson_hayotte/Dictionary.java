package fr.esiea.unique.cosson_hayotte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Dictionary {
	InputStream is;
	BufferedReader in;
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
    				 start=s.substring(0, s.indexOf(li));
    				 word=li;
    				 end=s.substring(s.indexOf(li)+li.length(), s.length());

    				if(isWord(s)&&( start.matches("["+pot.getCommonPot()+"]*") || end.matches("["+pot.getCommonPot()+"]*")) ||
    						( start.matches("["+pot.getCommonPot()+"]*") && end.matches("["+pot.getCommonPot()+"]*"))){
    					
    					i=1;
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
