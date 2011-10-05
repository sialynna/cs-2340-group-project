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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StartPage {

	private JFrame frmApocalypseTrail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.frmApocalypseTrail.setVisible(true);
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
		frmApocalypseTrail = new JFrame();
		frmApocalypseTrail.setTitle("Apocalypse Trail");
		frmApocalypseTrail.setResizable(false);
		frmApocalypseTrail.setBounds(100, 100, 450, 300);
		frmApocalypseTrail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApocalypseTrail.getContentPane().setLayout(null);
		
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		newGame.setBounds(26, 25, 110, 50);
		frmApocalypseTrail.getContentPane().add(newGame);
		
		JButton btnNewButton = new JButton("About...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(26, 175, 110, 50);
		frmApocalypseTrail.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Exit Game");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(26, 100, 110, 50);
		frmApocalypseTrail.getContentPane().add(button);
		
		JLabel background = new JLabel("background");
		background.setIcon(new ImageIcon(StartPage.class.getResource("/gui/resources/startscreen.jpg")));
		background.setBounds(0, 0, 450, 278);
		frmApocalypseTrail.getContentPane().add(background);
	}
}
