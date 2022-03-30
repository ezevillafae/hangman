package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;

public abstract class BaseView extends JFrame {
	public BaseView() {
		setupComponents();
	}

	abstract void setupComponents();
}
