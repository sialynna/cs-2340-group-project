package classes;

/**
 * ration class
 * Rations determine how fast the health and stamina of the
 * members decrease or increase
 * 
 */
public class Rations 
{
	private int rationsPerDay;
	
	/**
	 * Constructor, initially set by GameEngine
	 * @param val the value
	 */
	public Rations(int val)
	{
		this.rationsPerDay=val;
	}
	
	/**
	 * getter for ration
	 * @return the ration value
	 */
	public int getRations()
	{
		return rationsPerDay;
	}
	
	/**
	 * setter for ration
	 * @param val the value.
	 */
	public void setRations(int val)
	{
		this.rationsPerDay=val;
	}
	
}
