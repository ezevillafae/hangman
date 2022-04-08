package ar.edu.ungs.hangman.core.words.infrastructure;

import ar.edu.ungs.hangman.core.words.domain.*;
import ar.edu.ungs.hangman.core.words.infrastructure.persistence.inmemory.InMemoryWordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class InMemoryWordRepositoryTest {
	private InMemoryWordRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = new InMemoryWordRepository();
	}

	@Test
	void should_search_words_by_language_and_difficult() {
		Difficult difficult = DifficultMother.random();
		Language language = LanguageMother.random();

		List<Word> actual = repository.searchByDifficultAndLanguage(difficult, language);

		boolean allMatch = actual.stream()
		                         .allMatch(word -> word.difficult().equals(difficult) &&
		                                           word.language().equals(language));

		assertTrue(allMatch);
	}
}