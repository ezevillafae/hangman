package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;

public final class DomainSessionFinderSingleton {
	private static volatile DomainSessionFinder instance;

	public static DomainSessionFinder instance() {
		DomainSessionFinder result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainSessionFinder.class) {
			if (instance == null) {
				instance = new DomainSessionFinder(SessionRepositorySingleton.instance());
			}
			return instance;
		}
	}
}
