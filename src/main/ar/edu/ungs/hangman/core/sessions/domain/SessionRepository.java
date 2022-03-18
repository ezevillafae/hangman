package ar.edu.ungs.hangman.core.sessions.domain;

import java.util.Optional;

public interface SessionRepository {
    void save(Session session);

    Optional<Session> findByUser(String user);
}
