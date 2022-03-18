package ar.edu.ungs.hangman.apps.forms;

import ar.edu.ungs.hangman.apps.forms.views.GameView;
import ar.edu.ungs.hangman.apps.shared.Application;

public final class FormsApplication extends Application {
    @Override
    public void run() {
        GameView gameView = new GameView();
    }
}
