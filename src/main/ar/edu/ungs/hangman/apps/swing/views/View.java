package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;

public abstract class View extends JFrame {
	protected void draw(){
		super.setSize(WIDTH, HEIGHT);
		super.setLayout(null);
		super.setVisible(true);
	}

	protected void die(){
		super.setVisible(false);
		super.removeAll();
		super.dispose();
	}
}
