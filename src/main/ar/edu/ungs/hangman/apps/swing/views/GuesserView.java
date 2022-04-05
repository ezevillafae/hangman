package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;

import javax.swing.*;

public final class GuesserView extends View {
	private final String user;
	private final String language;

	private JFrame frame;

	private final SessionGuessCreator creator;
	private final SessionGuesser guesser;

	public GuesserView(String user,
	                   String language,
	                   SessionGuessCreator creator,
	                   SessionGuesser guesser) {
		this.user = user;
		this.language = language;
		this.creator = creator;
		this.guesser = guesser;

		initialize();
	}

	private void initialize() {
		this.frame = new JFrame();
	}

	@Override
	public JFrame frame() {
		return null;
	}
}
