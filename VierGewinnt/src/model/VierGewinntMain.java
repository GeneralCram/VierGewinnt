package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class VierGewinntMain {

	public static void main(String[] args) {
		// SpielEngineInterface test = new SpielEngine();
		// test.start();
		JButton button = new JButton();
		JLabel label = new JLabel();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Button gedrückt");
			}
		});

		acceptInterface(new SpielEngineInterface() {

			@Override
			public void start() {
				System.out.println("Tolle anonyme Klasse!");
			}
		});

	}

	static void acceptInterface(SpielEngineInterface test) {
		test.start();
	}
}