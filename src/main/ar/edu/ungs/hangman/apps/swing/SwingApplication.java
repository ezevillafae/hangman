package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.shared.Application;
import ar.edu.ungs.hangman.apps.swing.views.MainView;

public final class SwingApplication implements Application {
	@Override
	public void run() {
		new MainView();
	}
}
