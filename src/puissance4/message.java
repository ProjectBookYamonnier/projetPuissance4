package puissance4;

import java.util.Scanner;

public class message {

	public static void avertissement() {
		System.err.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();
		System.out.println("         %           ");
		System.out.println("        %%%                 AVERTISSEMENT : Il va se produire une erreur si vous rentrez");
		System.out.println("       %   %                un caractère dans la console. Veuillez uniquement entrez les");
		System.out.println("      %%   %%               numéros correcpondant dans les questions qui vous sont posées.");
		System.out.println("     %%%   %%%       ");
		System.out.println("    %%%%%%%%%%%      C'est donc pour cela que nous vous demandons de respecter cette unique règle d'or :");
		System.out.println("   %%%%%   %%%%%     ");
		System.out.println("  %%%%%%   %%%%%%    - Au risque que votre jeu s'arrête.");
		System.out.println(" %%%%%%%%%%%%%%%%%   ");
		System.out.println();
		System.err.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println();
	}
	
	public static void recommence() {
		System.out.println();
		System.out.println("Voulez-vous recommencer une nouvelle partie");
		System.out.println("       '1' pour OUI et '2' pour NON");
		Scanner bu = new Scanner(System.in);
		int jouer = Outils.scanner(bu);
		if (jouer == 1) {
			projet.jeu();
		}
		else {
			System.out.println("Merci d'avoir joué !!! ");
		}
	}
}
