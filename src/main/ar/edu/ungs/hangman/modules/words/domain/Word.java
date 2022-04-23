package ar.edu.ungs.hangman.modules.words.domain;

import java.util.Objects;

public final class Word {
	private final String value;
	private final Language language;
	private final Difficult difficult;

	public Word(String value) {
		this.value = value;
		this.language = Language.DEFAULT;
		this.difficult = Difficult.DEFAULT;
	}

	public Word(String value, Language language, Difficult difficult) {
		this.value = value;
		this.language = language;
		this.difficult = difficult;
	}

	public Integer length() {
		return value.length();
	}

	public String value() {
		return value;
	}

	public Language language() {
		return language;
	}

	public Difficult difficult() {
		return difficult;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Word word = (Word) o;
		return Objects.equals(value, word.value) && language == word.language && difficult == word.difficult;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, language, difficult);
	}

	@Override
	public String toString() {
		return "Word{" + "value='" + value + '\'' + ", language=" + language + ", difficult=" + difficult + '}';
	}
}
