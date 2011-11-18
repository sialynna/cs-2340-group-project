package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import classes.GameEngine;
import classes.Item;
import classes.Leader;
import classes.Member;
import classes.Supplies;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Component;
import java.io.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements Serializable{

	JLabel timeLabel;
	JLabel yearLabel;
	JLabel monthLabel;
	JLabel dayLabel;
	JLabel rationsAmt;
	JLabel rationsPerDay;
	JLabel pacePerDay;
	JLabel distTravelAmt;
	JPanel main;
	JPanel mapProgress;
	
	Point2D start = new Point2D.Double(521, 342);
	Point2D firstLoc = new Point2D.Double(436, 306);
	Point2D secondLoc = new Point2D.Double(334, 273);
	Point2D firstRiv = new Point2D.Double(295, 279);
	Point2D fourthLoc = new Point2D.Double(236, 292);
	Point2D fifthLoc = new Point2D.Double(208, 246);
	Point2D secondRiv = new Point2D.Double(175, 237);
	Point2D seventhLoc = new Point2D.Double(139, 227);
	Point2D eigthLoc = new Point2D.Double(123, 160);
	Point2D ninthLoc = new Point2D.Double(59, 155);
	Point2D goal = new Point2D.Double(41, 145);
	
	private double percent;
	private double startX;
	private double startY;
	private double nextX;
	private double nextY;
	private int whichLine;
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		setLayout(null);
		setBounds(0, 0, 720, 480);
		
		main = this;
		
		JButton moveButton = new JButton("");
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameEngine.move();
				whichLine = GameEngine.getLocationAt();
				percent = (GameEngine.getLocation()-GameEngine.getNextLocation(0)) / (GameEngine.getNextLocation(1)-GameEngine.getNextLocation(0));
				updateScreen();
			}
		});
		
		mapProgress = new MapProgress();
		add(mapProgress);
		
		JLabel distTraveled = new JLabel("Distance Travelled:");
		distTraveled.setHorizontalAlignment(SwingConstants.CENTER);
		distTraveled.setForeground(Color.GREEN);
		distTraveled.setFont(new Font("American Typewriter", Font.BOLD, 12));
		distTraveled.setBounds(556, 271, 141, 16);
		add(distTraveled);
		
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
		monthLabel.setFont(new Font("American Typewriter", Font.BOLD, 11));
		monthLabel.setBounds(576, 13, 31, 16);
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
				String[] choices = {"Filling", "Normal", "Meager", "Starvation"};
				String rationInput = (String) JOptionPane.showInputDialog(main, "Choose Rations", "Rations:", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				if ((rationInput != null) && (rationInput.length() > 0)){
				GameEngine.setRations(rationInput);
				updateScreen();
				}
			}
		});
		rationsButton.setBorderPainted(false);
		rationsButton.setBounds(568, 114, 20, 20);
		add(rationsButton);
		
		JButton paceButton = new JButton("");
		paceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] choices = {"Stopped", "Easy", "Normal", "Grueling"};
				String paceInput = (String) JOptionPane.showInputDialog(main, "Choose Pace", "Pace:", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				if ((paceInput != null) && (paceInput.length() > 0)){
				GameEngine.setPace(paceInput);
				updateScreen();
				}
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

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filename1 = "engine.ser";
				String filename2 = "supplies.ser";
				//String filename3 = "wagon.ser";
				String filename4 = "rations.ser";
				String filename5 = "pace.ser";
				String filename6 = "leader.ser";
				String filename7 = "location.ser";
				String filename8 = "map.ser";
				//String filename9 = "store.ser";
				String filename10 = "mainframe.ser";
				String filename11 = "mainpanel.ser";
				String filename12 = "member1.ser";
				String filename13 = "member2.ser";
				String filename14 = "member3.ser";
				String filename15 = "member4.ser";
				//String filename16 = "items.ser";

				ObjectOutputStream out1 = null;
				ObjectOutputStream out2 = null;
				//ObjectOutputStream out3 = null;
				ObjectOutputStream out4 = null;
				ObjectOutputStream out5 = null;
				ObjectOutputStream out6 = null;
				ObjectOutputStream out7 = null;
				ObjectOutputStream out8 = null;
				//ObjectOutputStream out9 = null;
				ObjectOutputStream out10 = null;
				ObjectOutputStream out11 = null;
				ObjectOutputStream out12 = null;
				ObjectOutputStream out13 = null;
				ObjectOutputStream out14 = null;
				ObjectOutputStream out15 = null;
				//ObjectOutputStream out16 = null;
				
				
				GameEngine persistEngine = GameEngine.engine;
				
				

			
				try
				{
					out1 = new ObjectOutputStream(new FileOutputStream(filename1));
					out2 = new ObjectOutputStream(new FileOutputStream(filename2));
					//out3 = new ObjectOutputStream(new FileOutputStream(filename3));
					out4 = new ObjectOutputStream(new FileOutputStream(filename4));
					out5 = new ObjectOutputStream(new FileOutputStream(filename5));
					out6 = new ObjectOutputStream(new FileOutputStream(filename6));
					out7 = new ObjectOutputStream(new FileOutputStream(filename7));
					out8 = new ObjectOutputStream(new FileOutputStream(filename8));
					//out9 = new ObjectOutputStream(new FileOutputStream(filename9));
					out10 = new ObjectOutputStream(new FileOutputStream(filename10));
					out11 = new ObjectOutputStream(new FileOutputStream(filename11));
					out12 = new ObjectOutputStream(new FileOutputStream(filename12));
					out13 = new ObjectOutputStream(new FileOutputStream(filename13));
					out14 = new ObjectOutputStream(new FileOutputStream(filename14));
					out15 = new ObjectOutputStream(new FileOutputStream(filename15));
					//out16 = new ObjectOutputStream(new FileOutputStream(filename16));
					
					
					out1.writeObject(persistEngine);
					out2.writeObject(GameEngine.getSupplies());
					//out3.writeObject(persistEngine.getWagon());
					out4.writeObject(persistEngine.getRationsClass());
					out5.writeObject(persistEngine.getPaceClass());
					out6.writeObject(persistEngine.getLeader());
					out7.writeObject(persistEngine.getLocationClass());
					out8.writeObject(persistEngine.getMap());
					//out9.writeObject(persistEngine.getStore());
					out10.writeObject(persistEngine.getFrame());
					out11.writeObject(persistEngine.getPanel());
					out12.writeObject(GameEngine.getMembers()[0]);
					if(GameEngine.getMembers().length ==2)
						out13.writeObject(GameEngine.getMembers()[1]);
					if(GameEngine.getMembers().length ==3 ){
						out13.writeObject(GameEngine.getMembers()[1]);
						out14.writeObject(GameEngine.getMembers()[2]);}
					if(GameEngine.getMembers().length ==4 ){
						out13.writeObject(GameEngine.getMembers()[1]);
						out14.writeObject(GameEngine.getMembers()[2]);
						out15.writeObject(GameEngine.getMembers()[3]);}
					//out16.writeObject(Item.RATIONS);
					
					out1.close();
					out2.close();
					//out3.close();
					out4.close();
					out5.close();
					out6.close();
					out7.close();
					out8.close();
					//out9.close();
					out10.close();
					out11.close();
					out12.close();			
					out13.close();	
					out14.close();	
					out15.close();
					//out16.close();
					
					
					System.out.println("Saved...");
				}

				catch(IOException ex)
				{
					ex.printStackTrace();
					System.out.println("ERROR saving");
				}

			}


		});
		saveButton.setBorderPainted(false);
		saveButton.setBounds(596, 196, 94, 20);
		add(saveButton);

		JLabel lblCurrentRations = new JLabel("Current Rations:");
		lblCurrentRations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentRations.setFont(new Font("American Typewriter", Font.BOLD, 12));
		lblCurrentRations.setForeground(Color.GREEN);
		lblCurrentRations.setBounds(568, 312, 117, 16);
		add(lblCurrentRations);
		
		JLabel label = new JLabel("Rations per Day:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label.setBounds(568, 360, 117, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Pace per Day:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_1.setBounds(568, 413, 117, 16);
		add(label_1);
		
		rationsAmt = new JLabel(Integer.toString(Item.RATIONS.getNum()));
		rationsAmt.setHorizontalAlignment(SwingConstants.CENTER);
		rationsAmt.setForeground(Color.GREEN);
		rationsAmt.setFont(new Font("American Typewriter", Font.BOLD, 12));
		rationsAmt.setBounds(568, 334, 117, 16);
		add(rationsAmt);
		
		rationsPerDay = new JLabel(GameEngine.getRations());
		rationsPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		rationsPerDay.setForeground(Color.GREEN);
		rationsPerDay.setFont(new Font("American Typewriter", Font.BOLD, 12));
		rationsPerDay.setBounds(568, 385, 117, 16);
		add(rationsPerDay);
		
		pacePerDay = new JLabel(GameEngine.getPace());
		pacePerDay.setHorizontalAlignment(SwingConstants.CENTER);
		pacePerDay.setForeground(Color.GREEN);
		pacePerDay.setFont(new Font("American Typewriter", Font.BOLD, 12));
		pacePerDay.setBounds(568, 436, 117, 16);
		add(pacePerDay);
		
		distTravelAmt = new JLabel("0");
		distTravelAmt.setHorizontalAlignment(SwingConstants.CENTER);
		distTravelAmt.setForeground(Color.GREEN);
		distTravelAmt.setFont(new Font("American Typewriter", Font.BOLD, 12));
		distTravelAmt.setBounds(568, 291, 117, 16);
		add(distTravelAmt);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainPanel.class.getResource("/gui/resources/Map Display.jpg")));
		background.setBounds(0, 0, 720, 480);
		add(background);
	}
	
	private void updateScreen()
	{	
		pacePerDay.setText(GameEngine.getPace());
		rationsPerDay.setText(GameEngine.getRations());
		rationsAmt.setText(Integer.toString(Item.RATIONS.getNum()));
		distTravelAmt.setText(Double.toString(GameEngine.getLocation()));
		dayLabel.setText(Integer.toString(GameEngine.getDay()));
		monthLabel.setText(GameEngine.getMonth());
		mapProgress.repaint();
	}
	
	protected class MapProgress extends JPanel{
		
		protected MapProgress(){
			this.setOpaque(false);
			this.setBounds(0, 0, 720, 480);
		}
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			
			switch (whichLine){
			case(0):
				startX = start.getX();
				startY = start.getY();
				nextX = start.getX() - ((start.getX() - firstLoc.getX())*percent);
				nextY = start.getY() - ((start.getY() - firstLoc.getY())*percent);
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(1):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				startX = firstLoc.getX();
				startY = firstLoc.getY();
				nextX = firstLoc.getX() - ((firstLoc.getX() - secondLoc.getX())*percent);
				nextY = firstLoc.getY() - ((firstLoc.getY() - secondLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(2):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				startX = secondLoc.getX();
				startY = secondLoc.getY();
				nextX = secondLoc.getX() - ((secondLoc.getX() - firstRiv.getX())*percent);
				nextY = secondLoc.getY() - ((secondLoc.getY() - firstRiv.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(3):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				startX = firstRiv.getX();
				startY = firstRiv.getY();
				nextX = firstRiv.getX() - ((firstRiv.getX() - fourthLoc.getX())*percent);
				nextY = firstRiv.getY() - ((firstRiv.getY() - fourthLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(4):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				startX = fourthLoc.getX();
				startY = fourthLoc.getY();
				nextX = fourthLoc.getX() - ((fourthLoc.getX() - fifthLoc.getX())*percent);
				nextY = fourthLoc.getY() - ((fourthLoc.getY() - fifthLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(5):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				g2.draw(new Line2D.Double(fourthLoc.getX(), fourthLoc.getY(), fifthLoc.getX(), fifthLoc.getY()));
				startX = fifthLoc.getX();
				startY = fifthLoc.getY();
				nextX = fifthLoc.getX() - ((fifthLoc.getX() - secondRiv.getX())*percent);
				nextY = fifthLoc.getY() - ((fifthLoc.getY() - secondRiv.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(6):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				g2.draw(new Line2D.Double(fourthLoc.getX(), fourthLoc.getY(), fifthLoc.getX(), fifthLoc.getY()));
				g2.draw(new Line2D.Double(fifthLoc.getX(), fifthLoc.getY(), secondRiv.getX(), secondRiv.getY()));
				startX = secondRiv.getX();
				startY = secondRiv.getY();
				nextX = secondRiv.getX() - ((secondRiv.getX() - seventhLoc.getX())*percent);
				nextY = secondRiv.getY() - ((secondRiv.getY() - seventhLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(7):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				g2.draw(new Line2D.Double(fourthLoc.getX(), fourthLoc.getY(), fifthLoc.getX(), fifthLoc.getY()));
				g2.draw(new Line2D.Double(fifthLoc.getX(), fifthLoc.getY(), secondRiv.getX(), secondRiv.getY()));
				g2.draw(new Line2D.Double(secondRiv.getX(), secondRiv.getY(), seventhLoc.getX(), seventhLoc.getY()));
				startX = seventhLoc.getX();
				startY = seventhLoc.getY();
				nextX = seventhLoc.getX() - ((seventhLoc.getX() - eigthLoc.getX())*percent);
				nextY = seventhLoc.getY() - ((seventhLoc.getY() - eigthLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(8):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				g2.draw(new Line2D.Double(fourthLoc.getX(), fourthLoc.getY(), fifthLoc.getX(), fifthLoc.getY()));
				g2.draw(new Line2D.Double(fifthLoc.getX(), fifthLoc.getY(), secondRiv.getX(), secondRiv.getY()));
				g2.draw(new Line2D.Double(secondRiv.getX(), secondRiv.getY(), seventhLoc.getX(), seventhLoc.getY()));
				g2.draw(new Line2D.Double(seventhLoc.getX(), seventhLoc.getY(), eigthLoc.getX(), eigthLoc.getY()));
				startX = eigthLoc.getX();
				startY = eigthLoc.getY();
				nextX = eigthLoc.getX() - ((eigthLoc.getX() - ninthLoc.getX())*percent);
				nextY = eigthLoc.getY() - ((eigthLoc.getY() - ninthLoc.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			case(9):
				g2.setColor(Color.GREEN);
				g2.setStroke(new BasicStroke(3));
				g2.draw(new Line2D.Double(start.getX(), start.getY(), firstLoc.getX(), firstLoc.getY()));
				g2.draw(new Line2D.Double(firstLoc.getX(), firstLoc.getY(), secondLoc.getX(), secondLoc.getY()));
				g2.draw(new Line2D.Double(secondLoc.getX(), secondLoc.getY(), firstRiv.getX(), firstRiv.getY()));
				g2.draw(new Line2D.Double(firstRiv.getX(), firstRiv.getY(), fourthLoc.getX(), fourthLoc.getY()));
				g2.draw(new Line2D.Double(fourthLoc.getX(), fourthLoc.getY(), fifthLoc.getX(), fifthLoc.getY()));
				g2.draw(new Line2D.Double(fifthLoc.getX(), fifthLoc.getY(), secondRiv.getX(), secondRiv.getY()));
				g2.draw(new Line2D.Double(secondRiv.getX(), secondRiv.getY(), seventhLoc.getX(), seventhLoc.getY()));
				g2.draw(new Line2D.Double(seventhLoc.getX(), seventhLoc.getY(), eigthLoc.getX(), eigthLoc.getY()));
				g2.draw(new Line2D.Double(eigthLoc.getX(), eigthLoc.getY(), ninthLoc.getX(), ninthLoc.getY()));
				startX = ninthLoc.getX();
				startY = ninthLoc.getY();
				nextX = ninthLoc.getX() - ((ninthLoc.getX() - goal.getX())*percent);
				nextY = ninthLoc.getY() - ((ninthLoc.getY() - goal.getY())*percent);
				g2.draw(new Line2D.Double(startX, startY, nextX, nextY));
				break;
			}
		}
	}
}
