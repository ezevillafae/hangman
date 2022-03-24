package ar.edu.ungs.hangman.core.sessions.application.guess;

import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

final class SessionGuesserTest {
	private SessionGuesser guesser;

	private SessionRepository repository;
	private DomainSessionFinder sessionFinder;
	private SessionTryer sessionTryer;

	@BeforeEach
	void setUp() {

		this.sessionFinder = mock(DomainSessionFinder.class);
		this.repository = mock(SessionRepository.class);
		this.sessionTryer = new SessionTryer(this.sessionFinder, repository);

		this.guesser = new SessionGuesser(sessionFinder, sessionTryer);
	}

	@Test
	void should_guess_the_word() {

	}

	@Test
	void should_fail_the_guess() {

	}
}