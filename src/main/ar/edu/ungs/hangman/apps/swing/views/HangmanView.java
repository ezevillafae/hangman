package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.modules.sessions.application.SessionResponse;
import ar.edu.ungs.hangman.modules.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.modules.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.modules.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.modules.sessions.domain.SessionFinished;
import ar.edu.ungs.hangman.modules.words.domain.Difficult;
import ar.edu.ungs.hangman.modules.words.domain.Language;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.Objects;

public final class HangmanView extends View {
	private final String user;
	private final SessionFinder sessionFinder;
	private final SessionDefaultCreator creator;
	private final SessionTryer tryer;
	private JTextField characterField;
	private JLabel[] characters;
	private JLabel lblUserName;
	private JLabel hangmanImage;
	private ImageIcon[] hangmanBackgrounds;
	private JLabel lblClose;
	private int xMouse;
	private int yMouse;
	private JLabel lblAttemps;

	public HangmanView(String user,
	                   String language,
	                   String difficult,
	                   SessionFinder sessionFinder,
	                   SessionDefaultCreator creator,
	                   SessionTryer tryer) {
		super();

		this.user = user;
		this.sessionFinder = sessionFinder;
		this.creator = creator;
		this.tryer = tryer;


		this.creator.create(user, Difficult.valueOf(difficult), Language.valueOf(language.toUpperCase(Locale.ROOT)));
		loadBackgrounds();
		initialize();
	}

	private void initialize() {



		/* ----------  Try Button   ------------- */
		JButton btnTry = new JButton("Try");

		btnTry.addActionListener(e -> {
			if (!characterFieldIsEmpty()) {
				SessionResponse response;
				try {

					tryer.execute(user, characterField.getText().charAt(0));
					response = this.sessionFinder.find(user);
					printCharacters(response);
					lblAttemps.setText(String.format("Intentos %s / %s", response.fails(), tryer.getMaxTries()));
					this.hangmanImage.setIcon(this.hangmanBackgrounds[response.fails()]);
					this.characterField.setText("");

				} catch (SessionFinished sessionFinished) {
					response = this.sessionFinder.find(user);
					printCharacters(response);
					lblAttemps.setText(String.format("Intentos %s / %s", response.fails(), tryer.getMaxTries()));
					this.hangmanImage.setIcon(this.hangmanBackgrounds[response.fails()]);
					showMessageDialog(btnTry, sessionFinished.getMessage());
					dispose();
				}
			}
		});

		btnTry.setBounds(25, 248, 89, 23);
		frame.getContentPane().add(btnTry);


		/* ----------  character field  ------------- */
		characterField = new JTextField();
		characterField.setDocument(new LimitJTextField(1));
		characterField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (Character.isDigit(character) || !Character.isLetter(character)) {
					e.consume();
				}
				e.setKeyChar(Character.toUpperCase(character));

			}
		});
		characterField.setBounds(125, 249, 86, 20);
		characterField.setColumns(10);
		frame.getContentPane().add(characterField);

		/* ----------  label userName  ------------- */
		lblUserName = new JLabel(this.user);
		lblUserName.setFont(customFont.deriveFont(14f));
		lblUserName.setForeground(Color.white);
		lblUserName.setBounds(15, 30, 124, 14);
		frame.getContentPane().add(lblUserName);

		/* ----------  frameDrag  ------------- */
		JLabel frameDrag = new JLabel("");
		frameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		frameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				frame.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		frameDrag.setBounds(0, 0, 386, 28);
		frame.getContentPane().add(frameDrag);


		/* ----------  Button close   ------------- */
		lblClose = new JLabel("X");
		lblClose.setFont(customFont.deriveFont(14f));
		lblClose.setForeground(Color.white);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setBounds(420, 11, 29, 17);
		frame.getContentPane().add(lblClose);


		/*  finding user   */
		SessionResponse response = this.sessionFinder.find(user);
		this.characters = new JLabel[response.characters().length];
		printCharacters(response);

		/* -------------  label attemps --------  */
		lblAttemps = new JLabel(String.format("Intentos %s / %s", response.fails(), tryer.getMaxTries()));
		lblAttemps.setFont(customFont.deriveFont(14f));
		lblAttemps.setForeground(Color.white);
		lblAttemps.setBounds(350, -10, 100, 100);

		frame.add(lblAttemps);

		/* ----------  Image Hangman  ------------- */
		hangmanImage = new JLabel();
		hangmanImage.setIcon(this.hangmanBackgrounds[response.fails()]);
		hangmanImage.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(hangmanImage);


	}

	private void loadBackgrounds() {
		this.hangmanBackgrounds = new ImageIcon[7];
		for (int i = 0; i < this.hangmanBackgrounds.length; i++){
			this.hangmanBackgrounds[i] = new ImageIcon(Objects.requireNonNull(getClass().getResource("/hangman" + (i+1) +".jpg")));
		}
	}

	private boolean characterFieldIsEmpty() {
		return this.characterField.getText().length() == 0;
	}


	private void printCharacters(SessionResponse session) {
		int xAxisTranslation = 0;
		for (int i = 0; i < session.characters().length; i++) {
			if (characters[i] == null) {
				this.characters[i] = new JLabel("_");
				this.characters[i].setBounds(27 + xAxisTranslation, 200, 60, 60);
				this.characters[i].setFont(customFont.deriveFont(15f));
				this.characters[i].setForeground(Color.white);
				xAxisTranslation += 30;
				frame.getContentPane().add(characters[i]);
			} else {
				if (session.characters()[i] != null) {
					this.characters[i].setText(session.characters()[i].toString());
				}
			}
		}
	}

	class LimitJTextField extends PlainDocument {
		private int max;

		LimitJTextField(int max) {
			super();
			this.max = max;
		}

		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null) {
				return;
			}
			if ((getLength() + text.length()) <= max) {
				super.insertString(offset, text, attr);
			}
		}
	}
}

