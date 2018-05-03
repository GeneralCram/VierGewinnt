package model;

public class VierGewinntMain {

	// Müssen enums als Objekt erstellt werden? Nein, es kann statisch darauf
	// zugegriffen werden.

	// Ich gehe hier auf deinen Commit-Kommentar bzgl. dem Aufrufen der start-Methode aus der SpielEngine ein.
	//
	// Zunächst nochmal der Hinweis:
	// Jegliche "public"-Methoden können immer nur an einem konkreten Objekt aufgerufen werden. 
	// Nur "public static"-Methoden können direkt an der Klasse aufgerufen werden, ohne vorher ein Objekt der Klasse erzeugt zu haben.
	// 
	// Konkret heißt das nun:
	// 1. Die Methode "start" ist nur "public" NICHT "static", also muss zunächst ein Objekt von "SpielEngine" erzeugt werden.
	// 2. Erstelle dieses Objekt von "SpielEngine" per "new SpielEngine()"
	// 3. Rufe die "start"-Methode an diesem Objekt auf.
	//
	// Beispiel-Code (nur innerhalb einer Methode gültig, z. B. innerhalb der "main"):
	// SpielEngine spielEngine = new SpielEngine(); // Objekt erstellen
	// spielEngine.start(); 			

	public static void main(String[] args) {

	}
}