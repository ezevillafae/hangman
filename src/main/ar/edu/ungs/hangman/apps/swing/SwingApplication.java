package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.Application;

import javax.swing.*;

public final class SwingApplication extends Application {
	private static final String TITLE = "HANGMAN";
	private static final String BUTTON_TEXT = "TRY";

	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 400;
	private static final Integer HEIGHT = 500;

	private final JFrame frame;
	private final JLabel title;
	private final JButton button;
	private final JTextField textField;

	public SwingApplication() {
		this.frame = new JFrame();
		this.title = new JLabel(TITLE);
		this.button = new JButton(BUTTON_TEXT);
		this.textField = new JTextField();

		setup();
	}

	private void setup() {
		title.setBounds(160, 20, 250, 10);
		button.setBounds(280, 400, 100, 50);
		textField.setBounds(MARGIN, 400, 250, 50);

		frame.add(title);
		frame.add(button);
		frame.add(textField);

		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		SwingApplication application = new SwingApplication();
	}

}
