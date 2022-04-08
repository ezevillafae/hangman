package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.domain.SessionFinished;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class GuesserView extends View {
	private final String user;
	private final String language;
	private final String winnerText = "the machine guessed!";
	private final String looserText = "the machine has failed";
	private final SessionGuessCreator creator;
	private final SessionGuesser guesser;
	private JTextField wordField;
	private Font customFont;
	private int xMouse;
	private int yMouse;
	private JLabel frameDrag;
	private JButton btnStart;
	private JLabel titleGuesser;
	private JLabel lblClose;
	private JLabel lblUserName;
	private JLabel hangmanBackgroundImage;

	public GuesserView(String user, String language, SessionGuessCreator creator, SessionGuesser guesser) {
		super();

		this.user = user;
		this.language = language;
		this.creator = creator;
		this.guesser = guesser;

		initialize();
	}

	private void initialize() {
		setLookAndFeel();
		loadFont();

		/* ---- Frame ------*/
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* frame center */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.getContentPane().setLayout(null);


		/* -------- Frame Drag ---------- */
		frameDrag = new JLabel("");

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

		frameDrag.setBounds(0, 0, 419, 24);
		frame.getContentPane().add(frameDrag);

		/*------ button Close --------*/
		lblClose = new JLabel("X");
		lblClose.setFont(customFont.deriveFont(20f));

		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		lblClose.setBounds(410, 11, 30, 24);
		frame.getContentPane().add(lblClose);


		/*--------- wordField -----------*/
		wordField = new JTextField();
		wordField.setBounds(138, 258, 86, 20);
		wordField.setColumns(10);
		frame.getContentPane().add(wordField);



		/*--------- start button  -----------*/
		btnStart = new JButton("Start");
		btnStart.setBounds(39, 257, 89, 23);
		frame.getContentPane().add(btnStart);

		btnStart.addActionListener(e -> {
			if (validWord(wordField.getText())) {
				String word = wordField.getText();
				creator.create(word);

				wordField.setText("");
				wordField.setEnabled(false);
				btnStart.setEnabled(false);


				try {
					guesser.guess();
					showMessageDialog(btnStart, winnerText);
				} catch (SessionFinished sessionFinished) {
					showMessageDialog(btnStart, looserText);
				} finally {
					dispose();
				}

			} else {
				wordField.setText("");
			}
		});

		/*--------- titleGuesser -----------*/

		titleGuesser = new JLabel("Guesser");
		titleGuesser.setFont(customFont.deriveFont(30f));
		titleGuesser.setBounds(39, 50, 123, 33);
		frame.getContentPane().add(titleGuesser);


		/*--------- label user name  -----------*/
		lblUserName = new JLabel(this.user);
		lblUserName.setFont(customFont.deriveFont(14f));
		lblUserName.setBounds(39, 110, 102, 24);
		frame.getContentPane().add(lblUserName);


		/*-------- background hangman ------------*/
		hangmanBackgroundImage = new JLabel("");
		hangmanBackgroundImage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/hanged.png"))));
		hangmanBackgroundImage.setBounds(197, 35, 450, 300);
		frame.getContentPane().add(hangmanBackgroundImage);
	}

	private void loadFont() {
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/SansitaSwashed.ttf"));
			GraphicsEnvironment gc = GraphicsEnvironment.getLocalGraphicsEnvironment();
			gc.registerFont(customFont);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean validWord(String word) {
		boolean allLetters = true;
		for (int i = 0; i < word.length(); i++) {
			allLetters = allLetters && isLetter(word.charAt(i));
		}
		return allLetters;
	}

	private boolean isLetter(char character) {
		return character <= 'z' && character >= 'a' || character <= 'Z' && character >= 'A';
	}
}
