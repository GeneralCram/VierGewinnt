/**
 * 
 */
package model;

/**
 * @author cram
 *
 */
public class Spielfeld {

	private final Farbe arraySpielFeld[][] = new Farbe[6][7];
	private Spielfeld instanceSpielfeld;

	private Spielfeld() {
	}

	public void setzeStein(int spalte, Farbe farbe) {
	}

	public Spielfeld getInstance() {

		if (instanceSpielfeld == null) {
			instanceSpielfeld = new Spielfeld();
		}
		return instanceSpielfeld;

	}
}
