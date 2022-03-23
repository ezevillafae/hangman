package ar.edu.ungs.hangman.core.sessions.application.tries;

import ar.edu.ungs.hangman.core.sessions.domain.*;
import ar.edu.ungs.hangman.core.words.domain.WordMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SessionTryerTest {
    private SessionTryer tryer;

    private DomainSessionFinder sessionFinder;
    private SessionRepository repository;

    @BeforeEach
    void setUp() {
        this.sessionFinder = mock(DomainSessionFinder.class);
        this.repository = mock(SessionRepository.class);

        tryer = new SessionTryer(sessionFinder, repository);
    }

    @Test
    void should_do_successful_try() {
        Session session = SessionMother.random();
        Character character = pickValidCharacter(session);
        int fails = session.fails();

        when(sessionFinder.find(session.user())).thenReturn(session);

        tryer.execute(session.user(), character);

        assertEquals(session.fails(), fails);
        verify(repository, atLeastOnce()).save(session);
    }


    @Test
    void should_do_fail_try() {
        String word = "test";
        Session session = SessionMother.build(WordMother.random(word));
        int fails = session.fails();

        when(sessionFinder.find(session.user())).thenReturn(session);

        tryer.execute(session.user(), 'a');

        assertEquals(fails + 1, session.fails());
        verify(repository, atLeastOnce()).save(session);
    }

    @Test
    void should_throws_session_finished() {
        String word = "test";
        Integer fails = 3;
        Session session = SessionMother.build(WordMother.random(word), fails);

        when(sessionFinder.find(session.user())).thenReturn(session);

        assertThrows(SessionFinished.class, () -> tryer.execute(session.user(), 'a'));
        verifyNoInteractions(repository);
    }


    private Character pickValidCharacter(Session session) {
        return session.word().value().charAt(new Random().nextInt(session.word().value().length() - 1));
    }
}