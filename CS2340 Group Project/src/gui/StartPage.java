package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class StartPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton exitGame = new JButton("Exit Game");
		exitGame.setBounds(26, 109, 110, 53);
		exitGame.setAlignmentY(Component.TOP_ALIGNMENT);
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().setLayout(null);
		
		JButton newGame = new JButton("New Game");
		newGame.setBounds(26, 37, 110, 53);
		frame.getContentPane().add(newGame);
		frame.getContentPane().add(exitGame);
		
		JButton btnNewButton = new JButton("About...");
		btnNewButton.setBounds(26, 183, 110, 53);
		frame.getContentPane().add(btnNewButton);
	}
}
