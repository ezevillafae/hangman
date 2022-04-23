package ar.edu.ungs.hangman.modules.sessions.application.find;

import ar.edu.ungs.hangman.modules.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.modules.sessions.domain.DomainSessionFinder;

public final class SessionFinder {
	private final DomainSessionFinder finder;

	public SessionFinder(DomainSessionFinder domainSessionFinder) {
		this.finder = domainSessionFinder;
	}

	public SessionResponse find(String user) {
		return SessionResponse.map(finder.find(user));
	}
}
