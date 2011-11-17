package classes;

import java.io.Serializable;

/**
 * Member class
 * Members have health, stamina, and can be sick or dead.
 *
 */
public class Member implements Serializable
{
	public String name;
	private int health = 100;
	private int stamina = 100;
	private boolean isSick = false;
	private enum Health{
		GOOD, FAIR, POOR, DEAD
	}
	private enum Stamina{
		RESTED, TIRED, WEARY, EXHAUSTED
	}
	
	/**
	 * constructor
	 * @param name the name of member.
	 */
	public Member(String name)
	{
		this.name = name;
	}
	
	/**
	 * getter for name
	 * @return the name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * checks if the guy is alive or dead.
	 * @return status
	 */
	public boolean alive()
	{
		if(health>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * makes member sick
	 */
	public void sick()
	{
		isSick=true;
	}
	
	/**
	 * return health status of guy
	 * @return is sick or not.
	 */
	public boolean isSick()
	{
		return isSick;
	}

}
