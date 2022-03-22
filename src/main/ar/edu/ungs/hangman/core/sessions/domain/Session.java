package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Session {
    public final static Integer MAX_TRIES = 5;
    private final String user;
    private final Word word;
    private final Character[] characters;
    private Integer fails;
    private Integer completedWords;

    public Session(String user, Word word) {
        this.user = user;
        this.word = word;
        this.characters = new Character[word.length()];
        this.fails = 0;
        this.completedWords = 0;
    }

    public String user() {
        return user;
    }

    public Word word() {
        return word;
    }

    public Character[] characters() {
        return characters;
    }

    public Integer attempts() {
        return fails;
    }

    public void add(Character character, Integer... positions) {
        for (int i = 0; i < positions.length; i++) {
            this.characters[i] = character;
            this.completedWords++;
        }
    }

    public Integer[] positions(Character character){
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            Character wordCharacter = word.value().charAt(i);

            if (wordCharacter.equals(character)) {
                positions.add(i);
            }
        }

        return positions.toArray(new Integer[0]);
    }

    public void fail() {
        this.fails++;

        if  (this.fails.equals(MAX_TRIES)) {
            throw new SessionFinished("game session ended for exceeding the maximum number of failed attempts");
        }
    }

    public Boolean isComplete(){
        return completedWords == word.value().length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(user, session.user) && Objects.equals(word, session.word) && Arrays.equals(characters, session.characters) && Objects.equals(fails, session.fails) && Objects.equals(completedWords, session.completedWords);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(user, word, fails, completedWords);
        result = 31 * result + Arrays.hashCode(characters);
        return result;
    }

    @Override
    public String toString() {
        return "Session{" +
                "user='" + user + '\'' +
                ", word=" + word +
                ", characters=" + Arrays.toString(characters) +
                ", fails=" + fails +
                ", completedWords=" + completedWords +
                '}';
    }
}
