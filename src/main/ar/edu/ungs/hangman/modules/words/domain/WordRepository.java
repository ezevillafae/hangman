package ar.edu.ungs.hangman.modules.words.domain;

import java.util.List;

public interface WordRepository {
	List<Word> searchByDifficultAndLanguage(Difficult difficult, Language language);
}
