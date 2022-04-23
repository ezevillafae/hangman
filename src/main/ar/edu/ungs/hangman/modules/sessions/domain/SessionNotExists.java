package ar.edu.ungs.hangman.modules.sessions.domain;

public final class SessionNotExists extends RuntimeException {
	public SessionNotExists(String id) {
		super(String.format("the session <%s> not exists", id));
	}
}
