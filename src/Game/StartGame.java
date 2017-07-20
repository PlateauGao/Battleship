package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartGame extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(new ImageIcon("images/background1.png").getImage(), 0, 0, Window.screenX(), Window.screenY(), this);

	}

	@SuppressWarnings("deprecation")
	public StartGame() {
		this.setLayout(null);
		ImageIcon image = new ImageIcon("images/text1.png");
		ImageIcon image2 = new ImageIcon("images/text2.png");
		JButton a = new JButton( image);
		
		a.setContentAreaFilled(false);
		
		a.setSize(360,130);
		a.setLocation(800,625);
		JButton b = new JButton(image2);
		b.setContentAreaFilled(false);
		
		
		b.setSize(360,130);
		b.setLocation(800,775);
		
		a.repaint();
		b.repaint();
		a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// TODO Auto-generated method stub
				
			}
		});
		this.add(a);
		this.add(b);
		
	}
	public void close(){
		this.setVisible(false);
	}
}
