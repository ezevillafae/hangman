package ar.edu.ungs.hangman.core.sessions.application.find;

import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;

public final class SessionFinder {
    private final DomainSessionFinder finder;

    public SessionFinder(DomainSessionFinder domainSessionFinder) {
        this.finder = domainSessionFinder;
    }

    public SessionResponse find(String user) {
        return SessionResponse.map(finder.find(user));
    }
}
