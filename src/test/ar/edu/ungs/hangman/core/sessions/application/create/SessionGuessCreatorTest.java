package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionMother;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.WordMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

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
		String randomWord = WordMother.random().value();
		Session expected = SessionMother.build("machine",new Word(randomWord));

		this.creator.create(randomWord);

		verify(repository, times(1)).save(expected);
	}
}