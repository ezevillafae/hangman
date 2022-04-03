package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
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

	private final JLabel titleLabel;
	private final JLabel languageLabel;
	private final JRadioButton englishLanguageRadioButton;
	private final JRadioButton spanishLanguageRadioButton;
	private final ButtonGroup languageButtonGroup;
	private final JButton guesserButton;
	private final JButton hangmanButton;
	private final JTextField textField;

	public MainView() {
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

		textField.setBounds(margin(), 60, 360, 50);
		textField.setToolTipText(USER_LABEL_TEXT);
		textField.setText(USER_LABEL_TEXT);

		languageLabel.setBounds(margin(), 120, 250, 10);
		englishLanguageRadioButton.setBounds(margin() + 20, 130, 150, 50);
		spanishLanguageRadioButton.setBounds(250, 130, 150, 50);

		languageButtonGroup.add(englishLanguageRadioButton);
		languageButtonGroup.add(spanishLanguageRadioButton);

		hangmanButton.setBounds(margin(), 190, 150, 50);

		guesserButton.setBounds(230, 190, 150, 50);

		super.add(titleLabel);
		super.add(textField);
		super.add(englishLanguageRadioButton);
		super.add(spanishLanguageRadioButton);
		super.add(guesserButton);
		super.add(hangmanButton);
	}

	public String language() {
		return this.englishLanguageRadioButton.isSelected() ?
		       this.englishLanguageRadioButton.getText().toUpperCase(Locale.ROOT) :
		       this.spanishLanguageRadioButton.getText().toUpperCase(Locale.ROOT);
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
