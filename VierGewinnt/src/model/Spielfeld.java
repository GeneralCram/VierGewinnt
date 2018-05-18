/**
 * 
 */
package model;

/**
 * @author cram
 *
 */
public class Spielfeld {

	// Spielfeld [Zeile] [Spalte]
	private final Farbe arraySpielFeld[][] = new Farbe[6][7];
	private static Spielfeld instanceSpielfeld;

	private Spielfeld() {
	}

	public void setzeStein(int spalte, Farbe farbe) {

		// Ermitteln an welcher Stelle/Loch die unterste freie Position an der
		// ausgewählten Spalte liegt
		for (int i = 5; i >= 0; i--) {
			if (arraySpielFeld[i][spalte] == null) {
				arraySpielFeld[i][spalte] = farbe;
				break;
			}

		}

	}

	public Farbe[][] getSpielFeldAnsicht() {
		return arraySpielFeld;
	}

	public static Spielfeld getInstance() {

		if (instanceSpielfeld == null) {
			instanceSpielfeld = new Spielfeld();
		}
		return instanceSpielfeld;

	}

	public void leereFeld() {
		for (int zeile = 0; zeile < arraySpielFeld.length; zeile++) {
			for (int spalte = 0; spalte < arraySpielFeld[zeile].length; spalte++) {
				arraySpielFeld[zeile][spalte] = null;
			}
		}
	}

	public boolean sindVierInEinerReihe() {
		// Zeilen
		for (int zeile = 0; zeile < 6; zeile++) {
			int summe = 1;

			for (int spalte = 0; spalte < 6; spalte++) {
				if (arraySpielFeld[zeile][spalte] != null && arraySpielFeld[zeile][spalte + 1] != null
						&& arraySpielFeld[zeile][spalte] == arraySpielFeld[zeile][spalte + 1]) {
					summe++;

					if (summe >= 4) {
						return true;
					}

				} else {
					summe = 1;

				}
			}
		}
		// Spalten
		for (int spalte = 0; spalte < 7; spalte++) {
			int summe = 1;

			for (int zeile = 0; zeile < 5; zeile++) {
				if (arraySpielFeld[zeile][spalte] != null && arraySpielFeld[zeile + 1][spalte] != null
						&& arraySpielFeld[zeile][spalte] == arraySpielFeld[zeile + 1][spalte]) {
					summe++;

					if (summe >= 4) {
						return true;
					}

				} else {
					summe = 1;

				}
			}
		}

		// Diagonale Reihen Mitte bis unten links
		for (int zeile = 0; zeile < 5; zeile++) {
			int summe = 1;
			int tempZeilenCounter = zeile;

			for (int spalte = 0; spalte < (5 - zeile); spalte++) {
				if (arraySpielFeld[tempZeilenCounter][spalte] != null
						&& arraySpielFeld[tempZeilenCounter + 1][spalte + 1] != null
						&& arraySpielFeld[tempZeilenCounter][spalte] == arraySpielFeld[tempZeilenCounter + 1][spalte
								+ 1]) {
					summe++;

					if (summe >= 4) {
						return true;
					}
				} else {
					summe = 1;
				}

				tempZeilenCounter++;
			}
		}

		// Diagonale Reihen Mitte bis oben rechts
		for (int spalte = 1; spalte < 7; spalte++) {
			int summe = 1;
			int tempSpaltenCounter = spalte;

			for (int zeile = 0; zeile < (6 - spalte); zeile++) {
				if (arraySpielFeld[zeile][tempSpaltenCounter] != null
						&& arraySpielFeld[zeile + 1][tempSpaltenCounter + 1] != null
						&& arraySpielFeld[zeile][tempSpaltenCounter] == arraySpielFeld[zeile + 1][tempSpaltenCounter
								+ 1]) {
					summe++;

					if (summe >= 4) {
						return true;
					}
				} else {
					summe = 1;
				}

				tempSpaltenCounter++;
			}
		}

		// for (int spalte = 0; spalte < 2; spalte++) {
		// int summe = 1;
		//
		// for (int zeile = 0; zeile < 5; zeile++) {
		// if (arraySpielFeld[zeile][zeile] != null && arraySpielFeld[zeile + 1][zeile +
		// 1] != null
		// && arraySpielFeld[zeile][zeile] == arraySpielFeld[zeile + 1][zeile + 1]) {
		// summe++;
		//
		// if (summe >= 4) {
		// return true;
		// }
		//
		// } else {
		// summe = 1;
		//
		// }
		// }
		// }
		//
		// for (int spalte = 2; spalte < 4; spalte++) {
		// int summe = 1;
		//
		// for (int zeile = 0; testbedingung < 5; zeile++) {
		// if (arraySpielFeld[zeile][zeile] != null && arraySpielFeld[zeile + 1][zeile +
		// 1] != null
		// && arraySpielFeld[zeile][zeile] == arraySpielFeld[zeile + 1][zeile + 1]) {
		// summe++;
		//
		// if (summe >= 4) {
		// return true;
		// }
		//
		// } else {
		// summe = 1;
		//
		// }
		// }
		// }

		return false;
	}

}