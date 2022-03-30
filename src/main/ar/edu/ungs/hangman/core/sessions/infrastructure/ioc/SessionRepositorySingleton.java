package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.sessions.infrastructure.persistence.inmemory.InMemorySessionRepository;

public final class SessionRepositorySingleton {
	private static volatile SessionRepository instance;

	public static SessionRepository instance() {
		SessionRepository result = instance;
		if (result != null) {
			return result;
		}
		synchronized (SessionRepository.class) {
			if (instance == null) {
				instance = new InMemorySessionRepository();
			}
			return instance;
		}
	}
}
