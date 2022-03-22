package ar.edu.ungs.hangman.core.sessions.infrastructure;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class InMemorySessionRepositoryTest {
    private InMemorySessionRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = new InMemorySessionRepository();
    }

    @Test
    void should_find_session_by_user() {
        List<Session> sessions = SessionMother.randoms();

        sessions.forEach(session -> repository.save(session));

        Session expected = sessions.stream().findAny().get();

        Optional<Session> actual = repository.findByUser(expected.user());

        assertTrue(actual.isPresent());
    }

    @Test
    void should_save_session() {
        List<Session> sessions = SessionMother.randoms();

        sessions.forEach(session -> repository.save(session));
    }
}