package puissance4;

public class erreur {

	public static void erreurColRemplie(int numJoueur) {
		System.err.println("ATTENTION, vous avez séléctionné une colonne déjà remplie");
		System.err.println("Merci de ne pas refaire la même erreur");
		System.err.println("Veuillez saisir une nouvelle colonne");
		System.out.println();
		System.out.println("Quels coup voulez-vous faire (Joueur " + numJoueur + ") ?");
	}
	
	public static void erreurNumNNCores(int numJoueur) {
		System.err.println("Le numéro de la colonne à jouer ne correspond pas, merci de le saissir à nouveau.");
		System.err.println("(Pour rappel, les numéros de colonnes sont entre 0 et 6)");
		System.out.println();
		System.out.println("Quels coup voulez-vous faire (Joueur " + numJoueur + ") ?");
	}
	
	public static void erreurNumJoueur() {
		System.err.println("Le numéro du Joueur saisi ne correspond pas, merci de le saisir à nouveau.");
		System.err.println("(Pour rappel, il y a le Joueur 1 et le Joueur 2)");
		System.out.println();
		System.out.print("Quels Joueur veux-tu être ?");
	}
	
	public static void erreurNumCommen() {
		System.err.println("Le numéro saissi ne correspond pas, merci de le saissir à nouveau.");
		System.err.println("(Pour rappel, le 1 est pour OUI et le 2 est pour NON)");
		System.out.println();
		System.out.println("Veux-tu commencer la partie ? (ou laisse-tu l'ordinateur débuter)");
	}
	
	public static void erreurNumParam() {
		System.err.println("ATTENTION, le jeu possède deux paramètres");
		System.err.println("(Pour rappel, pour utiliser le premier paramètre, taper 1 et le deuxième paramètre, taper 2)");
		System.out.println();
		System.out.println("Quel paramètre voulez-vous utiliser ?");
	}
	
	public static void erreurIA() {
		System.err.println("Le numéro saisi ne correspond pas, merci de le saisir à nouveau.");
		System.err.println("(Pour rappel le 1 est pour le niveau facile, le 2 pour un niveau moyen et le 3 pour un niveau difficile)");
		System.out.println();
		System.out.println("Quels niveaux voulez-vous choisir ?");
	}
	
//	public static void erreurChar() {
//		if (gggg != int.class) {
//			erreur.erreurChar();
//		}
//	}
	
}
