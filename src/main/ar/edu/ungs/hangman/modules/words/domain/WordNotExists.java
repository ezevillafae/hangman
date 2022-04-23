package ar.edu.ungs.hangman.modules.words.domain;

public final class WordNotExists extends RuntimeException {
	public WordNotExists(Difficult difficult, Language language) {
		super(String.format("the word for difficult <%s> and language <%s> not exists", difficult.name(),
		                    language.name()));
	}
}
