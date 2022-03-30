package ar.edu.ungs.hangman.core.sessions.domain;

public final class DomainSessionTryer {
    private final DomainSessionFinder sessionFinder;
    private final SessionRepository repository;

    public DomainSessionTryer(DomainSessionFinder sessionFinder, SessionRepository repository) {
        this.sessionFinder = sessionFinder;
        this.repository = repository;
    }

    public void execute(Session session, Character character, Integer maxTries) {
        Integer[] positions = session.positions(character);

        if (isFailedTry(positions)) {
            failTry(session, maxTries);
            return;
        }

        successfulTry(character, session, positions);
    }

    private void successfulTry(Character character, Session session, Integer[] positions) {
        session.add(character, positions);
        repository.save(session);
    }

    private void failTry(Session session, Integer maxTries) {
        session.fail();
        ensureSessionContinue(session, maxTries);
        repository.save(session);
    }

    private void ensureSessionContinue(Session session, Integer maxTries) {
        if (session.fails().equals(maxTries)) {
            throw new SessionFinished("game session ended for exceeding the maximum number of failed attempts");
        }
    }

    private boolean isFailedTry(Integer[] positions) {
        return positions.length == 0;
    }
}
