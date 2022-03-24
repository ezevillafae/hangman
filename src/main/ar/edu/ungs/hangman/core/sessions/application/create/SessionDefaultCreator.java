package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.core.words.domain.Language;
import ar.edu.ungs.hangman.core.words.domain.Word;

public final class SessionDefaultCreator {
	private final SessionRepository repository;
	private final DomainWordRandomPicker domainWordRandomPicker;

	public SessionDefaultCreator(SessionRepository repository, DomainWordRandomPicker domainWordRandomPicker) {
		this.repository = repository;
		this.domainWordRandomPicker = domainWordRandomPicker;
	}

	public void create(String user, Difficult difficult, Language language) {
		Word word = domainWordRandomPicker.pick(difficult, language);

		Session session = new Session(user, word);

		repository.save(session);
	}
}
