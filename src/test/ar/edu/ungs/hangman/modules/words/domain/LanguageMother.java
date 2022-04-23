package ar.edu.ungs.hangman.modules.words.domain;

import java.util.Arrays;

public final class LanguageMother {
	public static Language random() {
		return Arrays.stream(Language.values()).findAny().get();
	}
}
