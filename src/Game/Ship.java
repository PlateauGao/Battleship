package Game;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel {
	String name;
	int size = 0;
	int shipisdown = 0;
	public int click = 0;

	public Ship(String a, int b) {
		name = a;
		size = b;
		setshipSize();
		setVisible(false);
		setOpaque(false);

	}

	public void paintComponent(Graphics g) {
		Image image = new ImageIcon("images/" + name + ".png").getImage();
		Image image1 = new ImageIcon("images/" + name + "down.png").getImage();
		super.paintComponent(g);
		if (click == 0 && shipisdown == 0) {
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setComposite(ac);
			g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		} else if (click == 1 && shipisdown == 0) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		} else if (click == 0 && shipisdown == 1) {
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setComposite(ac);
			g2d.drawImage(image1, 0, 0, getWidth(), getHeight(), this);
		} else if (click == 1 && shipisdown == 1) {
			g.drawImage(image1, 0, 0, getWidth(), getHeight(), this);
		}

	}

	public void setshipLocation(int x, int y) {
		setLocation(x - x % 50, y - y % 50);

	}

	public void setshipSize() {
		setSize(size * 50 - (size - 1) * 50 * shipisdown, 50 + (size - 1) * 50 * shipisdown);
	}

	public void setshipClick() {
		click = (click + 1) % 2;
	}

	public void setshipDown() {
		shipisdown = (shipisdown + 1) % 2;
	}

	public int shipsize() {
		return size;
	}

	public int shipdown() {
		return shipisdown;
	}
}
