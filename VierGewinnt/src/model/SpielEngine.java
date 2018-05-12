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

	// Default Constructor
	public SpielEngine() {
	}

	// 3 Phasen die durchlaufen werden: 1 mal die INIT Phase, zum Übergeben der
	// Startparameter,
	// die VERARBEITE_EINGABE Phase beeinhaltet die Spielmechanik. Schleife bis Ende
	// Ende gibt die Möglichkeit des Neustarts

	public void zeigeSpielFeld(Farbe[][] arrayDesSpielFeld) {
		for (int i = 0; i < arrayDesSpielFeld.length; i++) {
			for (int j = 0; j < arrayDesSpielFeld[i].length; j++) {
				if (arrayDesSpielFeld[i][j] == null) {
					System.out.print("  |  ");
				} else {
					System.out.print("|" + arrayDesSpielFeld[i][j]);
				}
				if (j == 6) {
					System.out.println("  |  ");
				}
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
					if (summe >= 4) {
						summe = summe + 1;
						if (summe >= 4) {
							return true;
						}
					} else {
						summe = 1;
					}
				}
			}
		}
		return false;
	}

	private void wechselSpieler() {
		if (aktuellerSpieler == spielerListe.get(1)) {
			aktuellerSpieler = spielerListe.get(0);
		} else if (aktuellerSpieler == spielerListe.get(0)) {
			aktuellerSpieler = spielerListe.get(1);
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
				// Startspieler wird zufällig festgemacht
				int randomInt = randomGenerator.nextInt(1);
				aktuellerSpieler = spielerListe.get(randomInt);
				status = EngineStatus.VERARBEITE_EINGABE;
			}

			if (status == EngineStatus.VERARBEITE_EINGABE) {
				System.out.println("Bitte geben Sie eine Spalte zwischen 1 und 7 für den Einwurf ein");

				// Wie packt man hier eine Schleife drum, ohne dass er nur die Catch Exception
				// wiederholt? Bei meinem Versuch hat er die Exception gespammt und wollte
				// keinen neuen Input
				try {
					int spalte = scanner.nextInt() - 1;
					aktuellerSpieler.setzeStein(spalte);
				}

				catch (Exception e)

				{
					System.out.println("Sie Depp haben eine falsche Spaltenzahl eingegeben!");

				}

				if (pruefeObVierInZeile(Spielfeld.getInstance().getSpielFeldAnsicht()) == true) {
					System.out.println("Gewonnen!");
				}
				zeigeSpielFeld(Spielfeld.getInstance().getSpielFeldAnsicht());

				wechselSpieler();

			}

			if (status == EngineStatus.ENDE) {

			}

		}

	}
}
