package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import classes.*;

/**
 * A GUI for the player to trade items with a store.
 * 
 * @author Christopher
 *
 */
@SuppressWarnings("serial")
public class TradePanel extends JPanel {

	private int totalAmt;
	private int totalWt;
	private Transaction trans;
	JPanel trade;
	
	private JTextField BuyMoxen;
	private JTextField BuyCloths;
	private JTextField BuyAmmo;
	private JTextField BuyMeds;
	private JTextField BuyAxles;
	private JTextField BuyWheels;
	private JTextField BuyYokes;
	private JTextField BuyRations;
	
	private JTextField[] inputs = new JTextField[8];
	
	private JLabel PurchaseWt;
	private JLabel PurchaseAmt;
	private JLabel TransAmtLbl;
	
	private JLabel MoxenMax;
	private JLabel ClothsMax;
	private JLabel AmmoMax;
	private JLabel MedsMax;
	private JLabel AxlesMax;
	private JLabel WheelsMax;
	private JLabel YokesMax;
	private JLabel RationsMax;
	
	private JLabel MoxenCost;
	private JLabel ClothsCost;
	private JLabel AmmoCost;
	private JLabel MedsCost;
	private JLabel AxlesCost;
	private JLabel WheelsCost;
	private JLabel YokesCost;
	private JLabel RationsCost;
	
	private JLabel PlayerMoneyAmt;
	
	private JLabel PlayerMoxenAmt;
	private JLabel PlayerClothsAmt;
	private JLabel PlayerAmmoAmt;
	private JLabel PlayerMedsAmt;
	private JLabel PlayerAxlesAmt;
	private JLabel PlayerWheelsAmt;
	private JLabel PlayerYokesAmt;
	private JLabel PlayerRationsAmt;
	
	private JLabel playerTotalWeight;
	private JLabel lblNumbersOnlyPlease;
	
	private JLabel[] costs = new JLabel[8];
	private JLabel[] stAmts = new JLabel[8];
	private JLabel[] plAmts = new JLabel[8];

	private int[] prices = new int[8];
	private int[] weights = new int[8];
	private Item[] items;
	private JLabel notEnough;
	private JLabel noMoxen;
	
	/**
	 * Create the panel.
	 */
	public TradePanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(null);
		setBounds(0, 0, 720, 480);
		setVisible(true);
		trade = this;
		
		JPanel ContentPanel = new JPanel();
		ContentPanel.setLayout(null);
		ContentPanel.setBounds(0,0,720,480);
		ContentPanel.setVisible(true);

		JPanel TransactionPanel = new JPanel();
		TransactionPanel.setBounds(222, 218, 275, 190);
		ContentPanel.add(TransactionPanel);
		TransactionPanel.setLayout(null);
		
