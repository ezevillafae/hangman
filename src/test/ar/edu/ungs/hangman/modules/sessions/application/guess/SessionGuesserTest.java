package ar.edu.ungs.hangman.modules.sessions.application.guess;

import ar.edu.ungs.hangman.modules.sessions.domain.*;
import ar.edu.ungs.hangman.modules.words.domain.WordMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

final class SessionGuesserTest {
	private SessionGuesser sessionGuesser;

	private DomainSessionFinder sessionFinder;
	private DomainSessionTryer sessionTryer;
	private SessionRepository sessionRepository;

	@BeforeEach
	void setUp() {
		this.sessionFinder = mock(DomainSessionFinder.class);
		this.sessionRepository = mock(SessionRepository.class);
		this.sessionTryer = new DomainSessionTryer(sessionFinder, sessionRepository);

		this.sessionGuesser = new SessionGuesser(sessionFinder, sessionTryer);
	}

	@Test
	void should_guess_the_word() {
		Session session = SessionMother.build("machine", WordMother.random());

		when(this.sessionFinder.find("machine")).thenReturn(session);

		assertThrows(SessionFinished.class, () -> this.sessionGuesser.guess());
	}
}