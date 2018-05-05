package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SpielEngine {

	Scanner scanner = new Scanner(System.in);

	private List<Spieler> spielerListe = new ArrayList<>();
	private String spieler1Name;
	private String spieler2Name;
	private Spieler aktuellerSpieler;
	private EngineStatus status = EngineStatus.INIT;
	private int randomInt;
	private Random randomGenerator;
	private Spielfeld spielfeldDisplay;

	// Default Constructor
	public SpielEngine() {
	}

	// 3 Phasen die durchlaufen werden: 1 mal die INIT Phase, zum �bergeben der
	// Startparameter,
	// die VERARBEITE_EINGABE Phase beeinhaltet die Spielmechanik. Schleife bis Ende
	// Ende gibt die M�glichkeit des Neustarts

	public void SpielfeldDarstellen(Farbe[][] arrayDesSpielFeld) {
		for (int i = 0; i < arrayDesSpielFeld.length; i++) {
			for (int j = 0; j < arrayDesSpielFeld[i].length; j++)
				System.out.print("|" + arrayDesSpielFeld[i][j]);
			System.out.println("|");
		}
	}

	public void start() {

		while (true) {

			if (status == EngineStatus.INIT) {

				System.out.println("Spieler 1, bitte geben Sie Ihren Namen ein!");
				spieler1Name = scanner.next();
				System.out.println("Spieler 2, bitte geben Sie Ihren Namen ein!");
				spieler2Name = scanner.next();

				spielerListe.add(new Spieler(Farbe.ROT, spieler1Name));
				spielerListe.add(new Spieler(Farbe.GELB, spieler2Name));
				randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(1);
				aktuellerSpieler = spielerListe.get(randomInt);
				status = EngineStatus.VERARBEITE_EINGABE;
			}

			if (status == EngineStatus.VERARBEITE_EINGABE) {
				System.out.println("Bitte geben Sie eine Spalte f�r den Einwurf ein");
				int spalte = scanner.nextInt();
				aktuellerSpieler.setzeStein(spalte);
				// Darstellung des Spielfelds �ber die Konsole.
				// Hier wird die Methode SpielfeldDarstellen aus der selben Klasse aufgerufen.
				// Als Argument wird die Methode "getArraySpielFeld" aus der Klasse "Spielfeld"
				// �bergeben.
				// Dieser gibt als Return den von der Methode "SpielfeldDarstellen" erwarteten 2
				// dimensionalen Array aus. Warum aber verlangt akzeptiert er das Argument nicht
				// und will dass es in static �bertragen wird? Gibt es das Objekt nicht? Fehtl
				// die Referenz?
				SpielfeldDarstellen(Spielfeld.getArraySpielFeld());
			}

			if (status == EngineStatus.ENDE) {

			}

		}

	}
}