		JButton btnBuyItems = new JButton("Buy Items");
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (trans.checkLegit(inputs))
				{
					notEnough.setVisible(false);
					noMoxen.setVisible(false);
					int[] purch = new int[8]; 
					for(int i=0; i < 8;i++ ){
						try{
							purch[i] = Integer.parseInt(inputs[i].getText());
							trans.addItems(items[i], purch[i]);
						} catch (NumberFormatException e){
							lblNumbersOnlyPlease.setVisible(true);
						}
					}
					for (JTextField j:inputs){
						j.setText("0");
					}
					trans.subMoney();
					totalAmt = 0;
				}
				else
				{
					noMoxen.setVisible(false);
					notEnough.setVisible(true);
				}
			}
		});
		btnBuyItems.setBounds(35, 129, 100, 50);
		TransactionPanel.add(btnBuyItems);
		
		PurchaseWt = new JLabel("0");
		PurchaseWt.setForeground(Color.GREEN);
		PurchaseWt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PurchaseWt.setAlignmentX(1.0f);
		PurchaseWt.setBounds(172, 62, 75, 25);
		TransactionPanel.add(PurchaseWt);
		
		TransAmtLbl = new JLabel("Purchase Amount:");
		TransAmtLbl.setForeground(Color.GREEN);
		TransAmtLbl.setFont(new Font("American Typewriter", Font.BOLD, 13));
		TransAmtLbl.setBounds(35, 25, 125, 25);
		TransactionPanel.add(TransAmtLbl);
		
		JLabel TransWtLbl = new JLabel("Purchase Weight:");
		TransWtLbl.setForeground(Color.GREEN);
		TransWtLbl.setFont(new Font("American Typewriter", Font.BOLD, 13));
		TransWtLbl.setBounds(35, 62, 125, 25);
		TransactionPanel.add(TransWtLbl);
		
		PurchaseAmt = new JLabel("0");
		PurchaseAmt.setForeground(Color.GREEN);
		PurchaseAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PurchaseAmt.setAlignmentX(1.0f);
		PurchaseAmt.setBounds(172, 25, 75, 25);
		TransactionPanel.add(PurchaseAmt);
		
		JButton button = new JButton("Exit Store");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Item.MOXEN.getNum() == 0){
					noMoxen.setVisible(true);
				} 
				else
				{
				GameEngine.setPanelMain();
				}
			}
		});
		button.setBounds(147, 129, 100, 50);
		TransactionPanel.add(button);
		
		notEnough = new JLabel("Not enough money and/or weight left!");
		notEnough.setVisible(false);
		notEnough.setForeground(Color.GREEN);
		notEnough.setFont(new Font("American Typewriter", Font.BOLD, 12));
		notEnough.setBounds(20, 99, 234, 25);
		TransactionPanel.add(notEnough);
		
		noMoxen = new JLabel("You should buy at least 1 Moxen!");
		noMoxen.setHorizontalAlignment(SwingConstants.CENTER);
		noMoxen.setForeground(Color.GREEN);
		noMoxen.setFont(new Font("American Typewriter", Font.BOLD, 13));
		noMoxen.setBounds(20, 99, 234, 25);
		TransactionPanel.add(noMoxen);
		
		JLabel transBackground = new JLabel("");
		transBackground.setBounds(0, 0, 275, 194);
		transBackground.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		transBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/gui/resources/TransactionBack.jpg")));
		TransactionPanel.add(transBackground);
		
		JPanel StorePanel = new JPanel();
		StorePanel.setBounds(12, 40, 200, 370);
		ContentPanel.add(StorePanel);
		StorePanel.setLayout(null);
		
		BuyRations = new JTextField();
		BuyRations.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyRations.setText("0");
		BuyRations.setColumns(10);
		BuyRations.setBounds(144, 282, 50, 28);
		StorePanel.add(BuyRations);
		
		BuyYokes = new JTextField();
		BuyYokes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});

		BuyYokes.setText("0");
		BuyYokes.setColumns(10);
		BuyYokes.setBounds(144, 252, 50, 28);
		StorePanel.add(BuyYokes);
		
		BuyWheels = new JTextField();
		BuyWheels.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyWheels.setText("0");
		BuyWheels.setColumns(10);
		BuyWheels.setBounds(144, 222, 50, 28);
		StorePanel.add(BuyWheels);
		
		BuyAxles = new JTextField();
		BuyAxles.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyAxles.setText("0");
		BuyAxles.setColumns(10);
		BuyAxles.setBounds(144, 192, 50, 28);
		StorePanel.add(BuyAxles);
		
		BuyMeds = new JTextField();
		BuyMeds.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyMeds.setText("0");
		BuyMeds.setColumns(10);
		BuyMeds.setBounds(144, 162, 50, 28);
		StorePanel.add(BuyMeds);
		
		BuyAmmo = new JTextField();
		BuyAmmo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyAmmo.setText("0");
		BuyAmmo.setColumns(10);
		BuyAmmo.setBounds(144, 132, 50, 28);
		StorePanel.add(BuyAmmo);
		
		BuyCloths = new JTextField();
		BuyCloths.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyCloths.setText("0");
		BuyCloths.setColumns(10);
		BuyCloths.setBounds(144, 102, 50, 28);
		StorePanel.add(BuyCloths);
		
		BuyMoxen = new JTextField();
		BuyMoxen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setTotals();
			}
		});
		BuyMoxen.setText("0");
		BuyMoxen.setColumns(10);
		BuyMoxen.setBounds(144, 72, 50, 28);
		StorePanel.add(BuyMoxen);

		
		JLabel StMoxenLbl = new JLabel("Moxen:");
		StMoxenLbl.setForeground(Color.GREEN);
		StMoxenLbl.setFont(new Font("American Typewriter", Font.BOLD, 12));
		StMoxenLbl.setBounds(6, 74, 55, 25);
		StorePanel.add(StMoxenLbl);
		
		JLabel label = new JLabel("Cloths:");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label.setBounds(6, 104, 55, 25);
		StorePanel.add(label);
		
		JLabel label_1 = new JLabel("Ammo:");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_1.setBounds(6, 134, 55, 25);
		StorePanel.add(label_1);
		
		JLabel label_2 = new JLabel("Meds:");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_2.setBounds(6, 164, 55, 25);
		StorePanel.add(label_2);
		
		JLabel label_3 = new JLabel("Axles:");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_3.setBounds(6, 194, 55, 25);
		StorePanel.add(label_3);
		
		JLabel label_4 = new JLabel("Wheels:");
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_4.setBounds(6, 224, 55, 25);
		StorePanel.add(label_4);
		
		JLabel label_5 = new JLabel("Yokes:");
		label_5.setForeground(Color.GREEN);
		label_5.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_5.setBounds(6, 254, 55, 25);
		StorePanel.add(label_5);
		
		JLabel label_6 = new JLabel("Rations:");
		label_6.setForeground(Color.GREEN);
		label_6.setFont(new Font("American Typewriter", Font.BOLD, 12));
		label_6.setBounds(6, 284, 65, 25);
		StorePanel.add(label_6);
		
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
		
		MoxenMax = new JLabel("0");
		MoxenMax.setHorizontalTextPosition(SwingConstants.CENTER);
		MoxenMax.setHorizontalAlignment(SwingConstants.CENTER);
		MoxenMax.setForeground(Color.GREEN);
		MoxenMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		MoxenMax.setAlignmentX(0.5f);
		MoxenMax.setBounds(98, 74, 50, 25);
		StorePanel.add(MoxenMax);
		
		ClothsMax = new JLabel("0");
		ClothsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		ClothsMax.setHorizontalAlignment(SwingConstants.CENTER);
		ClothsMax.setForeground(Color.GREEN);
		ClothsMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		ClothsMax.setAlignmentX(0.5f);
		ClothsMax.setBounds(98, 104, 50, 25);
		StorePanel.add(ClothsMax);
		
		AmmoMax = new JLabel("0");
		AmmoMax.setHorizontalTextPosition(SwingConstants.CENTER);
		AmmoMax.setHorizontalAlignment(SwingConstants.CENTER);
		AmmoMax.setForeground(Color.GREEN);
		AmmoMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		AmmoMax.setAlignmentX(0.5f);
		AmmoMax.setBounds(98, 134, 50, 25);
		StorePanel.add(AmmoMax);
		
		MedsMax = new JLabel("0");
		MedsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		MedsMax.setHorizontalAlignment(SwingConstants.CENTER);
		MedsMax.setForeground(Color.GREEN);
		MedsMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		MedsMax.setAlignmentX(0.5f);
		MedsMax.setBounds(98, 164, 50, 25);
		StorePanel.add(MedsMax);
		
		AxlesMax = new JLabel("0");
		AxlesMax.setHorizontalTextPosition(SwingConstants.CENTER);
		AxlesMax.setHorizontalAlignment(SwingConstants.CENTER);
		AxlesMax.setForeground(Color.GREEN);
		AxlesMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		AxlesMax.setAlignmentX(0.5f);
		AxlesMax.setBounds(98, 194, 50, 25);
		StorePanel.add(AxlesMax);
		
		WheelsMax = new JLabel("0");
		WheelsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		WheelsMax.setHorizontalAlignment(SwingConstants.CENTER);
		WheelsMax.setForeground(Color.GREEN);
		WheelsMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		WheelsMax.setAlignmentX(0.5f);
		WheelsMax.setBounds(98, 224, 50, 25);
		StorePanel.add(WheelsMax);
		
		YokesMax = new JLabel("0");
		YokesMax.setHorizontalTextPosition(SwingConstants.CENTER);
		YokesMax.setHorizontalAlignment(SwingConstants.CENTER);
		YokesMax.setForeground(Color.GREEN);
		YokesMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		YokesMax.setAlignmentX(0.5f);
		YokesMax.setBounds(98, 254, 50, 25);
		StorePanel.add(YokesMax);
		
		RationsMax = new JLabel("0");
		RationsMax.setHorizontalTextPosition(SwingConstants.CENTER);
		RationsMax.setHorizontalAlignment(SwingConstants.CENTER);
		RationsMax.setForeground(Color.GREEN);
		RationsMax.setFont(new Font("American Typewriter", Font.BOLD, 12));
		RationsMax.setAlignmentX(0.5f);
		RationsMax.setBounds(98, 284, 50, 25);
		StorePanel.add(RationsMax);
		
		ClothsCost = new JLabel("0");
		ClothsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		ClothsCost.setHorizontalAlignment(SwingConstants.CENTER);
		ClothsCost.setForeground(Color.GREEN);
		ClothsCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		ClothsCost.setAlignmentX(0.5f);
		ClothsCost.setBounds(56, 105, 50, 25);
		StorePanel.add(ClothsCost);
		
		MoxenCost = new JLabel("0");
		MoxenCost.setHorizontalTextPosition(SwingConstants.CENTER);
		MoxenCost.setHorizontalAlignment(SwingConstants.CENTER);
		MoxenCost.setForeground(Color.GREEN);
		MoxenCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		MoxenCost.setAlignmentX(0.5f);
		MoxenCost.setBounds(56, 75, 50, 25);
		StorePanel.add(MoxenCost);
		
		MedsCost = new JLabel("0");
		MedsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		MedsCost.setHorizontalAlignment(SwingConstants.CENTER);
		MedsCost.setForeground(Color.GREEN);
		MedsCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		MedsCost.setAlignmentX(0.5f);
		MedsCost.setBounds(56, 165, 50, 25);
		StorePanel.add(MedsCost);
		
		AmmoCost = new JLabel("0");
		AmmoCost.setHorizontalTextPosition(SwingConstants.CENTER);
		AmmoCost.setHorizontalAlignment(SwingConstants.CENTER);
		AmmoCost.setForeground(Color.GREEN);
		AmmoCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		AmmoCost.setAlignmentX(0.5f);
		AmmoCost.setBounds(56, 135, 50, 25);
		StorePanel.add(AmmoCost);
		
		WheelsCost = new JLabel("0");
		WheelsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		WheelsCost.setHorizontalAlignment(SwingConstants.CENTER);
		WheelsCost.setForeground(Color.GREEN);
		WheelsCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		WheelsCost.setAlignmentX(0.5f);
		WheelsCost.setBounds(56, 225, 50, 25);
		StorePanel.add(WheelsCost);
		
		AxlesCost = new JLabel("0");
		AxlesCost.setHorizontalTextPosition(SwingConstants.CENTER);
		AxlesCost.setHorizontalAlignment(SwingConstants.CENTER);
		AxlesCost.setForeground(Color.GREEN);
		AxlesCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		AxlesCost.setAlignmentX(0.5f);
		AxlesCost.setBounds(56, 195, 50, 25);
		StorePanel.add(AxlesCost);
		
		RationsCost = new JLabel("0");
		RationsCost.setHorizontalTextPosition(SwingConstants.CENTER);
		RationsCost.setHorizontalAlignment(SwingConstants.CENTER);
		RationsCost.setForeground(Color.GREEN);
		RationsCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		RationsCost.setAlignmentX(0.5f);
		RationsCost.setBounds(56, 285, 50, 25);
		StorePanel.add(RationsCost);
		
		YokesCost = new JLabel("0");
		YokesCost.setHorizontalTextPosition(SwingConstants.CENTER);
		YokesCost.setHorizontalAlignment(SwingConstants.CENTER);
		YokesCost.setForeground(Color.GREEN);
		YokesCost.setFont(new Font("American Typewriter", Font.BOLD, 12));
		YokesCost.setAlignmentX(0.5f);
		YokesCost.setBounds(56, 255, 50, 25);
		StorePanel.add(YokesCost);
		
		JLabel CostLabel = new JLabel("Cost");
		CostLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		CostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CostLabel.setForeground(Color.GREEN);
		CostLabel.setFont(new Font("American Typewriter", Font.BOLD, 13));
		CostLabel.setAlignmentX(0.5f);
		CostLabel.setBounds(56, 43, 50, 25);
		StorePanel.add(CostLabel);
		
		lblNumbersOnlyPlease = new JLabel("Numbers only please!");
		lblNumbersOnlyPlease.setFont(new Font("American Typewriter", Font.BOLD, 13));
		lblNumbersOnlyPlease.setForeground(Color.GREEN);
		lblNumbersOnlyPlease.setVisible(false);
		lblNumbersOnlyPlease.setBounds(28, 321, 144, 28);
		StorePanel.add(lblNumbersOnlyPlease);
		
		JLabel storeback = new JLabel("");
		storeback.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		storeback.setIcon(new ImageIcon(MainFrame.class.getResource("/gui/resources/TextBackground.jpg")));
		storeback.setBounds(0, 0, 200, 370);
		StorePanel.add(storeback);
		
		JPanel PlayerPanel = new JPanel();
		PlayerPanel.setBounds(508, 40, 200, 370);
		ContentPanel.add(PlayerPanel);
		PlayerPanel.setLayout(null);
		
		PlayerMoneyAmt = new JLabel("0");
		PlayerMoneyAmt.setForeground(Color.GREEN);
		PlayerMoneyAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMoneyAmt.setAlignmentX(1.0f);
		PlayerMoneyAmt.setBounds(119, 43, 75, 25);
		PlayerPanel.add(PlayerMoneyAmt);
		
		JLabel PlayerMoney = new JLabel("Money:");
		PlayerMoney.setForeground(Color.GREEN);
		PlayerMoney.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMoney.setBounds(36, 43, 71, 25);
		PlayerPanel.add(PlayerMoney);
		
		JLabel PlayerMoxen = new JLabel("Moxen:");
		PlayerMoxen.setForeground(Color.GREEN);
		PlayerMoxen.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMoxen.setBounds(36, 74, 71, 25);
		PlayerPanel.add(PlayerMoxen);
		
		JLabel PlayerCloths = new JLabel("Cloths:");
		PlayerCloths.setForeground(Color.GREEN);
		PlayerCloths.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerCloths.setBounds(36, 104, 71, 25);
		PlayerPanel.add(PlayerCloths);
		
		JLabel PlayerAmmo = new JLabel("Ammo:");
		PlayerAmmo.setForeground(Color.GREEN);
		PlayerAmmo.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerAmmo.setBounds(36, 134, 71, 25);
		PlayerPanel.add(PlayerAmmo);
		
		JLabel PlayerMeds = new JLabel("Meds:");
		PlayerMeds.setForeground(Color.GREEN);
		PlayerMeds.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerMeds.setBounds(36, 164, 71, 25);
		PlayerPanel.add(PlayerMeds);
		
		JLabel PlayerAxles = new JLabel("Axles:");
		PlayerAxles.setForeground(Color.GREEN);
		PlayerAxles.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerAxles.setBounds(36, 194, 71, 25);
		PlayerPanel.add(PlayerAxles);
		
		JLabel PlayerWheels = new JLabel("Wheels:");
		PlayerWheels.setForeground(Color.GREEN);
		PlayerWheels.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerWheels.setBounds(36, 224, 71, 25);
		PlayerPanel.add(PlayerWheels);
		
		JLabel PlayerYokes = new JLabel("Yokes:");
		PlayerYokes.setForeground(Color.GREEN);
		PlayerYokes.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerYokes.setBounds(36, 254, 71, 25);
		PlayerPanel.add(PlayerYokes);
		
		JLabel PlayerRations = new JLabel("Rations:");
		PlayerRations.setForeground(Color.GREEN);
		PlayerRations.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerRations.setBounds(36, 284, 71, 25);
		PlayerPanel.add(PlayerRations);
		
		JLabel PlayerItems = new JLabel("Weight:");
		PlayerItems.setForeground(Color.GREEN);
		PlayerItems.setFont(new Font("American Typewriter", Font.BOLD, 13));
		PlayerItems.setBounds(36, 314, 71, 25);
		PlayerPanel.add(PlayerItems);
		
		JLabel PlayerInventory = new JLabel("Player Inventory");
		PlayerInventory.setHorizontalTextPosition(SwingConstants.CENTER);
		PlayerInventory.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerInventory.setForeground(Color.GREEN);
		PlayerInventory.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerInventory.setAlignmentX(0.5f);
		PlayerInventory.setBounds(6, 6, 188, 25);
		PlayerPanel.add(PlayerInventory);
		
		PlayerMoxenAmt = new JLabel("0");
		PlayerMoxenAmt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		PlayerMoxenAmt.setForeground(Color.GREEN);
		PlayerMoxenAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMoxenAmt.setBounds(118, 74, 75, 25);
		PlayerPanel.add(PlayerMoxenAmt);
		
		PlayerClothsAmt = new JLabel("0");
		PlayerClothsAmt.setForeground(Color.GREEN);
		PlayerClothsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerClothsAmt.setAlignmentX(1.0f);
		PlayerClothsAmt.setBounds(118, 104, 75, 25);
		PlayerPanel.add(PlayerClothsAmt);
		
		PlayerAmmoAmt = new JLabel("0");
		PlayerAmmoAmt.setForeground(Color.GREEN);
		PlayerAmmoAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerAmmoAmt.setAlignmentX(1.0f);
		PlayerAmmoAmt.setBounds(118, 134, 75, 25);
		PlayerPanel.add(PlayerAmmoAmt);
		
		PlayerMedsAmt = new JLabel("0");
		PlayerMedsAmt.setForeground(Color.GREEN);
		PlayerMedsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerMedsAmt.setAlignmentX(1.0f);
		PlayerMedsAmt.setBounds(118, 164, 75, 25);
		PlayerPanel.add(PlayerMedsAmt);
		
		PlayerAxlesAmt = new JLabel("0");
		PlayerAxlesAmt.setForeground(Color.GREEN);
		PlayerAxlesAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerAxlesAmt.setAlignmentX(1.0f);
		PlayerAxlesAmt.setBounds(118, 194, 75, 25);
		PlayerPanel.add(PlayerAxlesAmt);
		
		PlayerWheelsAmt = new JLabel("0");
		PlayerWheelsAmt.setForeground(Color.GREEN);
		PlayerWheelsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerWheelsAmt.setAlignmentX(1.0f);
		PlayerWheelsAmt.setBounds(118, 224, 75, 25);
		PlayerPanel.add(PlayerWheelsAmt);
		
		PlayerYokesAmt = new JLabel("0");
		PlayerYokesAmt.setForeground(Color.GREEN);
		PlayerYokesAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerYokesAmt.setAlignmentX(1.0f);
		PlayerYokesAmt.setBounds(118, 254, 75, 25);
		PlayerPanel.add(PlayerYokesAmt);
		
		PlayerRationsAmt = new JLabel("0");
		PlayerRationsAmt.setForeground(Color.GREEN);
		PlayerRationsAmt.setFont(new Font("American Typewriter", Font.BOLD, 15));
		PlayerRationsAmt.setAlignmentX(1.0f);
		PlayerRationsAmt.setBounds(118, 284, 75, 25);
		PlayerPanel.add(PlayerRationsAmt);
		
		playerTotalWeight = new JLabel("0");
		playerTotalWeight.setForeground(Color.GREEN);
		playerTotalWeight.setFont(new Font("American Typewriter", Font.BOLD, 15));
		playerTotalWeight.setAlignmentX(1.0f);
		playerTotalWeight.setBounds(118, 314, 75, 25);
		PlayerPanel.add(playerTotalWeight);
		
		JLabel playerback = new JLabel("New label");
		playerback.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		playerback.setIcon(new ImageIcon(MainFrame.class.getResource("/gui/resources/TextBackground.jpg")));
		playerback.setBounds(0, 0, 200, 370);
		PlayerPanel.add(playerback);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainFrame.class.getResource("/gui/resources/TradeBackground.jpg")));
		background.setBounds(0, 0, 720, 480);
		ContentPanel.add(background);
	}

	public void setStore(int[] prices, int[] quants) {
		for (int i=0; i < 8; i++){
			this.prices[i] = prices[i];
			costs[i].setText(Integer.toString(prices[i]));
			stAmts[i].setText(Integer.toString(quants[i]));
			}
	}
	
	public void setPlayer(int[] quants, int money, int weight){
		for (int i=0; i < 8; i++){
			plAmts[i].setText(Integer.toString(quants[i]));
		}
		PlayerMoneyAmt.setText(Integer.toString(money));
		playerTotalWeight.setText(Integer.toString(weight));
	}

	private void setTotals(){
		totalAmt = 0;
		totalWt = 0;
		for(int i=0; i < 8; i++){
			if(inputs[i].getText().equals("")){
				//do nothing
			}else{
				try{
					System.out.println(Integer.parseInt(inputs[i].getText()));
					lblNumbersOnlyPlease.setVisible(false);
					totalAmt += Integer.parseInt(inputs[i].getText()) * prices[i];
					totalWt += Integer.parseInt(inputs[i].getText()) * weights[i];
					PurchaseWt.setText(Integer.toString(totalWt));
					PurchaseAmt.setText(Integer.toString(totalAmt));
				} catch (NumberFormatException e) {
					lblNumbersOnlyPlease.setVisible(true);
				}
			}
			PurchaseAmt.setText(Integer.toString(totalAmt));
		}
	}
	public int getTotalAmt(){
		return totalAmt;
	}
	public int getTotalWt(){
		return totalWt;
	}
	public void setTransaction(Transaction trans){
		this.trans = trans;
	}
	
}