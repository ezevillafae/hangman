package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Session {
    private final String user;
    private final Word word;
    private final Character[] characters;
    private Integer fails;
    private Integer completedCharacters;

    public Session(String user, Word word) {
        this.user = user;
        this.word = word;
        this.characters = new Character[word.length()];
        this.fails = 0;
        this.completedCharacters = 0;
    }

    public Session(String user, Word word, Integer fails) {
        this.user = user;
        this.word = word;
        this.characters = new Character[word.length()];
        this.fails = fails;
        this.completedCharacters = 0;
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

    public Integer fails() {
        return fails;
    }

    public void add(Character character, Integer... positions) {
        for (Integer position : positions) {
            this.characters[position] = character;
            this.completedCharacters++;
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
    }

    public Boolean isComplete(){
        return completedCharacters == word.value().length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(user, session.user) && Objects.equals(word, session.word) && Arrays.equals(characters, session.characters) && Objects.equals(fails, session.fails) && Objects.equals(completedCharacters, session.completedCharacters);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(user, word, fails, completedCharacters);
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
                ", completedWords=" + completedCharacters +
                '}';
    }
}
