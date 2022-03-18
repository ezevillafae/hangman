package ar.edu.ungs.hangman.apps.shared;

import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.sessions.infrastructure.InMemorySessionRepository;
import ar.edu.ungs.hangman.core.words.domain.WordRandomPicker;
import ar.edu.ungs.hangman.core.words.domain.WordRepository;
import ar.edu.ungs.hangman.core.words.infrastructure.InMemoryWordRepository;

public abstract class Application {
    private final WordRepository wordRepository;
    protected final WordRandomPicker wordRandomPicker;

    private final SessionRepository sessionRepository;
    protected final SessionTryer sessionTryer;
    protected final SessionCreator sessionCreator;
    protected final SessionFinder sessionFinder;

    public Application() {
        this.wordRepository = new InMemoryWordRepository();
        this.wordRandomPicker = new WordRandomPicker(wordRepository);

        this.sessionRepository = new InMemorySessionRepository();
        this.sessionTryer = new SessionTryer(sessionRepository);
        this.sessionCreator = new SessionCreator(sessionRepository, wordRandomPicker);
        this.sessionFinder = new SessionFinder(sessionRepository);
    }

    public abstract void run();
}
