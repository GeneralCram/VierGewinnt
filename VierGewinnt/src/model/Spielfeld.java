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

	public Spielfeld() {
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

	public static Spielfeld getInstance() {

		if (instanceSpielfeld == null) {
			instanceSpielfeld = new Spielfeld();
		}
		return instanceSpielfeld;

	}

	public void SpielfeldDarstellen(Farbe[][] arraySpielfeld) {
		for (int i = 0; i < arraySpielfeld.length; i++) {
			for (int j = 0; j < arraySpielfeld[i].length; j++)
				System.out.print("|" + arraySpielfeld[i][j]);
			System.out.println("|");
		}
	}

	public boolean VierEineReihe() {

		return false;
	}

}