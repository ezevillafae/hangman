package ar.edu.ungs.hangman.core.words.application;

import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.Language;
import ar.edu.ungs.hangman.core.words.domain.Word;
import ar.edu.ungs.hangman.core.words.domain.WordRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public final class WordRandomPicker {
    private final WordRepository repository;

    public WordRandomPicker(WordRepository repository) {
        this.repository = repository;
    }

    public Optional<Word> pick(Difficult difficult, Language language){
        List<Word> words = repository.searchByDifficultAndLanguage(difficult, language);

        if (words.isEmpty()){
            return Optional.empty();
        }

        int number = new Random().nextInt(words.size() - 1);

        return Optional.ofNullable(words.get(number));
    }
}
