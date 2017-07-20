package Game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

	// Ship ship1pre = new Ship("Ship1pre");

	int i = 0;

	private Window window;
	MouseMotionListener mousemotion;
	MouseListener mouselistener;
	Position[][] player1;
	public Board(Window w) {
		
		Ship[] ship;
		ship = new Ship[5];
		ship[0] = new Ship("Ship1", 5);
		ship[1] = new Ship("Ship2", 4);
		ship[2] = new Ship("Ship3", 3);
		ship[3] = new Ship("Ship4", 3);
		ship[4] = new Ship("Ship5", 2);
	
		window = w;
		player1 = new Position[10][10];
		for (int a = 0; a != 10; a++) {
			for (int b = 0; b != 10; b++) {
				player1[a][b] = new Position(a * 50, b * 50, 1);
			}
		}
		MouseMotionListener mousemotion = new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseMoved(MouseEvent e) {

				
					ship[i].repaint();
					ship[i].setshipLocation(e.getX(), e.getY());
					ship[i].setVisible(true);
					add(ship[i]);
					setLayout(null);
				
				// TODO Auto-generated method stu

			}

		};
		MouseListener mouselistener = new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getX() - e.getX() % 50 + (ship[i].shipsize() - 1) * 50 * ((ship[i].shipisdown + 1) % 2) < 500
							&& e.getY() - e.getY() % 50
									+ (ship[i].shipsize() - 1) * 50 * ((ship[i].shipisdown) % 2) < 500
							&& shipissetable(ship[i], player1, e.getX(), e.getY(), ship[i].shipisdown)) {
						ship[i].setshipClick();

						ship[i].repaint();
						if (ship[i].shipisdown == 1) {
							for (int count = 0; count != ship[i].shipsize(); count++) {
								player1[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50 + count]
										.setship();
								
							}
						} else if (ship[i].shipisdown == 0) {
							for (int count = 0; count != ship[i].shipsize(); count++) {
								player1[(e.getX() - e.getX() % 50) / 50 + count][(e.getY() - e.getY() % 50) / 50]
										.setship();
							
							}
						}
						i = i + 1;
						if (i == 5) {
							
							if (window.player == 0) {
								window.change();
							}
							window.nextplayer();
							removeMouseListener(this);
							removeMouseMotionListener(mousemotion);
							for(int a=0;a!=5;a++){
								ship[a].setVisible(false);
							}
							if(window.player==2){
								window.nextstep();
							}
						}

					}
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ship[i].setshipDown();
					ship[i].setshipSize();
					ship[i].repaint();
				}

			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent arg0) {

				// TODO Auto-generated method stub

			}
		};
		this.addMouseMotionListener(mousemotion);
		this.addMouseListener(mouselistener);

	}

	protected void paintComponent(Graphics g) {
		for (int i = 0; i <= 500; i = i + 50) {
			g.drawLine(0, i, 500, i);

		}

		for (int i = 0; i <= 500; i = i + 50) {
			g.drawLine(i, 0, i, 500);

		}
	}

	public boolean shipissetable(Ship ship, Position[][] position, int x, int y, int shipisdown) {
		int count1 = 0;
		if (ship.shipisdown == 1) {

			for (int count = 0; count != ship.shipsize(); count++) {
				count1 += position[(x - x % 50) / 50][(y - y % 50) / 50 + count].shipissetable();
			}
		} else if (ship.shipisdown == 0) {
			for (int count = 0; count != ship.shipsize(); count++) {
				count1 += position[(x - x % 50) / 50 + count][(y - y % 50) / 50].shipissetable();
			}
		}
		if (count1 == ship.shipsize()) {
			return true;
		} else {
			return false;
		}
	}


}