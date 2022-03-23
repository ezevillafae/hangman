package ar.edu.ungs.hangman.core.sessions.application.tries;

import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionFinished;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

public final class SessionTryer {
    private final DomainSessionFinder sessionFinder;
    private final SessionRepository repository;
    private final static Integer MAX_TRIES = 4;

    public SessionTryer(DomainSessionFinder sessionFinder, SessionRepository repository) {
        this.sessionFinder = sessionFinder;
        this.repository = repository;
    }

    public void execute(String user, Character character) {
        Session session = this.sessionFinder.find(user);

        Integer[] positions = session.positions(character);

        if (isFailedTry(positions)){
            failTry(session);
            return;
        }

        successfulTry(character, session, positions);
    }

    private void successfulTry(Character character, Session session, Integer[] positions) {
        session.add(character, positions);
        repository.save(session);
    }

    private void failTry(Session session) {
        session.fail();
        ensureSessionContinue(session);
        repository.save(session);
    }

    private void ensureSessionContinue(Session session) {
        if (session.fails().equals(MAX_TRIES)){
            throw new SessionFinished("game session ended for exceeding the maximum number of failed attempts");
        }
    }

    private boolean isFailedTry(Integer[] positions) {
        return positions.length == 0;
    }
}
