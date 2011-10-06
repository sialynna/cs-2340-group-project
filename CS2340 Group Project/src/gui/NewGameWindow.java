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
import java.awt.Font;

public class NewGameWindow {

	private JFrame frame;
	private JTextField leaderName;
	private JTextField member1;
	private JTextField member2;
	private JTextField member3;
	private JTextField member4;
	
	private JLabel lblMember_1;
	private JLabel lblMember_2;
	private JLabel lblMember_3;
	private JLabel lblMember_4;
	private JLabel startscreen;
	private JButton btnStartGame;
	private JLabel namelabelBackground;
	private JLabel paceBack;
	private JLabel rationsBack;
	private JLabel mem_1_back;
	private JLabel mem_2_back;
	private JLabel mem_3_back;
	private JLabel mem_4_back;
	
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
		this.frame.setVisible(true);
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
		lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(10, 16, 115, 30);
		frame.getContentPane().add(lblNewLabel);
		
		leaderName = new JTextField();
		leaderName.setBounds(118, 16, 178, 30);
		leaderName.setForeground(Color.LIGHT_GRAY);
		leaderName.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(leaderName);
		leaderName.setColumns(10);
		
		Choice partySizeChoice = new Choice();
		partySizeChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String choice = (String)arg0.getItem();
				if (choice == "1"){
					member2.setVisible(false);
					lblMember_2.setVisible(false);
					mem_2_back.setVisible(false);
					member3.setVisible(false);
					lblMember_3.setVisible(false);
					mem_3_back.setVisible(false);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
				}
				else if(choice == "2"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3.setVisible(false);
					lblMember_3.setVisible(false);
					mem_3_back.setVisible(false);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
				}
				else if (choice == "3"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3.setVisible(true);
					lblMember_3.setVisible(true);
					mem_3_back.setVisible(true);
					member4.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
				}
				else if (choice == "4"){
					member2.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3.setVisible(true);
					lblMember_3.setVisible(true);
					mem_3_back.setVisible(true);
					member4.setVisible(true);
					lblMember_4.setVisible(true);
					mem_4_back.setVisible(true);
				}
			}
		});
		partySizeChoice.setBounds(262, 56, 43, 26);
		partySizeChoice.add("1");
		partySizeChoice.add("2");
		partySizeChoice.add("3");
		partySizeChoice.add("4");
		partySizeChoice.setForeground(Color.LIGHT_GRAY);
		partySizeChoice.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(partySizeChoice);
		
		JLabel lblHowManyOther = new JLabel("How many other wagon members?");
		lblHowManyOther.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblHowManyOther.setForeground(Color.GREEN);
		lblHowManyOther.setBounds(6, 56, 250, 30);
		frame.getContentPane().add(lblHowManyOther);
		
		member1 = new JTextField();
		member1.setColumns(10);
		member1.setBounds(103, 104, 178, 30);
		member1.setForeground(Color.LIGHT_GRAY);
		member1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member1);
		
		member2 = new JTextField();
		member2.setVisible(false);
		member2.setColumns(10);
		member2.setBounds(103, 143, 178, 30);
		member2.setForeground(Color.LIGHT_GRAY);
		member2.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member2);
		
		member3 = new JTextField();
		member3.setVisible(false);
		member3.setColumns(10);
		member3.setBounds(103, 185, 178, 30);
		member3.setForeground(Color.LIGHT_GRAY);
		member3.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member3);
		
		member4 = new JTextField();
		member4.setVisible(false);
		member4.setColumns(10);
		member4.setBounds(103, 224, 178, 30);
		member4.setForeground(Color.LIGHT_GRAY);
		member4.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member4);
		
		lblMember_1 = new JLabel("Member 1:");
		lblMember_1.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblMember_1.setForeground(Color.GREEN);
		lblMember_1.setBounds(8, 104, 85, 30);
		frame.getContentPane().add(lblMember_1);
		
		lblMember_2 = new JLabel("Member 2:");
		lblMember_2.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblMember_2.setForeground(Color.GREEN);
		lblMember_2.setVisible(false);
		lblMember_2.setBounds(8, 143, 85, 30);
		frame.getContentPane().add(lblMember_2);
		
		lblMember_3 = new JLabel("Member 3:");
		lblMember_3.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblMember_3.setForeground(Color.GREEN);
		lblMember_3.setVisible(false);
		lblMember_3.setBounds(8, 185, 85, 30);
		frame.getContentPane().add(lblMember_3);
		
		lblMember_4 = new JLabel("Member 4:");
		lblMember_4.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblMember_4.setForeground(Color.GREEN);
		lblMember_4.setVisible(false);
		lblMember_4.setBounds(8, 224, 85, 30);
		frame.getContentPane().add(lblMember_4);
		
		Choice initialPaceChoice = new Choice();
		initialPaceChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		initialPaceChoice.setForeground(Color.LIGHT_GRAY);
		initialPaceChoice.setBackground(Color.DARK_GRAY);
		initialPaceChoice.setBounds(325, 56, 115, 26);
		initialPaceChoice.add("Stopped");
		initialPaceChoice.add("Easy");
		initialPaceChoice.add("Normal");
		initialPaceChoice.add("Grueling");
		frame.getContentPane().add(initialPaceChoice);
		
		Choice initialRationsChoice = new Choice();
		initialRationsChoice.setForeground(Color.LIGHT_GRAY);
		initialRationsChoice.setBackground(Color.DARK_GRAY);
		initialRationsChoice.setBounds(325, 136, 115, 26);
		initialRationsChoice.add("Filling");
		initialRationsChoice.add("Normal");
		initialRationsChoice.add("Meager");
		initialRationsChoice.add("Starvation");
		frame.getContentPane().add(initialRationsChoice);
		
		JLabel lblInitialPace = new JLabel("Initial Pace:");
		lblInitialPace.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblInitialPace.setForeground(Color.GREEN);
		lblInitialPace.setBounds(335, 23, 96, 30);
		frame.getContentPane().add(lblInitialPace);
		
		JLabel lblInitialRations = new JLabel("Initial Rations:");
		lblInitialRations.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblInitialRations.setForeground(Color.GREEN);
		lblInitialRations.setBounds(330, 104, 115, 30);
		frame.getContentPane().add(lblInitialRations);
		
		namelabelBackground = new JLabel("");
		namelabelBackground.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		namelabelBackground.setForeground(Color.GREEN);
		namelabelBackground.setFont(new Font("American Typewriter", Font.BOLD, 14));
		namelabelBackground.setBounds(2, 16, 115, 30);
		frame.getContentPane().add(namelabelBackground);
		
		JLabel memberselectBack = new JLabel("");
		memberselectBack.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/memberselectLabelBackground.jpg")));
		memberselectBack.setForeground(Color.GREEN);
		memberselectBack.setFont(new Font("American Typewriter", Font.BOLD, 14));
		memberselectBack.setBounds(4, 56, 250, 30);
		frame.getContentPane().add(memberselectBack);
		
		paceBack = new JLabel("");
		paceBack.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		paceBack.setForeground(Color.GREEN);
		paceBack.setFont(new Font("American Typewriter", Font.BOLD, 14));
		paceBack.setBounds(325, 23, 115, 30);
		frame.getContentPane().add(paceBack);
		
		rationsBack = new JLabel("");
		rationsBack.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		rationsBack.setForeground(Color.GREEN);
		rationsBack.setFont(new Font("American Typewriter", Font.BOLD, 14));
		rationsBack.setBounds(325, 104, 115, 30);
		frame.getContentPane().add(rationsBack);
		
		mem_1_back = new JLabel("");
		mem_1_back.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/memberLabelBackground.jpg")));
		mem_1_back.setForeground(Color.GREEN);
		mem_1_back.setFont(new Font("American Typewriter", Font.BOLD, 14));
		mem_1_back.setBounds(4, 104, 85, 30);
		frame.getContentPane().add(mem_1_back);
		
		mem_2_back = new JLabel("");
		mem_2_back.setVisible(false);
		mem_2_back.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/memberLabelBackground.jpg")));
		mem_2_back.setForeground(Color.GREEN);
		mem_2_back.setFont(new Font("American Typewriter", Font.BOLD, 14));
		mem_2_back.setBounds(4, 143, 85, 30);
		frame.getContentPane().add(mem_2_back);
		
		mem_3_back = new JLabel("");
		mem_3_back.setVisible(false);
		mem_3_back.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/memberLabelBackground.jpg")));
		mem_3_back.setForeground(Color.GREEN);
		mem_3_back.setFont(new Font("American Typewriter", Font.BOLD, 14));
		mem_3_back.setBounds(2, 185, 85, 30);
		frame.getContentPane().add(mem_3_back);
		
		mem_4_back = new JLabel("");
		mem_4_back.setVisible(false);
		mem_4_back.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/memberLabelBackground.jpg")));
		mem_4_back.setForeground(Color.GREEN);
		mem_4_back.setFont(new Font("American Typewriter", Font.BOLD, 14));
		mem_4_back.setBounds(2, 224, 85, 30);
		frame.getContentPane().add(mem_4_back);
		
		startscreen = new JLabel("startscreen");
		startscreen.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/newgame.jpg")));
		startscreen.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(startscreen);
	}
}
