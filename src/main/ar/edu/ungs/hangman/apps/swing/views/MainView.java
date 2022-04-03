package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class MainView extends View {
	private static final String TITLE = "HANGMAN";
	private static final String WARNING = "Ingrese su nombre, por favor";

	private static final String HANGMAN_BUTTON_TEXT = "HANGMAN GAME";
	private static final String GUESSER_BUTTON_TEXT = "GUESSER GAME";
	private static final String USER_LABEL_TEXT = "Ingrese su nombre";
	private static final String LANGUAGE_LABEL_TEXT = "Seleccione el lenguaje";

	private static final String ENGLISH_RADIO_BUTTON_TEXT = "English";
	private static final String SPANISH_RADIO_BUTTON_TEXT = "Spanish";

	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 400;
	private static final Integer HEIGHT = 300;

	private final JLabel title;
	private final JLabel languageLabel;
	private final JRadioButton englishLanguageRadioButton;
	private final JRadioButton spanishLanguageRadioButton;
	private final ButtonGroup languageButtonGroup;
	private final JButton guesserButton;
	private final JButton hangmanButton;
	private final JTextField textField;


	public MainView() {
		this.title = new JLabel(TITLE);
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
		super.draw();

		title.setBounds(160, 20, 250, 10);

		textField.setBounds(MARGIN, 60, 360, 50);
		textField.setToolTipText(USER_LABEL_TEXT);
		textField.setText(USER_LABEL_TEXT);

		languageLabel.setBounds(MARGIN, 120, 250, 10);
		englishLanguageRadioButton.setBounds(MARGIN + 20, 130, 150, 50);
		spanishLanguageRadioButton.setBounds(250, 130, 150, 50);

		languageButtonGroup.add(englishLanguageRadioButton);
		languageButtonGroup.add(spanishLanguageRadioButton);

		hangmanButton.setBounds(MARGIN, 190, 150, 50);
		hangmanButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					showWarningMessageDialog(hangmanButton, WARNING);
				} else if (languageButtonGroup.getSelection() == null) {
					showWarningMessageDialog(hangmanButton, LANGUAGE_LABEL_TEXT);
				} else {
					String user = textField.getText();
					String language = getRadioButtonSelected();

					die();
					new HangmanView(user, language);
				}
			}
		});

		guesserButton.setBounds(230, 190, 150, 50);
		guesserButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					showWarningMessageDialog(guesserButton, WARNING);
				} else if (languageButtonGroup.getSelection() == null) {
					showWarningMessageDialog(guesserButton, LANGUAGE_LABEL_TEXT);
				} else {
					String user = textField.getText();
					String language = getRadioButtonSelected();

					die();
					new GuesserView(user, language);
				}
			}
		});

		super.add(title);
		super.add(textField);
		super.add(englishLanguageRadioButton);
		super.add(spanishLanguageRadioButton);
		super.add(guesserButton);
		super.add(hangmanButton);
	}

	private String getRadioButtonSelected() {
		return this.englishLanguageRadioButton.isSelected() ?
		       this.englishLanguageRadioButton.getText() :
		       this.spanishLanguageRadioButton.getText();
	}

	private void showWarningMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}
}
