package ar.edu.ungs.hangman.core.sessions.application.attempt;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionFinished;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

public final class SessionAttempter {
    private final DomainSessionFinder finder;
    private final SessionRepository repository;

    public SessionAttempter(SessionRepository repository) {
        this.finder = new DomainSessionFinder(repository);
        this.repository = repository;
    }

    public void attempt(String user, Character character) {
        Session session = finder.find(user);

        Integer[] positions = session.positions(character);

        session.add(character, positions);

        boolean isFailedAttempt = isFailedAttempt(positions);

        ensureAttemptIsFail(session, isFailedAttempt);

        ensureSessionIsComplete(session);

        this.repository.save(session);
    }

    private boolean isFailedAttempt(Integer[] positions) {
        return positions.length > 0;
    }

    private void ensureAttemptIsFail(Session session, boolean isFailedAttempt) {
        if (isFailedAttempt) {
            session.fail();
        }
    }

    private void ensureSessionIsComplete(Session session) {
        if (session.isComplete()) {
            throw new SessionFinished("GAME SESSION WIN");
        }
    }
}
