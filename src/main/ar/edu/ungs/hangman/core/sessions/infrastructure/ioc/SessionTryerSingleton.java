package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;

public final class SessionTryerSingleton {
	private static volatile SessionTryer instance;

	public static SessionTryer instance() {
		SessionTryer result = instance;
		if (result != null) {
			return result;
		}
		synchronized (SessionTryer.class) {
			if (instance == null) {
				instance = new SessionTryer(DomainSessionTryerSingleton.instance(), DomainSessionFinderSingleton.instance());
			}
			return instance;
		}
	}
}
