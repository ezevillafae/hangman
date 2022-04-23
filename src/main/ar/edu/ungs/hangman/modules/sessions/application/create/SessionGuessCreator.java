package ar.edu.ungs.hangman.modules.sessions.application.create;

import ar.edu.ungs.hangman.modules.sessions.domain.Session;
import ar.edu.ungs.hangman.modules.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.modules.words.domain.Word;

public final class SessionGuessCreator {
	private final static String USER_MACHINE = "machine";

	private final SessionRepository repository;

	public SessionGuessCreator(SessionRepository repository) {
		this.repository = repository;
	}

	public void create(String word) {
		Session session = new Session(USER_MACHINE, new Word(word));

		this.repository.save(session);
	}
}