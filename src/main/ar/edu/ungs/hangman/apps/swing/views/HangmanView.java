package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class HangmanView {

	private JFrame frame;
	private JTextField characterField;
	private JLabel hangmanTitle;
	private JLabel[] characterSpaces;
	private JLabel lblUserName;
	private JLabel hangmanImage;
	private Font customFont;
	private Image iconClose;
	private ImageIcon escaledIconClose;
	private JLabel lblClose;
	private int xMouse;
	private int yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanView window = new HangmanView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HangmanView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLookAndFeel();
		loadFont();
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		hangmanImage = new JLabel();
		hangmanImage.setIcon(new ImageIcon(getClass().getResource("/hanged.png")));
		hangmanImage.setBounds(196, 39, 434, 261);
		frame.getContentPane().add(hangmanImage);

		JButton btnTry = new JButton("Try");

		btnTry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Character[] c = {'h','o','l',null};
				replaceCharactersSpaces(c);
			}
		});

		btnTry.setBounds(25, 248, 89, 23);
		frame.getContentPane().add(btnTry);

		characterField = new JTextField();
		characterField.setDocument(new LimitJTextField(1));
		characterField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();
				if(Character.isDigit(c) || !Character.isLetter(c))
					e.consume();
				e.setKeyChar(Character.toUpperCase(c));

			}
		});
		characterField.setBounds(125, 249, 86, 20);
		characterField.setColumns(10);
		frame.getContentPane().add(characterField);

		hangmanTitle = new JLabel("Hangman");
		hangmanTitle.setFont(customFont.deriveFont(24f));
		hangmanTitle.setBounds(25, 60, 112, 39);
		frame.getContentPane().add(hangmanTitle);

		lblUserName = new JLabel("Usuario1");
		lblUserName.setFont(customFont.deriveFont(14f));
		lblUserName.setBounds(25, 110, 124, 14);
		frame.getContentPane().add(lblUserName);



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

				frame.setLocation(e.getXOnScreen() - xMouse ,e.getYOnScreen() - yMouse);
			}
		});
		frameDrag.setBounds(0, 0, 386, 28);
		frame.getContentPane().add(frameDrag);

		lblClose = new JLabel("X");
		lblClose.setFont(customFont.deriveFont(20f));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setBounds(411, 11, 29, 17);
		lblClose.setIcon(escaledIconClose);
		frame.getContentPane().add(lblClose);

		paintCharacterSpaces(10);


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


	private void paintCharacterSpaces(int size) {
		this.characterSpaces = new JLabel[size];
		int xAxisTranslation = 0;
		for(int i = 0; i < characterSpaces.length; i++) {
			characterSpaces[i] = new JLabel("_");
			//characterSpaces[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
			characterSpaces[i].setBounds(27 + xAxisTranslation, 200, 46, 14);
			xAxisTranslation += 20;
			frame.getContentPane().add(characterSpaces[i]);
		}
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void replaceCharactersSpaces(Character[] characters) {
		for(int i = 0; i < characters.length ; i++) {
			if(characters[i] != null)
				characterSpaces[i].setText(characters[i].toString());
		}
	}


	class LimitJTextField extends PlainDocument
	{
		private int max;
		LimitJTextField(int max) {
			super();
			this.max = max;
		}
		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null)
				return;
			if ((getLength() + text.length()) <= max) {
				super.insertString(offset, text, attr);
			}
		}
	}
}

