package ar.edu.ungs.hangman.modules.words.domain;

import java.util.List;
import java.util.Random;

public final class DomainWordRandomPicker {
	private final WordRepository repository;

	public DomainWordRandomPicker(WordRepository repository) {
		this.repository = repository;
	}

	public Word pick(Difficult difficult, Language language) {
		List<Word> words = repository.searchByDifficultAndLanguage(difficult, language);

		if (words.isEmpty()) {
			throw new WordNotExists(difficult, language);
		}

		int number = new Random().nextInt(words.size() - 1);

		return words.get(number);
	}
}
