package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;

public final class HangmanView extends View {
	private final String user;
	private final String language;

	private final SessionDefaultCreator creator;
	private final SessionTryer tryer;

	public HangmanView(String user,
	                   String language,
	                   SessionDefaultCreator creator,
	                   SessionTryer tryer) {
		this.user = user;
		this.language = language;
		this.creator = creator;
		this.tryer = tryer;
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
