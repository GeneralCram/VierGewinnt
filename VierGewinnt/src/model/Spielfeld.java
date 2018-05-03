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

	// Die Klasse Spielfeld sollte nicht direkt für die Darstellung des Spielfelds zuständig sein.
	// Stattdessen sollte die SpielEngine dies erledigen (das ist wichtig im Hinblick auf ein spätere Ausgliederung
	// der Darstellungslogik).
	// Schau nochmal in das Klassendiagramm und achte darauf, wo welche Methoden definiert sind.
	// Konkret ist in der Spielfeld-Klasse die Methode "getSpielfeldAnsicht" definiert. 
	// In der SpielEngine-Klasse ist die private Methode "zeigeSpielfeld" definiert.
	// 
	// Diese Methoden spielen folgendermaßen zusammen:
	// Die Methode "getSpielfeldAnsicht" soll eine Kopie von "arraySpielFeld" zurückgeben, damit es von außen nicht möglich ist, das Spielfeld zu verändern - Prinzip Information Hiding.
	// (Leider konnte ich den Rückgabetypen im Klassendiagramm nicht definieren. Lass dich davon also nicht beirren)
	// Wenn dir das zu kompliziert scheint, dann kann auch zunächst einfach das arraySpielFeld zurückgegeben werden.
	// Die SpielEngine-Klasse holt sich dann in der "zeigeSpielfeld"-Methode die Ansicht/Kopie dieses Arrays und gibt es auf der Konsole aus.

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