package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

final class SessionGuessCreatorTest {
	private SessionGuessCreator creator;

	private SessionRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = mock(SessionRepository.class);

		this.creator = new SessionGuessCreator(repository);
	}

	@Test
	void should_create_guess_session() {

	}
}