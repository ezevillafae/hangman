package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;

public final class SessionGuessCreatorSingleston {
	private static volatile SessionGuessCreator instance;

	public static SessionGuessCreator instance() {
		SessionGuessCreator result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainSessionFinder.class) {
			if (instance == null) {
				instance = new SessionGuessCreator(SessionRepositorySingleton.instance());
			}
			return instance;
		}
	}
}
