package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;

public final class MainView extends View {
	private static final String TITLE = "AHORCADO";
	private static final String WARNING = "Ingrese su nombre, por favor";

	private static final String HANGMAN_BUTTON_TEXT = "JUGAR AHORCADO";
	private static final String GUESSER_BUTTON_TEXT = "JUGAR AL ADIVINADOR";
	private static final String USER_LABEL_TEXT = "Ingrese su nombre";
	private static final String LANGUAGE_LABEL_TEXT = "Seleccione el lenguaje con el que desea jugar";

	private static final String ENGLISH_RADIO_BUTTON_TEXT = "Inglés";
	private static final String SPANISH_RADIO_BUTTON_TEXT = "Español";

	private final SessionDefaultCreator sessionDefaultCreator;
	private final SessionTryer tryer;

	private final SessionFinder sessionFinder;
	private final SessionGuessCreator sessionGuessCreator;
	private final SessionGuesser guesser;

	private JFrame frame;
	private final JLabel titleLabel;
	private final JLabel languageLabel;
	private final JRadioButton englishLanguageRadioButton;
	private final JRadioButton spanishLanguageRadioButton;
	private final ButtonGroup languageButtonGroup;
	private final JButton guesserButton;
	private final JButton hangmanButton;
	private final JTextField textField;

	public MainView(SessionDefaultCreator sessionDefaultCreator,
	                SessionTryer tryer,
	                SessionFinder sessionFinder,
	                SessionGuessCreator sessionGuessCreator,
	                SessionGuesser guesser) {
		this.sessionFinder = sessionFinder;
		this.sessionDefaultCreator = sessionDefaultCreator;
		this.tryer = tryer;
		this.sessionGuessCreator = sessionGuessCreator;
		this.guesser = guesser;


		this.frame = new JFrame();
		frame.setBounds(0, 0, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.titleLabel = new JLabel(TITLE);
		this.languageLabel = new JLabel(LANGUAGE_LABEL_TEXT);
		this.hangmanButton = new JButton(HANGMAN_BUTTON_TEXT);
		this.guesserButton = new JButton(GUESSER_BUTTON_TEXT);
		this.textField = new JTextField();

		this.englishLanguageRadioButton = new JRadioButton(ENGLISH_RADIO_BUTTON_TEXT);
		this.spanishLanguageRadioButton = new JRadioButton(SPANISH_RADIO_BUTTON_TEXT);

		this.languageButtonGroup = new ButtonGroup();

		draw();
	}

	public void draw() {
		titleLabel.setBounds(160, 20, 250, 10);

		textField.setBounds(20, 60, 360, 50);
		textField.setToolTipText(USER_LABEL_TEXT);
		textField.setText(USER_LABEL_TEXT);

		languageLabel.setBounds(20, 120, 250, 10);
		englishLanguageRadioButton.setBounds(40, 130, 150, 50);
		spanishLanguageRadioButton.setBounds(250, 130, 150, 50);

		languageButtonGroup.add(englishLanguageRadioButton);
		languageButtonGroup.add(spanishLanguageRadioButton);

		hangmanButton.setBounds(20, 190, 150, 50);
		hangmanButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()){
					showMessageDialog(hangmanButton, WARNING);
					return;
				}

				if (languageButtonGroup.getSelection() == null){
					showMessageDialog(hangmanButton, LANGUAGE_LABEL_TEXT);
					return;
				}

				dispose();
				EventQueue.invokeLater(() -> {
					HangmanView window = new HangmanView(textField.getText(), language(), sessionFinder, sessionDefaultCreator, tryer);
					window.frame().setVisible(true);
				});
			}
		});

		guesserButton.setBounds(230, 190, 150, 50);
		guesserButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()){
					showMessageDialog(guesserButton, WARNING);
					return;
				}

				if (languageButtonGroup.getSelection() == null){
					showMessageDialog(guesserButton, LANGUAGE_LABEL_TEXT);
					return;
				}

				dispose();
				EventQueue.invokeLater(() -> {
					GuesserView window = new GuesserView(textField.getText(), language(), sessionGuessCreator, guesser);
					window.frame().setVisible(true);
				});
			}
		});

		this.frame.add(titleLabel);
		this.frame.add(textField);
		this.frame.add(englishLanguageRadioButton);
		this.frame.add(spanishLanguageRadioButton);
		this.frame.add(guesserButton);
		this.frame.add(hangmanButton);
	}

	public String language() {
		return this.englishLanguageRadioButton.isSelected() ?
		       this.englishLanguageRadioButton.getText().toUpperCase(Locale.ROOT) :
		       this.spanishLanguageRadioButton.getText().toUpperCase(Locale.ROOT);
	}

	public void dispose() {
		this.frame.dispose();
		this.frame.setVisible(false);
	}

	@Override
	public JFrame frame() {
		return frame;
	}
}
