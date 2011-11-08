package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import classes.GameEngine;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	JLabel timeLabel;
	JLabel yearLabel;
	JLabel monthLabel;
	JLabel dayLabel;
	JLabel rationsAmt;
	JLabel rationsPerDay;
	JLabel pacePerDay;
	
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		setLayout(null);
		this.setVisible(true);
		setBounds(0, 0, 720, 480);
		
		JButton moveButton = new JButton("");
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameEngine.move();
				dayLabel.setText(Integer.toString(GameEngine.getDay()));
			}
		});
		
		timeLabel = new JLabel("10:00");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.GREEN);
		timeLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		timeLabel.setBounds(664, 12, 45, 16);
		add(timeLabel);
		
		yearLabel = new JLabel("2021");
		yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yearLabel.setForeground(Color.GREEN);
		yearLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		yearLabel.setBounds(618, 12, 39, 16);
		add(yearLabel);
		
		monthLabel = new JLabel("JAN");
		monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		monthLabel.setForeground(Color.GREEN);
		monthLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		monthLabel.setBounds(576, 12, 31, 16);
		add(monthLabel);
		
		dayLabel = new JLabel("1");
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLabel.setForeground(Color.GREEN);
		dayLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		dayLabel.setBounds(545, 12, 25, 16);
		add(dayLabel);
		moveButton.setBorderPainted(false);
		moveButton.setBounds(568, 60, 20, 20);
		add(moveButton);
		
		JButton rationsButton = new JButton("");
		rationsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rationsButton.setBorderPainted(false);
		rationsButton.setBounds(568, 114, 20, 20);
		add(rationsButton);
		
		JButton paceButton = new JButton("");
		paceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		paceButton.setBorderPainted(false);
		paceButton.setBounds(568, 142, 20, 20);
		add(paceButton);
		
		JButton menuButton = new JButton("");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuButton.setBorderPainted(false);
		menuButton.setBounds(568, 170, 20, 20);
		add(menuButton);
		
		JLabel lblCurrentRations = new JLabel("Current Rations:");
		lblCurrentRations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentRations.setFont(new Font("American Typewriter", Font.BOLD, 13));
		lblCurrentRations.setForeground(Color.GREEN);
		lblCurrentRations.setBounds(568, 293, 117, 16);
		add(lblCurrentRations);
		
		JLabel label = new JLabel("Rations per Day:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label.setBounds(568, 349, 117, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Pace per Day:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_1.setBounds(568, 405, 117, 16);
		add(label_1);
		
		rationsAmt = new JLabel("0");
		rationsAmt.setHorizontalAlignment(SwingConstants.CENTER);
		rationsAmt.setForeground(Color.GREEN);
		rationsAmt.setFont(new Font("American Typewriter", Font.BOLD, 13));
		rationsAmt.setBounds(568, 321, 117, 16);
		add(rationsAmt);
		
		rationsPerDay = new JLabel("0");
		rationsPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		rationsPerDay.setForeground(Color.GREEN);
		rationsPerDay.setFont(new Font("American Typewriter", Font.BOLD, 13));
		rationsPerDay.setBounds(568, 377, 117, 16);
		add(rationsPerDay);
		
		pacePerDay = new JLabel("0");
		pacePerDay.setHorizontalAlignment(SwingConstants.CENTER);
		pacePerDay.setForeground(Color.GREEN);
		pacePerDay.setFont(new Font("American Typewriter", Font.BOLD, 13));
		pacePerDay.setBounds(568, 433, 117, 16);
		add(pacePerDay);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainPanel.class.getResource("/gui/resources/Map Display.jpg")));
		background.setBounds(0, 0, 720, 480);
		add(background);
	}
	
	
	
}
