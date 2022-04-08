package ar.edu.ungs.hangman.core.words.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

final class DomainWordRandomPickerTest {
	private DomainWordRandomPicker picker;
	private WordRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = mock(WordRepository.class);
		this.picker = new DomainWordRandomPicker(repository);
	}

	@Test
	void when_contains_words_should_pick_random_word() {
		Language language = LanguageMother.random();
		Difficult difficult = DifficultMother.random();

		List<Word> expects = WordMother.randoms(language, difficult);

		when(repository.searchByDifficultAndLanguage(difficult, language)).thenReturn(expects);

		Word actual = picker.pick(difficult, language);

		assertTrue(expects.contains(actual));
	}

	@Test
	void when_not_contains_words_should_throws_word_not_exists() {
		Language language = LanguageMother.random();
		Difficult difficult = DifficultMother.random();

		List<Word> expects = WordMother.empty();

		when(repository.searchByDifficultAndLanguage(difficult, language)).thenReturn(expects);

		assertThrows(WordNotExists.class, () -> picker.pick(difficult, language));
	}
}