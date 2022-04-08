package ar.edu.ungs.hangman.core.sessions.application.tries;

import ar.edu.ungs.hangman.core.sessions.domain.*;

public final class SessionTryer {
    private final static Integer MAX_TRIES = 6;

    private final DomainSessionTryer domainSessionTryer;
    private final DomainSessionFinder domainSessionFinder;

    public SessionTryer(DomainSessionTryer domainSessionTryer, DomainSessionFinder domainSessionFinder) {
        this.domainSessionTryer = domainSessionTryer;
        this.domainSessionFinder = domainSessionFinder;
    }

    public void execute(String user, Character character) {
        Session session = domainSessionFinder.find(user);

        domainSessionTryer.execute(session, character, MAX_TRIES);
    }

    public Integer getMaxTries(){
        return MAX_TRIES;
    }
}
