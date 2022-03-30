package ar.edu.ungs.hangman.core.words.infrastructure.ioc;

import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;

public final class DomainWordRandomPickerSingleton {
	private static volatile DomainWordRandomPicker instance;

	public static DomainWordRandomPicker instance() {
		DomainWordRandomPicker result = instance;
		if (result != null) {
			return result;
		}
		synchronized (DomainWordRandomPicker.class) {
			if (instance == null) {
				instance = new DomainWordRandomPicker(WordRepositorySingleton.instance());
			}
			return instance;
		}
	}
}
