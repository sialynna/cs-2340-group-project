package classes;

/**
 * Member class
 * 
 *
 */
public class Member 
{
	private String name;
	private int health = 100;
	private int stamina = 100;
	private boolean isSick = false;
	private boolean isDead = false;
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
	 * setter for name
	 * @param name the name
	 */
	public void setName(String name)
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

}
