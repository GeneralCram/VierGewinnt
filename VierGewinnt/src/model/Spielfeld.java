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

	// Wie lasse ich diese Methode das Spielfeld darstellen? Wenn ich Sie in
	// Spielengine aurufe, muss ich ja ein Array zum darstellen übergeben. Das Array
	// ist aber als Private in der Klasse Spielfeld deklariert. Über
	// InstanceSpielfeld vlt, oder is das nur zum Erstellen des Objekts?
	// Ahh, scheinbar war ein Schreibfehler drin. Jetzt erkennt er ArraySpielFeld
	//
	// Immer noch kein Verständnis. Ich brauche ein Objekt, an dem ich diese Methode
	// anwenden kann. Das Objekt wird innerhalb der Methode genannt
	// ArraySpielFeld ist ja auch schon erschaffen. Aber wenn ich diese Methode
	// innerhalb von SpielEngine nutzen will, muss ich in SpielEngine erst noch ein
	// Objekt davon erschaffen?!
	//
	// Mhhh dritter Ansatz. Also instanceSpielfeld ist ein Objekt der Klasse
	// Spielfeld. ArraySpielFeld ist ein Objekt innerhalb des Objekts der Klasse
	// SpielFeld.
	//

	public void SpielfeldDarstellen() {
		for (int i = 0; i < arraySpielFeld.length; i++) {
			for (int j = 0; j < arraySpielFeld[i].length; j++)
				System.out.print("|" + arraySpielFeld[i][j]);
			System.out.println("|");
		}
	}

	public boolean VierEineReihe() {

		return false;
	}

}