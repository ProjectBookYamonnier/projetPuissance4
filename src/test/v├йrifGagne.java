package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class vérifGagne {

	public static boolean aGagneVer(int numJoueur, int numL, int numC, int [][] grille) {
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
	
	@Test
	public void verifieColonne() {
		int [][]tab1 = {{1,2,2,2,1,1,1},
		        		{1,1,2,2,2,1,1},
		        		{1,1,1,2,2,2,2},
		        		{1,1,1,2,2,2,2},
		        		{2,1,1,1,2,2,1},
		        		{2,2,1,1,1,2,1}};
		        		
		boolean t1 = aGagneVer(1,0,0,tab1);
		boolean t1bis2 = aGagneVer(2,0,0,tab1);
		boolean t2 = aGagneVer(1,1,1,tab1);
		boolean t2bis2 = aGagneVer(2,1,1,tab1);
		boolean t3 = aGagneVer(1,2,2,tab1);
		boolean t3bis2 = aGagneVer(2,2,2,tab1);
		boolean t4 = aGagneVer(1,0,3,tab1);
		boolean t4bis2 = aGagneVer(2,0,3,tab1);
		boolean t5 = aGagneVer(1,1,4,tab1);
		boolean t5bis2 = aGagneVer(2,1,4,tab1);
		boolean t6 = aGagneVer(1,2,5,tab1);
		boolean t6bis2 = aGagneVer(2,2,5,tab1);
		boolean depassement0 = aGagneVer(1,5,6,tab1);
		boolean testfalse0 = aGagneVer(1,0,6,tab1);
		boolean testfalse1 = aGagneVer(1,1,6,tab1);
		boolean testfalse2 = aGagneVer(1,2,6,tab1);
		boolean testbisfalse0 = aGagneVer(2,0,6,tab1);
		boolean testbisfalse1 = aGagneVer(2,1,6,tab1);
		boolean testbisfalse2 = aGagneVer(2,2,6,tab1);
		
		assertEquals(t1,true); 
		assertEquals(t1bis2,false);
		assertEquals(t2,true);
		assertEquals(t2bis2,false);
		assertEquals(t3,true); 
		assertEquals(t3bis2,false); 
		assertEquals(t4,false); 
		assertEquals(t4bis2,true);
		assertEquals(t5,false); 
		assertEquals(t5bis2,true);
		assertEquals(t6,false); 
		assertEquals(t6bis2,true);
		assertEquals(depassement0, false);
		assertEquals(testfalse0,false); 
		assertEquals(testfalse1,false);
		assertEquals(testfalse2,false);
		assertEquals(testbisfalse0,false);
		assertEquals(testbisfalse1,false);
		assertEquals(testbisfalse2,false);
		
	}
	
	public static boolean aGagneHor(int numJoueur, int numL, int numC, int [][] grille) {
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

	@Test
	public void verifieLigne() {
		int [][] tab1 = {{1,2,2,2,1,1,1},
		        		 {1,1,2,2,2,1,1},
		        		 {1,1,1,2,2,2,2},
		        		 {1,1,1,2,2,2,2},
		        		 {2,1,1,1,2,2,1},
		        	   	 {2,2,1,1,1,2,1}};
		
		int [][] tab2 = {{1,1,1,1,2,2,2},
						 {2,1,1,1,1,2,2},
        				 {2,2,1,1,1,1,2},
        				 {1,1,1,2,2,2,2},
        				 {2,1,1,1,2,2,1},
        				 {1,1,1,2,1,1,1}};
		
		int [][] tab3 = {{2,2,2,2,1,1,1},
						 {1,2,2,2,2,1,1},
						 {1,1,2,2,2,2,1},
						 {2,2,2,1,1,1,1},
						 {1,2,2,2,1,1,2},
						 {2,2,2,1,2,2,2}};

		boolean t1 = aGagneHor(1,0,0,tab1);
		boolean t1bis2 = aGagneHor(2,0,0,tab1);
		boolean t2 = aGagneHor(1,1,1,tab1);
		boolean t2bis2 = aGagneHor(2,1,1,tab1);
		boolean t3 = aGagneHor(1,2,3,tab1);
		boolean t3bis2 = aGagneHor(2,2,3,tab1);
		boolean t4 = aGagneHor(1,2,2,tab1);
		boolean t4bis2 = aGagneHor(2,2,3,tab1);
		boolean t5 = aGagneHor(1,4,1,tab1);
		boolean t5bis2 = aGagneHor(2,4,1,tab1);
		boolean t6 = aGagneHor(1,5,2,tab1);
		boolean t6bis2 = aGagneHor(2,5,2,tab1);
		boolean depassement1 = aGagneHor(1,5,5,tab1);
		boolean testfalse0 = aGagneHor(1,0,6,tab1);
		boolean testfalse1 = aGagneHor(1,1,6,tab1);
		boolean testfalse2 = aGagneHor(1,2,6,tab1);
		boolean testbisfalse0 = aGagneHor(2,0,6,tab1);
		boolean testbisfalse1 = aGagneHor(2,1,6,tab1);
		boolean testbisfalse2 = aGagneHor(2,2,6,tab1);
		boolean t7 = aGagneHor(1,0,0,tab2);
		boolean t7bis2 = aGagneHor(2,0,0,tab2);
		boolean t8 = aGagneHor(1,1,1,tab2);
		boolean t8bis2 = aGagneHor(2,1,1,tab2);
		boolean t9 = aGagneHor(1,2,2,tab2);
		boolean t9bis2 = aGagneHor(2,2,3,tab2);
		boolean t10 = aGagneHor(1,2,3,tab2);
		boolean t10bis2 = aGagneHor(2,2,3,tab2);
		boolean t11 = aGagneHor(1,4,1,tab2);
		boolean t11bis2 = aGagneHor(2,4,1,tab2);
		boolean t12 = aGagneHor(1,5,2,tab2);
		boolean t12bis2 = aGagneHor(2,5,2,tab2);
		boolean depassement2 = aGagneHor(1,5,5,tab2);
		boolean testfalse3 = aGagneHor(1,0,6,tab2);
		boolean testfalse4 = aGagneHor(1,1,6,tab2);
		boolean testfalse5 = aGagneHor(1,2,6,tab2);
		boolean testbisfalse3 = aGagneHor(2,0,6,tab2);
		boolean testbisfalse4 = aGagneHor(2,1,6,tab2);
		boolean testbisfalse5 = aGagneHor(2,2,6,tab2);
		boolean t13 = aGagneHor(1,0,0,tab3);
		boolean t13bis2 = aGagneHor(2,0,0,tab3);
		boolean t14 = aGagneHor(1,1,1,tab3);
		boolean t14bis2 = aGagneHor(2,1,1,tab3);
		boolean t15 = aGagneHor(1,2,3,tab3);
		boolean t15bis2 = aGagneHor(2,2,2,tab3);
		boolean t16 = aGagneHor(1,2,3,tab3);
		boolean t16bis2 = aGagneHor(2,2,3,tab3);
		boolean t17 = aGagneHor(1,4,1,tab3);
		boolean t17bis2 = aGagneHor(2,4,1,tab3);
		boolean t18 = aGagneHor(1,5,2,tab3);
		boolean t18bis2 = aGagneHor(2,5,2,tab3);
		boolean depassement3 = aGagneHor(1,5,5,tab3);
		boolean testfalse6 = aGagneHor(1,0,6,tab3);
		boolean testfalse7 = aGagneHor(1,1,6,tab3);
		boolean testfalse8 = aGagneHor(1,2,6,tab3);
		boolean testbisfalse6 = aGagneHor(2,0,6,tab3);
		boolean testbisfalse7 = aGagneHor(2,1,6,tab3);
		boolean testbisfalse8 = aGagneHor(2,2,6,tab3);
		
		assertEquals(t1,false); 
		assertEquals(t1bis2,false);
		assertEquals(t2,false);
		assertEquals(t2bis2,false);
		assertEquals(t3,false); 
		assertEquals(t3bis2,true); 
		assertEquals(t4,false); 
		assertEquals(t4bis2,true);
		assertEquals(t5,false); 
		assertEquals(t5bis2,false);
		assertEquals(t6,false); 
		assertEquals(t6bis2,false);
		assertEquals(depassement1, false);
		assertEquals(testfalse0,false); 
		assertEquals(testfalse1,false);
		assertEquals(testfalse2,false);
		assertEquals(testbisfalse0,false);
		assertEquals(testbisfalse1,false);
		assertEquals(testbisfalse2,false);
		assertEquals(t7,true); 
		assertEquals(t7bis2,false);
		assertEquals(t8,true);
		assertEquals(t8bis2,false);
		assertEquals(t9,true); 
		assertEquals(t9bis2,false); 
		assertEquals(t10,false); 
		assertEquals(t10bis2,false);
		assertEquals(t11,false); 
		assertEquals(t11bis2,false);
		assertEquals(t12,false); 
		assertEquals(t12bis2,false);
		assertEquals(depassement2, false);
		assertEquals(testfalse3,false); 
		assertEquals(testfalse4,false);
		assertEquals(testfalse5,false);
		assertEquals(testbisfalse3,false);
		assertEquals(testbisfalse4,false);
		assertEquals(testbisfalse5,false);
		assertEquals(t13,false); 
		assertEquals(t13bis2,true);
		assertEquals(t14,false);
		assertEquals(t14bis2,true);
		assertEquals(t15,false); 
		assertEquals(t15bis2,true); 
		assertEquals(t16,false); 
		assertEquals(t16bis2,false);
		assertEquals(t17,false); 
		assertEquals(t17bis2,false);
		assertEquals(t18,false); 
		assertEquals(t18bis2,false);
		assertEquals(depassement3, false);
		assertEquals(testfalse6,false); 
		assertEquals(testfalse7,false);
		assertEquals(testfalse8,false);
		assertEquals(testbisfalse6,false);
		assertEquals(testbisfalse7,false);
		assertEquals(testbisfalse8,false);
	}
	
	public static boolean aGagneDiagMont(int numJoueur, int numL, int numC, int grille [][]) {
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
	
	@Test
	public void verifieDiagMont() {
		int [][] tab1 = {{1,1,1,1,2,1,2},
		        		 {1,1,1,2,1,2,2},
		        		 {1,1,2,1,2,2,1},
		        		 {1,2,1,2,2,1,1},
		        		 {2,1,2,2,1,1,1},
		        	   	 {1,2,2,1,1,1,1}};
		
		int [][] tab2 = {{2,2,2,2,1,2,1},
						 {2,2,2,1,2,1,1},
        				 {2,2,1,2,1,1,2},
        				 {2,1,2,1,1,2,2},
        				 {1,2,1,1,2,2,2},
        				 {2,1,1,2,2,2,2}};
		
		boolean t1 = aGagneDiagMont(1,3,0,tab1);
		boolean t1bis2 = aGagneDiagMont(2,3,0,tab1);
		boolean t2 = aGagneDiagMont(1,2,0,tab1);
		boolean t2bis2 = aGagneDiagMont(2,2,0,tab1);
		boolean t3 = aGagneDiagMont(1,1,0,tab1);
		boolean t3bis2 = aGagneDiagMont(2,1,0,tab1);
		boolean t4 = aGagneDiagMont(1,0,0,tab1);
		boolean t4bis2 = aGagneDiagMont(2,0,0,tab1);
		boolean t5 = aGagneDiagMont(1,4,1,tab1);
		boolean t5bis2 = aGagneDiagMont(2,4,1,tab1);
		boolean t6 = aGagneDiagMont(1,3,2,tab1);
		boolean t6bis2 = aGagneDiagMont(2,3,2,tab1);
		boolean depassement1 = aGagneDiagMont(1,5,5,tab1);
		boolean testfalse0 = aGagneDiagMont(1,0,6,tab1);
		boolean testfalse1 = aGagneDiagMont(1,1,6,tab1);
		boolean testfalse2 = aGagneDiagMont(1,2,6,tab1);
		boolean testbisfalse0 = aGagneDiagMont(2,0,6,tab1);
		boolean testbisfalse1 = aGagneDiagMont(2,1,6,tab1);
		boolean testbisfalse2 = aGagneDiagMont(2,2,6,tab1);
		boolean t7 = aGagneDiagMont(1,0,0,tab2);
		boolean t7bis2 = aGagneDiagMont(2,0,0,tab2);
		boolean t8 = aGagneDiagMont(1,1,1,tab2);
		boolean t8bis2 = aGagneDiagMont(2,1,1,tab2);
		boolean t9 = aGagneDiagMont(1,2,2,tab2);
		boolean t9bis2 = aGagneDiagMont(2,2,3,tab2);
		boolean t10 = aGagneDiagMont(1,2,3,tab2);
		boolean t10bis2 = aGagneDiagMont(2,2,3,tab2);
		boolean t11 = aGagneDiagMont(1,4,1,tab2);
		boolean t11bis2 = aGagneDiagMont(2,4,1,tab2);
		boolean t12 = aGagneDiagMont(1,5,2,tab2);
		boolean t12bis2 = aGagneDiagMont(2,5,2,tab2);
		boolean depassement2 = aGagneDiagMont(1,5,5,tab2);
		boolean testfalse3 = aGagneDiagMont(1,0,6,tab2);
		boolean testfalse4 = aGagneDiagMont(1,1,6,tab2);
		boolean testfalse5 = aGagneDiagMont(1,2,6,tab2);
		boolean testbisfalse3 = aGagneDiagMont(2,0,6,tab2);
		boolean testbisfalse4 = aGagneDiagMont(2,1,6,tab2);
		boolean testbisfalse5 = aGagneDiagMont(2,2,6,tab2);
		
		assertEquals(t1,true); 
		assertEquals(t1bis2,false);
		assertEquals(t2,false);
		assertEquals(t2bis2,false);
		assertEquals(t3,false); 
		assertEquals(t3bis2,false); 
		assertEquals(t4,false); 
		assertEquals(t4bis2,false);
		assertEquals(t5,true); 
		assertEquals(t5bis2,false);
		assertEquals(t6,true); 
		assertEquals(t6bis2,false);
		assertEquals(depassement1, false);
		assertEquals(testfalse0,false); 
		assertEquals(testfalse1,false);
		assertEquals(testfalse2,false);
		assertEquals(testbisfalse0,false);
		assertEquals(testbisfalse1,false);
		assertEquals(testbisfalse2,false);
		assertEquals(t7,false); 
		assertEquals(t7bis2,false);
		assertEquals(t8,false);
		assertEquals(t8bis2,false);
		assertEquals(t9,false); 
		assertEquals(t9bis2,false); 
		assertEquals(t10,false); 
		assertEquals(t10bis2,false);
		assertEquals(t11,false); 
		assertEquals(t11bis2,true);
		assertEquals(t12,true); 
		assertEquals(t12bis2,false);
		assertEquals(depassement2, false);
		assertEquals(testfalse3,false); 
		assertEquals(testfalse4,false);
		assertEquals(testfalse5,false);
		assertEquals(testbisfalse3,false);
		assertEquals(testbisfalse4,false);
		assertEquals(testbisfalse5,false);
	}
	
	public static boolean aGagneDiagDesc(int numJoueur, int numL, int numC, int [][] grille) {
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

	@Test
	public void verifieDiagDesc() {
		int [][] tab1 = {{1,2,2,1,1,1,1},
		        		 {2,1,2,2,1,1,1},
		        		 {1,2,1,2,2,1,1},
		        		 {1,1,2,1,2,2,1},
		        		 {1,1,1,2,1,2,2},
		        	   	 {1,1,1,1,2,1,2}};
		
		int [][] tab2 = {{2,1,1,2,2,2,2},
						 {1,2,1,1,2,2,2},
        				 {2,1,2,1,1,2,2},
        				 {2,2,1,2,1,1,2},
        				 {2,2,2,1,2,1,1},
        				 {2,2,2,2,1,2,1}};
		
		boolean t1 = aGagneDiagDesc(1,3,0,tab2);
		boolean t1bis2 = aGagneDiagDesc(2,3,0,tab2);
		boolean t2 = aGagneDiagDesc(1,2,0,tab2);
		boolean t2bis2 = aGagneDiagDesc(2,2,0,tab2);
		boolean t3 = aGagneDiagDesc(1,0,4,tab2);
		boolean t3bis2 = aGagneDiagDesc(2,0,4,tab2);
		boolean t4 = aGagneDiagDesc(1,0,5,tab2);
		boolean t4bis2 = aGagneDiagDesc(2,0,5,tab2);
		boolean t5 = aGagneDiagDesc(1,0,6,tab2);
		boolean t5bis2 = aGagneDiagDesc(2,0,6,tab2);
		boolean t6 = aGagneDiagDesc(1,1,1,tab2);
		boolean t6bis2 = aGagneDiagDesc(2,1,1,tab2);
		boolean depassement1 = aGagneDiagDesc(1,5,5,tab2);
		boolean testfalse0 = aGagneDiagDesc(1,0,6,tab2);
		boolean testfalse1 = aGagneDiagDesc(1,1,6,tab2);
		boolean testfalse2 = aGagneDiagDesc(1,2,6,tab2);
		boolean testbisfalse0 = aGagneDiagDesc(2,0,6,tab2);
		boolean testbisfalse1 = aGagneDiagDesc(2,1,6,tab2);
		boolean testbisfalse2 = aGagneDiagDesc(2,2,6,tab2);
		boolean t7 = aGagneDiagDesc(1,2,0,tab2);
		boolean t7bis2 = aGagneDiagDesc(2,2,0,tab2);
		boolean t8 = aGagneDiagDesc(1,2,2,tab2);
		boolean t8bis2 = aGagneDiagDesc(2,2,2,tab2);
		boolean t9 = aGagneDiagDesc(1,3,0,tab2);
		boolean t9bis2 = aGagneDiagDesc(2,3,0,tab2);
		boolean t10 = aGagneDiagDesc(1,3,3,tab2);
		boolean t10bis2 = aGagneDiagDesc(2,3,3,tab2);
		boolean t11 = aGagneDiagDesc(1,4,0,tab2);
		boolean t11bis2 = aGagneDiagDesc(2,4,0,tab2);
		boolean t12 = aGagneDiagDesc(1,5,0,tab2);
		boolean t12bis2 = aGagneDiagDesc(2,5,0,tab2);
		boolean depassement2 = aGagneDiagDesc(1,5,5,tab1);
		boolean testfalse3 = aGagneDiagDesc(1,0,6,tab1);
		boolean testfalse4 = aGagneDiagDesc(1,1,6,tab1);
		boolean testfalse5 = aGagneDiagDesc(1,2,6,tab1);
		boolean testbisfalse3 = aGagneDiagDesc(2,0,6,tab1);
		boolean testbisfalse4 = aGagneDiagDesc(2,1,6,tab1);
		boolean testbisfalse5 = aGagneDiagDesc(2,2,6,tab1);
		
		assertEquals(t1,false); 
		assertEquals(t1bis2,false);
		assertEquals(t2,false);
		assertEquals(t2bis2,true);
		assertEquals(t3,false); 
		assertEquals(t3bis2,false); 
		assertEquals(t4,false); 
		assertEquals(t4bis2,false);
		assertEquals(t5,false); 
		assertEquals(t5bis2,false);
		assertEquals(t6,false); 
		assertEquals(t6bis2,true);
		assertEquals(depassement1, false);
		assertEquals(testfalse0,false); 
		assertEquals(testfalse1,false);
		assertEquals(testfalse2,false);
		assertEquals(testbisfalse0,false);
		assertEquals(testbisfalse1,false);
		assertEquals(testbisfalse2,false);
		assertEquals(t7,false); 
		assertEquals(t7bis2,true);
		assertEquals(t8,false);
		assertEquals(t8bis2,true);
		assertEquals(t9,false); 
		assertEquals(t9bis2,false);
		assertEquals(t10,false); 
		assertEquals(t10bis2,false);
		assertEquals(t11,false); 
		assertEquals(t11bis2,false);
		assertEquals(t12,false); 
		assertEquals(t12bis2,false);
		assertEquals(depassement2, false);
		assertEquals(testfalse3,false); 
		assertEquals(testfalse4,false);
		assertEquals(testfalse5,false);
		assertEquals(testbisfalse3,false);
		assertEquals(testbisfalse4,false);
		assertEquals(testbisfalse5,false);
	}
	
	public static boolean aGagne(int numJoueur, int [][] grille) {
		boolean gagne = false;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				if (aGagneHor(numJoueur, i, j, grille) == true || aGagneVer(numJoueur, i, j, grille) == true || aGagneDiagMont(numJoueur, i, j, grille) == true || aGagneDiagDesc(numJoueur, i, j, grille) == true) {
					gagne = true;
				}
			}
		}
		return gagne;
	}
	
	@Test
	public void verifieaGagne() {
		
		int [][] tab1 = {{0,0,0,0,0,0,0},
				 		 {0,0,0,0,0,0,0},
				 		 {0,0,0,0,0,0,0},
				 		 {0,0,0,0,0,0,0},
				 		 {1,0,2,0,1,0,2},
				 		 {2,1,1,2,2,2,2}};
		
		int [][] tab2 = {{0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0},
						 {1,0,0,0,0,0,0},
						 {1,0,0,0,0,0,0},
						 {1,0,1,0,2,0,2},
						 {1,1,2,1,2,2,2}};
		
		int [][] tab3 = {{0,0,0,0,0,0,0},
						 {0,0,0,0,0,1,0},
						 {0,0,0,2,2,2,0},
						 {0,0,2,1,1,1,2},
						 {0,2,2,2,1,1,2},
						 {2,2,2,1,2,2,2}};
		
		boolean t1 = aGagne(1, tab1);
		boolean t1bis = aGagne(2, tab1);
		boolean t2 = aGagne(1, tab2);
		boolean t2bis = aGagne(2, tab2);
		boolean t3 = aGagne(1, tab3);
		boolean t3bis = aGagne(2, tab3);
		
		assertEquals(t1,false); 
		assertEquals(t1bis,true);
		assertEquals(t2,true);
		assertEquals(t2bis,false); 
		assertEquals(t3,false);
		assertEquals(t3bis,true);
	}
	
	public static boolean matchNul(int [][] grille) {
		int totalGrille = grille.length*grille[0].length;
		int total = 0;
		for (int i = 0; i < grille.length; i++){
			for (int j = 0; j < grille[i].length; j++){
				if (grille[i][j] != 0 && !aGagne(1, grille) && !aGagne(2, grille)){
					total++;
				}
				if (total == totalGrille) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Test
	public void verifieMatchNul() {
		int [][] tab1 = {{1,2,1,2,1,2,1},  //MATCH NUL
		        		 {1,2,1,2,1,2,1},
		        		 {2,1,2,1,2,1,2},
		        		 {2,1,2,1,2,1,2},
		        		 {2,1,2,1,2,1,2},
		        	   	 {1,2,1,2,1,2,1}};
		
		int [][] tab2 = {{0,0,0,0,0,0,0},  //PAS DE MATCH NUL ET PAS DE GAGNE
				 		 {0,0,0,0,0,0,0},
				 		 {0,1,0,0,0,0,2},
				 		 {0,2,1,0,1,0,2},
				 		 {0,2,2,1,2,1,1},
				 		 {0,2,2,2,1,2,1}};
		
		int [][] tab3 = {{1,2,1,1,1,1,2},  //PARTIE GAGNANTE
						 {2,1,2,1,1,1,2},
						 {2,1,2,2,2,1,1},
						 {1,2,2,1,1,2,1},
						 {1,1,1,2,1,2,2},
						 {1,1,2,1,2,1,2}};
		
		boolean t1 = matchNul(tab1);
		boolean t2 = matchNul(tab2);
		boolean t3 = matchNul(tab3);
		
		assertEquals(t1,true); 
		assertEquals(t2,false);
		assertEquals(t3,false);
	}
	
	
}
