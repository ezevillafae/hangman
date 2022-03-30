package ar.edu.ungs.hangman.apps;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.sessions.infrastructure.InMemorySessionRepository;
import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.core.words.domain.WordRepository;
import ar.edu.ungs.hangman.core.words.infrastructure.InMemoryWordRepository;

public abstract class Application {
	protected final SessionTryer sessionTryer;
	protected final SessionDefaultCreator sessionDefaultCreator;
	protected final SessionGuessCreator sessionGuessCreator;
	protected final SessionFinder sessionFinder;
	protected final SessionGuesser sessionGuesser;

	public Application() {
		WordRepository wordRepository = new InMemoryWordRepository();
		DomainWordRandomPicker domainWordRandomPicker = new DomainWordRandomPicker(wordRepository);

		SessionRepository sessionRepository = new InMemorySessionRepository();
		DomainSessionFinder domainSessionFinder = new DomainSessionFinder(sessionRepository);
		DomainSessionTryer domainSessionTryer = new DomainSessionTryer(domainSessionFinder, sessionRepository);

		this.sessionTryer = new SessionTryer(domainSessionTryer, domainSessionFinder);
		this.sessionDefaultCreator = new SessionDefaultCreator(sessionRepository, domainWordRandomPicker);
		this.sessionGuessCreator = new SessionGuessCreator(sessionRepository);
		this.sessionGuesser = new SessionGuesser(domainSessionFinder, domainSessionTryer);

		this.sessionFinder = new SessionFinder(domainSessionFinder);
	}

	public abstract void run();
}
