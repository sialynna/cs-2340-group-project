package classes;

import gui.TradeWindow;
/**
 * This class creates and controls most of the game functions
 * 
 * @author Christopher Whittemore
 *
 */
public class GameEngine {
	
	private static int gameDay;
	private Event randEvent;
	private Wagon wagon;
	private Rations rations;
	private Pace pace;
	private Supplies supplies;
	private Leader ld;
	Transaction initialTrans;
	Store iniStore;
	TradeWindow initialTrade;
	
	
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
			this.rations=new Rations(3);
		}
		else if(rations.equals("Normal"))
		{
			this.rations=new Rations(2);
		}
		else if(rations.equals("Meager"))
		{
				this.rations=new Rations(1);
		}
		else if(rations.equals("Starvation"))
		{
			this.rations=new Rations(0);
		}
		
		if(pace.equals("Stopped"))
		{
			this.pace=new Pace(0);
		}
		else if(pace.equals("Easy"))
		{
			this.pace=new Pace(1);
		}
		else if(pace.equals("Normal"))
		{
			this.pace=new Pace(2);
		}
		else if(pace.equals("Grueling"))
		{
			this.pace=new Pace(3);
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
		else if (membernames.length == 2)
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
		
		iniStore = new Store(iniPrices, iniQuant);
		initialTrade = new TradeWindow();
		initialTrans = new Transaction(iniStore, supplies, initialTrade);
		initialTrade.setTransaction(initialTrans);
	}
}
