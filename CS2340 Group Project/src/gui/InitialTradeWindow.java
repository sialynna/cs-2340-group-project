package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class InitialTradeWindow {

	private JFrame frame;
	private JTextField BuyMoxen;
	private JTextField BuyCloths;
	private JTextField BuyAmmo;
	private JTextField BuyMeds;
	private JTextField BuyAxles;
	private JTextField BuyWheels;
	private JTextField BuyYokes;
	private JTextField BuyRations;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialTradeWindow window = new InitialTradeWindow();
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
	public InitialTradeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setLocation(new Point(0, 0));
		frame.setBounds(new Rectangle(0, 0, 720, 480));
		frame.setResizable(false);
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel TransactionPanel = new JPanel();
		TransactionPanel.setBounds(222, 218, 275, 190);
		frame.getContentPane().add(TransactionPanel);
		TransactionPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 275, 194);
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		lblNewLabel.setIcon(new ImageIcon(InitialTradeWindow.class.getResource("/gui/resources/TransactionBack.jpg")));
		TransactionPanel.add(lblNewLabel);
		
		JPanel StorePanel = new JPanel();
		StorePanel.setBounds(12, 40, 200, 370);
		frame.getContentPane().add(StorePanel);
		StorePanel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 312, 50, 28);
		StorePanel.add(textField);
		
		BuyRations = new JTextField();
		BuyRations.setColumns(10);
		BuyRations.setBounds(144, 282, 50, 28);
		StorePanel.add(BuyRations);
		
		BuyYokes = new JTextField();
		BuyYokes.setColumns(10);
		BuyYokes.setBounds(144, 252, 50, 28);
		StorePanel.add(BuyYokes);
		
		BuyWheels = new JTextField();
		BuyWheels.setColumns(10);
		BuyWheels.setBounds(144, 222, 50, 28);
		StorePanel.add(BuyWheels);
		
		BuyAxles = new JTextField();
		BuyAxles.setColumns(10);
		BuyAxles.setBounds(144, 192, 50, 28);
		StorePanel.add(BuyAxles);
		
		BuyMeds = new JTextField();
		BuyMeds.setColumns(10);
		BuyMeds.setBounds(144, 162, 50, 28);
		StorePanel.add(BuyMeds);
		
		BuyAmmo = new JTextField();
		BuyAmmo.setColumns(10);
		BuyAmmo.setBounds(144, 132, 50, 28);
		StorePanel.add(BuyAmmo);
		
		BuyCloths = new JTextField();
		BuyCloths.setColumns(10);
		BuyCloths.setBounds(144, 102, 50, 28);
		StorePanel.add(BuyCloths);
		
		BuyMoxen = new JTextField();
		BuyMoxen.setBounds(144, 72, 50, 28);
		StorePanel.add(BuyMoxen);
		BuyMoxen.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Moxen:");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.BOLD, 13));
		lblNewLabel_2.setBounds(6, 74, 55, 25);
		StorePanel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("Cloths:");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label.setBounds(6, 104, 55, 25);
		StorePanel.add(label);
		
		JLabel label_1 = new JLabel("Ammo:");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_1.setBounds(6, 134, 55, 25);
		StorePanel.add(label_1);
		
		JLabel label_2 = new JLabel("Meds:");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_2.setBounds(6, 164, 55, 25);
		StorePanel.add(label_2);
		
		JLabel label_3 = new JLabel("Axles:");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_3.setBounds(6, 194, 55, 25);
		StorePanel.add(label_3);
		
		JLabel label_4 = new JLabel("Wheels:");
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_4.setBounds(6, 224, 55, 25);
		StorePanel.add(label_4);
		
		JLabel label_5 = new JLabel("Yokes:");
		label_5.setForeground(Color.GREEN);
		label_5.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_5.setBounds(6, 254, 55, 25);
		StorePanel.add(label_5);
		
		JLabel label_6 = new JLabel("Rations:");
		label_6.setForeground(Color.GREEN);
		label_6.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_6.setBounds(6, 284, 65, 25);
		StorePanel.add(label_6);
		
		JLabel label_7 = new JLabel("Items:");
		label_7.setForeground(Color.GREEN);
		label_7.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_7.setBounds(6, 314, 55, 25);
		StorePanel.add(label_7);
		
		JLabel StoreInventory = new JLabel("Store Inventory");
		StoreInventory.setHorizontalAlignment(SwingConstants.CENTER);
		StoreInventory.setHorizontalTextPosition(SwingConstants.CENTER);
		StoreInventory.setAlignmentX(Component.CENTER_ALIGNMENT);
		StoreInventory.setForeground(Color.GREEN);
		StoreInventory.setFont(new Font("American Typewriter", Font.BOLD, 15));
		StoreInventory.setBounds(6, 6, 188, 25);
		StorePanel.add(StoreInventory);
		
		JLabel BuyLabel = new JLabel("Buy");
		BuyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		BuyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BuyLabel.setForeground(Color.GREEN);
		BuyLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		BuyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		BuyLabel.setBounds(144, 43, 50, 25);
		StorePanel.add(BuyLabel);
		
		JLabel MaxLabel = new JLabel("Max");
		MaxLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		MaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MaxLabel.setForeground(Color.GREEN);
		MaxLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		MaxLabel.setAlignmentX(0.5f);
		MaxLabel.setBounds(98, 43, 50, 25);
		StorePanel.add(MaxLabel);
		
		JLabel MoxenMax = new JLabel("0");
		MoxenMax.setHorizontalTextPosition(SwingConstants.CENTER);
		MoxenMax.setHorizontalAlignment(SwingConstants.CENTER);
		MoxenMax.setForeground(Color.GREEN);
		MoxenMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		MoxenMax.setAlignmentX(0.5f);
		MoxenMax.setBounds(98, 74, 50, 25);
		StorePanel.add(MoxenMax);
		
		JLabel ClothsMax = new JLabel("0");
		ClothsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		ClothsMax.setHorizontalAlignment(SwingConstants.CENTER);
		ClothsMax.setForeground(Color.GREEN);
		ClothsMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		ClothsMax.setAlignmentX(0.5f);
		ClothsMax.setBounds(98, 104, 50, 25);
		StorePanel.add(ClothsMax);
		
		JLabel AmmoMax = new JLabel("0");
		AmmoMax.setHorizontalTextPosition(SwingConstants.CENTER);
		AmmoMax.setHorizontalAlignment(SwingConstants.CENTER);
		AmmoMax.setForeground(Color.GREEN);
		AmmoMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		AmmoMax.setAlignmentX(0.5f);
		AmmoMax.setBounds(98, 134, 50, 25);
		StorePanel.add(AmmoMax);
		
		JLabel MedsMax = new JLabel("0");
		MedsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		MedsMax.setHorizontalAlignment(SwingConstants.CENTER);
		MedsMax.setForeground(Color.GREEN);
		MedsMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		MedsMax.setAlignmentX(0.5f);
		MedsMax.setBounds(98, 164, 50, 25);
		StorePanel.add(MedsMax);
		
		JLabel AxlesMax = new JLabel("0");
		AxlesMax.setHorizontalTextPosition(SwingConstants.CENTER);
		AxlesMax.setHorizontalAlignment(SwingConstants.CENTER);
		AxlesMax.setForeground(Color.GREEN);
		AxlesMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		AxlesMax.setAlignmentX(0.5f);
		AxlesMax.setBounds(98, 194, 50, 25);
		StorePanel.add(AxlesMax);
		
		JLabel WheelsMax = new JLabel("0");
		WheelsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		WheelsMax.setHorizontalAlignment(SwingConstants.CENTER);
		WheelsMax.setForeground(Color.GREEN);
		WheelsMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		WheelsMax.setAlignmentX(0.5f);
		WheelsMax.setBounds(98, 224, 50, 25);
		StorePanel.add(WheelsMax);
		
		JLabel YokesMax = new JLabel("0");
		YokesMax.setHorizontalTextPosition(SwingConstants.CENTER);
		YokesMax.setHorizontalAlignment(SwingConstants.CENTER);
		YokesMax.setForeground(Color.GREEN);
		YokesMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		YokesMax.setAlignmentX(0.5f);
		YokesMax.setBounds(98, 254, 50, 25);
		StorePanel.add(YokesMax);
		
		JLabel RationsMax = new JLabel("0");
		RationsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		RationsMax.setHorizontalAlignment(SwingConstants.CENTER);
		RationsMax.setForeground(Color.GREEN);
		RationsMax.setFont(new Font("American Typewriter", Font.BOLD, 13));
		RationsMax.setAlignmentX(0.5f);
		RationsMax.setBounds(98, 284, 50, 25);
		StorePanel.add(RationsMax);
		
		JLabel label_35 = new JLabel("0");
		label_35.setHorizontalTextPosition(SwingConstants.CENTER);
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setForeground(Color.GREEN);
		label_35.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_35.setAlignmentX(0.5f);
		label_35.setBounds(98, 314, 50, 25);
		StorePanel.add(label_35);
		
		JLabel label_9 = new JLabel("0");
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.GREEN);
		label_9.setFont(new Font("American Typewriter", Font.BOLD, 13));
		label_9.setAlignmentX(0.5f);
		label_9.setBounds(56, 105, 50, 25);
		StorePanel.add(label_9);
		
		JLabel MoxenCost = new JLabel("0");
		MoxenCost.setHorizontalTextPosition(SwingConstants.CENTER);
		MoxenCost.setHorizontalAlignment(SwingConstants.CENTER);
		MoxenCost.setForeground(Color.GREEN);
		MoxenCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		MoxenCost.setAlignmentX(0.5f);
		MoxenCost.setBounds(56, 75, 50, 25);
		StorePanel.add(MoxenCost);
		
		JLabel MedsCost = new JLabel("0");
		MedsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		MedsCost.setHorizontalAlignment(SwingConstants.CENTER);
		MedsCost.setForeground(Color.GREEN);
		MedsCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		MedsCost.setAlignmentX(0.5f);
		MedsCost.setBounds(56, 165, 50, 25);
		StorePanel.add(MedsCost);
		
		JLabel AmmoCost = new JLabel("0");
		AmmoCost.setHorizontalTextPosition(SwingConstants.CENTER);
		AmmoCost.setHorizontalAlignment(SwingConstants.CENTER);
		AmmoCost.setForeground(Color.GREEN);
		AmmoCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		AmmoCost.setAlignmentX(0.5f);
		AmmoCost.setBounds(56, 135, 50, 25);
		StorePanel.add(AmmoCost);
		
		JLabel WheelsCost = new JLabel("0");
		WheelsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		WheelsCost.setHorizontalAlignment(SwingConstants.CENTER);
		WheelsCost.setForeground(Color.GREEN);
		WheelsCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		WheelsCost.setAlignmentX(0.5f);
		WheelsCost.setBounds(56, 225, 50, 25);
		StorePanel.add(WheelsCost);
		
		JLabel AxlesCost = new JLabel("0");
		AxlesCost.setHorizontalTextPosition(SwingConstants.CENTER);
		AxlesCost.setHorizontalAlignment(SwingConstants.CENTER);
		AxlesCost.setForeground(Color.GREEN);
		AxlesCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		AxlesCost.setAlignmentX(0.5f);
		AxlesCost.setBounds(56, 195, 50, 25);
		StorePanel.add(AxlesCost);
		
		JLabel RationsCost = new JLabel("0");
		RationsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		RationsCost.setHorizontalAlignment(SwingConstants.CENTER);
		RationsCost.setForeground(Color.GREEN);
		RationsCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		RationsCost.setAlignmentX(0.5f);
		RationsCost.setBounds(56, 285, 50, 25);
		StorePanel.add(RationsCost);
		
		JLabel YokesCost = new JLabel("0");
		YokesCost.setHorizontalTextPosition(SwingConstants.CENTER);
		YokesCost.setHorizontalAlignment(SwingConstants.CENTER);
		YokesCost.setForeground(Color.GREEN);
		YokesCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		YokesCost.setAlignmentX(0.5f);
		YokesCost.setBounds(56, 255, 50, 25);
		StorePanel.add(YokesCost);
		
		JLabel ItemsCost = new JLabel("0");
		ItemsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		ItemsCost.setHorizontalAlignment(SwingConstants.CENTER);
		ItemsCost.setForeground(Color.GREEN);
		ItemsCost.setFont(new Font("American Typewriter", Font.BOLD, 13));
		ItemsCost.setAlignmentX(0.5f);
		ItemsCost.setBounds(56, 315, 50, 25);
		StorePanel.add(ItemsCost);
		
		JLabel CostLabel = new JLabel("Cost");
		CostLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		CostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CostLabel.setForeground(Color.GREEN);
		CostLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		CostLabel.setAlignmentX(0.5f);
		CostLabel.setBounds(56, 43, 50, 25);
		StorePanel.add(CostLabel);
		
		JLabel storeback = new JLabel("New label");
		storeback.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		storeback.setIcon(new ImageIcon(InitialTradeWindow.class.getResource("/gui/resources/TextBackground.jpg")));
		storeback.setBounds(0, 0, 200, 370);
		StorePanel.add(storeback);
		
		JPanel PlayerPanel = new JPanel();
		PlayerPanel.setBounds(508, 40, 200, 370);
		frame.getContentPane().add(PlayerPanel);
		PlayerPanel.setLayout(null);
		
		JLabel PlayerMoneyAmt = new JLabel("0");
		PlayerMoneyAmt.setForeground(Color.GREEN);
		PlayerMoneyAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMoneyAmt.setAlignmentX(1.0f);
		PlayerMoneyAmt.setBounds(119, 43, 75, 25);
		PlayerPanel.add(PlayerMoneyAmt);
		
		JLabel PlayerMoney = new JLabel("Money:");
		PlayerMoney.setForeground(Color.GREEN);
		PlayerMoney.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMoney.setBounds(36, 43, 100, 25);
		PlayerPanel.add(PlayerMoney);
		
		JLabel PlayerMoxen = new JLabel("Moxen:");
		PlayerMoxen.setForeground(Color.GREEN);
		PlayerMoxen.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMoxen.setBounds(36, 74, 100, 25);
		PlayerPanel.add(PlayerMoxen);
		
		JLabel PlayerCloths = new JLabel("Cloths:");
		PlayerCloths.setForeground(Color.GREEN);
		PlayerCloths.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerCloths.setBounds(36, 104, 100, 25);
		PlayerPanel.add(PlayerCloths);
		
		JLabel PlayerAmmo = new JLabel("Ammo:");
		PlayerAmmo.setForeground(Color.GREEN);
		PlayerAmmo.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerAmmo.setBounds(36, 134, 100, 25);
		PlayerPanel.add(PlayerAmmo);
		
		JLabel PlayerMeds = new JLabel("Meds:");
		PlayerMeds.setForeground(Color.GREEN);
		PlayerMeds.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMeds.setBounds(36, 164, 100, 25);
		PlayerPanel.add(PlayerMeds);
		
		JLabel PlayerAxles = new JLabel("Axles:");
		PlayerAxles.setForeground(Color.GREEN);
		PlayerAxles.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerAxles.setBounds(36, 194, 100, 25);
		PlayerPanel.add(PlayerAxles);
		
		JLabel PlayerWheels = new JLabel("Wheels:");
		PlayerWheels.setForeground(Color.GREEN);
		PlayerWheels.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerWheels.setBounds(36, 224, 100, 25);
		PlayerPanel.add(PlayerWheels);
		
		JLabel PlayerYokes = new JLabel("Yokes:");
		PlayerYokes.setForeground(Color.GREEN);
		PlayerYokes.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerYokes.setBounds(36, 254, 100, 25);
		PlayerPanel.add(PlayerYokes);
		
		JLabel PlayerRations = new JLabel("Rations:");
		PlayerRations.setForeground(Color.GREEN);
		PlayerRations.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerRations.setBounds(36, 284, 100, 25);
		PlayerPanel.add(PlayerRations);
		
		JLabel PlayerItems = new JLabel("Items:");
		PlayerItems.setForeground(Color.GREEN);
		PlayerItems.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerItems.setBounds(36, 314, 100, 25);
		PlayerPanel.add(PlayerItems);
		
		JLabel PlayerInventory = new JLabel("Player Inventory");
		PlayerInventory.setHorizontalTextPosition(SwingConstants.CENTER);
		PlayerInventory.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerInventory.setForeground(Color.GREEN);
		PlayerInventory.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerInventory.setAlignmentX(0.5f);
		PlayerInventory.setBounds(6, 6, 188, 25);
		PlayerPanel.add(PlayerInventory);
		
		JLabel PlayerMoxenAmt = new JLabel("0");
		PlayerMoxenAmt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		PlayerMoxenAmt.setForeground(Color.GREEN);
		PlayerMoxenAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMoxenAmt.setBounds(118, 74, 75, 25);
		PlayerPanel.add(PlayerMoxenAmt);
		
		JLabel PlayerClothsAmt = new JLabel("0");
		PlayerClothsAmt.setForeground(Color.GREEN);
		PlayerClothsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerClothsAmt.setAlignmentX(1.0f);
		PlayerClothsAmt.setBounds(118, 104, 75, 25);
		PlayerPanel.add(PlayerClothsAmt);
		
		JLabel PlayerAmmoAmt = new JLabel("0");
		PlayerAmmoAmt.setForeground(Color.GREEN);
		PlayerAmmoAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerAmmoAmt.setAlignmentX(1.0f);
		PlayerAmmoAmt.setBounds(118, 134, 75, 25);
		PlayerPanel.add(PlayerAmmoAmt);
		
		JLabel PlayerMedsAmt = new JLabel("0");
		PlayerMedsAmt.setForeground(Color.GREEN);
		PlayerMedsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMedsAmt.setAlignmentX(1.0f);
		PlayerMedsAmt.setBounds(118, 164, 75, 25);
		PlayerPanel.add(PlayerMedsAmt);
		
		JLabel PlayerAxlesAmt = new JLabel("0");
		PlayerAxlesAmt.setForeground(Color.GREEN);
		PlayerAxlesAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerAxlesAmt.setAlignmentX(1.0f);
		PlayerAxlesAmt.setBounds(118, 194, 75, 25);
		PlayerPanel.add(PlayerAxlesAmt);
		
		JLabel PlayerWheelsAmt = new JLabel("0");
		PlayerWheelsAmt.setForeground(Color.GREEN);
		PlayerWheelsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerWheelsAmt.setAlignmentX(1.0f);
		PlayerWheelsAmt.setBounds(118, 224, 75, 25);
		PlayerPanel.add(PlayerWheelsAmt);
		
		JLabel PlayerYokesAmt = new JLabel("0");
		PlayerYokesAmt.setForeground(Color.GREEN);
		PlayerYokesAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerYokesAmt.setAlignmentX(1.0f);
		PlayerYokesAmt.setBounds(118, 254, 75, 25);
		PlayerPanel.add(PlayerYokesAmt);
		
		JLabel PlayerRationsAmt = new JLabel("0");
		PlayerRationsAmt.setForeground(Color.GREEN);
		PlayerRationsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerRationsAmt.setAlignmentX(1.0f);
		PlayerRationsAmt.setBounds(118, 284, 75, 25);
		PlayerPanel.add(PlayerRationsAmt);
		
		JLabel label_24 = new JLabel("0");
		label_24.setForeground(Color.GREEN);
		label_24.setFont(new Font("American Typewriter", Font.BOLD, 15));
		label_24.setAlignmentX(1.0f);
		label_24.setBounds(118, 314, 75, 25);
		PlayerPanel.add(label_24);
		
		JLabel playerback = new JLabel("New label");
		playerback.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		playerback.setIcon(new ImageIcon(InitialTradeWindow.class.getResource("/gui/resources/TextBackground.jpg")));
		playerback.setBounds(0, 0, 200, 370);
		PlayerPanel.add(playerback);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(InitialTradeWindow.class.getResource("/gui/resources/TradeBackground.jpg")));
		background.setBounds(0, 0, 720, 480);
		frame.getContentPane().add(background);
	}
}