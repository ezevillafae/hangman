package ar.edu.ungs.hangman.core.words.infrastructure.persistence.inmemory;

import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.Language;
import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.WordRepository;

import java.util.ArrayList;
import java.util.List;

public final class InMemoryWordRepository implements WordRepository {
	private final List<Word> words;

	public InMemoryWordRepository() {
		this.words = new ArrayList<>();

		presetData();
	}

	@Override
	public List<Word> searchByDifficultAndLanguage(Difficult difficult, Language language) {
		List<Word> words = new ArrayList<>();

		for (Word word : this.words) {
			if (ensureWordContainsDifficultAndLanguage(difficult, language, word)) {
				words.add(word);
			}
		}

		return words;
	}

	private boolean ensureWordContainsDifficultAndLanguage(Difficult difficult, Language language, Word word) {
		return word.difficult().equals(difficult) && word.language().equals(language);
	}


	private void presetData() {
		// Spanish
		this.words.add(new Word("nivel", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("atril", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("caminar", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("correr", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("gato", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("perro", Language.SPANISH, Difficult.EASY));
		this.words.add(new Word("manzana", Language.SPANISH, Difficult.MEDIUM));
		this.words.add(new Word("puente", Language.SPANISH, Difficult.MEDIUM));
		this.words.add(new Word("cuenta", Language.SPANISH, Difficult.MEDIUM));
		this.words.add(new Word("latin", Language.SPANISH, Difficult.MEDIUM));
		this.words.add(new Word("gracias", Language.SPANISH, Difficult.HARD));
		this.words.add(new Word("maraton", Language.SPANISH, Difficult.HARD));
		this.words.add(new Word("cerrojo", Language.SPANISH, Difficult.HARD));
		this.words.add(new Word("estrategia", Language.SPANISH, Difficult.HARD));
		
		// English
		this.words.add(new Word("basic", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("clear", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("man", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("men", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("women", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("woman", Language.ENGLISH, Difficult.EASY));
		this.words.add(new Word("brother", Language.ENGLISH, Difficult.MEDIUM));
		this.words.add(new Word("sister", Language.ENGLISH, Difficult.MEDIUM));
		this.words.add(new Word("lemon", Language.ENGLISH, Difficult.MEDIUM));
		this.words.add(new Word("apple", Language.SPANISH, Difficult.MEDIUM));
		this.words.add(new Word("understand", Language.ENGLISH, Difficult.HARD));
		this.words.add(new Word("obviously", Language.ENGLISH, Difficult.HARD));
		this.words.add(new Word("storm", Language.ENGLISH, Difficult.HARD));
		this.words.add(new Word("strawberry", Language.ENGLISH, Difficult.HARD));
	}
}
