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

	// 3 Phasen die durchlaufen werden: 1 mal die INIT Phase, zum Übergeben der
	// Startparameter,
	// die VERARBEITE_EINGABE Phase beeinhaltet die Spielmechanik. Schleife bis Ende
	// Ende gibt die Möglichkeit des Neustarts
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
				System.out.println("Bitte geben Sie eine Spalte für den Einwurf ein");
				int spalte = scanner.nextInt();
				aktuellerSpieler.setzeStein(spalte);
				// Es scheint das Falsche Spielfeld referenziert zu sein? bei
				// .SpielfeldDarstellen! !!! Was
				// viel wichtiger ist, bei
				// der Darstellung kommt es doch sicherlich zu einer NullPointerException! Wie
				// soll das Programm leere Felder darstellen? Eieiei Vielleicht dafür einmal
				// alle über eine Schleife alle leeren (Null) Felder mit z.B. "Leer" füllen und
				// danach alle mit "Leer" wieder zu Null machen? Das is doch nix
				spielfeldDisplay.SpielfeldDarstellen();
			}

			if (status == EngineStatus.ENDE) {

			}

		}

	}
}
