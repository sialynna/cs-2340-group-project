package classes;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WinPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WinPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 720, 480);
		add(lblNewLabel);

	}
}
