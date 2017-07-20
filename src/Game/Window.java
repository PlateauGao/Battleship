package Game;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Window {

	JFrame window = new JFrame();
	Board board = new Board(this);
	Board board2 = new Board(this);
	Attack[] attack;
	int side = 1;
	int num1;
	int num2;
	JTextArea textarea = new JTextArea("Set your boat here");
	JTextArea textarea1 = new JTextArea("Attack here!");
	JLabel textarea3 = new JLabel();
	JLabel textarea4 = new JLabel();

	MouseListener mousecopy, attack1mouse, attack2mouse;
	MouseMotionListener mousecopy2;
	int player = 0;
	Cursor coursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/mouse.png").getImage(),
			new Point(0, 0), "stick");
	Cursor coursor1 = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/mouse1.png").getImage(),
			new Point(30, 20), "stick");
	Cursor coursor2 = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/mouse2.png").getImage(),
			new Point(16, 16), "stick");

	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	@SuppressWarnings("deprecation")
	public Window() {
		StartGame start = new StartGame();
		start.setBounds(0, 0, screenSize.width, screenSize.height);
		window.add(start);

		window.setCursor(coursor);

		attack = new Attack[2];
		attack[0] = new Attack(board.player1, this, "player1");
		attack[1] = new Attack(board2.player1, this, "player2");
		window.setSize(screenSize.width, screenSize.height);

		board.setBounds(screenSize.width / 2 - 500, 400, 501, 501);
		board.setOpaque(false);
		window.add(board);

		board2.setBounds(screenSize.width / 2 + 200, 400, 501, 501);
		board2.setOpaque(false);
		window.add(board2);

		window.setLayout(null);
		window.setVisible(true);

		mousecopy = board2.getMouseListeners()[0];
		mousecopy2 = board2.getMouseMotionListeners()[0];
		board2.removeMouseListener(board2.getMouseListeners()[0]);
		board2.removeMouseMotionListener(board2.getMouseMotionListeners()[0]);

		attack1mouse = attack[0].getMouseListeners()[0];
		attack2mouse = attack[1].getMouseListeners()[0];
		window.add(attack[0]);
		attack[0].setBounds(screenSize.width / 2 - 500, 400, 501, 501);
		window.add(attack[1]);
		attack[1].setBounds(screenSize.width / 2 + 200, 400, 501, 501);
		attack[0].removeMouseListener(attack1mouse);
		attack[1].removeMouseListener(attack2mouse);

		textarea.setFont(new Font("Arial", Font.BOLD, 39));
		;
		textarea1.setFont(new Font("Arial", Font.BOLD, 39));
		;
		textarea3.setFont(new Font("Arial", Font.BOLD, 39));
		;
		textarea4.setFont(new Font("Arial", Font.BOLD, 39));
		;

		textarea.setSize(500, 150);
		textarea1.setSize(500, 150);
		textarea.setLocation(screenSize.width / 2 - 400, 350);
		textarea1.setLocation(screenSize.width / 2 - 350, 350);
		textarea.setLayout(null);
		textarea1.setLayout(null);
		textarea.setVisible(true);
		textarea1.setVisible(false);
		textarea.setOpaque(false);
		textarea1.setOpaque(false);
		textarea.disable();
		textarea1.disable();
		textarea3.disable();
		textarea4.disable();
		window.add(textarea);
		window.add(textarea1);

		textarea3.setSize(500, 200);
		textarea4.setSize(500, 200);
		textarea3.setLocation(screenSize.width / 2 - 400, 850);
		textarea4.setLocation(screenSize.width / 2 + 300, 850);
		textarea3.setOpaque(false);
		textarea4.setOpaque(false);
		textarea3.setText("Attack times: "+Integer.toString(num1));
		textarea4.setText("Attack times: "+Integer.toString(num2));
		window.add(textarea3);
		window.add(textarea4);

		Background background = new Background();
		background.setBounds(0, 0, screenSize.width, screenSize.height);
		window.add(background);
		
		
		   
		

	}

	public void change() {
		textarea.setLocation(screenSize.width / 2 + 300, 350);
		textarea.repaint();
		board2.addMouseListener(mousecopy);
		board2.addMouseMotionListener(mousecopy2);

	}

	public void nextplayer() {
		player++;
	}

	public void nextstep() {

		attack[0].addMouseListener(attack1mouse);
		textarea.setVisible(false);
		textarea1.setVisible(true);
		window.setCursor(coursor2);
	}

	public void changeside() {
		if (side == 0) {
			attack[1].removeMouseListener(attack2mouse);

			attack[0].addMouseListener(attack1mouse);
			textarea1.setLocation(screenSize.width / 2 - 375, 350);
			textarea1.repaint();
		} else if (side == 1) {
			attack[0].removeMouseListener(attack1mouse);

			attack[1].addMouseListener(attack2mouse);
			textarea1.setLocation(screenSize.width / 2 + 350, 350);
			textarea1.repaint();
		}
		

	}

	public void win(String a) {
		if (a == "player1") {
			window.add(new Win(1));
			window.setVisible(false);

		} else if (a == "player2") {
			window.add(new Win(2));
		}
		// window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.setVisible(false);

	}

	public static int screenX() {
		return screenSize.width;
	}

	public static int screenY() {
		return screenSize.height;
	}
	
}
