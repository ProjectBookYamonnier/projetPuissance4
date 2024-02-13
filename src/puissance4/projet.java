package puissance4;

import java.util.Scanner;


public class projet {

	public static void main(String[] args) {
		jeu();
		
	}
	
	public static int [][]grille = new int [6][7];

	public static int[][]initialiseGrille(int [][]tab) {
		for (int i = 0; i < tab.length; i ++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = 0;
			}
		}
		return tab;
	}

	public static void afficheGrille() {
		for (int i = 0; i < grille.length; i ++) {
			System.out.print("                                ");
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print("|"); 
				if (grille[i][j] == 0) System.out.print(" ");
				else if (grille[i][j] == 1) System.out.print("X");
				else if (grille [i][j] == 2) System.out.print("O");
			} 
			System.out.println("|"); 
		}
		System.out.println("                                 0 1 2 3 4 5 6 ");
		System.out.println();
	}

	public static int [][]jouer(int numJoueur, int indiceColonne) {
		for (int i = grille.length-1; i >= 0; i--) {
			if (grille[i][indiceColonne] == 0){
				grille[i][indiceColonne] = numJoueur;
				return grille;
			} 
		}
		return grille;
	}
	
	public static boolean aGagneHor(int numJoueur, int numL, int numC) {
		int gagne = 0;
		if (numC+4 > grille[0].length) return false;
		
			for (int j = numC; j < numC+4; j++) {
				if (grille[numL][j] == numJoueur && grille[numL].length <= 7) {
					gagne += 1;
				}
			}
			
		if (gagne >= 4) return true;
		else return false;
	}
	
	public static boolean aGagneVer(int numJoueur, int numL, int numC) {
		int gagne = 0;
		if (numL+4 > grille.length) return false;
		
			for (int i = numL; i < numL+4; i++) {
					if (grille[i][numC] == numJoueur && grille.length <= 6) {
						gagne += 1;
					}
			}
			
		if (gagne >= 4) return true;
		else return false;
	}

	public static boolean aGagneDiagMont(int numJoueur, int numL, int numC) {
		int gagne = 0;
		if (numL-3 < 0 || numC+4 > grille.length) return false;
		for (int i = 0; i < 4; i++) { 
			if (grille[numL][numC] == numJoueur && numL >= 0 && numC < grille[numL].length) {
				gagne ++;
				numL--;
				numC++;
			}
			else if (grille[numL][numC] != numJoueur) return false;
		}
		if (gagne >= 4) return true; 
		else return false;
	}

	public static boolean aGagneDiagDesc(int numJoueur, int numL, int numC) {
		int gagne = 0;
		if (numC + 4 > grille[0].length)return false;
		if (numL + 4 > grille.length)return false;
		for (int i = 0; i < 4; i++) { 
			if (grille[numL][numC] == numJoueur && numL < grille.length && numC < grille[numL].length && numL >= 0 && numC >= 0) {
				gagne ++;
				numL++;
				numC++;
			}
			else if(grille[numL][numC] != numJoueur) return false;
		}
		if (gagne >= 4) return true; 
		else return false;
	}
	
	public static boolean aGagne(int numJoueur) {
		boolean gagne = false;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				if (aGagneHor(numJoueur, i, j) == true || aGagneVer(numJoueur, i, j) == true || aGagneDiagMont(numJoueur, i, j) == true || aGagneDiagDesc(numJoueur, i, j) == true) {
					gagne = true;
				}
			}
		}
		return gagne;
	}

	public static boolean matchNul() {
		int totalGrille = grille.length*grille[0].length;
		int total = 0;
		for (int i = 0; i < grille.length; i++){
			for (int j = 0; j < grille[i].length; j++){
				if (grille[i][j] != 0 && !aGagne(1) && !aGagne(2)){
					total++;
				}
				if (total == totalGrille) {
					return true;
				}
				
			}
		}
		return false;
	}

	public static void jeu() {
		Decoration.inter();
		message.avertissement();
		boolean gagne = false;
		Scanner para = new Scanner(System.in);
		System.out.println("Deux Paramètres sont présent dans ce jeu:");
		System.out.println("1. Je joue avec un ami");
		System.out.println("2. Je joue avec l'ordinateur");
		System.out.println();
		System.out.println("Quel paramètre voulez-vous utiliser ?");
		int param = Outils.scanner(para);
		System.out.println();
		while (param != 1 && param != 2) {
			erreur.erreurNumParam();
			param = para.nextInt();
			System.out.println();
		}
		Decoration.inter();
		if (param == 1) {
			Scanner co = new Scanner(System.in);
			System.out.println("Quels joueur veut débuter la partie (1 ou 2) ?");
			int numJoueur = Outils.scanner(co);
			while (numJoueur != 1 && numJoueur != 2) {
				erreur.erreurNumJoueur();
				numJoueur = co.nextInt();
				System.out.println();
			}
			afficheGrille();
			while (gagne == false && !matchNul()) {
				if (numJoueur == 1) {
					jeuIntermédiaire(1);
					Decoration.inter();
					afficheGrille();
					if (matchNul() == true) System.out.println("Match nul !");
					else if (aGagne(1) == true) {
						gagne = true;
						System.out.println("Le joueur " + numJoueur + " a gagné !");
					}
					else numJoueur = 2;
				}
				if (numJoueur == 2) {
					jeuIntermédiaire(2);
					Decoration.inter();
					afficheGrille();
					if (matchNul() == true) System.out.println("Match nul !");
					else if (aGagne(2) == true) {
						gagne = true;
						System.out.println("Le joueur " + numJoueur + " a gagné !");
					}
					else numJoueur = 1;
				}
			}
			message.recommence();
		}
		if (param == 2){
			int numJoueur = 1;
			Scanner co = new Scanner(System.in);
			System.out.println("Quels joueur veut-tu être (1 ou 2) ?");
			int Joueur = Outils.scanner(co);
			while (Joueur != 1 && Joueur != 2) {
				erreur.erreurNumJoueur();
				Joueur = Outils.scanner(co);
				System.out.println();
			}
			Scanner niveauIA = new Scanner(System.in);
			System.out.println("Quel niveau veut-tu pour l'ordinateur (facile = 1, moyen = 2 et difficile = 3) ?");
			int niveau = Outils.scanner(niveauIA);
			while (niveau != 1 && niveau != 2 && niveau!= 3) {
				erreur.erreurIA();
				niveau = Outils.scanner(niveauIA);
				System.out.println();
			}
			Scanner bo = new Scanner(System.in);
			System.out.println("Veux-tu commencer la partie ? (ou laisse-tu l'ordinateur débuter)");
			System.out.println("             '1' pour OUI et '0' pour NON       ");
			int s = Outils.scanner(bo);
			System.out.println();
			while (s != 1 && s != 0) {
				erreur.erreurNumCommen();
				s = Outils.scanner(bo);
				System.out.println();
			}
			afficheGrille();
			if (s == 0) {
				while (gagne == false && !matchNul()) {
					if (Joueur == 1) {
						if (numJoueur == 2) {
							jeuIntermédiaire(1);
							Decoration.inter();
							afficheGrille();
							if (matchNul() == true) System.out.println("Match nul !");
							else if (aGagne(1) == true) {
								gagne = true;
								System.out.println("BRAVO !!!! Vous avez gagné !");
							}
							else numJoueur = 1;
						}
						if (numJoueur == 1) {
							if (niveau == 1) {
								joueCoupRandom(2);
							}
							if (niveau == 2) {
								joueCoupRandom2(2);
								if (!joueCoupRandom2(2)) {
									joueCoupRandom(2);
								}
							}
							if (niveau == 3) {
								joueCoupRandom3(2);
							}
							Decoration.inter();
							System.out.println();
							System.out.println("                        L'ordinateur vient de joueur !!");
							System.out.println();
							afficheGrille();
							if (matchNul() == true) System.out.println("Match nul !");
							else if (aGagne(2) == true) {
								gagne = true;
								System.out.println("L'ordinateur a gagné !");
							}
							else numJoueur = 2;
						}
					}
					if (Joueur == 2) {
						if (numJoueur == 1) {
							if (niveau == 1) {
								joueCoupRandom(1);
							}
							if (niveau == 2) {
								joueCoupRandom2(1);
								if (!joueCoupRandom2(1)) {
									joueCoupRandom(1);
								}
							}
							if (niveau ==3) {
								joueCoupRandom3(1);
							}
							Decoration.inter();
							System.out.println();
							System.out.println("                        L'ordinateur vient de joueur !!");
							System.out.println();
							afficheGrille();
							if (matchNul() == true) System.out.println("Match nul !");
							else if (aGagne(1) == true) {
								gagne = true;
								System.out.println("L'ordinateur a gagné !");
							}
							else numJoueur = 2;
						}
						if (numJoueur == 2) {
							jeuIntermédiaire(2);
							Decoration.inter();
							afficheGrille();
							if (matchNul() == true) {
								System.out.println("Match nul !");
							}
							else if (aGagne(2) == true) {
								gagne = true;
								System.out.println("BRAVO !!!! Vous avez gagné !");
							}
							else numJoueur = 1;
						}
					}
				}
			}
			if (s == 1) {
				while (gagne == false && !matchNul()) {
					if (Joueur == 1) {
						if (numJoueur == 1) {
							jeuIntermédiaire(1);
							Decoration.inter();
							afficheGrille();
							if (matchNul() == true) {
								System.out.println("Match nul !");
							}
							else if (aGagne(1) == true) {
								gagne = true;
								System.out.println("BRAVO !!!! Vous avez gagné !");
							}
							else numJoueur = 2;
						}
						if (numJoueur == 2) {
							if (niveau == 1) {
								joueCoupRandom(2);
							}
							if (niveau == 2) {
								joueCoupRandom2(2);
								if (!joueCoupRandom2(2)) {
									joueCoupRandom(2);
								}
							}
							if (niveau ==3) {
								joueCoupRandom3(2);
							}
							Decoration.inter();
							System.out.println();
							System.out.println("                        L'ordinateur vient de joueur !!");
							System.out.println();
							afficheGrille();
							if (matchNul() == true) {
								System.out.println("Match nul !");
							}
							else if (aGagne(2) == true) {
								gagne = true;
								System.out.println("L'ordinateur a gagné !");
							}
							else numJoueur = 1;
						}
					}
					if (Joueur == 2) {
						if (numJoueur == 2) {
							if (niveau == 1) {
								joueCoupRandom(1);
							}
							if (niveau == 2) {
								joueCoupRandom2(1);
								if (!joueCoupRandom2(1)) {
									joueCoupRandom(1);
								}
							}
							if (niveau ==3) {
								joueCoupRandom3(1);
							}
							Decoration.inter();
							System.out.println();
							System.out.println("                        L'ordinateur vient de joueur !!");
							System.out.println();
							afficheGrille();
							if (matchNul() == true) {
								System.out.println("Match nul !");
							}
							else if (aGagne(1) == true) {
								gagne = true;
								System.out.println("L'ordinateur a gagné !");
							}
							else numJoueur = 1;
						}
						if (numJoueur == 1) {
							jeuIntermédiaire(2);
							Decoration.inter();
							afficheGrille();
							if (matchNul() == true) {
								System.out.println("Match nul !");
							}
							else if (aGagne(2) == true) {
								gagne = true;
								System.out.println("BRAVO !!!! Vous avez gagné !");
							}
							else numJoueur = 2;
						}
					}
				}
			}
			message.recommence();
		}
		
	}
	
	public static void jeuIntermédiaire(int numJoueur) {
		Scanner s = new Scanner(System.in);
		System.out.print("Quel coup pour le joueur " + numJoueur + " ?");
		int Colonnes = Outils.scanner(s);
		while (Colonnes < 0 || Colonnes > 6 || grille[0][Colonnes] != 0) {
			if (Colonnes < 0 || Colonnes > 6) {
				erreur.erreurNumNNCores(numJoueur);
				Colonnes = Outils.scanner(s);
				System.out.println();
			}
			if (grille[0][Colonnes] != 0) {
				erreur.erreurColRemplie(numJoueur);
				Colonnes = Outils.scanner(s); 
				System.out.println();
			}
		}
		int numC = Colonnes;
		jouer(numJoueur, numC);
		afficheGrilleInit(grille);
		if (aGagne(numJoueur) || matchNul()) s.close();
	}
	
	public static void joueCoupRandom(int numJoueur) {
		int numC = Outils.entierAleatoire(0, 6);
		while (grille[0][numC] != 0) {
			numC = Outils.entierAleatoire(0, 6);
		}
		jouer(numJoueur, numC);
	}
	
	public static boolean joueCoupRandom2(int numJoueur) {
		boolean gagne = false;
		for(int i = 0; i < grille.length; i++) {
			boolean ColRemplie = false;
			if (grille[0][i] != 0) {
				ColRemplie = true;
			}
			else {
				jouer(numJoueur, i);
			}
			
			if (aGagne(numJoueur)) {
				gagne = true;
				return gagne;
			}
			if (!gagne && !ColRemplie) {
				deleteCoup(numJoueur, i);
			}
		}
		return gagne;
	}
	
	public static void deleteCoup(int numJoueur, int numC) {
		int i = 0;
		boolean effect = false;
		while (i < grille[numC].length && effect == false) {
			if(grille[0][numC] != 0) {
				effect = true;
			}
			if((grille[i][numC] == numJoueur) && !effect) {
				grille[i][numC] = 0;
				effect = true;
			}
			i++;	
		}
	}
	
	public static void afficheGrilleInit(int [][] tab ) {
		for (int i = 0; i< tab.length; i++) {
			for (int j = 0; j <  tab[i].length; j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void joueCoupRandom3(int numJoueur) {
//		joueCoupRandom2(1);
		afficheGrilleInit(grille);
		if (!joueCoupRandom2(numJoueur)) {
			int autreJoueur = 0;
			if (numJoueur == 1) {
				autreJoueur = 2;
			}
			else {
				autreJoueur = 1;
			}
			int Colonne = modifJoueCoupRandom2(autreJoueur);
			afficheGrilleInit(grille);
			if (Colonne == -1) {
				joueCoupRandom(numJoueur);
				afficheGrilleInit(grille);
			}
			else {
				jouer(numJoueur,Colonne);
				afficheGrilleInit(grille);
			}
		}
	}
	
	public static int modifJoueCoupRandom2(int numJoueur) {
		int gagne = -1;
		for(int i = grille.length-1; i >= 0; i--) {
			jouer(numJoueur, i);
			if (aGagne(numJoueur)) {
				gagne = i;
			}
			deleteCoup(numJoueur, i);
		}
		afficheGrilleInit(grille);
		return gagne;
	}
	
	
	
}
