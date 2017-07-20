package Game;

import javax.swing.JOptionPane;

public class Win extends JOptionPane {
	public Win(int x) {
		Object[] options = { "Play Again!", "Exist" };
		int i = JOptionPane.showOptionDialog(null, "Player " + x + " Win! Continue?", "GAME OVER",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (i == 0) {

			new Window();

		} else {
			System.exit(0);
		}
	}
}
