package classes;

import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.MainFrame;
import gui.MainPanel;
import gui.TradePanel;
/**
 * This class creates and controls most of the game functions
 * 
 * @author Christopher Whittemore
 *
 */
public class GameEngine implements Serializable {
	private static enum Months{JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC};
	private static int gameMonth;
	private static int gameDay;
	private static int gameYear;
	private static Wagon wagon;
	private static Rations rations = new Rations();
	private static Pace pace = new Pace();
	private static Supplies supplies;
	private static Leader ld;
	private static Location location;
	protected static int percentTraveled;
	private static Map map;
	private static String[] membernames;
	static Random rn = new Random();
	Transaction initialTrans;
	Store iniStore;
	private static Double playerLocation = (double) 0;
	public static GameEngine engine;
	
	static MainFrame mainFrame;
	Event randEvent;
	static JPanel main;// = new MainPanel();
	private static Member[] members;
	private static String eventOutput;
	
	private static Member member1;
	private static Member member2;
	private static Member member3;
	private static Member member4;
	
	private int[] iniPrices ={150, 50, 80, 200, 120, 20, 100, 1};
	private int[] iniQuant ={99, 99, 99, 99, 99, 99, 99, 99};
	/**
	 * Constructor sets up the leader, members of the wagon, rations, pace, and wagon.
	 * 
	 * @param leader
	 * @param profession
	 * @param rations
	 * @param pace
	 * @param membernames
	 */
	public GameEngine(String leader, String profession, String rations, String pace, String ...membernames) {
		engine = this;
		gameDay = 1;
		gameMonth = 0;
		gameYear = 2012;
		GameEngine.membernames = membernames;
		wagon = new Wagon();
		
		supplies = new Supplies(profession);
		
		ld = new Leader(leader, profession);
		
		if(rations.equals("Filling"))
		{
			GameEngine.rations.setRations(3);
		}
		else if(rations.equals("Normal"))
		{
			GameEngine.rations.setRations(2);
		}
		else if(rations.equals("Meager"))
		{
			GameEngine.rations.setRations(1);
		}
		else if(rations.equals("Starvation"))
		{
			GameEngine.rations.setRations(0);
		}
		
		if(pace.equals("Stopped"))
		{
			GameEngine.pace.setPace(0);
		}
		else if(pace.equals("Easy"))
		{
			GameEngine.pace.setPace(1);
		}
		else if(pace.equals("Normal"))
		{
			GameEngine.pace.setPace(2);
		}
		else if(pace.equals("Grueling"))
		{
			GameEngine.pace.setPace(3);
		}
		
		if (membernames.length == 1)
		{
			members=new Member[1];
			members[0]=new Member(membernames[0]);
			
//			member1 = new Member(membernames[0]);
		} 
		else if (membernames.length == 2)
		{
			members=new Member[2];
			members[0]=new Member(membernames[0]);
			members[1]=new Member(membernames[1]);
//			member1 = new Member(membernames[0]);
//			member2 = new Member(membernames[1]);
		} 
		else if (membernames.length == 3)
		{
			members=new Member[3];
			members[0]=new Member(membernames[0]);
			members[1]=new Member(membernames[1]);
			members[2]=new Member(membernames[2]);
//			member1 = new Member(membernames[0]);
//			member2 = new Member(membernames[1]);
//			member3 = new Member(membernames[2]);
		} 
		else 
		{
			members=new Member[4];
			members[0]=new Member(membernames[0]);
			members[1]=new Member(membernames[1]);
			members[2]=new Member(membernames[2]);
			members[3]= new Member(membernames[3]);
//			member1 = new Member(membernames[0]);
//			member2 = new Member(membernames[1]);
//			member3 = new Member(membernames[2]);
//			member4 = new Member(membernames[3]);
		}
		System.out.println(ld.getName());
		System.out.println(ld.getProfession());
		
		location = new Location(0, GameEngine.map, GameEngine.pace);
		
		iniStore = new Store(iniPrices, iniQuant);
		mainFrame = new MainFrame();
		initialTrans = new Transaction(iniStore, supplies, mainFrame);
		mainFrame.setTransaction(initialTrans);	
	}
	
	public static void setPanelMain()
	{
		mainFrame.swapPanel(main);
	}
	public static void loadPanelMain()
	{
		main = new MainPanel();
		mainFrame.swapPanel(main);
	}
	public static void setPanelTrade(){
		JPanel trade = new TradePanel();
		mainFrame.swapPanel(trade);
	}
	
