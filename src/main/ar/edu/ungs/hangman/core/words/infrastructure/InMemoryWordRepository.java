package ar.edu.ungs.hangman.core.words.infrastructure;

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
        this.words.add(new Word("nivel", Language.SPANISH, Difficult.EASY));
    }
}
