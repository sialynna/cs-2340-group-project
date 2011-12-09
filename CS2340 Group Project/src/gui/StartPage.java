package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import classes.GameEngine;
import classes.Item;
import classes.Leader;
import classes.Load;
import classes.Location;
import classes.Map;
import classes.Member;
import classes.Pace;
import classes.Rations;
import classes.Store;
import classes.Supplies;
import classes.Wagon;

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
				NewGameWindow newgamewindow = new NewGameWindow();
				frmApocalypseTrail.dispose();
			}
		});
		newGame.setBounds(26, 25, 110, 50);
		frmApocalypseTrail.getContentPane().add(newGame);
		
		JButton btnNewButton = new JButton("About...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutWindow about = new AboutWindow();
			}
		});
		btnNewButton.setBounds(300, 175, 110, 50);
		frmApocalypseTrail.getContentPane().add(btnNewButton);
		
		JButton loadButton = new JButton("Load Game");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Load.load();
//				String filename1 = "engine.ser";
//				String filename2 = "supplies.ser";
//				//String filename3 = "wagon.ser";
//				String filename4 = "rations.ser";
//				String filename5 = "pace.ser";
//				String filename6 = "leader.ser";
//				String filename7 = "location.ser";
//				String filename8 = "map.ser";
//				//String filename9 = "store.ser";
//				String filename10 = "mainframe.ser";
//				String filename11 = "mainpanel.ser";
//				String filename12 = "member1.ser";
//				String filename13 = "member2.ser";
//				String filename14 = "member3.ser";
//				String filename15 = "member4.ser";
//				//String filename16 = "items.ser";
//				
//				
//				ObjectInputStream in1 = null;
//				ObjectInputStream in2 = null;
//				//ObjectInputStream in3 = null;
//				ObjectInputStream in4 = null;
//				ObjectInputStream in5 = null;
//				ObjectInputStream in6 = null;
//				ObjectInputStream in7 = null;
//				ObjectInputStream in8 = null;
//				//ObjectInputStream in9 = null;
//				ObjectInputStream in10 = null;
//				ObjectInputStream in11 = null;
//				ObjectInputStream in12 = null;
//				ObjectInputStream in13 = null;
//				ObjectInputStream in14 = null;
//				ObjectInputStream in15 = null;
//				//ObjectInputStream in16 = null;
//				try
//				{
//					in1 = new ObjectInputStream(new FileInputStream(filename1));
//					in2 = new ObjectInputStream(new FileInputStream(filename2)); 
//					//in3 = new ObjectInputStream(new FileInputStream(filename3));
//					in4 = new ObjectInputStream(new FileInputStream(filename4));
//					in5 = new ObjectInputStream(new FileInputStream(filename5));
//					in6 = new ObjectInputStream(new FileInputStream(filename6));
//					in7 = new ObjectInputStream(new FileInputStream(filename7));
//					in8 = new ObjectInputStream(new FileInputStream(filename8));
//					//in9 = new ObjectInputStream(new FileInputStream(filename9));
//					in10 = new ObjectInputStream(new FileInputStream(filename10));
//					in11 = new ObjectInputStream(new FileInputStream(filename11));
//					//in16 = new ObjectInputStream(new FileInputStream(filename16));
//					
//					
//					try {
//						GameEngine gEngine = (GameEngine)in1.readObject();
//						Supplies supply = (Supplies)in2.readObject();
//						//Wagon wagon = (Wagon)in3.readObject();
//						Rations rations = (Rations)in4.readObject();
//						Pace pace = (Pace)in5.readObject();
//						Leader leader = (Leader)in6.readObject();
//						Location location = (Location)in7.readObject();
//						Map map = (Map)in8.readObject();
//						//Store store = (Store)in9.readObject();
//						MainFrame frame = (MainFrame)in10.readObject();
//						MainPanel panel = (MainPanel)in11.readObject();
//						//Item amount = (Item)in16.readObject();
//						
//						try{
//							in12 = new ObjectInputStream(new FileInputStream(filename12));
//							in13 = new ObjectInputStream(new FileInputStream(filename13));
//							in14 = new ObjectInputStream(new FileInputStream(filename14));
//							in15 = new ObjectInputStream(new FileInputStream(filename15));
//								try{
//									Member member1 = (Member)in12.readObject();
//									Member member2 = (Member)in13.readObject();
//									Member member3 = (Member)in14.readObject();
//									Member member4 = (Member)in15.readObject();
//									Member[] members = gEngine.getMembers();
//									members[0] = member1;
//									if(members.length == 2)
//										members[1] = member2;
//									if(members.length == 3){
//										members[1] = member2;
//										members[2] = member3;}
//									if(members.length == 4){
//										members[1] = member2;
//										members[2] = member3;
//										members[3] = member4;}
//									gEngine.setMembers(members);
//								}
//								catch(IOException ex)
//								{
//									System.out.println("");
//								}
//						}
//						catch(IOException ex)
//						{
//							System.out.println("ERROR loading file");
//						}
//						
//						
//						
//						
//					    // set everything in game engine
//						gEngine.setSupplies(supply);
//						//gEngine.setWagon(wagon);
//						gEngine.setRations(rations);
//						gEngine.setPace(pace);
//						gEngine.setLeader(leader);
//						gEngine.setLocation(location);
//						gEngine.setMap(map);
//						gEngine.setFrame(frame);
//						gEngine.setPanel(panel);
//						//gEngine.setRationsAmt(amount.RATIONS.getNum());
//						
//						
//						
//						gEngine.setPanelMain();
//						//panel.updateScreen();
//						
//						in1.close();
//						in2.close();
//						//in3.close();
//						in4.close();
//						in5.close();
//						in6.close();
//						in7.close();
//						in8.close();
//						//in9.close();
//						in10.close();
//						in11.close();
//						//in12.close();
//						//in16.close();
//						
//						
//					} catch (ClassNotFoundException e) {
//						System.out.println("ERROR reading");
//					}
//					System.out.println("Found...");
//					
//				}
//				catch(IOException ex)
//				{
//					System.out.println("ERROR loading file");
//				}
			}
		});
		loadButton.setBounds(26, 100, 110, 50);
		frmApocalypseTrail.getContentPane().add(loadButton);
		
		JButton button = new JButton("Exit Game");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(26, 175, 110, 50);
		frmApocalypseTrail.getContentPane().add(button);
		
		JLabel background = new JLabel("background");
		background.setIcon(new ImageIcon(StartPage.class.getResource("/gui/resources/startscreen.jpg")));
		background.setBounds(0, 0, 450, 278);
		frmApocalypseTrail.getContentPane().add(background);
		frmApocalypseTrail.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{newGame, button, btnNewButton, frmApocalypseTrail.getContentPane(), background}));
	}
}
