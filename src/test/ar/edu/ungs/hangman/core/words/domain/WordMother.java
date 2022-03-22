package ar.edu.ungs.hangman.core.words.domain;

import java.util.Collections;
import java.util.List;

public final class WordMother {
    public static Word random() {
        return new Word("random", LanguageMother.random(), DifficultMother.random());
    }

    public static Word random(Language language, Difficult difficult) {
        return new Word("random", language, difficult);
    }

    public static List<Word> randoms(Language language, Difficult difficult) {
        return List.of(WordMother.random(language, difficult),
                WordMother.random(language, difficult),
                WordMother.random(language, difficult),
                WordMother.random(language, difficult));
    }

    public static List<Word> empty() {
        return Collections.emptyList();
    }
}
