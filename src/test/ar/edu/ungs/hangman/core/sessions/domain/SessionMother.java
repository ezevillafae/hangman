package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.WordMother;

public final class SessionMother {
    public static Session random(){
        return new Session("user", WordMother.random());
    }
}
