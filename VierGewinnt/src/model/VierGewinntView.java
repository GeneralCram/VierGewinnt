package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VierGewinntView extends JFrame implements ActionListener {

	private JLabel labelStatusleiste = new JLabel();
	private JPanel panelNamensEingabe = new JPanel();
	private SpielfeldPanel panelSpielfeld = new Spielfeldpanel;
	private JTextField eingabeFeldSpielername1 = new JTextField(14);
	private JTextField eingabeFeldSpielername2 new JTextField(14);
	private JButton buttonNamensEingabeOK = new JButton("Name akzeptieren");
	private JButton buttonNeustart = new JButton("Zurücksetzen");
	private JButton buttonEnde = new JButton("Beenden");

	public VierGewinntView(int inBreite, int inHoehe) {

		setTitle("Vier Gewinnt");
		setSize(inBreite, inHoehe);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panelNamensEingabe);
		add(eingabeFeldSpielername1);
		add(eingabeFeldSpielername2);
		add(buttonNamensEingabeOK);
		add(buttonNeustart);
		add(buttonEnde);

	}

	public void zeigeNamensEingabePanel() {
	}

	public void zeigeSpielfeldPanel() {
	}

	public void zeichneSpielfeld() {
	}

	public void setEndeButtonsVisible(boolean inVisible) {

	}

	public void zeigeStatus(String inStatusText) {
	}

	public getSpielername10 () 
	{return 
	}

	public getSpielername20 () 
	{return 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void addListenerNameEingabeOK ( inListener) {}

	public void addListenerNeustart( inListener)

	public void addListenerEnde()

	public void addMouseListenerSpielfeld()
}
