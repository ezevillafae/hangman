package ar.edu.ungs.hangman.core.sessions.domain;

import ar.edu.ungs.hangman.core.words.domain.Word;

import java.util.ArrayList;
import java.util.List;

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
}
