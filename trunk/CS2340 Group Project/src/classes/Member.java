package classes;

/**
 * Member class
 * 
 *
 */
public class Member 
{
	private String name;
	
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
