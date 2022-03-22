package ar.edu.ungs.hangman.core.words.domain;

import java.util.Arrays;

public final class DifficultMother {
    public static Difficult random() {
        return Arrays.stream(Difficult.values()).findAny().get();
    }
}
