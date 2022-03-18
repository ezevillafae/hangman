package ar.edu.ungs.hangman.core.sessions.application.tries;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionFinished;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

public final class SessionTryer {
    private final DomainSessionFinder finder;
    private final SessionRepository repository;

    public SessionTryer(SessionRepository repository) {
        this.finder = new DomainSessionFinder(repository);
        this.repository = repository;
    }

    public void attempt(String user, Character character) {
        Session session = finder.find(user);

        Integer[] positions = session.positions(character);

        session.add(character, positions);

        ensureTryIsFail(session, isFailedTry(positions));

        ensureSessionIsComplete(session);

        this.repository.save(session);
    }

    private boolean isFailedTry(Integer[] positions) {
        return positions.length > 0;
    }

    private void ensureTryIsFail(Session session, boolean isFailedTry) {
        if (isFailedTry) {
            session.fail();
        }
    }

    private void ensureSessionIsComplete(Session session) {
        if (session.isComplete()) {
            throw new SessionFinished("GAME SESSION WIN");
        }
    }
}
