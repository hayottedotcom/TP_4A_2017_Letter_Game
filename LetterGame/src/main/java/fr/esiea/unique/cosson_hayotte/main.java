package fr.esiea.unique.cosson_hayotte;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("coucou");
			
			//Déclaration objet
			SacLettres tirage = new SacLettres();
			PotCommun pot = new PotCommun();
			
			//1er tirage
			tirage.nouveauTirage();
			pot.addPotCommum(tirage.getLettre());
			System.out.println("Tirage 1 : "+tirage.getLettre());
			pot.affichePotCommun();

			//2ème tirage
			tirage.nouveauTirage();
			pot.addPotCommum(tirage.getLettre());
			System.out.println("Tirage 2 : "+tirage.getLettre());
			pot.affichePotCommun();
	}

}
