package ar.edu.ungs.hangman.modules.sessions.application.guess;

import ar.edu.ungs.hangman.modules.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.modules.sessions.domain.DomainSessionFinder;
import ar.edu.ungs.hangman.modules.sessions.domain.DomainSessionTryer;
import ar.edu.ungs.hangman.modules.sessions.domain.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SessionGuesser {
	private final static String USER_MACHINE = "machine";
	private final static Integer MAX_TRIES = 100;

	private final static List<Character> VOWELS = vowels();
	private final static List<Character> CONSONANTS = consonants();

	private final DomainSessionFinder sessionFinder;
	private final DomainSessionTryer sessionTryer;

	public SessionGuesser(DomainSessionFinder sessionFinder, DomainSessionTryer sessionTryer) {
		this.sessionFinder = sessionFinder;
		this.sessionTryer = sessionTryer;
	}

	private static List<Character> vowels() {
		List<Character> values = new ArrayList<>();
		Collections.addAll(values, 'A', 'E', 'I', 'O', 'U');
		return values;
	}

	private static List<Character> consonants() {
		List<Character> values = new ArrayList<>();
		Collections.addAll(values, 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V',
		                   'X', 'Z', 'W', 'Y');
		return values;
	}

	public SessionResponse guess() {
		Session session = this.sessionFinder.find(USER_MACHINE);

		for (Character character : VOWELS) {
			sessionTryer.execute(session, character, MAX_TRIES);
		}

		for (Character consonant : CONSONANTS) {
			sessionTryer.execute(session, consonant, MAX_TRIES);
		}

		return SessionResponse.map(session);
	}
}

