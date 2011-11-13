package classes;

import java.util.Random;

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
public class GameEngine {
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
	
	static MainFrame mainFrame;
	Event randEvent;
	static JPanel main = new MainPanel();
	private static Member[] members;
	
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
	public static void setPanelTrade(){
		JPanel trade = new TradePanel();
		mainFrame.swapPanel(trade);
	}
	
	public static Event move(){
		Event event=new Event();
		int eventType;
		gameDay++;
		
		location.updateLocation();
		eventType = event.generateEvent();
		if(location.landmarkType()!=4)
		{
			eventType=4;
		}
		if(eventType==0) // random member sick.
		{
			event.ranSick();
		}
		else if(eventType==1&&GameEngine.pace.getPaceNum()==0) //Dust Storm days happen
		{
			event.dustStorm();
		}
		else if(eventType==3)
		{
			
		}
		
		if (location.landmarkType() == 3){
			//you win, calc score, show win page
		}
		else if (location.landmarkType() == 1){
			//store
		}
		else if (location.landmarkType() == 2){
			//river
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
	/**
	 * getter for day
	 * @return day
	 */
	public static int getLocation(){
		return location.getLocation();
	}
	public static int getNextLocation(){
		return location.getLandmarkDist();
	}
	public static int getLocationAt(){
		return location.getLandmarkAt();
	}
	
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
}
