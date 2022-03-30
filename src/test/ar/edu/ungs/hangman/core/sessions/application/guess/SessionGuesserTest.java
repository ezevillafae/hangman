package ar.edu.ungs.hangman.core.sessions.application.guess;

import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.sessions.domain.*;
import ar.edu.ungs.hangman.core.words.domain.WordMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		SessionResponse expected = SessionResponse.map(session);

		when(this.sessionFinder.find("machine")).thenReturn(session);

		SessionResponse actual = this.sessionGuesser.guess();

		assertEquals(expected.characters(), actual.characters());
	}
}