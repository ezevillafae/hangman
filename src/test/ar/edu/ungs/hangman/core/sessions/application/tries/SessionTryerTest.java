package ar.edu.ungs.hangman.core.sessions.application.tries;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.*;

class SessionTryerTest {
	private SessionTryer tryer;

	private DomainSessionTryer domainSessionTryer;
	private DomainSessionFinder domainSessionFinder;


	@BeforeEach
	void setUp() {
		this.domainSessionTryer = mock(DomainSessionTryer.class);
		this.domainSessionFinder = mock(DomainSessionFinder.class);

		tryer = new SessionTryer(domainSessionTryer, domainSessionFinder);
	}

	@Test
	void should_try() {
		Session session = SessionMother.random();
		Character character = pickValidCharacter(session);

		when(domainSessionFinder.find(session.user())).thenReturn(session);

		tryer.execute(session.user(), character);

		verify(domainSessionTryer, atLeastOnce()).execute(session, character, 6);
	}

	private Character pickValidCharacter(Session session) {
		return session.word().value().charAt(new Random().nextInt(session.word().value().length() - 1));
	}
}