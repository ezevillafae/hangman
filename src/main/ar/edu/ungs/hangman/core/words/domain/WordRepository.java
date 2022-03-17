package ar.edu.ungs.hangman.core.words.domain;

import java.util.List;
import java.util.Set;

public interface WordRepository {
    List<Word> searchByDifficultAndLanguage(Difficult difficult, Language language);
}
