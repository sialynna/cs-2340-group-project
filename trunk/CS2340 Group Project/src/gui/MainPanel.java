package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(null);
		
		JButton moveButton = new JButton("");
		moveButton.setBorderPainted(false);
		moveButton.setBounds(568, 60, 20, 20);
		add(moveButton);
		
		JButton rationsButton = new JButton("");
		rationsButton.setBorderPainted(false);
		rationsButton.setBounds(568, 114, 20, 20);
		add(rationsButton);
		
		JButton paceButton = new JButton("");
		paceButton.setBorderPainted(false);
		paceButton.setBounds(568, 142, 20, 20);
		add(paceButton);
		
		JButton menuButton = new JButton("");
		menuButton.setBorderPainted(false);
		menuButton.setBounds(568, 170, 20, 20);
		add(menuButton);
		
		JLabel background = new JLabel("background");
		background.setIcon(new ImageIcon(MainPanel.class.getResource("/gui/resources/Map Display.jpg")));
		background.setBounds(0, 0, 720, 480);
		add(background);
		

	}
}
