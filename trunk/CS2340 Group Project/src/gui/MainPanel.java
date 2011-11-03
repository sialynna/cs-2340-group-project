package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(null);
		
		JLabel background = new JLabel("background");
		background.setBounds(0, 0, 720, 480);
		add(background);
		

	}
}
