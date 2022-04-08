package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;

public abstract class View {
	protected final JFrame frame;

	public View() {
		this.frame = new JFrame();
	}

	protected void showMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}


	public JFrame frame() {
		return this.frame;
	}

	public void dispose() {
		this.frame.dispose();
		this.frame.setVisible(false);
	}
}
