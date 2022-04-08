package ar.edu.ungs.hangman.core.sessions.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DomainSessionFinderTest {
	private DomainSessionFinder finder;

	private SessionRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = mock(SessionRepository.class);

		this.finder = new DomainSessionFinder(repository);
	}

	@Test
	void when_session_exists_should_find_session() {
		Session expected = SessionMother.random();

		when(repository.findByUser(expected.user())).thenReturn(Optional.of(expected));

		Session actual = finder.find(expected.user());

		assertEquals(expected, actual);
	}

	@Test
	void when_session_not_exists_should_throws_session_not_exists() {
		Session expected = SessionMother.random();

		when(repository.findByUser(expected.user())).thenReturn(Optional.empty());

		assertThrows(SessionNotExists.class, () -> finder.find(expected.user()));
	}
}