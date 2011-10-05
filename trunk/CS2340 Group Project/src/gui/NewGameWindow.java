package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;

public class NewGameWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		JLabel lblNewLabel = new JLabel("Player Name:");
		lblNewLabel.setBounds(6, 19, 115, 22);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 16, 178, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setForeground(Color.LIGHT_GRAY);
		choice.setBackground(Color.LIGHT_GRAY);
		choice.setBounds(249, 50, 32, 26);
		frame.getContentPane().add(choice);
		
		JLabel lblHowManyOther = new JLabel("How many other wagon members?");
		lblHowManyOther.setBounds(6, 50, 367, 26);
		frame.getContentPane().add(lblHowManyOther);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 104, 178, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 146, 178, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 185, 178, 30);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 224, 178, 30);
		frame.getContentPane().add(textField_4);
		
		JLabel lblMember = new JLabel("Member 1:");
		lblMember.setBounds(6, 104, 115, 30);
		frame.getContentPane().add(lblMember);
		
		JLabel lblMember_1 = new JLabel("Member 2:");
		lblMember_1.setBounds(6, 146, 115, 30);
		frame.getContentPane().add(lblMember_1);
		
		JLabel lblMember_2 = new JLabel("Member 3:");
		lblMember_2.setBounds(6, 185, 115, 30);
		frame.getContentPane().add(lblMember_2);
		
		JLabel lblMember_3 = new JLabel("Member 4:");
		lblMember_3.setBounds(6, 224, 115, 30);
		frame.getContentPane().add(lblMember_3);
	}
}
