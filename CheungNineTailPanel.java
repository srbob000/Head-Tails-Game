import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * 
 * Class for Cheung_28_12
 *
 */
class CheungNineTailPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int matrixSize = 3;
	private int coinSize = 50;
	private char[] initialNode = new char[matrixSize * matrixSize]; //matrix size
	private char[] previous = new char[matrixSize * matrixSize];

	public CheungNineTailPanel() {
		for (int i = 0; i < initialNode.length; i++) {
			initialNode[i] = 'H'; //all nodes start H
		}
		previous = null;
		addMouseListener(new MouseAdapter() { //mouse listener

			@Override
			public void mouseReleased(MouseEvent e) {
				changeState((e.getX() / coinSize) * matrixSize + (e.getY() / coinSize));
			}
		});
	}

	public CheungNineTailPanel(char[] initialNode, char[] previous) {
		for (int i = 0; i < initialNode.length; i++) {
			this.initialNode[i] = initialNode[i];
			this.previous[i] = previous[i];
		}
	}

	public char[] getInitialNode() {
		return initialNode;
	}

	void changeState(int i) {
		if (initialNode[i] == 'H') { //changes nodes
			initialNode[i] = 'T';
		} else {
			initialNode[i] = 'H';
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) { //color, size of nodes
		super.paintComponent(g);
		g.setFont(new Font("Monospaced", Font.BOLD, 26));
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				g.drawRect(i * coinSize, j * coinSize, coinSize, coinSize);
				if ((previous != null) && (initialNode[i * matrixSize + j] != previous[i * matrixSize + j])) {
					g.setColor(Color.RED);
					g.drawString(initialNode[i * matrixSize + j] + "", i * coinSize + coinSize / 3,
							j * coinSize + 2 * (coinSize / 3));
					g.setColor(Color.BLACK);
				} else {
					g.drawString(initialNode[i * matrixSize + j] + "", i * coinSize + coinSize / 3,
							j * coinSize + 2 * (coinSize / 3));
				}
			}
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(matrixSize * coinSize + 1, matrixSize * coinSize + 1);
	}

}
