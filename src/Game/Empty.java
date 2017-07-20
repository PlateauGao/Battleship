package Game;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


	public class Empty extends JPanel{
		
		public Empty(int x,int y){
			setVisible(true);
			setOpaque(false);
			setLocation(x, y);
			setSize(50, 50);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image image = new ImageIcon("images/empty.png").getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			
		}
	}