	public static void playerHasArrivedFort(){
		String[] choices = {"Yes", "No"};
		String loc = GameEngine.getLocationName();
		int input = (int) JOptionPane.showOptionDialog(main, "You have arrived at "+ loc + " would you like to shop?", loc, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
	}
	public static void playerHasArrivedRiver(){
		String[] choices = {"Ford the River", "Float Across", "Hire the Ferry"};
		String loc = GameEngine.getLocationName();
		int input = (int) JOptionPane.showOptionDialog(main, "You have arrived at "+ loc + " how would you like to cross?", loc, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
	}
	public static void playerHasArrivedOregon(){
		//JPanel winPanel = new WinPanel();
		//mainFrame.swapPanel(winPanel);
		JOptionPane.showMessageDialog(main, "You have arrived at OREGON! YOU WIN!");

	}
	
	public static void eventPopup(String eventOutput){
		JOptionPane.showMessageDialog(main, eventOutput);
	}
	
	
	public static Event move(){
		Event event=new Event();
		int eventType;
		gameDay++;
		
		location.updateLocation();
		playerLocation = location.getLocation();
		
		if(location.landmarkType() == 1){
			playerHasArrivedFort();
		}
		else if(location.landmarkType() == 2){
			playerHasArrivedRiver();
		}
		else if(location.landmarkType() == 3){
			playerHasArrivedOregon();
		}
		
		eventType = event.generateEvent();
		
		if(location.landmarkType()!=4)
		{
			eventType=4;
		}
		if(eventType==0) // random member sick.
		{
			eventOutput=event.ranSick();
			eventPopup(eventOutput);
		}
		else if(eventType==1)
		{
			eventOutput=event.deadMox();
			eventPopup(eventOutput);
		}
		else if(eventType==2)
		{
			eventOutput=event.ranItem(false);
			eventPopup(eventOutput);
		}
		
		


		
		if(Item.RATIONS.getNum() >= rations.getRationsNum()+1){
			supplies.subItem(Item.RATIONS, rations.getRationsNum()+1);
		}
		
		if(gameDay == 31){
			
			gameDay = 1;
			
			if (gameMonth == 11)
			{
				gameMonth = 0;
				gameYear++;
			}
			else
			{
				gameMonth++;
			}	
		}
		return null;
	}

	public static Double getLocation(){
		return playerLocation;
	}
	
	/**
	 * Returns the distance to the next location
	 * @param offset
	 * @return
	 */
	public static Double getNextLocation(int offset){
		return location.getLandmarkDist(offset);
	}
	
	/**
	 * Returns the number of the landmark the player is at
	 * @return
	 */
	public static int getLocationAt(){
		return location.getLandmarkAt();
	}
	/**
	 * getter for day
	 * @return day
	 */
	public static int getDay(){
		return gameDay;
	}
	
	/**
	 * getter for rations
	 * @return the rations
	 */
	public static String getRations(){
		return rations.getRations();
	}
	
	/**
	 * setter for rations
	 * @param rationInput set rations based off input.
	 */
	public static void setRations(String rationInput) {
		
		if(rationInput.equals("Filling"))
		{
			GameEngine.rations.setRations(3);
		}
		else if(rationInput.equals("Normal"))
		{
			GameEngine.rations.setRations(2);
		}
		else if(rationInput.equals("Meager"))
		{
			GameEngine.rations.setRations(1);
		}
		else if(rationInput.equals("Starvation"))
		{
			GameEngine.rations.setRations(0);
		}
	}
	/**
	 * getter for pace.
	 * @return the pace.
	 */
	public static String getPace(){
		return pace.getPace();
	}
	
	/**
	 * setter for pace.
	 * @param paceInput the pace input..
	 */
	public static void setPace(String paceInput) {
		
		if(paceInput.equals("Stopped"))
		{
			GameEngine.pace.setPace(0);
		}
		else if(paceInput.equals("Easy"))
		{
			GameEngine.pace.setPace(1);
		}
		else if(paceInput.equals("Normal"))
		{
			GameEngine.pace.setPace(2);
		}
		else if(paceInput.equals("Grueling"))
		{
			GameEngine.pace.setPace(3);
		}
		
	}
	/**
	 * getter for the month.
	 * @return the month.
	 */
	public static String getMonth()
	{	
		Months[] monthsEnum = Months.values();
		return monthsEnum[gameMonth].toString();
	}
	
	/**
	 * getter for members
	 * @return the members.
	 */
	public static Member[] getMembers()
	{
		return members;
	}
	public static void setMembers(int memberz)
	{
		if (memberz == 1)
		{
			members=new Member[1];
		} 
		else if (memberz == 2)
		{
			members=new Member[2];
			
		} 
		else if (memberz== 3)
		{
			members=new Member[3];
		} 
		else 
		{
			members=new Member[4];
			
		}
		
	}

	public static Supplies getSupplies() {
		return supplies;
	}
	public static void setSupplies(Supplies supplies) {
		GameEngine.supplies = supplies;
	}
	public void setMap(Map map) {
		GameEngine.map = map;
	}
	public void setWagon(Wagon wagon) {
		GameEngine.wagon = wagon;
	}
	public void setRations(Rations rations) {
		GameEngine.rations = rations;
	}
	public void setPace(Pace pace) {
		GameEngine.pace = pace;
	}
	public void setLeader(Leader leader) {
		GameEngine.ld = leader;
	}
	public void setLocation(Location location) {
		GameEngine.location = location;
	}
	public void setFrame(MainFrame frame) {
		GameEngine.mainFrame = frame;
	}
	public void setPanel(MainPanel panel) {
		GameEngine.main = panel;
	}
	public Map getMap() {
		return map;
	}
	public Wagon getWagon() {
		return wagon;
	}
	public Leader getLeader() {
		return ld;
	}

	public MainFrame getFrame() {
		return mainFrame;
	}
	public JPanel getPanel() {
		return main;
	}
	public Rations getRationsClass() {
		return rations;
	}
	public Pace getPaceClass() {
		return pace;
	}
	public Location getLocationClass() {
		return location;
	}
//	public int getRationsAmt() {
//		return Item.RATIONS.getNum();
//	}
//	public void setRationsAmt(int amount){
//		Item.RATIONS.setNum(amount);
//	}

	public void setMembers(Member[] members) {
		member1 = members[0];
		if(members[1] != null)
		member2 = members[1];
		if(members[1] != null)
		member3 = members[2];
		if(members[1] != null)
		member4 = members[3];
		
		this.members = members;
	}

	public static String getLocationName() {
		return location.getLandmarkName();
	}
}
