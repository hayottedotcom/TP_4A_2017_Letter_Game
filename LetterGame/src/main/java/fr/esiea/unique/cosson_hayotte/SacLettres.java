package fr.esiea.unique.cosson_hayotte;

public class SacLettres {
	
	//Tableau contenant les lettres
	private String[] sac={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"
			,"p","q","r","s","t","u","v","w","x","y","z"};
	//Le nombre aléatoire généré
	private double random;

	public SacLettres() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void nouveauTirage(){
		random=Math.random() * 25;
	}
	//getter de la lettre en fonction du random
	public String getLettre(){
		return sac[(int) random];
	}

}
