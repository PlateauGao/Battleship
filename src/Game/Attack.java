package Game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Attack extends JPanel {
	int ruinnumber=0;
	
	MouseListener attackmouse;
	String name;
	public Attack(Position[][] position,Window window,String s) {
		name=s;
		setOpaque(false);
		setLayout(null);
		
		attackmouse=new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (position[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50].shipissetable() == 1
						&& position[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50].attacked() == 0) {

					add(new Empty(e.getX() - e.getX() % 50, e.getY() - e.getY() % 50));
																						
					repaint(); 
					if(window.side==0){
						
					window.num2++;
					}
					else if(window.side==1){
						
						window.num1++;
						
						}window.textarea3.setText("Attack times: "+Integer.toString(window.num1));
					window.textarea4.setText("Attack times: "+Integer.toString(window.num2));
						window.textarea3.repaint();
						window.textarea4.repaint();
				
					window.changeside();
					
					window.side=(window.side+1)%2;
				} else if (position[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50]
						.shipissetable() == 0
						&& position[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50].attacked() == 0) {
					add(new Ruin(e.getX() - e.getX() % 50, e.getY() - e.getY() % 50));
				
					
					
					
					repaint();
					if(window.side==0){
						
						window.num2++;
						}
						else if(window.side==1){
							
							window.num1++;
							
							}
					window.textarea3.setText("Attack times: "+Integer.toString(window.num1));
					window.textarea4.setText("Attack times: "+Integer.toString(window.num2));
						window.textarea3.repaint();
						window.textarea4.repaint();
					position[(e.getX() - e.getX() % 50) / 50][(e.getY() - e.getY() % 50) / 50].beattacked();
					ruinnumber++;
					
					if(ruinnumber==17){
						window.win(name);
					}
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		addMouseListener(attackmouse);
	}
	public String getname(){
		return name;
	}
	
}