package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VierGewinntView extends JFrame implements ActionListener {

	private JLabel labelStatusleiste;
	private JPanel panelNamensEingabe;
	private SpielfeldPanel panelSpielfeld;
	private JTextField eingabeFeldSpielername1;
	private JTextField eingabeFeldSpielername2;
	private JButton buttonNamensEingabeOK;
	private JButton buttonNeustart;
	private JButton buttonEnde;

	public VierGewinntView(int inBreite, int inHoehe) {

		setTitle("Vier Gewinnt");
		setSize(inBreite, inHoehe);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
