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

	public void start() {

		while (true) {

			if (status == EngineStatus.INIT) {

				spieler1Name = scanner.next();
				spieler2Name = scanner.next();

				spielerListe.add(new Spieler(Farbe.ROT, spieler1Name));
				spielerListe.add(new Spieler(Farbe.GELB, spieler2Name));
				randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(1);
				aktuellerSpieler = spielerListe.get(randomInt);
				status = EngineStatus.VERARBEITE_EINGABE;
			}

			if (status == EngineStatus.VERARBEITE_EINGABE) {
				int spalte = scanner.nextInt();
				aktuellerSpieler.setzeStein(spalte);

			}

			if (status == EngineStatus.ENDE) {

			}

		}

	}
}
