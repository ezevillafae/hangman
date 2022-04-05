package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;

public abstract class View {
	protected void showMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}

	public abstract JFrame frame();
}
