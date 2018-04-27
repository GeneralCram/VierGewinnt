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
	// 
	// Dies ist die Schnittstelle für den Spieler um mit dem Spielfeld zu interagieren.
	// Die Information in welcher Zeile der Stein zu liegen kommt, ist nur in dieser Klasse
	// vorhanden und somit nach außen gekapselt. Sie ist auch für den Spieler nicht relevant - Prinzip "Information Hiding".

	public void setzeStein(int spalte, Farbe farbe) {

	}

	public Spielfeld getInstance() {

		if (instanceSpielfeld == null) {
			instanceSpielfeld = new Spielfeld();
		}
		return instanceSpielfeld;
	}

	// Das Array soll nicht nach außen gegeben werden - Prinzip "Information Hiding"
	public Farbe[][] getArraySpielFeld() {
		return arraySpielFeld;
	}
}