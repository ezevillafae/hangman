package ar.edu.ungs.hangman.core.words.infrastructure.ioc;

import ar.edu.ungs.hangman.core.words.domain.WordRepository;
import ar.edu.ungs.hangman.core.words.infrastructure.persistence.inmemory.InMemoryWordRepository;

public final class WordRepositorySingleton {
	private static volatile WordRepository instance;

	public static WordRepository instance() {
		WordRepository result = instance;
		if (result != null) {
			return result;
		}
		synchronized (WordRepository.class) {
			if (instance == null) {
				instance = new InMemoryWordRepository();
			}
			return instance;
		}
	}
}
