package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.Language;
import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.WordRandomPicker;

public final class SessionCreator {
    private final SessionRepository repository;
    private final WordRandomPicker wordRandomPicker;

    public SessionCreator(SessionRepository repository, WordRandomPicker wordRandomPicker) {
        this.repository = repository;
        this.wordRandomPicker = wordRandomPicker;
    }

    public void create(String user, Difficult difficult, Language language) {
        Word word = wordRandomPicker.pick(difficult, language);

        Session session = new Session(user, word);

        repository.save(session);
    }
}
