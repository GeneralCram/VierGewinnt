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
	private Random randomGenerator;
	private boolean invalidInput = true;
	int spalte;

	// Default Constructor
	public SpielEngine() {
	}

	// 3 Phasen die durchlaufen werden: 1 mal die INIT Phase, zum Übergeben der
	// Startparameter,
	// die VERARBEITE_EINGABE Phase beeinhaltet die Spielmechanik. Schleife bis Ende
	// Ende gibt die Möglichkeit des Neustarts

	public void start() {

		while (true) {

			if (status == EngineStatus.INIT) {
				spielerAnlegen();
				status = EngineStatus.VERARBEITE_EINGABE;
			}

			if (status == EngineStatus.VERARBEITE_EINGABE) {

				liesSpalteUndSetzeStein();
				if (hatSpielerGewonnen() == true) {
					status = EngineStatus.ENDE;
				}

				zeigeSpielFeld(Spielfeld.getInstance().getSpielFeldAnsicht());
				wechselSpieler();
			}

			if (status == EngineStatus.ENDE) {
				System.out.println("Supergeil, Sie haben Gewonnen!");

			}

		}

	}

	private void zeigeSpielFeld(Farbe[][] arrayDesSpielFeld) {
		for (int i = 0; i < arrayDesSpielFeld.length; i++) {
			for (int j = 0; j < arrayDesSpielFeld[i].length; j++) {
				if (arrayDesSpielFeld[i][j] == null) {
					System.out.print("  |  ");
				} else {
					if (arrayDesSpielFeld[i][j] == Farbe.GELB) {
						System.out.print("  | " + "G");
					} else {
						System.out.print("  | " + "R");
					}

				}
			}
			System.out.println("  |  ");
		}
	}

	private void wechselSpieler() {
		if (aktuellerSpieler == spielerListe.get(1)) {
			aktuellerSpieler = spielerListe.get(0);
		} else if (aktuellerSpieler == spielerListe.get(0)) {
			aktuellerSpieler = spielerListe.get(1);
		}
	}

	private void spielerAnlegen() {
		System.out.println("Spieler 1, bitte geben Sie Ihren Namen ein!");
		spieler1Name = scanner.next();
		System.out.println("Spieler 2, bitte geben Sie Ihren Namen ein!");
		spieler2Name = scanner.next();

		spielerListe.add(new Spieler(Farbe.ROT, spieler1Name));
		spielerListe.add(new Spieler(Farbe.GELB, spieler2Name));
		randomGenerator = new Random();
		// Startspieler wird zufällig festgemacht
		int randomInt = randomGenerator.nextInt(1);
		aktuellerSpieler = spielerListe.get(randomInt);
	}

	private void liesSpalteUndSetzeStein() {
		invalidInput = true;
		//
		while (invalidInput) {

			System.out.print("Bitte geben Sie eine Spalte zwischen 1 und 7 für den Einwurf ein\" ");

			if (scanner.hasNextInt()) {
				spalte = scanner.nextInt();

				// Bereich checken
				if (spalte >= 1 && spalte <= 7) {
					invalidInput = false;
					spalte = spalte - 1;
				} else {
					System.out.println("Sie haben eine Zahl außerhalb 1-7 eingegeben.");
				}
			} else {
				System.out.println("Falsche Eingabe, bitte noch einmal");
				scanner.next();
			}
		}

		aktuellerSpieler.setzeStein(spalte);
	}

	private boolean hatSpielerGewonnen() {
		return Spielfeld.getInstance().sindVierInEinerReihe();

	}
}
