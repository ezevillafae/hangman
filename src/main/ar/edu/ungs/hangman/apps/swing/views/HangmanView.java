package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.infrastructure.ioc.SessionDefaultCreatorSingleton;
import ar.edu.ungs.hangman.core.sessions.infrastructure.ioc.SessionTryerSingleton;

public final class HangmanView extends View {
	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 800;
	private static final Integer HEIGHT = 600;

	private final String user;
	private final String language;

	private final SessionDefaultCreator creator;
	private final SessionTryer tryer;

	public HangmanView(String user, String language) {
		this.user = user;
		this.language = language;

		this.creator = SessionDefaultCreatorSingleton.instance();
		this.tryer = SessionTryerSingleton.instance();

		draw();
	}

	@Override
	protected void draw() {
		super.draw();
	}
}
