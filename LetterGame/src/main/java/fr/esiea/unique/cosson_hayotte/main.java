package fr.esiea.unique.cosson_hayotte;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("coucou");
			SacLettres tirage = new SacLettres(Math.random()*25);
			System.out.println(tirage.getLettre());
	}

}
