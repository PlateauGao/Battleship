package Game;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(new ImageIcon("images/back.jpg").getImage(), 0, 0, Window.screenX(),Window.screenY(), this);

	}


}
