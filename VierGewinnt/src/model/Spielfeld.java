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

	public boolean VierEineReihe() {

		return false;
	}

}