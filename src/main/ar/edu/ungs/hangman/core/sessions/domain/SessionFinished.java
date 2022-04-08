package ar.edu.ungs.hangman.core.sessions.domain;

public final class SessionFinished extends RuntimeException {
	public SessionFinished(String message) {
		super(message);
	}
}
