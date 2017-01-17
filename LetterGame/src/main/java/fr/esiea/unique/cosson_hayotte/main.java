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
			//1er tirage
			tirage.nouveauTirage();
			System.out.println(tirage.getLettre());
			//2ème tirage
			tirage.nouveauTirage();
			System.out.println(tirage.getLettre());
	}

}
