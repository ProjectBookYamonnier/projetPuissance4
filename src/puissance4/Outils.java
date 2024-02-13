package puissance4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Outils {

	public static int scanner(Scanner S) {
		int valeurs = S.nextInt();
		return valeurs;
	}
	
	public static int entierAleatoire(int a, int b){
		return ThreadLocalRandom.current().nextInt(a, b + 1);	
	}
}
