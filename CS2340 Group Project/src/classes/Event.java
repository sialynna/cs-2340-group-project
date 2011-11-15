package classes;

import java.util.Random;

public class Event {
	private int event;
	private int chance;
	Random rn = new Random();

	/**
	 * Random event class
	 * 
	 */
	public Event()
	{
		
	}
	
	/**
	 * checks if there is an event this turn 
	 * @return event
	 */
	public boolean eventChance()
	{
		chance = rn.nextInt(3);
		if(chance ==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * generates event
	 * @return 0 = sick, 1 = dust storm, 2 = mox dies, 3 = found supplies, 4 = nothing happens
	 */
	public int generateEvent()
	{
		if(eventChance())
		{
			event=rn.nextInt(3);
			return event;
		}
		else
		{
			return 4;
			
		}
	}
	
	/**
	 * random member gets sick
	 */
	public void ranSick()
	{
		int ranMember;
<<<<<<< .mine
		ranMember=rn.nextInt(GameEngine.getMembers().length);
=======
		
		ranMember=rn.nextInt(GameEngine.getMembers().length-1);
>>>>>>> .r150
		if(ranMember==0&&!GameEngine.getMembers()[0].isSick())
		{
			GameEngine.getMembers()[0].sick();
		}
		else if(ranMember==1&&!GameEngine.getMembers()[1].isSick())
		{
			GameEngine.getMembers()[1].sick();
		}
		else if (ranMember==2&&!GameEngine.getMembers()[2].isSick())
		{
			GameEngine.getMembers()[2].sick();
		}
		else if(ranMember==3&&!GameEngine.getMembers()[3].isSick())
		{
			GameEngine.getMembers()[3].sick();
		}
	}
	
	/**
	 * lose 3 turns.
	 */
	public void dustStorm()
	{
		GameEngine.setPace("Stopped");
		GameEngine.move();
		GameEngine.move();
		GameEngine.move();
	}
	
	/**
	 * moxen dies.
	 */
	public void deadMox()
	{
		GameEngine.getSupplies().subItem(Item.MOXEN, 1);
	}
	
//	/**
//	 * removes a moxen from inventory. 
//	 * @param item
//	 * @param sup
//	 */
//	public void moxDies(Item item,Supplies sup){
//		sup.subItem(item.MOXEN, 1);
//		
//	}

}
