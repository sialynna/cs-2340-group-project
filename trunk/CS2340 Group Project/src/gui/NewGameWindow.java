package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NewGameWindow {

	private JFrame frame;
	private JTextField leaderName;
	private JTextField member1;
	private JTextField member2;
	private JTextField member3;
	private JTextField member4;
	
	JLabel lblMember_1;
	JLabel lblMember_2;
	JLabel lblMember_3;
	JLabel lblMember_4;
	private JLabel startscreen;
	private JButton btnStartGame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGameWindow window = new NewGameWindow();
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
	public NewGameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStartGame = new JButton("Start Game!");
		btnStartGame.setBounds(306, 187, 117, 67);
		frame.getContentPane().add(btnStartGame);
		
		JLabel lblNewLabel = new JLabel("Player Name:");
		lblNewLabel.setBounds(6, 19, 115, 22);
		frame.getContentPane().add(lblNewLabel);
		
		leaderName = new JTextField();
		leaderName.setBounds(103, 16, 178, 28);
		frame.getContentPane().add(leaderName);
		leaderName.setColumns(10);
		
		Choice partySizeChoice = new Choice();
		partySizeChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String choice = (String)arg0.getItem();
				if (choice == "1"){
					member2.setVisible(false);
					lblMember_2.setVisible(false);
					member3.setVisible(false);
					lblMember_3.setVisible(false);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
				}
				else if(choice == "2"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					member3.setVisible(false);
					lblMember_3.setVisible(false);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
				}
				else if (choice == "3"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					member3.setVisible(true);
					lblMember_3.setVisible(true);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
				}
				else if (choice == "4"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					member3.setVisible(true);
					lblMember_3.setVisible(true);
					member4.setVisible(true);
					lblMember_4.setVisible(true);
				}
			}
		});
		partySizeChoice.setForeground(Color.LIGHT_GRAY);
		partySizeChoice.setBackground(Color.DARK_GRAY);
		partySizeChoice.setBounds(238, 56, 43, 26);
		partySizeChoice.add("1");
		partySizeChoice.add("2");
		partySizeChoice.add("3");
		partySizeChoice.add("4");
		frame.getContentPane().add(partySizeChoice);
		
		JLabel lblHowManyOther = new JLabel("How many other wagon members?");
		lblHowManyOther.setBounds(6, 56, 367, 26);
		frame.getContentPane().add(lblHowManyOther);
		
		member1 = new JTextField();
		member1.setColumns(10);
		member1.setBounds(103, 104, 178, 30);
		frame.getContentPane().add(member1);
		
		member2 = new JTextField();
		member2.setVisible(false);
		member2.setColumns(10);
		member2.setBounds(103, 143, 178, 30);
		frame.getContentPane().add(member2);
		
		member3 = new JTextField();
		member3.setVisible(false);
		member3.setColumns(10);
		member3.setBounds(103, 185, 178, 30);
		frame.getContentPane().add(member3);
		
		member4 = new JTextField();
		member4.setVisible(false);
		member4.setColumns(10);
		member4.setBounds(103, 224, 178, 30);
		frame.getContentPane().add(member4);
		
		lblMember_1 = new JLabel("Member 1:");
		lblMember_1.setBounds(6, 104, 115, 30);
		frame.getContentPane().add(lblMember_1);
		
		lblMember_2 = new JLabel("Member 2:");
		lblMember_2.setVisible(false);
		lblMember_2.setBounds(6, 143, 115, 30);
		frame.getContentPane().add(lblMember_2);
		
		lblMember_3 = new JLabel("Member 3:");
		lblMember_3.setVisible(false);
		lblMember_3.setBounds(6, 185, 115, 30);
		frame.getContentPane().add(lblMember_3);
		
		lblMember_4 = new JLabel("Member 4:");
		lblMember_4.setVisible(false);
		lblMember_4.setBounds(6, 224, 115, 30);
		frame.getContentPane().add(lblMember_4);
		
		Choice initialPaceChoice = new Choice();
		initialPaceChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		initialPaceChoice.setForeground(Color.LIGHT_GRAY);
		initialPaceChoice.setBackground(Color.DARK_GRAY);
		initialPaceChoice.setBounds(308, 56, 115, 26);
		initialPaceChoice.add("Stopped");
		initialPaceChoice.add("Easy");
		initialPaceChoice.add("Normal");
		initialPaceChoice.add("Grueling");
		frame.getContentPane().add(initialPaceChoice);
		
		Choice initialRationsChoice = new Choice();
		initialRationsChoice.setForeground(Color.LIGHT_GRAY);
		initialRationsChoice.setBackground(Color.DARK_GRAY);
		initialRationsChoice.setBounds(308, 136, 115, 26);
		initialRationsChoice.add("Filling");
		initialRationsChoice.add("Normal");
		initialRationsChoice.add("Meager");
		initialRationsChoice.add("Starvation");
		frame.getContentPane().add(initialRationsChoice);
		
		JLabel lblInitialPace = new JLabel("Initial Pace:");
		lblInitialPace.setBounds(308, 22, 88, 16);
		frame.getContentPane().add(lblInitialPace);
		
		JLabel lblInitialRations = new JLabel("Initial Rations:");
		lblInitialRations.setBounds(308, 104, 98, 16);
		frame.getContentPane().add(lblInitialRations);
		
		startscreen = new JLabel("startscreen");
		startscreen.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/newgame.jpg")));
		startscreen.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(startscreen);
	}
}
