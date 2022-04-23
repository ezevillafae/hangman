package ar.edu.ungs.hangman.modules.sessions.domain;

public final class DomainSessionFinder {
	private final SessionRepository repository;

	public DomainSessionFinder(SessionRepository repository) {
		this.repository = repository;
	}

	public Session find(String user) {
		return repository.findByUser(user).orElseThrow(() -> new SessionNotExists(user));
	}
}
