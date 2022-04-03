package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JComponent {
	public abstract Integer width();
	public abstract Integer height();
	public abstract Integer margin();

	protected void showMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}
}
