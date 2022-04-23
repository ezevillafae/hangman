package ar.edu.ungs.hangman.modules.words.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WordMother {
	public static Word random() {
		return new Word("random", LanguageMother.random(), DifficultMother.random());
	}

	public static Word random(Language language, Difficult difficult) {
		return new Word("random", language, difficult);
	}

	public static List<Word> randoms(Language language, Difficult difficult) {
		List<Word> values = new ArrayList<>();
		Collections.addAll(values, WordMother.random(language, difficult), WordMother.random(language, difficult),
		                   WordMother.random(language, difficult), WordMother.random(language, difficult));
		return values;
	}

	public static List<Word> empty() {
		return Collections.emptyList();
	}

	public static Word random(String value) {
		return new Word(value, LanguageMother.random(), DifficultMother.random());
	}
}
