package ar.edu.ungs.hangman.apps;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.sessions.infrastructure.InMemorySessionRepository;
import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.core.words.domain.WordRepository;
import ar.edu.ungs.hangman.core.words.infrastructure.InMemoryWordRepository;

public abstract class Application {
	private final WordRepository wordRepository;
	protected final DomainWordRandomPicker domainWordRandomPicker;

	private final SessionRepository sessionRepository;
	protected final SessionTryer sessionTryer;
	protected final SessionDefaultCreator sessionDefaultCreator;
	protected final SessionGuessCreator sessionGuessCreator;
	protected final DomainSessionFinder domainSessionFinder;
	protected final SessionFinder sessionFinder;
	protected final SessionGuesser sessionGuesser;

	public Application() {
		this.wordRepository = new InMemoryWordRepository();
		this.domainWordRandomPicker = new DomainWordRandomPicker(wordRepository);

		this.sessionRepository = new InMemorySessionRepository();
		this.domainSessionFinder = new DomainSessionFinder(sessionRepository);
		this.sessionTryer = new SessionTryer(domainSessionFinder, sessionRepository);
		this.sessionDefaultCreator = new SessionDefaultCreator(sessionRepository, domainWordRandomPicker);
		this.sessionGuessCreator = new SessionGuessCreator(sessionRepository);
		this.sessionGuesser = new SessionGuesser(domainSessionFinder, sessionTryer);

		this.sessionFinder = new SessionFinder(domainSessionFinder);
	}

	public abstract void run();
}
