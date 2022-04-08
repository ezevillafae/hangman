package ar.edu.ungs.hangman.apps.swing.views;

import ar.edu.ungs.hangman.core.sessions.application.create.SessionDefaultCreator;
import ar.edu.ungs.hangman.core.sessions.application.create.SessionGuessCreator;
import ar.edu.ungs.hangman.core.sessions.application.find.SessionFinder;
import ar.edu.ungs.hangman.core.sessions.application.guess.SessionGuesser;
import ar.edu.ungs.hangman.core.sessions.application.tries.SessionTryer;
import ar.edu.ungs.hangman.core.words.domain.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainView extends View {

	private static final String TITLE = "AHORCADO";
	private static final String WARNING = "Ingrese su nombre, por favor";

	private static final String HANGMAN_BUTTON_TEXT = "JUGAR AHORCADO";
	private static final String GUESSER_BUTTON_TEXT = "JUGAR AL ADIVINADOR";
	private static final String USER_LABEL_TEXT = "Ingrese su nombre";
	private static final String LANGUAGE_LABEL_TEXT = "Seleccione el lenguaje con el que desea jugar";

	private static final String ENGLISH_RADIO_BUTTON_TEXT = "Inglés";
	private static final String SPANISH_RADIO_BUTTON_TEXT = "Español";
	protected int xMouse;
	protected int yMouse;
	private JTextField userNameTextField;
	private Font customFont;
	private JLabel lblUserName;
	private JLabel btnClose;
	private JRadioButton rdbtnEnglish;
	private JRadioButton rdbtnSpanish;
	private JButton btnPlayHangman;
	private JButton btnPlayGuesser;
	private JLabel frameDrag;
	private JPanel panel;
	private JLabel logoUngs;
	private JLabel titleHangman;
	private ButtonGroup languageButtonGroup;


	private SessionDefaultCreator sessionDefaultCreator;
	private SessionTryer tryer;
	private SessionFinder sessionFinder;
	private SessionGuessCreator sessionGuessCreator;
	private SessionGuesser guesser;

	/**
	 * Create the application.
	 */
	public MainView(SessionDefaultCreator sessionDefaultCreator,
	                SessionTryer tryer,
	                SessionFinder sessionFinder,
	                SessionGuessCreator sessionGuessCreator,
	                SessionGuesser guesser) {
		this.sessionDefaultCreator = sessionDefaultCreator;
		this.tryer = tryer;
		this.sessionFinder = sessionFinder;
		this.sessionGuessCreator = sessionGuessCreator;
		this.guesser = guesser;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLookAndFeel();
		loadFont();

		/* ------ frame ----------*/
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/* frame center */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);


		/* ------ User name text field ----------*/
		userNameTextField = new JTextField();
		userNameTextField.setBounds(184, 166, 256, 20);
		frame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);


		/* ------ label user name  ----------*/
		lblUserName = new JLabel(USER_LABEL_TEXT);
		lblUserName.setBounds(184, 141, 126, 14);
		frame.getContentPane().add(lblUserName);


		/* ------ button close ----------*/
		btnClose = new JLabel("X");
		btnClose.setFont(customFont.deriveFont(14f));
		btnClose.setBounds(417, 11, 23, 14);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(btnClose);

		/* ------ Language buttons  ----------*/
		languageButtonGroup = new ButtonGroup();

		rdbtnEnglish = new JRadioButton("Ingl\u00E9s");
		rdbtnEnglish.setBounds(185, 217, 109, 23);
		frame.getContentPane().add(rdbtnEnglish);

		rdbtnSpanish = new JRadioButton("Espa\u00F1ol");
		rdbtnSpanish.setBounds(321, 217, 109, 23);
		rdbtnEnglish.getModel().setGroup(languageButtonGroup);
		rdbtnSpanish.getModel().setGroup(languageButtonGroup);
		frame.getContentPane().add(rdbtnSpanish);

		/* ------ play Buttons ----------*/
		btnPlayHangman = new JButton("Jugar Ahorcado");
		btnPlayHangman.setBounds(184, 247, 126, 23);

		btnPlayHangman.addActionListener(e -> {
			if (userNameTextField.getText().isEmpty()) {
				showMessageDialog(userNameTextField, WARNING);
				return;
			}
			if (languageButtonGroup.getSelection() == null) {
				showMessageDialog(btnPlayHangman, LANGUAGE_LABEL_TEXT);
				return;
			}
			frame.dispose();

			EventQueue.invokeLater(() -> {
				HangmanView window = new HangmanView(userNameTextField.getText(), Language.SPANISH.toString(),
				                                     sessionFinder, sessionDefaultCreator, tryer);
				window.frame.setVisible(true);
			});
		});

		frame.getContentPane().add(btnPlayHangman);

		btnPlayGuesser = new JButton("Jugar Adivinador");
		btnPlayGuesser.setBounds(321, 247, 119, 23);

		btnPlayGuesser.addActionListener(e -> {
			if (userNameTextField.getText().isEmpty()) {
				showMessageDialog(userNameTextField, WARNING);
				return;
			}
			if (languageButtonGroup.getSelection() == null) {
				showMessageDialog(btnPlayHangman, LANGUAGE_LABEL_TEXT);
				return;
			}
			frame.dispose();

			EventQueue.invokeLater(() -> {
				GuesserView window = new GuesserView(userNameTextField.getText(), Language.SPANISH.toString(),
				                                     sessionGuessCreator, guesser);
				window.frame.setVisible(true);
			});
		});

		frame.getContentPane().add(btnPlayGuesser);


		/* ------ frame drag ----------*/
		frameDrag = new JLabel("");
		frameDrag.setBounds(0, 0, 407, 25);
		frame.getContentPane().add(frameDrag);
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

		/*------------------------*/
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 174, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);


		/* ------ titleHangman ----------*/
		titleHangman = new JLabel("Hangman");
		titleHangman.setHorizontalAlignment(SwingConstants.CENTER);
		titleHangman.setFont(customFont.deriveFont(30f));
		titleHangman.setBounds(0, 110, 174, 53);
		panel.add(titleHangman);


		/* ------ logo ungs ----------*/
		logoUngs = new JLabel("");
		logoUngs.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/ungs.jpg"))));
		logoUngs.setBounds(230, 51, 162, 63);
		frame.getContentPane().add(logoUngs);
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

	public JFrame frame() {
		return this.frame;
	}
}
