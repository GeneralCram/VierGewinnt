package model;

public class VierGewinntMain {

	// Müssen enums als Objekt erstellt werden? Nein, es kann statisch darauf
	// zugegriffen werden.

	public static void main(String[] args) {

		// Es wird hier der Konstruktor von SpielEngine ausgerufen - dieser erstellt ein
		// neues Objekt der Methode "Start"
		new SpielEngine();
	}
}