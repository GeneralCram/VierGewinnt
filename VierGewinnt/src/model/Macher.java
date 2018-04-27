package model;

import java.util.Scanner;

public class Macher {

	private Farbe siegBedingung;
	private int i;

	// Wie gebe ich einen Werte aus einer enum vor? Zum Testen
	private Farbe testFarbe = "ROT";
	Scanner SpalteUser = new Scanner(System.in);

	public Macher() {
	}

	{

		while (siegBedingung <> testFarbe)

		{

			// todo Mensch sucht eine Zeile aus
			
			// Aufpassen bei Usereingabe, nur INT gestattet
			i = SpalteUser.nextInt();
			
			
			// todo rausfinden welche unterste Zeile ist
			
			
			// todo Platziere Stein an unterster Stelle -> Unnötig / falsch? Muss doch erst Zeile ermittelt werden, bevor Wert übergeben wird?
			Spielfeld.setzeStein(i, testFarbe);
		

			// todo Prüfe ob Sieger, übergeben der Stelle des letzten Steineinwurfs, angrenzende Felder prüfen
			
			//Vertikal
			If (Spielfeld.getArraySpielFeld()arraySpielFeld[i][-3] = testFarbe && arraySpielFeld[i][-2] = testFarbe && arraySpielFeld[i][-1] = testFarbe)
			{siegBedingung = testFarbe;}
			elseif
			If (arraySpielFeld[i][-2] = testFarbe && arraySpielFeld[i][-1] = testFarbe && arraySpielFeld[][+1] = testFarbe)
			{siegBedingung = testFarbe;}
			elseif
			If (arraySpielFeld[i][-1] = testFarbe && arraySpielFeld[i][+1] = testFarbe && arraySpielFeld[][+2] = testFarbe)
			{siegBedingung = testFarbe;}			
			elseif
			If (arraySpielFeld[i][+1] = testFarbe && arraySpielFeld[i][+2] = testFarbe && arraySpielFeld[][+3] = testFarbe)
			{siegBedingung = testFarbe;}		
		}

	}
}