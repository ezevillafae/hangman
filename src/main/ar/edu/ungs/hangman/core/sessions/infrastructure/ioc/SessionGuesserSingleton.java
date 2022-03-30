package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;

public final class SessionGuesserSingleton {
	private static volatile SessionGuesser instance;

	public static SessionGuesser instance() {
		SessionGuesser result = instance;
		if (result != null) {
			return result;
		}
		synchronized (SessionGuesser.class) {
			if (instance == null) {
				instance = new SessionGuesser(DomainSessionFinderSingleton.instance(), DomainSessionTryerSingleton.instance());
			}
			return instance;
		}
	}
}
