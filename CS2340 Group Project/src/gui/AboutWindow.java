package gui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AboutWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutWindow window = new AboutWindow();
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
	public AboutWindow() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Jay Zuerndorfer");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(128, 141, 194, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Christopher Whittemore");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(128, 86, 194, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Mitch Leif");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(128, 58, 194, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Thomas Bellitire");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(128, 30, 194, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Jeffrey Zhang");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(128, 114, 194, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Team C.A.K.E");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		label_4.setBackground(Color.DARK_GRAY);
		label_4.setBounds(128, 185, 194, 35);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("CS 2340");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.GREEN);
		label_5.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		label_5.setBackground(Color.DARK_GRAY);
		label_5.setBounds(128, 222, 194, 16);
		frame.getContentPane().add(label_5);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(AboutWindow.class.getResource("/gui/resources/aboutbackground.jpg")));
		background.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(background);
	}
}
