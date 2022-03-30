package ar.edu.ungs.hangman.core.sessions.infrastructure.ioc;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.words.infrastructure.ioc.DomainWordRandomPickerSingleton;

public final class SessionDefaultCreatorSingleton {
	private static volatile SessionDefaultCreator instance;

	public static SessionDefaultCreator instance() {
		SessionDefaultCreator result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainSessionFinder.class) {
			if (instance == null) {
				instance = new SessionDefaultCreator(SessionRepositorySingleton.instance(), DomainWordRandomPickerSingleton.instance());
			}
			return instance;
		}
	}
}
