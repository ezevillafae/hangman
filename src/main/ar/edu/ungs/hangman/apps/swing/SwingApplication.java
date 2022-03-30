package ar.edu.ungs.hangman.apps.swing;

import ar.edu.ungs.hangman.apps.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;

public final class SwingApplication extends Application {
	private static final String TITLE = "HANGMAN";
	private static final String WARNING = "Ingrese su nombre, por favor";

	private static final String HANGMAN_BUTTON_TEXT = "HANGMAN GAME";
	private static final String GUESSER_BUTTON_TEXT = "GUESSER GAME";
	private static final String LABEL_TEXT = "Ingrese su nombre";


	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 400;
	private static final Integer HEIGHT = 350;

	private final JFrame frame;
	private final JLabel title;
	private final JLabel warning;
	private final JButton guesserButton;
	private final JButton hangmanButton;
	private final JTextField textField;

	public SwingApplication() {
		this.frame = new JFrame();
		this.title = new JLabel(TITLE);
		this.warning = new JLabel(WARNING);
		this.hangmanButton = new JButton(HANGMAN_BUTTON_TEXT);
		this.guesserButton = new JButton(GUESSER_BUTTON_TEXT);
		this.textField = new JTextField(LABEL_TEXT);

		setup();
	}

	private void setup() {
		title.setBounds(160, 20, 250, 10);
		warning.setBounds(160, 20, 250, 10);


		textField.setBounds(MARGIN, 60, 360, 50);

		hangmanButton.setBounds(MARGIN, 140, 150, 50);
		hangmanButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		guesserButton.setBounds(230, 140, 150, 50);
		guesserButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		frame.add(title);
		frame.add(textField);
		frame.add(guesserButton);
		frame.add(hangmanButton);

		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		SwingApplication application = new SwingApplication();
	}

}
