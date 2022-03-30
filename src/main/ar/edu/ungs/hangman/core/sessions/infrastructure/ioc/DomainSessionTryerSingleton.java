package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionTryer;

public final class DomainSessionTryerSingleton {
	private static volatile DomainSessionTryer instance;

	public static DomainSessionTryer instance() {
		DomainSessionTryer result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainSessionFinder.class) {
			if (instance == null) {
				instance = new DomainSessionTryer(DomainSessionFinderSingleton.instance(), SessionRepositorySingleton.instance());
			}
			return instance;
		}
	}
}
