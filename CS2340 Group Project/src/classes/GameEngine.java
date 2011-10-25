package classes;

public class GameEngine {
	
	private static int gameDay;
	private Event randEvent;
	private Wagon wagon;
	private Rations rations;
	private Pace pace;
	private Supplies supplies;
	private Leader ld;
	
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
			Member member1 = new Member(membernames[1]);
			System.out.println(member1.getName());  // for debugging
		} 
		else if (membernames.length == 2)
		{
			Member member1 = new Member(membernames[1]);
			Member member2 = new Member(membernames[2]);
			System.out.println(member1.getName());
			System.out.println(member2.getName());
		} 
		else if (membernames.length == 2)
		{
			Member member1 = new Member(membernames[1]);
			Member member2 = new Member(membernames[2]);
			Member member3 = new Member(membernames[3]);
			System.out.println(member1.getName());
			System.out.println(member2.getName());
			System.out.println(member3.getName());
		} 
		else 
		{
			Member member1 = new Member(membernames[1]);
			Member member2 = new Member(membernames[2]);
			Member member3 = new Member(membernames[3]);
			Member member4 = new Member(membernames[4]);
			System.out.println(member1.getName());
			System.out.println(member2.getName());
			System.out.println(member3.getName());
			System.out.println(member4.getName());
		}
	}
	
}
