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
		
		JButton exitGame = new JButton("Exit Game");
		exitGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitGame.setBounds(26, 109, 110, 53);
		exitGame.setAlignmentY(Component.TOP_ALIGNMENT);
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmApocalypseTrail.getContentPane().setLayout(null);
		
		JButton newGame = new JButton("New Game");
		newGame.setBounds(26, 37, 110, 53);
		frmApocalypseTrail.getContentPane().add(newGame);
		frmApocalypseTrail.getContentPane().add(exitGame);
		
		JButton btnNewButton = new JButton("About...");
		btnNewButton.setBounds(26, 183, 110, 53);
		frmApocalypseTrail.getContentPane().add(btnNewButton);
	}
}
