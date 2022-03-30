package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.WordMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DomainSessionTryerTest {
    private DomainSessionTryer tryer;

    private DomainSessionFinder sessionFinder;
    private SessionRepository repository;

    @BeforeEach
    void setUp() {
        this.sessionFinder = mock(DomainSessionFinder.class);
        this.repository = mock(SessionRepository.class);

        tryer = new DomainSessionTryer(sessionFinder, repository);
    }

    @Test
    void when_choose_successful_letter_should_try() {
        Session session = SessionMother.random();
        Character character = pickValidCharacter(session);
        int fails = session.fails();

        when(sessionFinder.find(session.user())).thenReturn(session);

        tryer.execute(session, character, 4);

        assertEquals(session.fails(), fails);
        verify(repository, atLeastOnce()).save(session);
    }


    @Test
    void when_choose_fail_letter_should_failed_try() {
        String word = "test";
        Session session = SessionMother.build(WordMother.random(word));
        int fails = session.fails();

        when(sessionFinder.find(session.user())).thenReturn(session);

        tryer.execute(session, 'a', 4);

        assertEquals(fails + 1, session.fails());
        verify(repository, atLeastOnce()).save(session);
    }

    @Test
    void when_choose_fail_letter_and_has_not_fail_tries_should_throws_session_finished() {
        String word = "test";
        Integer fails = 3;
        Session session = SessionMother.build(WordMother.random(word), fails);

        when(sessionFinder.find(session.user())).thenReturn(session);

        assertThrows(SessionFinished.class, () -> tryer.execute(session, 'a', 4));
        verifyNoInteractions(repository);
    }


    private Character pickValidCharacter(Session session) {
        return session.word().value().charAt(new Random().nextInt(session.word().value().length() - 1));
    }
}