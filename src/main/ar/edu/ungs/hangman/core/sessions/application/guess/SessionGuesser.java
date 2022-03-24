package ar.edu.ungs.hangman.core.sessions.application.guess;

import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.core.sessions.domain.Session;

import java.util.List;

public final class SessionGuesser {
	private final static String USER_MACHINE = "machine";
	private final static List<Character> VOWELS = List.of('A', 'E', 'I', 'O', 'U');
	private final static List<Character> CONSONATS = List.of('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W', 'Y');

	private final DomainSessionFinder sessionFinder;
	private final SessionTryer sessionTryer;

	public SessionGuesser(DomainSessionFinder sessionFinder, SessionTryer sessionTryer) {
		this.sessionFinder = sessionFinder;
		this.sessionTryer = sessionTryer;
	}

	public SessionResponse guess() {
		Session session = this.sessionFinder.find(USER_MACHINE);

		for (Character character: VOWELS){
			sessionTryer.execute(USER_MACHINE, character);
		}

		for (Character consonant: CONSONATS){
			sessionTryer.execute(USER_MACHINE, consonant);
		}

		return SessionResponse.map(session);
	}
}

