package ar.edu.ungs.hangman.core.sessions.application;

import ar.edu.ungs.hangman.core.sessions.domain.Session;

import java.util.Arrays;
import java.util.Objects;

public final class SessionResponse {
    private final String user;
    private final String word;
    private final Character[] characters;
    private Integer failoverTries;

    public SessionResponse(String user, String word, Character[] characters, Integer failoverTries) {
        this.user = user;
        this.word = word;
        this.characters = characters;
        this.failoverTries = failoverTries;
    }

    public static SessionResponse map(Session session) {
        return new SessionResponse(session.user(),
                                   session.word().value(),
                                   session.characters(),
                                   session.attempts());
    }

    public String user() {
        return user;
    }

    public String word() {
        return word;
    }

    public Character[] characters() {
        return characters;
    }

    public Integer failoverTries() {
        return failoverTries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionResponse that = (SessionResponse) o;
        return Objects.equals(user,
                              that.user) && Objects.equals(
                word, that.word) && Arrays.equals(characters, that.characters) && Objects.equals(
                failoverTries, that.failoverTries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(user, word, failoverTries);
        result = 31 * result + Arrays.hashCode(characters);
        return result;
    }

    @Override
    public String toString() {
        return "SessionResponse{" +
                "user='" + user + '\'' +
                ", word='" + word + '\'' +
                ", characters=" + Arrays.toString(characters) +
                ", failoverTries=" + failoverTries +
                '}';
    }
}
