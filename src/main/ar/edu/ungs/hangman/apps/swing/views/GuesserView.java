package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.infrastructure.ioc.SessionGuessCreatorSingleton;
import ar.edu.ungs.hangman.core.sessions.infrastructure.ioc.SessionGuesserSingleton;

public final class GuesserView extends View {
	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 800;
	private static final Integer HEIGHT = 600;

	private final String user;
	private final String language;

	private final SessionGuessCreator creator;
	private final SessionGuesser guesser;

	public GuesserView(String user, String language) {
		this.user = user;
		this.language = language;

		this.creator = SessionGuessCreatorSingleton.instance();
		this.guesser = SessionGuesserSingleton.instance();

		draw();
	}

	@Override
	protected void draw() {
		super.draw();
	}
}
