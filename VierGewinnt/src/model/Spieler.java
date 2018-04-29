/**
 * 
 */
package model;

/**
 * @author cram
 *
 */
public class Spieler {

	private String name;
	private Farbe farbe;

	public Spieler(Farbe farbe, String name) {

		this.name = name;
		this.farbe = farbe;

	}

	public void setzeStein(int spalte) {

		Spielfeld.getInstance().setzeStein(spalte, farbe);

	}

}
