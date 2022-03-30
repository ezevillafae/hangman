package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;

public final class SessionFinderSingleton {
	private static volatile SessionFinder instance;

	public static SessionFinder instance() {
		SessionFinder result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainSessionFinder.class) {
			if (instance == null) {
				instance = new SessionFinder(DomainSessionFinderSingleton.instance());
			}
			return instance;
		}
	}
}
