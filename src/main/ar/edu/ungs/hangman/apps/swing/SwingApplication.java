package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.Application;

import javax.swing.*;

public final class SwingApplication extends Application {
	@Override
	public void run() {
		JFrame frame = new JFrame("SwingApplication");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 500);
	}

}
