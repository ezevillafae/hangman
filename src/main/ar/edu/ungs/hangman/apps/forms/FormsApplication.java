package ar.edu.ungs.hangman.apps.forms;

import ar.edu.ungs.hangman.apps.forms.views.GameView;
import ar.edu.ungs.hangman.apps.shared.Application;

import javax.swing.*;

public final class FormsApplication implements Application {
    @Override
    public void run() {
        GameView gameView = new GameView();
        gameView.setVisible(true);
        gameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
