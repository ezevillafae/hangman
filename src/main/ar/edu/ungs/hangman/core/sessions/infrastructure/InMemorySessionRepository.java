package ar.edu.ungs.hangman.core.sessions.infrastructure;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemorySessionRepository implements SessionRepository {
    private final Map<String, Session> sessions;

    public InMemorySessionRepository() {
        this.sessions = new HashMap<>();
    }

    @Override
    public void save(Session session) {
        sessions.put(session.user(), session);
    }

    @Override
    public Optional<Session> findByUser(String user) {
        return Optional.ofNullable(sessions.get(user));
    }
}
