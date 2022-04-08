package ar.edu.ungs.hangman.core.sessions.application.find;

import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

final class SessionFinderTest {
	private SessionFinder finder;

	private DomainSessionFinder domainSessionFinder;

	@BeforeEach
	void setUp() {
		this.domainSessionFinder = mock(DomainSessionFinder.class);

		this.finder = new SessionFinder(domainSessionFinder);
	}

	@Test
	void should_find_session() {
		Session session = SessionMother.random();
		SessionResponse expected = SessionResponse.map(session);

		when(this.domainSessionFinder.find(expected.user())).thenReturn(session);

		SessionResponse actual = finder.find(session.user());

		assertEquals(expected, actual);
	}
}