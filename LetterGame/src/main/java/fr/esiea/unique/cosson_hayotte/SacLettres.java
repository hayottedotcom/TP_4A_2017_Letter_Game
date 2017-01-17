package fr.esiea.unique.cosson_hayotte;

public class SacLettres {
	
	private String[] sac={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"
			,"p","q","r","s","t","u","v","w","x","y","z"};
	private double random;

	public SacLettres(double d) {
		// TODO Auto-generated constructor stub
		this.random=d;
		
	}
	
	public String getLettre(){
		return sac[(int) random];
	}

}
