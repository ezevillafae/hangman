package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class MainView extends BaseView {
	private static final String TITLE = "HANGMAN";
	private static final String WARNING = "Ingrese su nombre, por favor";

	private static final String HANGMAN_BUTTON_TEXT = "HANGMAN GAME";
	private static final String GUESSER_BUTTON_TEXT = "GUESSER GAME";
	private static final String LABEL_TEXT = "Ingrese su nombre";


	private static final Integer MARGIN = 20;
	private static final Integer WIDTH = 400;
	private static final Integer HEIGHT = 350;

	private final JLabel title;
	private final JLabel warning;
	private final JButton guesserButton;
	private final JButton hangmanButton;
	private final JTextField textField;

	public MainView() {
		this.title = new JLabel(TITLE);
		this.warning = new JLabel(WARNING);
		this.hangmanButton = new JButton(HANGMAN_BUTTON_TEXT);
		this.guesserButton = new JButton(GUESSER_BUTTON_TEXT);
		this.textField = new JTextField();

		setupComponents();
	}

	void setupComponents() {
		title.setBounds(160, 20, 250, 10);
		warning.setBounds(160, 20, 250, 10);

		textField.setBounds(MARGIN, 60, 360, 50);
		textField.setToolTipText(LABEL_TEXT);

		hangmanButton.setBounds(MARGIN, 140, 150, 50);
		hangmanButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					showWarningMessageDialog(hangmanButton);
					return;
				}


			}
		});

		guesserButton.setBounds(230, 140, 150, 50);
		guesserButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					showWarningMessageDialog(guesserButton);
					return;
				}
			}
		});

		super.add(title);
		super.add(textField);
		super.add(guesserButton);
		super.add(hangmanButton);

		super.setSize(WIDTH, HEIGHT);
		super.setLayout(null);
		super.setVisible(true);
	}

	private void showWarningMessageDialog(Component component) {
		JOptionPane.showMessageDialog(component, warning);
	}
}
