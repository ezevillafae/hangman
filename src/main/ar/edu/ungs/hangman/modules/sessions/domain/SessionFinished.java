package ar.edu.ungs.hangman.modules.sessions.domain;

public final class SessionFinished extends RuntimeException {
	public SessionFinished(String message) {
		super(message);
	}
}
