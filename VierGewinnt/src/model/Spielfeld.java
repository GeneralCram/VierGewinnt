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

	public boolean pruefeObVierInZeile(Farbe[][] arraySpielFeld) {
		for (int zeile = 0; zeile < 6; zeile++) {
			int summe = 1;
			for (int spalte = 0; spalte < 6; spalte++) { // nur bis zur 6.Spalte pruefen, da die nachfolgende Spalte
															// immer mitkontrolliert wird
				if (arraySpielFeld[zeile][spalte + 1] != null && arraySpielFeld[zeile][spalte] != null
						&& arraySpielFeld[zeile][spalte] == arraySpielFeld[zeile][spalte + 1]) {
					summe++;

					// Wie soll diese Bedingung (summe >= 4) an dieser Stelle jemals wahr werden?
					// summe wird oben auf 1 gesetzt und bei dem Wert bleibt es dann auch.
					// Ich würde an dieser Stelle unkonditional (also ohne if-Block) summe = summe +
					// 1 oder auch einfach summe++ (ist die kurze Notation dafür) setzen.
					// So wird jedes Mal der Wert erhöht, wenn ein gleicher Stein als Nachbar
					// gefunden wird.
					// Sollte kein gleicher Nachbar gefunden werden, dann summe = 1.
					// Nachdem die innere Schleife für die Spalten durchgelaufen ist, kannst du dann
					// die Bedingung (summe >= 4) verwenden um true zurückzugeben. Also:

				} else { // Diesen Block als else-Zweig für den (arraySpielfeld[zeile][spalte] != null &&
							// ...)-Block (also den äußeren if-Block) verwenden
					summe = 1;
				}
			}
			if (summe >= 4) { // Diesen if-Block hinter die innere Schleife setzen
				return true;
			}
		}
		return false;

	}

	public boolean VierEineReihe() {

		return false;
	}

}