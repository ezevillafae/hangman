package ar.edu.ungs.hangman.modules.sessions.application.create;

import ar.edu.ungs.hangman.modules.sessions.domain.Session;
import ar.edu.ungs.hangman.modules.sessions.domain.SessionMother;
import ar.edu.ungs.hangman.modules.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.modules.words.domain.Difficult;
import ar.edu.ungs.hangman.modules.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.modules.words.domain.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SessionDefaultCreatorTest {
	private SessionDefaultCreator creator;

	private SessionRepository repository;
	private DomainWordRandomPicker domainWordRandomPicker;

	@BeforeEach
	void setUp() {
		this.repository = mock(SessionRepository.class);
		this.domainWordRandomPicker = mock(DomainWordRandomPicker.class);

		this.creator = new SessionDefaultCreator(repository, domainWordRandomPicker);
	}

	@Test
	void should_create_default_session() {
		Session expected = SessionMother.random();
		Language language = expected.word().language();
		Difficult difficult = expected.word().difficult();

		when(domainWordRandomPicker.pick(difficult, language)).thenReturn(expected.word());

		creator.create(expected.user(), difficult, language);

		verify(repository, atLeastOnce()).save(expected);
	}
}