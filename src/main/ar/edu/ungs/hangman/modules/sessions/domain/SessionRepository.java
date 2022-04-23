package ar.edu.ungs.hangman.modules.sessions.domain;

import java.util.Optional;

public interface SessionRepository {
	void save(Session session);

	Optional<Session> findByUser(String user);
}
