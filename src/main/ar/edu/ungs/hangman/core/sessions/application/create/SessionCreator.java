package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.Language;
import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;

public final class SessionCreator {
    private final SessionRepository repository;
    private final DomainWordRandomPicker domainWordRandomPicker;

    public SessionCreator(SessionRepository repository, DomainWordRandomPicker domainWordRandomPicker) {
        this.repository = repository;
        this.domainWordRandomPicker = domainWordRandomPicker;
    }

    public void create(String user, Difficult difficult, Language language) {
        Word word = domainWordRandomPicker.pick(difficult, language);

        Session session = new Session(user, word);

        repository.save(session);
    }
}
