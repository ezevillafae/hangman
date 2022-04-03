package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.shared.Application;
import ar.edu.ungs.hangman.apps.swing.views.MainView;
import ar.edu.ungs.hangman.apps.swing.views.View;

import javax.swing.*;

public final class SwingApplication extends JFrame implements Application {
	private View view;

	private String user;
	private String language;

	public SwingApplication() {
		this.user = "";
		this.language = "";
	}

	@Override
	public void run() {
		super.setVisible(true);

		this.setView(new MainView());
	}

	private void setView(View view) {
		this.view = view;

		super.setContentPane(this.view);
		super.setSize(view.width(), view.height());
	}
}
