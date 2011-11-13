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
	 * @return 0 = sick, 1 = dust storm, 2 = mox dies, 3 = found supplies, 
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
	
	public void moxDies(Item item,Supplies sup){
		sup.subItem(item, 1);
		
	}

}
