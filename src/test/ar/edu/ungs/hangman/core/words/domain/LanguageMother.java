package ar.edu.ungs.hangman.core.words.domain;

import java.util.Arrays;

public final class LanguageMother {
	public static Language random() {
		return Arrays.stream(Language.values()).findAny().get();
	}
}
