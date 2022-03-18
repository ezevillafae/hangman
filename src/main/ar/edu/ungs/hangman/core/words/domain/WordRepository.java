package ar.edu.ungs.hangman.core.words.domain;

import java.util.List;

public interface WordRepository {
    List<Word> searchByDifficultAndLanguage(Difficult difficult, Language language);
}
