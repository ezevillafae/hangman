package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;

public final class GameOverView extends View {
	private final String user;

	private final JLabel titleLabel;

	private static final String WIN_TITLE = "¡Felicidades! Ha ganado el juego";
	private static final String LOSS_TITLE = "¡Para la próxima!";

	public GameOverView(String user, Boolean won) {
		this.user = user;
		this.titleLabel = new JLabel(won ? WIN_TITLE : LOSS_TITLE);

		setup();
	}

	private void setup() {
		titleLabel.setBounds(160, 20, 250, 10);
	}

	@Override
	public Integer width() {
		return 400;
	}

	@Override
	public Integer height() {
		return 300;
	}

	@Override
	public Integer margin() {
		return 20;
	}
}
