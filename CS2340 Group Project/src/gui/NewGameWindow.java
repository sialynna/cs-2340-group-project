package gui;

import java.awt.EventQueue;
import classes.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JSeparator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;

/**
 * This class creates the New Game Window which gives the player the
 * options to enter their name, the number of other wagon members,
 * their starting profession, pace, and rations per day.
 * 
 * @author Team C.A.K.E
 *
 */
public class NewGameWindow {

	private JFrame frame;
	private JTextField leaderName;
	private JTextField member1name;
	private JTextField member2name;
	private JTextField member3name;
	private JTextField member4name;
	
	private JLabel lblMember_1;
	private JLabel lblMember_2;
	private JLabel lblMember_3;
	private JLabel lblMember_4;
	private JLabel startscreen;
	private JLabel noname;
	private JButton btnStartGame;
	private JLabel namelabelBackground;
	private JLabel paceBack;
	private JLabel rationsBack;
	private JLabel mem_1_back;
	private JLabel mem_2_back;
	private JLabel mem_3_back;
	private JLabel mem_4_back;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JComboBox profSelect;
	private JComboBox paceSelect;
	private JComboBox rationSelect;
	private String profession = "Carpenter";
	private String choice;
	private String paceval = "Stopped";
	private String ratval = "Filling";
	public static GameEngine Engine;
	
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] memberNo = {"1", "2", "3", "4"};
		String[] profs = {"Carpenter", "Banker", "Doctor"};
		String[] paces = {"Stopped", "Easy", "Normal", "Grueling"};
		String[] rations = {"Filling", "Normal", "Meager", "Starvation"};
		
		
		JComboBox memberSelect = new JComboBox(memberNo);
		memberSelect.setForeground(Color.BLACK);
		memberSelect.setBackground(Color.WHITE);
		memberSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				choice = (String)arg0.getItem();
				if (choice == "1"){
					member2name.setVisible(false);
					lblMember_2.setVisible(false);
					mem_2_back.setVisible(false);
					member3name.setVisible(false);
					lblMember_3.setVisible(false);
					mem_3_back.setVisible(false);
					member4name.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
					 
				}
				else if(choice == "2"){
					member2name.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3name.setVisible(false);
					lblMember_3.setVisible(false);
					mem_3_back.setVisible(false);
					member4name.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
				}
				else if (choice == "3"){
					member2name.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3name.setVisible(true);
					lblMember_3.setVisible(true);
					mem_3_back.setVisible(true);
					member4name.setVisible(false);
					lblMember_4.setVisible(false);
					mem_4_back.setVisible(false);
				}
				else if (choice == "4"){
					member2name.setVisible(true);
					lblMember_2.setVisible(true);
					mem_2_back.setVisible(true);
					member3name.setVisible(true);
					lblMember_3.setVisible(true);
					mem_3_back.setVisible(true);
					member4name.setVisible(true);
					lblMember_4.setVisible(true);
					mem_4_back.setVisible(true);
				}
			}
		});
		
		rationSelect = new JComboBox(rations);
		rationSelect.setBounds(306, 174, 115, 27);
		frame.getContentPane().add(rationSelect);
		rationSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox rat=(JComboBox)e.getSource();
				ratval=(String)rat.getSelectedItem();
			}
		});
		
		paceSelect = new JComboBox(paces);
		paceSelect.setBounds(306, 112, 115, 27);
		frame.getContentPane().add(paceSelect);
		paceSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox pc=(JComboBox)e.getSource();
				paceval=(String)pc.getSelectedItem();
			}
		});
		
		profSelect = new JComboBox(profs);
		profSelect.setBounds(306, 49, 115, 27);
		frame.getContentPane().add(profSelect);
		
		profSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox prof=(JComboBox)e.getSource();
				String profval=(String)prof.getSelectedItem();
				profession = profval;
			}
		});
		memberSelect.setBounds(234, 58, 60, 27);
		frame.getContentPane().add(memberSelect);
		
		
		label_1 = new JLabel("Profession:");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("American Typewriter", Font.BOLD, 14));
		label_1.setBounds(322, 15, 96, 30);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("American Typewriter", Font.BOLD, 14));
		label_2.setBounds(306, 16, 115, 30);
		frame.getContentPane().add(label_2);
		
		btnStartGame = new JButton("Start Game!");
		btnStartGame.setBackground(Color.GRAY);
		btnStartGame.setBounds(305, 218, 117, 54);
		frame.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if (leaderName.getText().equals("") || leaderName.getText().equals(null))
				{
					leaderName.setBackground(Color.red);
					noname.setVisible(true);
				} 
				else if (member1name.getText().equals(""))
				{
					member1name.setBackground(Color.red);
					noname.setVisible(true);
				}
				else if (member2name.isVisible() && member2name.getText().equals(""))
				{
					member2name.setBackground(Color.red);
					noname.setVisible(true);
				}
				else if (member3name.isVisible() && member3name.getText().equals(""))
				{
					member3name.setBackground(Color.red);
					noname.setVisible(true);
				}
				else if (member4name.isVisible() && member4name.getText().equals(""))
				{
					member4name.setBackground(Color.red);
					noname.setVisible(true);
				}
				else
				{

					if (member2name.isVisible() == false && member3name.isVisible() == false && member4name.isVisible() == false)
					{
						Engine = new GameEngine(leaderName.getText(), profession, ratval, paceval, member1name.getText());
					} 
					else if (member3name.isVisible() == false && member4name.isVisible() == false)
					{
						Engine = new GameEngine(leaderName.getText(), profession, ratval, paceval, member1name.getText(), member2name.getText());
					} 
					else if (member4name.isVisible() == false)
					{
						Engine = new GameEngine(leaderName.getText(), profession, ratval, paceval, member1name.getText(), member2name.getText(), member3name.getText());
					} 
					else 
					{
						Engine = new GameEngine(leaderName.getText(), profession, ratval, paceval, member1name.getText(), member2name.getText(), member3name.getText(), member4name.getText());
					}
					frame.dispose();
				} 
			}
		});
		
		JLabel lblNewLabel = new JLabel("Player Name:");
		lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(10, 16, 115, 30);
		frame.getContentPane().add(lblNewLabel);
		
		leaderName = new JTextField();
		leaderName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				leaderName.setBackground(Color.DARK_GRAY);
				noname.setVisible(false);
			}
		});
		leaderName.setBounds(118, 16, 168, 30);
		leaderName.setForeground(Color.LIGHT_GRAY);
		leaderName.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(leaderName);
		leaderName.setColumns(10);

		JLabel lblHowManyOther = new JLabel("How many other wagon members?");
		lblHowManyOther.setFont(new Font("American Typewriter", Font.BOLD, 12));
		lblHowManyOther.setForeground(Color.GREEN);
		lblHowManyOther.setBounds(14, 56, 223, 30);
		frame.getContentPane().add(lblHowManyOther);
		
		member1name = new JTextField();
		member1name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				member1name.setBackground(Color.DARK_GRAY);
				noname.setVisible(false);
			}
		});
		member1name.setColumns(10);
		member1name.setBounds(103, 104, 178, 30);
		member1name.setForeground(Color.LIGHT_GRAY);
		member1name.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member1name);
		
		member2name = new JTextField();
		member2name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				member2name.setBackground(Color.DARK_GRAY);
				noname.setVisible(false);
			}
		});
		member2name.setVisible(false);
		member2name.setColumns(10);
		member2name.setBounds(103, 143, 178, 30);
		member2name.setForeground(Color.LIGHT_GRAY);
		member2name.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member2name);
		
		member3name = new JTextField();
		member3name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				member3name.setBackground(Color.DARK_GRAY);
				noname.setVisible(false);
			}
		});
		member3name.setVisible(false);
		member3name.setColumns(10);
		member3name.setBounds(103, 185, 178, 30);
		member3name.setForeground(Color.LIGHT_GRAY);
		member3name.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member3name);
		
		member4name = new JTextField();
		member4name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				member4name.setBackground(Color.DARK_GRAY);
				noname.setVisible(false);
			}
		});
		member4name.setVisible(false);
		member4name.setColumns(10);
		member4name.setBounds(103, 224, 178, 30);
		member4name.setForeground(Color.LIGHT_GRAY);
		member4name.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member4name);

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
		
		JLabel lblInitialPace = new JLabel("Initial Pace:");
		lblInitialPace.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblInitialPace.setForeground(Color.GREEN);
		lblInitialPace.setBounds(319, 78, 96, 30);
		frame.getContentPane().add(lblInitialPace);
		
		JLabel lblInitialRations = new JLabel("Initial Rations:");
		lblInitialRations.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblInitialRations.setForeground(Color.GREEN);
		lblInitialRations.setBounds(311, 141, 115, 30);
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
		memberselectBack.setBounds(4, 56, 233, 30);
		frame.getContentPane().add(memberselectBack);
		
		paceBack = new JLabel("");
		paceBack.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		paceBack.setForeground(Color.GREEN);
		paceBack.setFont(new Font("American Typewriter", Font.BOLD, 14));
		paceBack.setBounds(306, 79, 115, 30);
		frame.getContentPane().add(paceBack);
		
		rationsBack = new JLabel("");
		rationsBack.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/nameLabelBackground.jpg")));
		rationsBack.setForeground(Color.GREEN);
		rationsBack.setFont(new Font("American Typewriter", Font.BOLD, 14));
		rationsBack.setBounds(306, 142, 115, 30);
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
		
		label = new JLabel("New label");
		label.setBounds(316, 23, 61, 16);
		frame.getContentPane().add(label);
		
		noname = new JLabel(" Please enter a name!");
		noname.setAlignmentX(Component.CENTER_ALIGNMENT);
		noname.setVisible(false);
		noname.setOpaque(true);
		noname.setBackground(Color.DARK_GRAY);
		noname.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		noname.setForeground(Color.RED);
		noname.setBounds(306, 199, 115, 16);
		frame.getContentPane().add(noname);
		
		startscreen = new JLabel("startscreen");
		startscreen.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/newgame.jpg")));
		startscreen.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(startscreen);
		initDataBindings();
	}
	protected void initDataBindings() {
	}
}
