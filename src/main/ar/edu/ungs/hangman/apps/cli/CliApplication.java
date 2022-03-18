package ar.edu.ungs.hangman.apps.cli;

import ar.edu.ungs.hangman.apps.shared.Application;
import ar.edu.ungs.hangman.core.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class CliApplication extends Application {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("----- HANGMAN -----");

        try {
            System.out.println("Enter language: ");
            Language language = Language.valueOf(reader.readLine());

            System.out.println("Enter user: ");
            String user = reader.readLine();

            System.out.println("Enter difficult: ");
            Difficult difficult = Difficult.valueOf(reader.readLine());

            sessionCreator.create(user, difficult, language);

            while (true) {
                SessionResponse session = sessionFinder.find(user);
                System.out.println(session.word());

                for (int i = 0; i < session.characters().length; i++) {
                    if (session.characters()[i] == null) {
                        System.out.print(" _ ");
                    } else {
                        System.out.println(" " + session.characters()[i] + " ");
                    }
                }

                System.out.println("Enter letter: ");
                Character character = reader.readLine().charAt(0);

                sessionTryer.attempt(user, character);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
