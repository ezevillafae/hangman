package ar.edu.ungs.hangman.apps.shared;

import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
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
    protected final SessionCreator sessionCreator;
    protected final DomainSessionFinder domainSessionFinder;
    protected final SessionFinder sessionFinder;

    public Application() {
        this.wordRepository = new InMemoryWordRepository();
        this.domainWordRandomPicker = new DomainWordRandomPicker(wordRepository);

        this.sessionRepository = new InMemorySessionRepository();
        this.sessionTryer = new SessionTryer();
        this.sessionCreator = new SessionCreator(sessionRepository, domainWordRandomPicker);
        this.domainSessionFinder = new DomainSessionFinder(sessionRepository);
        this.sessionFinder = new SessionFinder(domainSessionFinder);
    }

    public abstract void run();
}
