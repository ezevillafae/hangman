package ar.edu.ungs.hangman.apps.swing.views;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public abstract class View {
	protected final JFrame frame;
	protected Font customFont;

	public View() {
		this.frame = new JFrame();
		setLookAndFeel();
		setDefaultFrame();
		centerFrame();
		loadFont();
	}

	protected void showMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadFont() {
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Bangla MN.ttf")));
			GraphicsEnvironment gc = GraphicsEnvironment.getLocalGraphicsEnvironment();
			gc.registerFont(customFont);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void setDefaultFrame () {
		/* ----------  Frame  ------------- */
		frame.setUndecorated(true);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void centerFrame(){
		/* frame center */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

	public JFrame frame() {
		return this.frame;
	}

	public void dispose() {
		this.frame.dispose();
		this.frame.setVisible(false);
	}
}
