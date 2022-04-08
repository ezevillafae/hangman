package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.WordMother;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SessionMother {
	public static Session build(String user, Word word) {
		return new Session(user, word);
	}

	public static Session build(Word word) {
		return new Session("user", word);
	}

	public static Session build(Word word, Integer fails) {
		return new Session("user", word, fails);
	}

	public static Session random() {
		return new Session("user", WordMother.random());
	}

	public static List<Session> randoms() {
		List<Session> values = new ArrayList<>();
		Collections.addAll(values, random(), random(), random(), random());
		return values;
	}
}
