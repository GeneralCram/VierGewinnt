package model;

import java.util.Scanner;

public class Macher {

	private Farbe siegBedingung;
	private int i;

	// Wie gebe ich einen Werte aus einer enum vor? Zum Testen
	// Z. B. Farbe.ROT (du greifst darauf zu, wie auf "public" Variablen)
	private Farbe testFarbe = "ROT";
	Scanner SpalteUser = new Scanner(System.in);

	public Macher() {
	}

	{

		while (siegBedingung <> testFarbe)

		{

			// TODO Mensch sucht eine Zeile aus
			// TODOs immer gro� schreiben, damit sie in der "Tasks" View erscheinen
			
			// TODO Aufpassen bei Usereingabe, nur INT gestattet
			i = SpalteUser.nextInt();
			
			
			// TODO rausfinden welche unterste Zeile ist
			// Sollte nicht hier passieren, siehe Spielfeld-Klasse
			
			
			// TODO Platziere Stein an unterster Stelle -> Unn�tig / falsch? Muss doch erst Zeile ermittelt werden, bevor Wert �bergeben wird?
			// Siehe oben
			Spielfeld.setzeStein(i, testFarbe);
		

			// TODO Pr�fe ob Sieger, �bergeben der Stelle des letzten Steineinwurfs, angrenzende Felder pr�fen
			// Sollte auch nicht hier passieren, sondern auch in der Spielfeld-Klasse
			
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