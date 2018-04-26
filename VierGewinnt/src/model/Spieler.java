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
	private Spielfeld spielfeld;

	public Spieler(Spielfeld spielfeld, Farbe farbe, String name) {

		this.name = name;
		this.farbe = farbe;
		this.spielfeld = spielfeld;
	}
}