package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.WordMother;

import java.util.List;

public final class SessionMother {
    public static Session random(){
        return new Session("user", WordMother.random());
    }

    public static List<Session> randoms(){
        return List.of(random(), random(), random(), random());
    }
}
