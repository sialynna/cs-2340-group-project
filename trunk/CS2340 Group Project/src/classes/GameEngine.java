package classes;

import gui.MainFrame;
/**
 * This class creates and controls most of the game functions
 * 
 * @author Christopher Whittemore
 *
 */
public class GameEngine {
	
	private static int gameDay;
	private static Wagon wagon;
	private static Rations rations = new Rations();
	private static Pace pace = new Pace();
	private static Supplies supplies;
	private static Leader ld;
	private static Location location;
	private static Map map;
	Transaction initialTrans;
	Store iniStore;
	MainFrame mainFrame;
	Event randEvent;
	
	private int[] iniPrices ={150, 50, 80, 200, 120, 20, 100, 10};
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
		gameDay = 0;
		
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
			Member member1 = new Member(membernames[0]);
			System.out.println(member1.getName());  // for debugging
		} 
		else if (membernames.length == 2)
		{
			Member member1 = new Member(membernames[0]);
			Member member2 = new Member(membernames[1]);
			System.out.println(member1.getName()); // for debugging
			System.out.println(member2.getName());
		} 
		else if (membernames.length == 3)
		{
			Member member1 = new Member(membernames[0]);
			Member member2 = new Member(membernames[1]);
			Member member3 = new Member(membernames[2]);
			System.out.println(member1.getName()); // for debugging
			System.out.println(member2.getName());
			System.out.println(member3.getName());
		} 
		else 
		{
			Member member1 = new Member(membernames[0]);
			Member member2 = new Member(membernames[1]);
			Member member3 = new Member(membernames[2]);
			Member member4 = new Member(membernames[3]);
			System.out.println(member1.getName()); // for debugging
			System.out.println(member2.getName());
			System.out.println(member3.getName());
			System.out.println(member4.getName());
		}
		System.out.println(ld.getName());
		System.out.println(ld.getProfession());
		
		location = new Location(0, GameEngine.map, GameEngine.pace);
		
		iniStore = new Store(iniPrices, iniQuant);
		mainFrame = new MainFrame();
		initialTrans = new Transaction(iniStore, supplies, mainFrame);
		mainFrame.setTransaction(initialTrans);
		
	}
	
	public static Event move(){
		gameDay++;
		location.updateLocation();
		
		return null;
		
	}
	
	public static int getDay(){
		return gameDay;
	}
}
