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
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JComboBox profSelect;
	private JComboBox paceSelect;
	private JComboBox rationSelect;
	private Leader ld;
	private Pace pacee;
	private Rations ration;
	private Supplies sup;
	private Member[] mem= new Member[3];
	private String name;
	private String profession;
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
		
		String[] memberNo = {"1", "2", "3", "4"};
		String[] profs = {"Carpenter", "Banker", "Doctor"};
		String[] paces = {"Stopped", "Easy", "Normal", "Grueling"};
		String[] rations = {"Filling", "Normal", "Meager", "Starvation"};
		
		
		JComboBox memberSelect = new JComboBox(memberNo);
		memberSelect.addItemListener(new ItemListener() {
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
		
		rationSelect = new JComboBox(rations);
		rationSelect.setBounds(306, 174, 115, 27);
		frame.getContentPane().add(rationSelect);
		rationSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox rat=(JComboBox)e.getSource();
				String ratval=(String)rat.getSelectedItem();
				if(ratval.equals("Filling"))
				{
					ration=new Rations(0);
				}
				else if(ratval.equals("Normal"))
				{
					ration=new Rations(1);
				}
				else if(ratval.equals("Meager"))
				{
					ration=new Rations(2);
				}
				else if(ratval.equals("Starvation"))
				{
					ration=new Rations(3);
				}
			}
		});
		
		paceSelect = new JComboBox(paces);
		paceSelect.setBounds(306, 112, 115, 27);
		frame.getContentPane().add(paceSelect);
		paceSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox pc=(JComboBox)e.getSource();
				String paceval=(String)pc.getSelectedItem();
				if(paceval.equals("Stopped"))
				{
					pacee=new Pace(0);
				}
				else if(paceval.equals("Easy"))
				{
					pacee=new Pace(1);
				}
				else if(paceval.equals("Normal"))
				{
					pacee=new Pace(2);
				}
				else if(paceval.equals("Grueling"))
				{
					pacee=new Pace(3);
				}
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
		btnStartGame.setBounds(306, 218, 117, 54);
		frame.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ld=new Leader(name,profession);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Player Name:");
		lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(10, 16, 115, 30);
		frame.getContentPane().add(lblNewLabel);
		
		leaderName = new JTextField();
		leaderName.setBounds(118, 16, 168, 30);
		leaderName.setForeground(Color.LIGHT_GRAY);
		leaderName.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(leaderName);
		leaderName.setColumns(10);
		leaderName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String text = leaderName.getText();
				name=text;
			}
		});
		
		JLabel lblHowManyOther = new JLabel("How many other wagon members?");
		lblHowManyOther.setFont(new Font("American Typewriter", Font.BOLD, 12));
		lblHowManyOther.setForeground(Color.GREEN);
		lblHowManyOther.setBounds(14, 56, 223, 30);
		frame.getContentPane().add(lblHowManyOther);
		
		member1 = new JTextField();
		member1.setColumns(10);
		member1.setBounds(103, 104, 178, 30);
		member1.setForeground(Color.LIGHT_GRAY);
		member1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member1);
		member1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mem[0]=new Member(member1.getText());
			}
		});
		
		
		member2 = new JTextField();
		member2.setVisible(false);
		member2.setColumns(10);
		member2.setBounds(103, 143, 178, 30);
		member2.setForeground(Color.LIGHT_GRAY);
		member2.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member2);
		member2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mem[1]=new Member(member2.getText());
			}
		});
		
		member3 = new JTextField();
		member3.setVisible(false);
		member3.setColumns(10);
		member3.setBounds(103, 185, 178, 30);
		member3.setForeground(Color.LIGHT_GRAY);
		member3.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member3);
		member3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mem[2]=new Member(member3.getText());
			}
		});
		
		member4 = new JTextField();
		member4.setVisible(false);
		member4.setColumns(10);
		member4.setBounds(103, 224, 178, 30);
		member4.setForeground(Color.LIGHT_GRAY);
		member4.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(member4);
		member4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mem[3]=new Member(member4.getText());
			}
		});
		
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
		
		startscreen = new JLabel("startscreen");
		startscreen.setIcon(new ImageIcon(NewGameWindow.class.getResource("/gui/resources/newgame.jpg")));
		startscreen.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(startscreen);
		initDataBindings();
	}
	protected void initDataBindings() {
	}
}
