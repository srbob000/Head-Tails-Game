import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Class for Cheung_28_12
 *
 */
public class CheungNineTail extends JApplet {
	private static final long serialVersionUID = 1L;
	private CheungNineTailPanel nineTailPanel = new CheungNineTailPanel();
	private JPanel jPanel1 = new JPanel(new FlowLayout());

	public CheungNineTail() {
		jPanel1.add(nineTailPanel);
		setLayout(new BorderLayout());
		add(jPanel1, BorderLayout.CENTER);
		JPanel jPanel2 = new JPanel(new FlowLayout());
		JButton jButton1 = new JButton("Solve"); // Creates panel along with buttons
		JButton jButton2 = new JButton("Start Over");
		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		add(jPanel2, BorderLayout.SOUTH); //buttons on the botton and action listener
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] initialNode = nineTailPanel.getInitialNode();

				CheungNineTailModel model = new CheungNineTailModel();
				java.util.List<Integer> path = model.getShortestPath(CheungNineTailModel.getIndex(initialNode));

				for (int i = 1; i < path.size(); i++) {
					jPanel1.add(new CheungNineTailPanel(CheungNineTailModel.getNode(path.get(i).intValue()),
							CheungNineTailModel.getNode(path.get(i - 1).intValue())));
				}
				jPanel1.updateUI(); 
			}
		});
		jButton2.addActionListener(new ActionListener() { //Action listener for button 2

			public void actionPerformed(ActionEvent e) {
				jPanel1.removeAll();
				nineTailPanel = new CheungNineTailPanel();
				jPanel1.add(nineTailPanel);
				jPanel1.updateUI();
			}
		});
	}
}
