package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.shared.Application;
import ar.edu.ungs.hangman.apps.swing.views.MainView;
import ar.edu.ungs.hangman.modules.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.modules.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.modules.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.modules.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.modules.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.modules.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.modules.sessions.domain.DomainSessionTryer;
import ar.edu.ungs.hangman.modules.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.modules.sessions.infrastructure.persistence.inmemory.InMemorySessionRepository;
import ar.edu.ungs.hangman.modules.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.modules.words.domain.WordRepository;
import ar.edu.ungs.hangman.modules.words.infrastructure.persistence.inmemory.InMemoryWordRepository;

import java.awt.*;

public final class SwingApplication implements Application {
	private final WordRepository wordRepository;
	private final SessionRepository sessionRepository;

	private final DomainWordRandomPicker domainWordRandomPicker;
	private final DomainSessionTryer domainSessionTryer;
	private final DomainSessionFinder domainSessionFinder;

	private final SessionFinder sessionFinder;
	private final SessionDefaultCreator sessionDefaultCreator;
	private final SessionGuessCreator sessionGuessCreator;

	private final SessionTryer tryer;
	private final SessionGuesser guesser;

	public SwingApplication() {
		this.wordRepository = new InMemoryWordRepository();
		this.sessionRepository = new InMemorySessionRepository();

		this.domainWordRandomPicker = new DomainWordRandomPicker(wordRepository);
		this.domainSessionFinder = new DomainSessionFinder(sessionRepository);
		this.domainSessionTryer = new DomainSessionTryer(domainSessionFinder, sessionRepository);

		this.sessionFinder = new SessionFinder(domainSessionFinder);
		this.sessionDefaultCreator = new SessionDefaultCreator(sessionRepository, domainWordRandomPicker);
		this.sessionGuessCreator = new SessionGuessCreator(sessionRepository);

		this.tryer = new SessionTryer(domainSessionTryer, domainSessionFinder);
		this.guesser = new SessionGuesser(domainSessionFinder, domainSessionTryer);

	}

	@Override
	public void run() {
		EventQueue.invokeLater(() -> {
			try {
				MainView window = new MainView(sessionDefaultCreator, tryer, sessionFinder, sessionGuessCreator,
				                               guesser);
				window.frame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
