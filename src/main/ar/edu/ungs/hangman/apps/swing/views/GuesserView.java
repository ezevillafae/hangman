package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;

public final class GuesserView extends View {
	private final String user;
	private final String language;

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
	}

	@Override
	public Integer width() {
		return 400;
	}

	@Override
	public Integer height() {
		return 300;
	}

	@Override
	public Integer margin() {
		return 20;
	}
}
