package ar.edu.ungs.hangman.core.sessions.application.find;

import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

public final class SessionFinder {
    private final DomainSessionFinder finder;

    public SessionFinder(SessionRepository repository) {
        this.finder = new DomainSessionFinder(repository);
    }

    public SessionResponse find(String user) {
        return SessionResponse.map(finder.find(user));
    }
}
