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

	public Spielfeld() {
	}

	// Dies ist der Setter? Hat hier doch gar nichts zu suchen, es muss doch auch
	// angegeben sein welche Zeile damit ein Wert gesetzt werden kann.
	// Dieser wiederrum muss doch erst ermittelt werden, dies wiederrum passiert
	// doch in der "controller Klasse"/Macher (die aber nicht der MVC Controller ist
	// und nicht die Main ist)

	public void setzeStein(int spalte, Farbe farbe) {

	}

	public Spielfeld getInstance() {

		if (instanceSpielfeld == null) {
			instanceSpielfeld = new Spielfeld();
		}
		return instanceSpielfeld;
	}

	public Farbe[][] getArraySpielFeld() {
		return arraySpielFeld;
	}
}