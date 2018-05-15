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

	// Das sieht soweit ok aus. Nur drei Dinge:
	// 1. Wieso nimmst du nicht z. B. "X" und "O" um die verschiedenen Farben zu
	// kennzeichnen? So würde das Feld bei der Ausgabe nicht so zerrissen aussehen
	// 2. Wieso schreibst du in der mittleren Ausgabe nicht auch " | " anstatt "|"?
	// So würde das Feld ebenfalls nicht so zerrissen aussehen.
	// 3. Wenn du dann noch die Kommentare im Code umsetzt, dann kommst du mit nur
	// einem if-Block aus (es gibt sogar eine noch elegantere Variante ganz ohne
	// if-Block, aber dazu später mehr).
	public void zeigeSpielFeld(Farbe[][] arrayDesSpielFeld) {
		for (int i = 0; i < arrayDesSpielFeld.length; i++) {
			for (int j = 0; j < arrayDesSpielFeld[i].length; j++) {
				if (arrayDesSpielFeld[i][j] == null) {
					System.out.print("  |  ");
				} else {
					System.out.print("  |" + arrayDesSpielFeld[i][j]);

					// if arrayDesSpielFeld[i][j] == "GELB" {System.out.print(" | " + "G"}; Warum
					// geht das nicht? Scheinbar weil hier der Wert als String Überprüft wird, er
					// aber den Typ Farbe erwartet.

				}
				if (j == 6) {
					System.out.println("  |  "); // Das hier hinter das Ende der inneren Schleife setzen, da das für
													// jede Zeile am Ende ausgegeben werden muss
				}
			}
		}
	}

	// Zunächst: Schau nochmal wieder ins Klassendiagramm.
	// Wie schon bei den beiden Methoden "zeigeSpielfeld" und "getSpielfeldAnsicht"
	// gibt es auch hier wieder zwei Methoden, die zusammenspielen sollen:
	// 1. In der Klasse "Spielfeld" gibt es die Methode "sindVierInEinerReihe": Hier
	// soll der Algorithmus implementiert werden, der prüft, ob vier Steine der
	// zuletzt gesetzten Farbe
	// in einer Reihe sind (horizontal, vertikal und diagonal). Dazu kann in der
	// Klasse "Spielfeld" ruhig die zuletzt gesetzte Farbe und die letzte verwendete
	// Spalte gespeichert werden,
	// sonst wird das zu kompliziert
	// 2. In der Klasse "SpielEngine" gibt es die Methode "spielerHatGewonnen": Hier
	// soll die Methode "sindVierInEinerReihe" verwendet/aufgerufen werden und wenn
	// true zurückkommt, dann hat
	// der aktuelleSpieler gewonnen und wenn false zurückkommt dann eben nicht. Kurz
	// gesagt gibt die Methode "spielerHatGewonnen" einfach den Rückgabewert von
	// "sindVierInEinerReihe" zurück.
	// 3. Die Methode "spielerHatGewonnen" wird unten dann so verwendet/aufgerufen,
	// wie du es schon mit dieser Methode "pruefeObVierInZeile" gemacht hast, um den
	// Sieg anzuzeigen (im Falle
	// des Siegs sollte hier dann natürlich auch der EngineStatus geändert werden)
	//
	// Nun zum Algorithmus: Den verstehe ich noch nicht so ganz. Ich sehe, dass du
	// prüfen willst, ob vier Steine in einer Zeile nebeneinander liegen, aber (in
	// der Schleife geht es weiter):
	public boolean pruefeObVierInZeile(Farbe[][] arraySpielFeld) {
		for (int zeile = 0; zeile < 5; zeile++) {
			int summe = 1;
			for (int spalte = 0; spalte < 6; spalte++) { // nur bis zur 6.Spalte pruefen, da die nachfolgende Spalte
															// immer mitkontrolliert wird
				if (arraySpielFeld[zeile][spalte] != null && arraySpielFeld[zeile][spalte + 1] != null
						&& arraySpielFeld[zeile][spalte] == arraySpielFeld[zeile][spalte + 1]) {
					summe++;

					// Wie soll diese Bedingung (summe >= 4) an dieser Stelle jemals wahr werden?
					// summe wird oben auf 1 gesetzt und bei dem Wert bleibt es dann auch.
					// Ich würde an dieser Stelle unkonditional (also ohne if-Block) summe = summe +
					// 1 oder auch einfach summe++ (ist die kurze Notation dafür) setzen.
					// So wird jedes Mal der Wert erhöht, wenn ein gleicher Stein als Nachbar
					// gefunden wird.
					// Sollte kein gleicher Nachbar gefunden werden, dann summe = 1.
					// Nachdem die innere Schleife für die Spalten durchgelaufen ist, kannst du dann
					// die Bedingung (summe >= 4) verwenden um true zurückzugeben. Also:

				} else { // Diesen Block als else-Zweig für den (arraySpielfeld[zeile][spalte] != null &&
							// ...)-Block (also den äußeren if-Block) verwenden
					summe = 1;
				}
			}
			if (summe >= 4) { // Diesen if-Block hinter die innere Schleife setzen
				System.out.println("Winner");
				return true;
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
				try {

					// Wie packt man hier eine Schleife drum, ohne dass er nur die Catch Exception
					// wiederholt? Bei meinem Versuch hat er die Exception gespammt und wollte
					// keinen neuen Input
					//
					// Die Schleife, die das hier immer wiederholt ist die äußere
					// while(true)-Schleife, solange sich der EngineStatus von VERARBEITE_EINGABE
					// nicht ändert.
					// Du kannst den try-Block einfach vergrößern und den gesamten Code von
					// "println("Bitte geben Sie eine Spalte... bis wechselSpieler()" in den
					// try-Block packen und den
					// catch-Block dann ganz ans Ende packen. Strukturell sieht das dann so aus:
					//
					// if (status == EngineStatus.VERARBEITE_EINGABE) {
					// try {
					// hier kommt der gesamte Code...
					// } catch (Exception e) {
					// hier kommt die Fehlermeldung
					// }
					// }
					//
					// Dann würde immer, wenn die Exception geworfen wird, durch die äußere
					// while(true)-Schleife wieder oben angefangen werden und direkt nach der
					// Fehlerausgabe wieder nach
					// der Spaltenzahl gefragt werden.
					//
					// Dazu aber noch folgende Anmerkungen:
					// 1. Du hast so noch nicht überprüft, ob eine zu kleine oder zu große
					// Spaltenzahl eingegeben wurde. Die Exceptions die von Scanner.nextInt()
					// geworfen werden können
					// beziehen sich nur darauf, ob überhaupt eine Zahl eingegeben wurde
					// (InputMismatchException, wenn keine Zahl eingegeben wurde)
					// oder ob funktionelle Probleme mit dem Scanner bestehen
					// (NoSuchElementException, IllegalStateException)
					// 2. Du betreibst hier Control-Flow-By-Exception, d. h. du verwendest eine
					// Exception als erwartetes Ergebnis um den Programmfluss zu steuern.
					// Das gilt als schlechter Stil (siehe hier warum:
					// https://softwareengineering.stackexchange.com/a/189225)
					// Im Grunde willst du ja sagen: Wenn die Exception (insbesondere NUR die
					// InputMismatchException) auftritt/geworfen wird, dann frage nochmal neu nach
					// der Spalte.
					// Das kannst du aber auch anders prüfen und vor allen Dingen reicht die
					// Exception allein auch nicht aus, um alle Fehleingaben abzufangen (zu kleine
					// oder große Spaltenzahl)
					// 3. Ein catch (Exception e)-Block, also ein Block der einfach jeden Typ von
					// Exception abfängt ist ebenfalls schlechter Stil.
					// Sorry für das frühe Bashing über Coding-Stil. Aber: Wehret den Anfängen ;)
					// (siehe hier warum: https://stackoverflow.com/a/2416334)
					// Du kannst ja nur bei der InputMismatchException sinnvollerweise nochmal nach
					// einer Eingabe fragen, die anderen beiden Exceptions deuten ja auf ein
					// funktionelles Problem
					// mit dem Scanner hin, der dann also offensichtlich keine weiteren Eingaben
					// mehr annehmen kann.
					//
					// Um es nun aber alles nicht zu kompliziert zu machen, kannst du das Ganze auch
					// erstmal, wie oben beschrieben umsetzen.
					// Optional natürlich mit der Prüfung auf zu kleine oder große Spaltenzahlen.
					// Merk dir aber am Besten, was ich hier schon mal zu Exception-Handling erwähnt
					// hab, damit es später richtig wird.

					System.out.print("Bitte geben Sie eine Spalte zwischen 1 und 7 für den Einwurf ein");
					while (!scanner.hasNextInt())
						System.out.println("Bitte geben Sie eine Zahl ein!");
					scanner.next();

					int spalte = scanner.nextInt() - 1;
					aktuellerSpieler.setzeStein(spalte);
				}

				catch (Exception e)

				{
					System.out.println("Sie Depp haben eine falsche Spaltenzahl eingegeben!");

				}

				if (pruefeObVierInZeile(Spielfeld.getInstance().getSpielFeldAnsicht()) == true) {
					status = EngineStatus.VERARBEITE_EINGABE;
				}
				zeigeSpielFeld(Spielfeld.getInstance().getSpielFeldAnsicht());

				wechselSpieler();

			}

			if (status == EngineStatus.ENDE) {
				System.out.println("Gewonnen!");

			}

		}

	}
}
